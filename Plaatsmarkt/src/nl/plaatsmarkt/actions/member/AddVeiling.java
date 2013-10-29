package nl.plaatsmarkt.actions.member;

import com.opensymphony.xwork2.ActionSupport;

public class AddVeiling extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String titel;
	private String omschrijving;
	private int subcats;

	@Override
	public String execute() throws Exception {

		return SUCCESS;
	}

	@Override
	public void validate(){
		System.out.println(subcats);
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getOmschrijving() {
		return omschrijving;
	}

	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}

	public int getSubcats() {
		return subcats;
	}

	public void setSubcats(int subcats) {
		this.subcats = subcats;
	}
	
}
