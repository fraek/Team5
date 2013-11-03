package nl.plaatsmarkt.util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import nl.plaatsmarkt.domain.Bod;
import nl.plaatsmarkt.domain.Gebruiker;
import nl.plaatsmarkt.domain.Veiling;

public class BodDAO implements IDAO<Bod>{
	private DatabaseDAO bdb = ServiceProvider.getDatabaseDAO();
	private IDAO<Gebruiker> gebdao = ServiceProvider.getGebruikerDAO();
	private IDAO<Veiling> vdao = ServiceProvider.getVeilingDAO();
	private DateConverter dc = new DateConverter();
	@Override
	public void create(Object T) throws SQLException {
		Bod bod = (Bod) T;
		bdb.open();
		bdb.createStmt();

		java.util.Date date = bod.getDatum();
		//java.sql.Timestamp timestamp = dc.dateToTimestamp(date);
		java.sql.Timestamp timestamp = new Timestamp(date.getTime()); 

		String statement = "INSERT INTO TO5_BOD(TIJD, BEDRAG, BIEDER, VEILING) values (?,?,?,?)";
		PreparedStatement preparedStatement = bdb.getCon().prepareStatement(statement);
		preparedStatement.setTimestamp(1, timestamp);
		preparedStatement.setDouble(2, bod.getBedrag());
		preparedStatement.setInt(3, bod.getDeBieder().getID());
		preparedStatement.setInt(4, bod.getDeVeiling().getID());
		preparedStatement.execute();

		bdb.close();
		bdb.closeStmt();		
	}

	@Override
	public List<Bod> read() throws SQLException {
		List<Bod> alleBiedingen = new ArrayList<Bod>();
		int max = count();
		int[] idList = new int[max];
		int at = 0;
		bdb.open();
		bdb.createStmt();

		String query = "SELECT * FROM TO5_BOD";
		ResultSet rs = bdb.getStmt().executeQuery(query);

		while(rs.next())
		{
			if(at > max){ break;}
			int id = rs.getInt(1);
			idList[at] = id;
			at++;
		}
		rs.close();

		bdb.closeStmt();
		bdb.close();

		for(int i = 0; i < max; i++){
			int newId = idList[i];
			alleBiedingen.add((Bod) getObject(newId));
		}

		return alleBiedingen;
	}

	@SuppressWarnings("null")
	@Override
	public Object getObject(int ID) throws SQLException {
		Bod opgehaaldeBod = null;
		try {
			bdb.open();
			String query = "SELECT * FROM TO5_BOD WHERE id = " + ID;
			PreparedStatement ps;
			ps = bdb.getCon().prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			java.sql.Date gebodenDate = null;
			java.util.Date gebodenDatum = null;
			double b;
			int id = 0;
			
			rs.next();

			Gebruiker bieder = null;
			int bid;
			Veiling v = null;
			int vid;

			id = rs.getInt("ID");
			b = rs.getDouble("BEDRAG");
			bid = rs.getInt("BIEDER");
			vid = rs.getInt("VEILING");
			gebodenDate = rs.getDate("TIJD");

			if(gebodenDate != null || !gebodenDate.equals("")){
				gebodenDatum = dc.sqlToUtil(gebodenDate);
			}
			if(bid > 0){
				bieder = (Gebruiker)gebdao.getObject(bid);
			}
			if(vid > 0){
				v = (Veiling)vdao.getObject(vid);
			}

			opgehaaldeBod = new Bod(
							b, 
							bieder,
							gebodenDatum, 
							v, 
							id);
			
			ps.close();
			bdb.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return opgehaaldeBod;
	}

	@Override
	public void update(Object T) throws SQLException {
		Veiling veiling = (Veiling)T;
		int id = veiling.getID();

		bdb.open();
		bdb.createStmt();

		java.util.Date aanmaakdate = veiling.getAanmaakDatum();
		java.sql.Date aanmaakdatum = dc.utilToSql(aanmaakdate);
		java.util.Date verloopdate = veiling.getVerloopDatum();
		java.sql.Date verloopdatum = dc.utilToSql(verloopdate);

		String statement = "UPDATE TO5_VEILING SET TITEL=?, BESCHRIJVING=?, AANMAAKDATUM=?, VERLOOPDATUM=?, AANBIEDER=?, SUBCATEGORIE=? WHERE ID="+id;
		PreparedStatement preparedStatement = bdb.getCon().prepareStatement(statement);
		preparedStatement.setString(1, veiling.getTitel());
		preparedStatement.setString(2, veiling.getBeschrijving());
		preparedStatement.setDate(3, aanmaakdatum);
		preparedStatement.setDate(4, verloopdatum);
		preparedStatement.setInt(5, veiling.getDeAanbieder().getID());
		preparedStatement.setInt(6, veiling.getDeSubCategorie().getID());
		preparedStatement.execute();

		bdb.close();
		bdb.closeStmt();		
	}

	@Override
	public void delete(Object T) throws SQLException {
		Veiling Veiling = (Veiling)T;
		int id = Veiling.getID();

		bdb.open();
		bdb.createStmt();

		String statement = "DELETE FROM TO5_VEILING WHERE id = " + id;
		PreparedStatement preparedStatement = bdb.getCon().prepareStatement(statement);
		preparedStatement.execute();

		bdb.close();
		bdb.closeStmt();	
	}

	@Override
	public void delete(int ID) throws SQLException {
		bdb.open();
		bdb.createStmt();

		String statement = "DELETE FROM TO5_Veiling WHERE id = " + ID;
		PreparedStatement preparedStatement = bdb.getCon().prepareStatement(statement);
		preparedStatement.execute();

		bdb.close();
		bdb.closeStmt();	
	}

	@Override
	public int count() {
		return bdb.getRows("TO5_BOD");
	}

	@Override
	public Object getObject(String NAAM) throws SQLException {
		//Deze methode zou theoretisch te gebruiken kunnen zijn bij 1 String waarde
		return null;
	}

}
