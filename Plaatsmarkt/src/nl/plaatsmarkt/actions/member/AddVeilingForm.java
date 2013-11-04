package nl.plaatsmarkt.actions.member;

import java.util.Collections;
import java.util.Comparator;
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
		Collections.sort(subcats, new CustomComparator());
		for(SubCategorie s:subcats){
			s.setNaam(s.getCategorie().getNaam() + " | " + s.getNaam());
		}
		return ActionSupport.SUCCESS;
	}

	public List<SubCategorie> getSubcats() {
		return subcats;
	}

	public void setSubcats(List<SubCategorie> subcats) {
		this.subcats = subcats;
	}
	
	//SORT
	public class CustomComparator implements Comparator<Object> {
		public int compare(Object o1, Object o2) {
            SubCategorie c1 = (SubCategorie) o1;
            SubCategorie c2 = (SubCategorie) o2;
            return c1.getCategorie().getNaam().compareToIgnoreCase(c2.getCategorie().getNaam());
        }
	}
}
