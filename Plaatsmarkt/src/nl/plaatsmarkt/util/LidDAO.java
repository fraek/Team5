package nl.plaatsmarkt.util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nl.plaatsmarkt.domain.Gebruiker;
import nl.plaatsmarkt.domain.Lid;

public class LidDAO implements IDAO<Lid>{
	private DatabaseDAO db = ServiceProvider.getDatabaseDAO();
	
	@Override
	public void create(Object T) throws SQLException {
		Lid lid = (Lid) T;
		db.open();
		db.createStmt();
		
		//java.util.Date utilGeboortedatum = lid.getGeboortedatum();
	    //java.sql.Date sqlGeboortedatum = new java.sql.Date(utilGeboortedatum.getTime());
		
		String statement = "INSERT INTO TO5_GEBRUIKER(NAAM, TUSSENVOEGSEL, ACHTERNAAM, EMAIL, WACHTWOORD, GEBOORTEDATUM, " +
				"WOONPLAATS, POSTCODE, ADRES, TELEFOONNUMMER, GEBRUIKERSNAAM, ROL) values (?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = db.getCon().prepareStatement(statement);
		preparedStatement.setString(1, lid.getVoornaam());
		preparedStatement.setString(2, lid.getTussenvoegsel());
		preparedStatement.setString(3, lid.getAchternaam());
		preparedStatement.setString(4, lid.getEmail());
		preparedStatement.setString(5, lid.getWachtwoord());
		preparedStatement.setDate(6, null); // Util Date omzetten naar SQL Date
		preparedStatement.setString(7, lid.getWoonplaats());
		preparedStatement.setString(8, lid.getPostcode());
		preparedStatement.setString(9, lid.getAdres());
		preparedStatement.setLong(10, lid.getTelefoonnummer());
		preparedStatement.setString(11, lid.getGebruikersnaam());
		preparedStatement.setString(12, lid.getGebruikerRol().toString());
		preparedStatement.execute();
		
		db.close();
		db.closeStmt();		
	}

	@Override
	public List<Lid> read() throws SQLException {
		db.open();
		db.createStmt();
		String query = "SELECT * FROM PERS_COMPONIST";
		ResultSet rs = db.getStmt().executeQuery(query);
		
		List<Lid> alleComponisten = new ArrayList<Lid>();
		while(rs.next())
			{
			alleComponisten.add(
					new Lid	(			rs.getString("NAAM"),
										rs.getString("LAND"),
										rs.getString("TIJDVAK"),
										rs.getString("COMPOSITIES"),
										rs.getInt("ID")
									) 	);
			}
		rs.close();
		
		db.close();
		db.closeStmt();		
		
		return alleGebruikers;
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
