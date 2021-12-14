import java.sql.*;
import java.util.ArrayList;



public class DataBase  {

	static Connection conn = null;
	
	// creating new data base
	public static void createNewDataBase(String fileName) {
		String url = "jdbc:sqlite:" + fileName;
		try(Connection conn = DriverManager.getConnection(url)){
			if(conn != null) {
				DatabaseMetaData meta = conn.getMetaData();
				
				// making sure the database has been created during testing
				System.out.println("The driver name is " + meta.getDriverName());
				System.out.println("Database created");
			}
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Error in createNewDataBase()");
		}

	}
	// creating a new table if not existed 
	public static void connectAndCreateTable() {

		try {
			String url = "jdbc:sqlite:GreatestScore.db";
			conn = DriverManager.getConnection(url);
			// making sure the connection has been established during testing
			System.out.println("Connection has been established, and a table has been created");

			String sql = "create table if not exists Players("
					+ "id integer primary key,"
					+ "name text not null,"
					+ "score integer"
					+ ")";
			Statement stmt = conn.createStatement();
			stmt.execute(sql);


		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Error in connectAndCreateTable()");
		}


	}
	// inserting a new player to the data base with default score = 0
	public static void insertPlayer(Player player) {		
		try {
			String sqlInsert = "Insert into Players ("
					+ "name,"
					+ "score)"
					+ " values(?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sqlInsert);
			pstmt.setString(1,player.getName());
			pstmt.setInt(2,player.getScore());
			pstmt.executeUpdate();
			

		} 
		catch(SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Error in insertPlayer(Player player)");
		}


	}
	
	// updating the score of the player after finishing the game.
	public static void updateScore(Player player) {
		try {
			String sqlUpdate = "UPDATE Players SET score = ?  WHERE name = ? ;"  ;
			PreparedStatement pstmt = conn.prepareStatement(sqlUpdate);
			pstmt.setInt(1,player.getScore());
			pstmt.setString(2,player.getName());
			pstmt.executeUpdate();
			
			

		} 
		catch(SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Error in updatePlayer(Player player)");
		}
	}
	
	// method to return the highest 10 scores to be put on the file (Hall oF Fame.txt)
	public static String showScore() {
		ArrayList<String> array = new ArrayList<>();
		String line1 = null, line2 = null,line3 = null,line4 = null, line5 = null, line6 = null, line7 = null, line8 = null, line9 = null,line10 = null;
		
		try {
			Statement stmt = conn.createStatement();
			String sqlGetInfo = "select id, name, score from Players "
					+ "order by score DESC "
					+ "limit 10; " ;
			ResultSet rs = stmt.executeQuery(sqlGetInfo);
			
			

			while(rs.next()) {
				
				array.add(rs.getInt("id")+"\t\t"+rs.getString("name")+"\t\t"+rs.getInt("score"));
				
			}
			line1 = array.get(0);
			line2 = array.get(1);
			line3 = array.get(2);
			line4 = array.get(3);
			line5 = array.get(4);
			line6 = array.get(5);
			line7 = array.get(6);
			line8 = array.get(7);
			line9 = array.get(8);
			line10 = array.get(9);
			
			
			

		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Error in  showscore");
		}
		
		return "ID      :     Name   :   Score   \n" + line1 + " \n"
						+ line2 + " \n"
						+ line3 + " \n"
						+ line4 + " \n"
						+ line5 + " \n"
						+ line6 + " \n"
						+ line7 + " \n"
						+ line8 + " \n"
						+ line9 + " \n"
						+ line10 ; 
			
				}
	
		// closing the connection after we are done with the game
	public static void closeConnection() {
		if(conn != null) {
			try {conn.close();
			}
			catch(SQLException e) {
				System.out.println(e.getMessage());
				System.out.println("Error catch close connection");
			}
		}
	}



}
