package nl.plaatsmarkt.actions.guest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import nl.plaatsmarkt.domain.Bod;
import nl.plaatsmarkt.domain.Veiling;
import nl.plaatsmarkt.util.IDAO;
import nl.plaatsmarkt.util.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

public class DeVeiling extends ActionSupport {
	private IDAO<Veiling> vdao = ServiceProvider.getVeilingDAO();
	private IDAO<Bod> bdao = ServiceProvider.getBodDAO();
	private static final long serialVersionUID = 1L;
	private int id;
	private Veiling deVeiling;
	private boolean afgelopen;
	private List<Bod> alleBiedingen, alleBiedingenByID;

	public String execute() throws Exception {
		alleBiedingen = new ArrayList<Bod>();
		alleBiedingenByID = new ArrayList<Bod>();
		
		setDeVeiling((Veiling) vdao.getObject(id));
		//setAlleVeilingen(vdao.read());
		
		setAlleBiedingen(bdao.read());
		for(Bod b:alleBiedingen) {
			if(b.getDeVeiling().getID() == deVeiling.getID()) {
				if(b.getBedrag() > 0) alleBiedingenByID.add(b);
			}
		}
		
		//Sorteren
		Collections.sort(alleBiedingenByID, new Comparator<Bod>() {
		    @Override
		    public int compare(Bod c1, Bod c2) {
		        return new Double(c2.getBedrag()).compareTo(new Double(c1.getBedrag()));
		    }
		});
		
		deVeiling.setAlleBiedingen((ArrayList<Bod>) alleBiedingenByID);
		return SUCCESS;
	}

	public int getId() {
		return id;
	}

	public void setId(int iD) {
		id = iD;
	}

	public Veiling getDeVeiling() {
		return deVeiling;
	}

	public void setDeVeiling(Veiling deVeiling) {
		this.deVeiling = deVeiling;
	}

	public List<Bod> getAlleBiedingen() {
		return alleBiedingen;
	}

	public void setAlleBiedingen(List<Bod> list) {
		this.alleBiedingen = list;
	}
}
