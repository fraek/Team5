package nl.plaatsmarkt.util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nl.plaatsmarkt.domain.Gebruiker;

public class GebruikerDAO implements IDAO<Gebruiker>{
	private DatabaseDAO db = ServiceProvider.getDatabaseDAO();
	
	@Override
	public void create(Object T) throws SQLException {
		Gebruiker gebruiker = (Gebruiker) T;
		db.open();
		db.createStmt();
		
		//java.util.Date utilGeboortedatum = lid.getGeboortedatum();
	    //java.sql.Date sqlGeboortedatum = new java.sql.Date(utilGeboortedatum.getTime());
		
		String statement = "INSERT INTO TO5_GEBRUIKER(NAAM, TUSSENVOEGSEL, ACHTERNAAM, EMAIL, WACHTWOORD, GEBOORTEDATUM, " +
				"WOONPLAATS, POSTCODE, ADRES, TELEFOONNUMMER, GEBRUIKERSNAAM, ROL) values (?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = db.getCon().prepareStatement(statement);
		preparedStatement.setString(1, gebruiker.getVoornaam());
		preparedStatement.setString(2, gebruiker.getTussenvoegsel());
		preparedStatement.setString(3, gebruiker.getAchternaam());
		preparedStatement.setString(4, gebruiker.getEmail());
		preparedStatement.setString(5, gebruiker.getWachtwoord());
		preparedStatement.setDate(6, null); // Util Date omzetten naar SQL Date
		preparedStatement.setString(7, gebruiker.getWoonplaats());
		preparedStatement.setString(8, gebruiker.getPostcode());
		preparedStatement.setString(9, gebruiker.getAdres());
		preparedStatement.setLong(10, gebruiker.getTelefoonnummer());
		preparedStatement.setString(11, gebruiker.getGebruikersnaam());
		preparedStatement.setString(12, gebruiker.getGebruikerRol().toString());
		preparedStatement.execute();
		
		db.close();
		db.closeStmt();		
	}

	@Override
	public List<Gebruiker> read() throws SQLException {
		db.open();
		db.createStmt();
		String query = "SELECT * FROM PERS_COMPONIST";
		ResultSet rs = db.getStmt().executeQuery(query);
		
		List<Gebruiker> alleGebruikers = new ArrayList<Gebruiker>();
//		while(rs.next())
//			{
//			alleComponisten.add(
//					new Lid	(			rs.getString("NAAM"),
//										rs.getString("LAND"),
//										rs.getString("TIJDVAK"),
//										rs.getString("COMPOSITIES"),
//										rs.getInt("ID")
//									) 	);
//			}
		rs.close();
		
		db.close();
		db.closeStmt();		
		
		return null;
	}

	@Override
	public Object getObject(int ID) throws SQLException {
		return null;
	}

	@Override
	public void update(Object T) throws SQLException {
	}

	@Override
	public void delete(Object T) throws SQLException {
	}

	@Override
	public int count() {
		return 0;
	}

}
