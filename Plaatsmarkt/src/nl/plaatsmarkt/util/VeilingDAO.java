package nl.plaatsmarkt.util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nl.plaatsmarkt.domain.Veiling;

public class VeilingDAO implements IDAO<Veiling>{
	private DatabaseDAO db = ServiceProvider.getDatabaseDAO();
	DateConverter dc = new DateConverter();
	@Override
	public void create(Object T) throws SQLException {
		Veiling veiling = (Veiling) T;
		db.open();
		db.createStmt();
		
		
		String statement = "INSERT INTO TO5_VEILING(TITEL, BESCHRIJVING, AANMAAKDATUM, VERLOOPDATUM) values (?,?,?,?)";
		PreparedStatement preparedStatement = db.getCon().prepareStatement(statement);
		preparedStatement.setString(1, veiling.getTitel());
		preparedStatement.execute();
		
		db.close();
		db.closeStmt();		
	}

	@Override
	public List<Veiling> read() throws SQLException {
		db.open();
		db.createStmt();
		String query = "SELECT * FROM TO5_VEILING";
		ResultSet rs = db.getStmt().executeQuery(query);
		List<Veiling> alleVeilingen = new ArrayList<Veiling>();
		java.sql.Date verloopdate = null;
		java.util.Date verloopdatum = null;
		while(rs.next())
			{

			verloopdate = rs.getDate("VERLOOPDATUM");
			if(verloopdate != null || !verloopdate.equals("")){
				verloopdatum = dc.sqlToUtil(verloopdate);
			}
			//alleVeilingen.add(new Veiling	());
			}
		rs.close();
		
		db.close();
		db.closeStmt();		
		
		return alleVeilingen;
	}

	@Override
	public Object getObject(int ID) throws SQLException {
		Veiling opgehaaldeVeiling = null;
		try {
			db.open();
			String query = "SELECT * FROM TO5_VEILING WHERE id = " + ID;
			PreparedStatement ps;
			ps = db.getCon().prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			java.sql.Date verloopdate = null;
			java.util.Date verloopdatum = null;
			rs.next();
			
			verloopdate = rs.getDate("VERLOOPDATUM");
			verloopdatum  = dc.sqlToUtil(verloopdate);
			
			//opgehaaldeVeiling = new Veiling();
			
			ps.close();
			db.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return opgehaaldeVeiling;
	}

	@Override
	public void update(Object T) throws SQLException {
		Veiling Veiling = (Veiling)T;
		int id = Veiling.getID();
		java.util.Date verloopdate = Veiling.getVerloopDatum();
		java.sql.Date verloopdatum = dc.utilToSql(verloopdate);
		
		db.open();
		db.createStmt();
		
		/*
		String statement = "UPDATE TO5_Veiling SET NAAM=?, TUSSENVOEGSEL=?, ACHTERNAAM=?, EMAIL=?, WACHTWOORD=?, GEBOORTEDATUM=?, WOONPLAATS=?, POSTCODE=?, ADRES=?, TELEFOONNUMMER=?, VeilingSNAAM=?, ROL=? WHERE ID = " + id;
		PreparedStatement preparedStatement = db.getCon().prepareStatement(statement);
		preparedStatement.setString(1, Veiling.getVoornaam());
		preparedStatement.setString(2, Veiling.getTussenvoegsel());
		preparedStatement.setString(3, Veiling.getAchternaam());
		preparedStatement.setString(4, Veiling.getEmail());
		preparedStatement.setString(5, Veiling.getWachtwoord());
		preparedStatement.setDate(6, geboortedatum);								//Veiling.getGeboortedatum()
		preparedStatement.setString(7, Veiling.getWoonplaats());
		preparedStatement.setString(8, Veiling.getPostcode());
		preparedStatement.setString(9, Veiling.getAdres());
		preparedStatement.setFloat(10, Veiling.getTelefoonnummer());
		preparedStatement.setString(11, Veiling.getVeilingsnaam());
		preparedStatement.setString(12, Veiling.getVeilingRol().toString());
		preparedStatement.execute();
		*/
		
		db.close();
		db.closeStmt();		
	}

	@Override
	public void delete(Object T) throws SQLException {
		Veiling Veiling = (Veiling)T;
		int id = Veiling.getID();
		
		db.open();
		db.createStmt();
		
		String statement = "DELETE FROM TO5_Veiling WHERE id = " + id;
		PreparedStatement preparedStatement = db.getCon().prepareStatement(statement);
		preparedStatement.execute();
		
		db.close();
		db.closeStmt();	
	}
	
	@Override
	public void delete(int ID) throws SQLException {
		db.open();
		db.createStmt();
		
		String statement = "DELETE FROM TO5_Veiling WHERE id = " + ID;
		PreparedStatement preparedStatement = db.getCon().prepareStatement(statement);
		preparedStatement.execute();
		
		db.close();
		db.closeStmt();	
	}

	@Override
	public int count() {
		return db.getRows("TO5_Veiling");
	}

	@Override
	public Object getObject(String NAAM) throws SQLException {
		//Deze methode zou theoretisch te gebruiken kunnen zijn bij 1 String waarde
		return null;
	}

}
