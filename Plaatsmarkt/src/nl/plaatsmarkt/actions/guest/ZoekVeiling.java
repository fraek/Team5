package nl.plaatsmarkt.actions.guest;

import java.util.ArrayList;
import java.util.List;

import nl.plaatsmarkt.domain.Veiling;
import nl.plaatsmarkt.util.IDAO;
import nl.plaatsmarkt.util.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

public class ZoekVeiling extends ActionSupport {
	private IDAO<Veiling> vdao = ServiceProvider.getVeilingDAO();
	private static final long serialVersionUID = 1L;
	private List<Veiling> alleVeilingen, alleVeilingenByTitel;
	private String titel;

	public String execute() throws Exception {
		alleVeilingenByTitel = new ArrayList<Veiling>();
		
		setAlleVeilingen(vdao.read());
		
		for(Veiling v:alleVeilingen){
			if(v.getTitel().toLowerCase().contains(titel.toLowerCase())){
				alleVeilingenByTitel.add(v);
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

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public List<Veiling> getAlleVeilingenByTitel() {
		return alleVeilingenByTitel;
	}

	public void setAlleVeilingenByTitel(List<Veiling> alleVeilingenByTitel) {
		this.alleVeilingenByTitel = alleVeilingenByTitel;
	}
}
