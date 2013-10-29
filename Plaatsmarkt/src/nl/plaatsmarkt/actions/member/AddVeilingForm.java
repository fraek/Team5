package nl.plaatsmarkt.actions.member;

import java.util.List;

import nl.plaatsmarkt.domain.SubCategorie;
import nl.plaatsmarkt.util.IDAO;
import nl.plaatsmarkt.util.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class AddVeilingForm extends ActionSupport {
	
	private IDAO<SubCategorie> subdao = ServiceProvider.getSubCategorieDAO();
	private List<SubCategorie> subcats;
	
	public String execute() throws Exception {
		setSubcats(subdao.read());
		
		return ActionSupport.SUCCESS;
	}

	public List<SubCategorie> getSubcats() {
		return subcats;
	}

	public void setSubcats(List<SubCategorie> subcats) {
		this.subcats = subcats;
	}
}
