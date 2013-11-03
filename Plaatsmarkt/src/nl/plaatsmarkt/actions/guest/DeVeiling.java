package nl.plaatsmarkt.actions.guest;

import nl.plaatsmarkt.domain.Veiling;
import nl.plaatsmarkt.util.IDAO;
import nl.plaatsmarkt.util.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

public class DeVeiling extends ActionSupport {
	private IDAO<Veiling> vdao = ServiceProvider.getVeilingDAO();
	private static final long serialVersionUID = 1L;
	private int id;
	private Veiling deVeiling;

	public String execute() throws Exception {
		setDeVeiling((Veiling) vdao.getObject(id));
		//setAlleVeilingen(vdao.read());
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
}
