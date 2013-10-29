package nl.plaatsmarkt.util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nl.plaatsmarkt.domain.Gebruiker;
import nl.plaatsmarkt.domain.GebruikerRol;

public class GebruikerDAO implements IDAO<Gebruiker>{
	private DatabaseDAO db = ServiceProvider.getDatabaseDAO();
	DateConverter dc = new DateConverter();
	@Override
	public void create(Object T) throws SQLException {
		Gebruiker gebruiker = (Gebruiker) T;
		db.open();
		db.createStmt();
		
		java.util.Date utilGeboortedatum = gebruiker.getGeboortedatum();
	    java.sql.Date sqlGeboortedatum = dc.utilToSql(utilGeboortedatum);
		
		String statement = "INSERT INTO TO5_GEBRUIKER(NAAM, TUSSENVOEGSEL, ACHTERNAAM, EMAIL, WACHTWOORD, GEBOORTEDATUM, " +
				"WOONPLAATS, POSTCODE, ADRES, TELEFOONNUMMER, GEBRUIKERSNAAM, ROL) values (?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = db.getCon().prepareStatement(statement);
		preparedStatement.setString(1, gebruiker.getVoornaam());
		preparedStatement.setString(2, gebruiker.getTussenvoegsel());
		preparedStatement.setString(3, gebruiker.getAchternaam());
		preparedStatement.setString(4, gebruiker.getEmail());
		preparedStatement.setString(5, gebruiker.getWachtwoord());
		preparedStatement.setDate(6, sqlGeboortedatum); // Util Date omzetten naar SQL Date
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

	@SuppressWarnings("null")
	@Override
	public List<Gebruiker> read() throws SQLException {
		db.open();
		db.createStmt();
		String query = "SELECT * FROM TO5_GEBRUIKER";
		ResultSet rs = db.getStmt().executeQuery(query);
		List<Gebruiker> alleGebruikers = new ArrayList<Gebruiker>();
		GebruikerRol rol = null;
		java.sql.Date date = null;
		java.util.Date geboortedatum = null;
		while(rs.next())
			{
			
			//Per result rol bepalen
			if(rs.getString("ROL").equalsIgnoreCase("Member")){
				rol = GebruikerRol.Member;
			}else if(rs.getString("ROL").equalsIgnoreCase("Admin")){
				rol = GebruikerRol.Admin;
			}else if(rs.getString("ROL").equalsIgnoreCase("Geblokkeerd")){
				rol = GebruikerRol.Geblokkeerd;
			}
			date = rs.getDate("GEBOORTEDATUM");
			if(date != null || !date.equals("")){
				geboortedatum = dc.sqlToUtil(date);
			}
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
							geboortedatum, 
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
			String query = "SELECT * FROM TO5_GEBRUIKER WHERE id = " + ID;
			PreparedStatement ps;
			ps = db.getCon().prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			java.sql.Date date = null;
			java.util.Date geboortedatum = null;
			rs.next();
		
			//Per result rol bepalen
			if(rs.getString("ROL").equalsIgnoreCase("Member")){
				rol = GebruikerRol.Member;
			}else if(rs.getString("ROL").equalsIgnoreCase("Admin")){
				rol = GebruikerRol.Admin;
			}else if(rs.getString("ROL").equalsIgnoreCase("Geblokkeerd")){
				rol = GebruikerRol.Geblokkeerd;
			}
			
			date = rs.getDate("GEBOORTEDATUM");
			geboortedatum  = dc.sqlToUtil(date);
			
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
						geboortedatum,	
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
		java.util.Date date = gebruiker.getGeboortedatum();
		java.sql.Date geboortedatum = dc.utilToSql(date);
		
		db.open();
		db.createStmt();
		
		String statement = "UPDATE TO5_GEBRUIKER SET NAAM=?, TUSSENVOEGSEL=?, ACHTERNAAM=?, EMAIL=?, WACHTWOORD=?, GEBOORTEDATUM=?, WOONPLAATS=?, POSTCODE=?, ADRES=?, TELEFOONNUMMER=?, GEBRUIKERSNAAM=?, ROL=? WHERE ID = " + id;
		PreparedStatement preparedStatement = db.getCon().prepareStatement(statement);
		preparedStatement.setString(1, gebruiker.getVoornaam());
		preparedStatement.setString(2, gebruiker.getTussenvoegsel());
		preparedStatement.setString(3, gebruiker.getAchternaam());
		preparedStatement.setString(4, gebruiker.getEmail());
		preparedStatement.setString(5, gebruiker.getWachtwoord());
		preparedStatement.setDate(6, geboortedatum);								//gebruiker.getGeboortedatum()
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
	public void delete(int ID) throws SQLException {
		db.open();
		db.createStmt();
		
		String statement = "DELETE FROM TO5_GEBRUIKER WHERE id = " + ID;
		PreparedStatement preparedStatement = db.getCon().prepareStatement(statement);
		preparedStatement.execute();
		
		db.close();
		db.closeStmt();	
	}

	@Override
	public int count() {
		return db.getRows("TO5_GEBRUIKER");
	}

	@Override
	public Object getObject(String NAAM) throws SQLException {
		//Deze methode zou theoretisch te gebruiken kunnen zijn bij 1 String waarde
		return null;
	}

}
