package nl.plaatsmarkt.util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nl.plaatsmarkt.domain.Bod;
import nl.plaatsmarkt.domain.Gebruiker;
import nl.plaatsmarkt.domain.SubCategorie;
import nl.plaatsmarkt.domain.Veiling;

public class BodDAO implements IDAO<Bod>{
	private DatabaseDAO db = ServiceProvider.getDatabaseDAO();
	private IDAO<Gebruiker> gebdao = ServiceProvider.getGebruikerDAO();
	private IDAO<Veiling> vdao = ServiceProvider.getVeilingDAO();
	private DateConverter dc = new DateConverter();
	@Override
	public void create(Object T) throws SQLException {
		Bod bod = (Bod) T;
		db.open();
		db.createStmt();

		java.util.Date date = bod.getDatum();
		java.sql.Timestamp timestamp = dc.dateToTimestamp(date);

		String statement = "INSERT INTO TO5_BOD(TIJD, BEDRAG, BIEDER, VEILING) values (?,?,?,?)";
		PreparedStatement preparedStatement = db.getCon().prepareStatement(statement);
		preparedStatement.setTimestamp(1, timestamp);
		preparedStatement.setDouble(2, bod.getBedrag());
		preparedStatement.setInt(3, bod.getDeBieder().getID());
		preparedStatement.setInt(4, bod.getDeVeiling().getID());
		preparedStatement.execute();

		db.close();
		db.closeStmt();		
	}

	@SuppressWarnings("null")
	@Override
	public List<Bod> read() throws SQLException {
		db.open();
		db.createStmt();
		String query = "SELECT * FROM TO5_BOD";
		ResultSet rs = db.getStmt().executeQuery(query);
		List<Bod> alleBiedingen = new ArrayList<Bod>();
		java.sql.Timestamp timestamp = null;
		java.util.Date datum = null;
		Gebruiker bieder = null;
		int gebid;
		Veiling veiling = null;
		int vid;
		while(rs.next())
		{
			timestamp = rs.getTimestamp("TIJD");
			if(timestamp != null){
				datum = dc.timestampToDate(timestamp);
			}
			gebid = rs.getInt("BIEDER");
			if(gebid > 0){
				bieder = (Gebruiker)gebdao.getObject(gebid);
			}
			vid = rs.getInt("VEILING");
			if(vid > 0){
				veiling = (Veiling)vdao.getObject(vid);
			}
			Bod bod = new Bod(rs.getDouble(3), bieder, datum, veiling, rs.getInt(1));
			System.out.println(bod.toString());
			//alleBiedingen.add(new Bod));
		}
		rs.close();

		db.close();
		db.closeStmt();		

		return alleBiedingen;
	}

	@SuppressWarnings("null")
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
			java.sql.Date aanmaakdate = null;
			java.util.Date aanmaakdatum = null;
			rs.next();
			
			Gebruiker aanbieder = null;
			int gebid;
			SubCategorie subcat = null;
			int scid;
			verloopdate = rs.getDate("VERLOOPDATUM");
			if(verloopdate != null || !verloopdate.equals("")){
				verloopdatum = dc.sqlToUtil(verloopdate);
			}
			aanmaakdate = rs.getDate("VERLOOPDATUM");
			if(aanmaakdate != null || !aanmaakdate.equals("")){
				aanmaakdatum = dc.sqlToUtil(aanmaakdate);
			}
			gebid = rs.getInt("AANBIEDER");
			if(gebid > 0){
				aanbieder = (Gebruiker)gebdao.getObject(gebid);
			}
			
			opgehaaldeVeiling = new Veiling(
					aanbieder,
					subcat,
					rs.getString("TITEL"),
					rs.getString("BESCHRIJVING"),
					aanmaakdatum,
					verloopdatum,
					rs.getInt("ID"));

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
		Veiling veiling = (Veiling)T;
		int id = veiling.getID();

		db.open();
		db.createStmt();

		java.util.Date aanmaakdate = veiling.getAanmaakDatum();
		java.sql.Date aanmaakdatum = dc.utilToSql(aanmaakdate);
		java.util.Date verloopdate = veiling.getVerloopDatum();
		java.sql.Date verloopdatum = dc.utilToSql(verloopdate);

		String statement = "UPDATE TO5_VEILING SET TITEL=?, BESCHRIJVING=?, AANMAAKDATUM=?, VERLOOPDATUM=?, AANBIEDER=?, SUBCATEGORIE=? WHERE ID="+id;
		PreparedStatement preparedStatement = db.getCon().prepareStatement(statement);
		preparedStatement.setString(1, veiling.getTitel());
		preparedStatement.setString(2, veiling.getBeschrijving());
		preparedStatement.setDate(3, aanmaakdatum);
		preparedStatement.setDate(4, verloopdatum);
		preparedStatement.setInt(5, veiling.getDeAanbieder().getID());
		preparedStatement.setInt(6, veiling.getDeSubCategorie().getID());
		preparedStatement.execute();

		db.close();
		db.closeStmt();		
	}

	@Override
	public void delete(Object T) throws SQLException {
		Veiling Veiling = (Veiling)T;
		int id = Veiling.getID();

		db.open();
		db.createStmt();

		String statement = "DELETE FROM TO5_VEILING WHERE id = " + id;
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
		return db.getRows("TO5_VEILING");
	}

	@Override
	public Object getObject(String NAAM) throws SQLException {
		//Deze methode zou theoretisch te gebruiken kunnen zijn bij 1 String waarde
		return null;
	}

}
