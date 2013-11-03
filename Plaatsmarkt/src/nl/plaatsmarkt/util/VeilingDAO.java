package nl.plaatsmarkt.util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nl.plaatsmarkt.domain.Gebruiker;
import nl.plaatsmarkt.domain.SubCategorie;
import nl.plaatsmarkt.domain.Veiling;
//VeilingDAO
public class VeilingDAO implements IDAO<Veiling>{
	private DatabaseDAO vdb = ServiceProvider.getDatabaseDAO();
	private IDAO<Gebruiker> gebdao = ServiceProvider.getGebruikerDAO();
	private IDAO<SubCategorie> scdao = ServiceProvider.getSubCategorieDAO();
	private DateConverter dc = new DateConverter();
	@Override
	public void create(Object T) throws SQLException {
		Veiling veiling = (Veiling) T;
		vdb.open();
		vdb.createStmt();

		java.util.Date aanmaakdate = veiling.getAanmaakDatum();
		java.sql.Date aanmaakdatum = dc.utilToSql(aanmaakdate);
		java.util.Date verloopdate = veiling.getVerloopDatum();
		java.sql.Date verloopdatum = dc.utilToSql(verloopdate);

		String statement = "INSERT INTO TO5_VEILING(TITEL, BESCHRIJVING, AANMAAKDATUM, VERLOOPDATUM, AANBIEDER, SUBCATEGORIE) values (?,?,?,?,?,?)";
		PreparedStatement preparedStatement = vdb.getCon().prepareStatement(statement);
		preparedStatement.setString(1, veiling.getTitel());
		preparedStatement.setString(2, veiling.getBeschrijving());
		preparedStatement.setDate(3, aanmaakdatum);
		preparedStatement.setDate(4, verloopdatum);
		preparedStatement.setInt(5, veiling.getDeAanbieder().getID());
		preparedStatement.setInt(6, veiling.getDeSubCategorie().getID());
		preparedStatement.execute();

		vdb.close();
		vdb.closeStmt();		
	}

	@Override
	public List<Veiling> read() throws SQLException {
		List<Veiling> alleVeilingen = new ArrayList<Veiling>();
		int max = count();
		int[] idList = new int[max];
		int at = 0;
		vdb.open();
		vdb.createStmt();

		String query = "SELECT * FROM TO5_VEILING";
		ResultSet rs = vdb.getStmt().executeQuery(query);

		while(rs.next())
		{
			if(at > max){ break;}
			int id = rs.getInt(1);
			idList[at] = id;
			at++;
		}
		rs.close();

		vdb.closeStmt();
		vdb.close();

		for(int i = 0; i < max; i++){
			int newId = idList[i];
			alleVeilingen.add((Veiling) getObject(newId));
		}

		return alleVeilingen;
	}

	@SuppressWarnings("null")
	@Override
	public Object getObject(int ID) throws SQLException {
		Veiling opgehaaldeVeiling = null;
		try {
			vdb.open();
			String query = "SELECT * FROM TO5_VEILING WHERE id = " + ID;
			PreparedStatement ps;
			ps = vdb.getCon().prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			java.sql.Date verloopdate = null;
			java.util.Date verloopdatum = null;
			java.sql.Date aanmaakdate = null;
			java.util.Date aanmaakdatum = null;
			String titel, beschrijving;
			int id = 0;
			rs.next();

			Gebruiker aanbieder = null;
			int gebid;
			SubCategorie subcat = null;
			int scid;

			id = rs.getInt("ID");

			titel = rs.getString("TITEL");
			beschrijving = rs.getString("BESCHRIJVING");

			verloopdate = rs.getDate("VERLOOPDATUM");
			if(verloopdate != null || !verloopdate.equals("")){
				verloopdatum = dc.sqlToUtil(verloopdate);
			}
			aanmaakdate = rs.getDate("AANMAAKDATUM");
			if(aanmaakdate != null || !aanmaakdate.equals("")){
				aanmaakdatum = dc.sqlToUtil(aanmaakdate);
			}
			gebid = rs.getInt("AANBIEDER");
			scid = rs.getInt("SUBCATEGORIE");
			if(gebid > 0){
				aanbieder = (Gebruiker)gebdao.getObject(gebid);
			}
			if(scid > 0){
				subcat = (SubCategorie)scdao.getObject(scid);
			}

			opgehaaldeVeiling = new Veiling(
					aanbieder,
					subcat,
					titel,
					beschrijving,
					aanmaakdatum,
					verloopdatum,
					id);
			
			ps.close();
			vdb.close();
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

		vdb.open();
		vdb.createStmt();

		java.util.Date aanmaakdate = veiling.getAanmaakDatum();
		java.sql.Date aanmaakdatum = dc.utilToSql(aanmaakdate);
		java.util.Date verloopdate = veiling.getVerloopDatum();
		java.sql.Date verloopdatum = dc.utilToSql(verloopdate);

		String statement = "UPDATE TO5_VEILING SET TITEL=?, BESCHRIJVING=?, AANMAAKDATUM=?, VERLOOPDATUM=?, AANBIEDER=?, SUBCATEGORIE=? WHERE ID="+id;
		PreparedStatement preparedStatement = vdb.getCon().prepareStatement(statement);
		preparedStatement.setString(1, veiling.getTitel());
		preparedStatement.setString(2, veiling.getBeschrijving());
		preparedStatement.setDate(3, aanmaakdatum);
		preparedStatement.setDate(4, verloopdatum);
		preparedStatement.setInt(5, veiling.getDeAanbieder().getID());
		preparedStatement.setInt(6, veiling.getDeSubCategorie().getID());
		preparedStatement.execute();

		vdb.close();
		vdb.closeStmt();		
	}

	@Override
	public void delete(Object T) throws SQLException {
		Veiling Veiling = (Veiling)T;
		int id = Veiling.getID();

		vdb.open();
		vdb.createStmt();

		String statement = "DELETE FROM TO5_VEILING WHERE id = " + id;
		PreparedStatement preparedStatement = vdb.getCon().prepareStatement(statement);
		preparedStatement.execute();

		vdb.close();
		vdb.closeStmt();	
	}

	@Override
	public void delete(int ID) throws SQLException {
		vdb.open();
		vdb.createStmt();

		String statement = "DELETE FROM TO5_Veiling WHERE id = " + ID;
		PreparedStatement preparedStatement = vdb.getCon().prepareStatement(statement);
		preparedStatement.execute();

		vdb.close();
		vdb.closeStmt();	
	}

	@Override
	public int count() {
		return vdb.getRows("TO5_VEILING");
	}

	@Override
	public Object getObject(String NAAM) throws SQLException {
		//Deze methode zou theoretisch te gebruiken kunnen zijn bij 1 String waarde
		return null;
	}

}
