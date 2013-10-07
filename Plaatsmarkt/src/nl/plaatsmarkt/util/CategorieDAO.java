package nl.plaatsmarkt.util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nl.plaatsmarkt.domain.Categorie;

public class CategorieDAO implements IDAO<Categorie>{
	private DatabaseDAO db = ServiceProvider.getDatabaseDAO();
	
	@Override
	public void create(Object T) throws SQLException {
		Categorie categorie = (Categorie)T;
		db.open();
		db.createStmt();
		
		String statement = "INSERT INTO TO5_CATEGORIE(OMSCHRIJVING, NAAM) values (?,?)";
		PreparedStatement preparedStatement = db.getCon().prepareStatement(statement);
		preparedStatement.setString(1, categorie.getOmschrijving());
		preparedStatement.setString(2, categorie.getNaam());
		preparedStatement.execute();
		
		db.close();
		db.closeStmt();		
	}

	@Override
	public List<Categorie> read() throws SQLException {
		db.open();
		db.createStmt();
		String query = "SELECT * FROM TO5_CATEGORIE";
		ResultSet rs = db.getStmt().executeQuery(query);
		List<Categorie> alleCategoriën = new ArrayList<Categorie>();
		while(rs.next())
			{
			alleCategoriën.add(
					new Categorie	(	
										rs.getString("NAAM"),
										rs.getString("OMSCHRIJVING"),
										Integer.parseInt(rs.getString("ID"))
									)
					);
			}
		rs.close();
		
		db.close();
		db.closeStmt();		
		
		return alleCategoriën;
	}

	@Override
	public Object getObject(int ID) throws SQLException {
		Categorie opgehaaldeCategorie = null;
		try {
			db.open();
			String query = "SELECT * FROM TO5_CATEGORIE WHERE id = " + ID;
			PreparedStatement ps;
			ps = db.getCon().prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			rs.next();
		
			opgehaaldeCategorie = new Categorie	(	
					rs.getString("NAAM"),
					rs.getString("OMSCHRIJVING"),
					Integer.parseInt(rs.getString("ID"))
				);
			
			ps.close();
			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return opgehaaldeCategorie;
	}
	
	@Override
	public Object getObject(String NAAM) throws SQLException {
		Categorie opgehaaldeCategorie = null;
		try {
			db.open();
			String query = "SELECT * FROM TO5_CATEGORIE WHERE NAAM = " + NAAM;
			PreparedStatement ps;
			ps = db.getCon().prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			rs.next();
		
			opgehaaldeCategorie = new Categorie	(	
					rs.getString("NAAM"),
					rs.getString("OMSCHRIJVING"),
					Integer.parseInt(rs.getString("ID"))
				);
			
			ps.close();
			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return opgehaaldeCategorie;
	}

	@Override
	public void update(Object T) throws SQLException {
		Categorie categorie = (Categorie)T;
		int id = categorie.getID();
		
		db.open();
		db.createStmt();
		
		String statement = "UPDATE TO5_CATEGORIE SET OMSCHRIJVING=?, NAAM=? WHERE ID = " + id;
		PreparedStatement preparedStatement = db.getCon().prepareStatement(statement);
		preparedStatement.setString(1, categorie.getOmschrijving());
		preparedStatement.setString(2, categorie.getNaam());
		preparedStatement.execute();
		
		db.close();
		db.closeStmt();		
	}

	@Override
	public void delete(Object T) throws SQLException {
		Categorie categorie = (Categorie)T;
		int id = categorie.getID();
		
		db.open();
		db.createStmt();
		
		String statement = "DELETE FROM TO5_CATEGORIE WHERE id = " + id;
		PreparedStatement preparedStatement = db.getCon().prepareStatement(statement);
		preparedStatement.execute();
		
		db.close();
		db.closeStmt();	
	}
	
	@Override
	public void delete(int ID) throws SQLException {
		db.open();
		db.createStmt();
		
		String statement = "DELETE FROM TO5_CATEGORIE WHERE id = " + ID;
		PreparedStatement preparedStatement = db.getCon().prepareStatement(statement);
		preparedStatement.execute();
		
		db.close();
		db.closeStmt();	
	}

	@Override
	public int count() {
		return db.getRows("TO5_CATEGORIE");
	}

}
