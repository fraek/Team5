package nl.plaatsmarkt.util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import nl.plaatsmarkt.domain.Categorie;
import nl.plaatsmarkt.domain.Gebruiker;
import nl.plaatsmarkt.domain.SubCategorie;
import nl.plaatsmarkt.domain.Veiling;
//VeilingDAO
public class VeilingDAO implements IDAO<Veiling>{
	private DatabaseDAO db = ServiceProvider.getDatabaseDAO();
	private IDAO<Gebruiker> gebdao = ServiceProvider.getGebruikerDAO();
	private IDAO<SubCategorie> scdao = ServiceProvider.getSubCategorieDAO();
	private DateConverter dc = new DateConverter();
	@Override
	public void create(Object T) throws SQLException {
		Veiling veiling = (Veiling) T;
		db.open();
		db.createStmt();

		java.util.Date aanmaakdate = veiling.getAanmaakDatum();
		java.sql.Date aanmaakdatum = dc.utilToSql(aanmaakdate);
		java.util.Date verloopdate = veiling.getVerloopDatum();
		java.sql.Date verloopdatum = dc.utilToSql(verloopdate);

		String statement = "INSERT INTO TO5_VEILING(TITEL, BESCHRIJVING, AANMAAKDATUM, VERLOOPDATUM, AANBIEDER, SUBCATEGORIE) values (?,?,?,?,?,?)";
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

	@SuppressWarnings("null")
	@Override
	public List<Veiling> read() throws SQLException {
		List<Veiling> alleVeilingen = new ArrayList<Veiling>();
		java.sql.Date aanmaakdate = null;
		java.util.Date aanmaakdatum = null;
		java.sql.Date verloopdate = null;
		java.util.Date verloopdatum = null;
		Gebruiker aanbieder = null;
		int gebid;
		SubCategorie subcat = null;
		int scid;
		
		db.open();
		db.createStmt();
		
		String query = "SELECT * FROM TO5_VEILING";
		ResultSet rs = db.getStmt().executeQuery(query);
		
		while(rs.next())
		{
/*
			verloopdate = rs.getDate("VERLOOPDATUM");
			if(verloopdate != null || !verloopdate.equals("")){
				verloopdatum = dc.sqlToUtil(verloopdate);
			}
			aanmaakdate = rs.getDate("AANMAAKDATUM");
			if(aanmaakdate != null || !aanmaakdate.equals("")){
				aanmaakdatum = dc.sqlToUtil(aanmaakdate);
			}
			gebid = rs.getInt("AANBIEDER");
			if(gebid > 0){
				//De volgende code werkt niet omdat de verbinding in getObject wordt gesloten
				aanbieder = (Gebruiker)gebdao.getObject(gebid);
			}
			scid = rs.getInt("SUBCATEGORIE");
			if(scid > 0){
				//De volgende code werkt niet omdat de verbinding in getObject wordt gesloten
				subcat = (SubCategorie)scdao.getObject(scid);
			}
			alleVeilingen.add(new Veiling(
					aanbieder,
					subcat,
					rs.getString("TITEL"),
					rs.getString("BESCHRIJVING"),
					aanmaakdatum,
					verloopdatum,
					rs.getInt("ID")
					));
*/
			verloopdate = rs.getDate("VERLOOPDATUM");
			aanmaakdate = rs.getDate("AANMAAKDATUM");
			gebid = rs.getInt("AANBIEDER");
			scid = rs.getInt("SUBCATEGORIE");
			String titel = rs.getString("TITEL");
			String beschrijving = rs.getString("BESCHRIJVING");
			int iedee = rs.getInt("ID");
			
			if(verloopdate != null || !verloopdate.equals("")){
				verloopdatum = dc.sqlToUtil(verloopdate);
			}
			if(aanmaakdate != null || !aanmaakdate.equals("")){
				aanmaakdatum = dc.sqlToUtil(aanmaakdate);
			}
			if(gebid > 0){
				//De volgende code werkt niet omdat de verbinding in getObject wordt gesloten
				//aanbieder = (Gebruiker)gebdao.getObject(gebid);
				aanbieder = new Gebruiker("guido", "P", "munk", "hallo", "guido@munk.nl", "trompetdreef 5", "3845CJ", "Harderwijk", new Date(), new Long("0625338663"));
			}
			if(scid > 0){
				//De volgende code werkt niet omdat de verbinding in getObject wordt gesloten
				//subcat = (SubCategorie)scdao.getObject(scid);
				subcat = new SubCategorie("telefoons", "telefoon veiling", 9, new Categorie("elektronica", "elektronica veilingen"));
			}
			
			alleVeilingen.add(new Veiling(
					aanbieder,
					subcat,
					titel,
					beschrijving,
					aanmaakdatum,
					verloopdatum,
					iedee
					));
		}
		rs.close();

		db.closeStmt();
		db.close();		

		return alleVeilingen;
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
			scid = rs.getInt("SUBCATEGORIE");
			if(scid > 0){
				subcat = (SubCategorie)scdao.getObject(scid);
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
