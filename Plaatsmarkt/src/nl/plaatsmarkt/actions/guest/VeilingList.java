package nl.plaatsmarkt.actions.guest;

import java.util.ArrayList;
import java.util.List;

import nl.plaatsmarkt.domain.Veiling;
import nl.plaatsmarkt.util.IDAO;
import nl.plaatsmarkt.util.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

public class VeilingList extends ActionSupport {
	private IDAO<Veiling> vdao = ServiceProvider.getVeilingDAO();
	private static final long serialVersionUID = 1L;
	private List<Veiling> alleVeilingen, alleVeilingenByID;
	private int id;

	public String execute() throws Exception {
		alleVeilingenByID = new ArrayList<Veiling>();
		setAlleVeilingen(vdao.read());
		for(Veiling v:alleVeilingen){
			if(v.getDeSubCategorie().getID() == id){
				alleVeilingenByID.add(v);
			}
		}
		return SUCCESS;
	}

	public List<Veiling> getAlleVeilingen() {
		return alleVeilingen;
	}

	public void setAlleVeilingen(List<Veiling> alleVeilingen) {
		this.alleVeilingen = alleVeilingen;
	}

	public List<Veiling> getAlleVeilingenByID() {
		return alleVeilingenByID;
	}

	public void setAlleVeilingenByID(List<Veiling> alleVeilingenByID) {
		this.alleVeilingenByID = alleVeilingenByID;
	}

	public int getId() {
		return id;
	}

	public void setId(int iD) {
		id = iD;
	}
}
