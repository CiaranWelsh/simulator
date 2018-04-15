package simulation;

import compartment.Coordinate;
import compartment.Lattice;
import species.Species;

import org.sqlite.*;

import java.io.File;
import java.sql.*;

// Need to store the results
public class Report {
	
	private Lattice lattice;
	private File dbFilename;
	private String dbPath;
	private Connection conn;
	public String name;

	public Report(File dbFilename, String name){
//		this.lattice = lattice;
		this.dbFilename = dbFilename;
		this.name = name; // name of table to store date in
		this.dbPath = "jdbc:sqlite:" + this.dbFilename.toString();
		this.conn = this.connect();
		this.createTable();
		
	}
    private Connection connect() {
        // SQLite connection string
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(this.dbPath);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
	
	public void createTable(){
		String createTableString = "CREATE TABLE IF NOT EXISTS " + this.name + "(\n"
				+ " ID integer PRIMARY KEY,\n"
				+ " Time integer NOT NULL,\n"
				+ " X integer NOT NULL,\n"
				+ " Y integer NOT NULL,\n"
				+ " Z integer NOT NULL,\n"
				+ " Species TEXT NOT NULL\n"
				+ ");";
		
		// add table
		try (Statement stmt = this.conn.createStatement()){
				stmt.execute(createTableString);
			}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			}
		}
		
	public void insert(int time, Coordinate coord, Species species){
		String sql = "BEGIN INSERT INTO " + this.name + " (Time, X, Y, Z, Species) Values(?, ?, ?, ?, ?) COMMIT";
		try (PreparedStatement pstmt = this.conn.prepareStatement(sql)){
			pstmt.setInt(1, time);
			pstmt.setInt(2, coord.x);
			pstmt.setInt(3, coord.y);
			pstmt.setInt(4, coord.z);
			pstmt.setString(5, species.name);
			pstmt.execute();
//			System.out.println("SQL code executed" + sql);
		}
		catch (SQLException e){
			System.out.println(e.getMessage());
		}
	}
	
	public ResultSet getID(int ID){
		String sql = "SELECT * FROM " + this.name + "\n"
				+ "WHERE ID = " + ID + ";";
	
	try 
	{
		Statement stmt = this.conn.createStatement();{
		ResultSet rs = stmt.executeQuery(sql);		
		return rs;
	}
	} 
	catch (SQLException e)
	{
		System.out.println(e.getMessage());
	}
	return null;
	}



}

















