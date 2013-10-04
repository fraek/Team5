package nl.plaatsmarkt.util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import nl.plaatsmarkt.domain.Gebruiker;
import nl.plaatsmarkt.domain.GebruikerRol;

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
		String query = "SELECT * FROM TO5_GEBRUIKER";
		ResultSet rs = db.getStmt().executeQuery(query);
		List<Gebruiker> alleGebruikers = new ArrayList<Gebruiker>();
		GebruikerRol rol = null;
		while(rs.next())
			{
			
			//Per result rol bepalen
			if(rs.getString("ROL").equalsIgnoreCase("Member")){
				rol = GebruikerRol.Member;
			}else if(rs.getString("ROL").equalsIgnoreCase("Admin")){
				rol = GebruikerRol.Admin;
			}
			
			Date datum = null;
			alleGebruikers.add(
					new Gebruiker	(	
							Integer.parseInt(rs.getString("ID")),
							rs.getString("NAAM"),
							rs.getString("TUSSENVOEGSEL"),
							rs.getString("ACHTERNAAM"),
							rs.getString("GEBRUIKERSNAAM"),
							rs.getString("EMAIL"),
							rs.getString("WACHTWOORD"),
							rs.getString("ADRES"),
							rs.getString("POSTCODE"),
							rs.getString("WOONPLAATS"),
							datum, //N.Y.I DATE		
							rs.getLong("TELEFOONNUMMER"),
							rol) 	);
			}
		rs.close();
		
		db.close();
		db.closeStmt();		
		
		return alleGebruikers;
	}

	@Override
	public Object getObject(int ID) throws SQLException {
		Gebruiker opgehaaldeGebruiker = null;
		try {
			db.open();
			GebruikerRol rol = null;
			Date datum = null;
			String query = "SELECT * FROM TO5_GEBRUIKER WHERE id = " + ID;
			PreparedStatement ps;
			ps = db.getCon().prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			rs.next();
		
			//Per result rol bepalen
			if(rs.getString("ROL").equalsIgnoreCase("Member")){
				rol = GebruikerRol.Member;
			}else if(rs.getString("ROL").equalsIgnoreCase("Admin")){
				rol = GebruikerRol.Admin;
			}
			
			opgehaaldeGebruiker = new Gebruiker	(	
						Integer.parseInt(rs.getString("ID")),
						rs.getString("NAAM"),
						rs.getString("TUSSENVOEGSEL"),
						rs.getString("ACHTERNAAM"),
						rs.getString("GEBRUIKERSNAAM"),
						rs.getString("EMAIL"),
						rs.getString("WACHTWOORD"),
						rs.getString("ADRES"),
						rs.getString("POSTCODE"),
						rs.getString("WOONPLAATS"),
						datum, //N.Y.I DATE		
						rs.getLong("TELEFOONNUMMER"),
						rol);
			
			ps.close();
			db.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return opgehaaldeGebruiker;
	}

	@Override
	public void update(Object T) throws SQLException {
		Gebruiker gebruiker = (Gebruiker)T;
		int id = gebruiker.getID();
		
		db.open();
		db.createStmt();
		
		String statement = "UPDATE PERS_COMPONIST SET NAAM=?, TUSSENVOEGSEL=?, ACHTERNAAM=?, EMAIL=?, WACHTWOORD=?, GEBOORTEDATUM=?, WOONPLAATS=?, POSTCODE=?, ADRES=?, TELEFOONNUMMER=?, GEBRUIKERSNAAM=?, ROL=? WHERE ID = " + id;
		PreparedStatement preparedStatement = db.getCon().prepareStatement(statement);
		preparedStatement.setString(1, gebruiker.getVoornaam());
		preparedStatement.setString(2, gebruiker.getTussenvoegsel());
		preparedStatement.setString(3, gebruiker.getAchternaam());
		preparedStatement.setString(4, gebruiker.getEmail());
		preparedStatement.setString(5, gebruiker.getWachtwoord());
		preparedStatement.setDate(6, null);								//gebruiker.getGeboortedatum()
		preparedStatement.setString(7, gebruiker.getWoonplaats());
		preparedStatement.setString(8, gebruiker.getPostcode());
		preparedStatement.setString(9, gebruiker.getAdres());
		preparedStatement.setFloat(10, gebruiker.getTelefoonnummer());
		preparedStatement.setString(11, gebruiker.getGebruikersnaam());
		preparedStatement.setString(12, gebruiker.getGebruikerRol().toString());
		preparedStatement.execute();
		
		db.close();
		db.closeStmt();		
	}

	@Override
	public void delete(Object T) throws SQLException {
		Gebruiker gebruiker = (Gebruiker)T;
		int id = gebruiker.getID();
		
		db.open();
		db.createStmt();
		
		String statement = "DELETE FROM TO5_GEBRUIKER WHERE id = " + id;
		PreparedStatement preparedStatement = db.getCon().prepareStatement(statement);
		preparedStatement.execute();
		
		db.close();
		db.closeStmt();	
	}

	@Override
	public int count() {
		return db.getRows("TO5_GEBRUIKER");
	}

}
