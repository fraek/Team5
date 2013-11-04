package nl.plaatsmarkt.actions.member;

import java.util.List;

import nl.plaatsmarkt.domain.Veiling;
import nl.plaatsmarkt.util.IDAO;
import nl.plaatsmarkt.util.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

public class VeilingOverzicht extends ActionSupport {
	private IDAO<Veiling> vdao = ServiceProvider.getVeilingDAO();
	private static final long serialVersionUID = 1L;
	private List<Veiling> veilingOverzicht;
	private int id;

	public String execute() throws Exception {
		setVeilingOverzicht(vdao.read());
		return SUCCESS;
	}

	public List<Veiling> getVeilingOverzicht() {
		return veilingOverzicht;
	}

	public void setVeilingOverzicht(List<Veiling> veilingOverzicht) {
		this.veilingOverzicht = veilingOverzicht;
	}

	public int getId() {
		return id;
	}

	public void setId(int iD) {
		id = iD;
	}
}
