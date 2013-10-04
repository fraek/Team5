package nl.plaatsmarkt.util;

import java.sql.SQLException;
import java.util.List;

public interface IDAO<T> {
	//Create, Read, Update, Delete
	//CRUD
	
	void create(Object T) throws SQLException;
	List<T> read() throws SQLException;
	Object getObject(int ID) throws SQLException;
	Object getObject(String NAAM) throws SQLException;
	void update(Object T) throws SQLException;
	void delete(Object T) throws SQLException;
	void delete(int ID) throws SQLException;
	int count();
}