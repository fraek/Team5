package nl.plaatsmarkt.util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nl.plaatsmarkt.domain.Categorie;
import nl.plaatsmarkt.domain.SubCategorie;

public class SubCategorieDAO implements IDAO<SubCategorie>{
	private IDAO<Categorie> catDAO = ServiceProvider.getCategorieDAO();
	private DatabaseDAO db = ServiceProvider.getDatabaseDAO();	

	@Override
	public void create(Object T) throws SQLException {
		SubCategorie subcategorie = (SubCategorie)T;
		db.open();
		db.createStmt();

		String statement = "INSERT INTO TO5_SUBCATEGORIE(OMSCHRIJVING, NAAM, CATEGORIE) values (?,?,?)";
		PreparedStatement preparedStatement = db.getCon().prepareStatement(statement);
		preparedStatement.setString(1, subcategorie.getOmschrijving());
		preparedStatement.setString(2, subcategorie.getNaam());
		preparedStatement.setInt(3, subcategorie.getCategorie().getID());
		preparedStatement.execute();

		db.close();
		db.closeStmt();		
	}

	@Override
	public List<SubCategorie> read() throws SQLException {
		db.open();
		db.createStmt();
		String query = "SELECT * FROM TO5_SUBCATEGORIE";
		ResultSet rs = db.getStmt().executeQuery(query);
		
		//Een lege lijst aanmaken die je uiteindelijk gevuld teruggeeft
		List<SubCategorie> alleSubcategoriën = new ArrayList<SubCategorie>();
		//Een lege 'categorie' aanmaken die iedere keer opnieuw wordt gevuld in de loop
		Categorie categorie = null;
		while(rs.next())
		{	
			//De categorie van de subcategorie ophalen dmv DAO
			categorie = (Categorie) catDAO.getObject(rs.getString("CATEGORIE"));
			alleSubcategoriën.add(
					new SubCategorie(	
							rs.getString("NAAM"),
							rs.getString("OMSCHRIJVING"),
							Integer.parseInt(rs.getString("ID")),
							categorie)
					);
		}
		rs.close();

		db.close();
		db.closeStmt();		

		return alleSubcategoriën;
	}

	@Override
	public Object getObject(int ID) throws SQLException {
		SubCategorie opgehaaldeSubcategorie = null;
		try {
			db.open();
			String query = "SELECT * FROM TO5_SUBCATEGORIE WHERE id = " + ID;
			PreparedStatement ps;
			ps = db.getCon().prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			rs.next();
			
			//De categorie van de subcategorie ophalen dmv DAO
			Categorie categorie = (Categorie) catDAO.getObject(rs.getString("CATEGORIE"));
			opgehaaldeSubcategorie = new SubCategorie	(	
					rs.getString("NAAM"),
					rs.getString("OMSCHRIJVING"),
					Integer.parseInt(rs.getString("ID")),
					categorie
					);

			ps.close();
			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return opgehaaldeSubcategorie;
	}
	
	@Override
	public Object getObject(String NAAM) throws SQLException {
		SubCategorie opgehaaldeSubcategorie = null;
		try {
			db.open();
			String query = "SELECT * FROM TO5_SUBCATEGORIE WHERE NAAM = " + NAAM;
			PreparedStatement ps;
			ps = db.getCon().prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			rs.next();
			
			//De categorie van de subcategorie ophalen dmv DAO
			Categorie categorie = (Categorie) catDAO.getObject(rs.getString("CATEGORIE"));
			opgehaaldeSubcategorie = new SubCategorie	(	
					rs.getString("NAAM"),
					rs.getString("OMSCHRIJVING"),
					Integer.parseInt(rs.getString("ID")),
					categorie
					);

			ps.close();
			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return opgehaaldeSubcategorie;
	}

	@Override
	public void update(Object T) throws SQLException {
		SubCategorie subcategorie = (SubCategorie)T;
		int id = subcategorie.getID();

		db.open();
		db.createStmt();

		String statement = "UPDATE TO5_SUBCATEGORIE SET OMSCHRIJVING=?, NAAM=?, CATEGORIE=? WHERE ID = " + id;
		PreparedStatement preparedStatement = db.getCon().prepareStatement(statement);
		preparedStatement.setString(1, subcategorie.getOmschrijving());
		preparedStatement.setString(2, subcategorie.getNaam());
		preparedStatement.setString(3, subcategorie.getCategorie().toString());
		preparedStatement.execute();

		db.close();
		db.closeStmt();		
	}

	@Override
	public void delete(Object T) throws SQLException {
		SubCategorie subcategorie = (SubCategorie)T;
		int id = subcategorie.getID();

		db.open();
		db.createStmt();

		String statement = "DELETE FROM TO5_SUBCATEGORIE WHERE id = " + id;
		PreparedStatement preparedStatement = db.getCon().prepareStatement(statement);
		preparedStatement.execute();

		db.close();
		db.closeStmt();	
	}

	@Override
	public void delete(int ID) throws SQLException {
		db.open();
		db.createStmt();

		String statement = "DELETE FROM TO5_SUBCATEGORIE WHERE id = " + ID;
		PreparedStatement preparedStatement = db.getCon().prepareStatement(statement);
		preparedStatement.execute();

		db.close();
		db.closeStmt();	
	}

	@Override
	public int count() {
		return db.getRows("TO5_SUBCATEGORIE");
	}

}
