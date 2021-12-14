import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;


public class DataBaseTest {
	static Connection conn = null;
	
	public static void createNewDataBase(String fileName) {
		String url = "jdbc:sqlite:⁨/Users/ahmed/javaEclipseWorkspace/Database/⁨src/" + fileName;
		try{
			conn = DriverManager.getConnection(url);
			if(conn != null) {
				DatabaseMetaData meta = conn.getMetaData();
				System.out.println("The driver name is " + meta.getDriverName());
				System.out.println("Done");
			}
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Error catch create new data base");
		}
		
		

	}
	public static void connectAndCreateTable(String fileName) {

		try {
			String url = "jdbc:sqlite:/Users/ahmed/javaEclipseWorkspace/Database/src/" + fileName;
			conn = DriverManager.getConnection(url);
			System.out.println("Connection has been established");
			
			String sql = "create table if not exists Customers("
					+ "id integer primary key,"
					+ "firstName text not null,"
					+ "lastName text not null,"
					+ "age integer,"
					+ "ssn integer,"
					+ "creditCard integer"
					+ ")";
			Statement stmt = conn.createStatement();
			stmt.execute(sql);

			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Error catch connect and create");
		}
		
		
	}
	public static void printTable() {

		try {
			Statement stmt = conn.createStatement();
			String sqlGetInfo = "select id, firstName, lastName, age, ssn, creditCard from Customers ; " ;
			ResultSet rs = stmt.executeQuery(sqlGetInfo);
			System.out.println("ID      :     First Name   :   Last Name   :    Age     :        SSN     :     Credit Card #");

			while(rs.next()) {
				System.out.println(rs.getInt("id")+"\t\t"+rs.getString("firstName")+"\t\t"+rs.getString("lastName")+"\t\t"+rs.getInt("age")+"\t\t"+rs.getInt("ssn")+"\t\t"+rs.getInt("creditCard"));
			}

		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Error in catch getInfo");
		}
	}
	public static void insertPerson(Person person) {		
		try {
			String sqlInsert = "Insert into Customers ("
					+ "firstName,"
					+ "lastName,"
					+ "age,"
					+ "ssn,"
					+ "creditCard)"
					+ " values(?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sqlInsert);
			pstmt.setString(1,person.getFirstName());
			pstmt.setString(2,person.getLastName());
			pstmt.setInt(3,person.getAge());
			pstmt.setLong(4,person.getSsn());
			pstmt.setLong(5,person.getCreditCard());
			pstmt.executeUpdate();
			
		} 
		catch(SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Error in catch insert");
		}
		
		
	}
	public static Person selectPerson(int i) {
		String fname = null;
		String lname = null;
		int age = 0;
		int ssn = 0;
		int creditCard = 0;
		try {
			Statement stmt = conn.createStatement();

			String selectPerson = "select id, firstName, lastName, age, ssn, creditCard from Customers where id =  " + Integer.toString(i) + "  ;" ;
			ResultSet rs = stmt.executeQuery(selectPerson);
			fname = rs.getString("firstName");
			lname = rs.getString("lastName");
			age = rs.getInt("age");
			ssn = rs.getInt("ssn");
			creditCard = rs.getInt("creditCard") ;
			System.out.println("ID      :     First Name   :   Last Name   :    Age     :        SSN     :     Credit Card #");
			System.out.println(rs.getInt("id")+"\t\t"+
							   rs.getString("firstName")+"\t\t"+
							   rs.getString("lastName")+"\t\t"+
							   rs.getInt("age")+"\t\t"+
							   rs.getInt("ssn")+"\t\t"+
							   rs.getInt("creditCard"));

		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Error in catch selectPerson");
		}
		return  new Person(fname,lname,age,ssn,creditCard);	
	}
	public static ArrayList<Person> findAllPeople(){
		ArrayList<Person> person = new ArrayList<>();
		try {

			Statement stmt = conn.createStatement();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Customers;");
			while (rs.next()) {
				person.add(new Person(rs.getString("firstName"), 
									  rs.getString("lastName"),
									  rs.getInt("age"),
									  rs.getInt("ssn"), 
									  rs.getInt("creditCard")));
			}


		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error in catch find all people");

		}
	

		
		return person;

	}
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
	
	public static void deletePerson(String fname, String lname) {
		// for me, I will not let the method to return anything
		try {
			Statement stmt = conn.createStatement();
			String sqlShowDelete = "select * from Customers where lastName = '"+ lname +"' and firstName = '"+fname+"' ;";
			ResultSet rs = stmt.executeQuery(sqlShowDelete);
			System.out.println("The following data will be deleted");
			System.out.println("ID      :     First Name   :   Last Name   :    Age     :        SSN     :     Credit Card #");
			System.out.println(rs.getInt("id")+"\t\t"+
							   rs.getString("firstName")+"\t\t"+
							   rs.getString("lastName")+"\t\t"+
							   rs.getInt("age")+"\t\t"+
							   rs.getInt("ssn")+"\t\t"+
							   rs.getInt("creditCard"));


			String sqlDelete = "delete from Customers where lastName = '"+ lname +"' and firstName = '"+fname+"' ;";
			stmt.executeUpdate(sqlDelete);
			System.out.println("Deletion complete.");
		} 
		catch(SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Error catch delete");
			// (Recursion) we will call the method again, if it could not find the name from the first trial. 
			System.out.println("We couldn't find a person with that name in the data base, please try another name.");
			Scanner scnr = new Scanner(System.in);
			System.out.println("Enter first name: ");
			String fname1 = scnr.next();
			System.out.println("Enter last name: ");
			String lname2 = scnr.next();
			deletePerson(fname1,lname2);
			

		}
		

	}
	

	public static void main(String[] args) {
		// create a new data base file
		createNewDataBase("table.db");
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		// connect to the created data base file and create a new table
		connectAndCreateTable("table.db");
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		// create objects to be inserted into the data base 
		Person Ahmed = new Person("Ahmed","Elshetany",26,8776367,993039939);
		Person Messi = new Person("Leonel","Messi",32,918828,8836774);
		Person John = new Person("John","Cena",35,8838939,1992838);
		Person Mickey = new Person("Mickey","Mouse",104,86543456,4562762);
		Person Simba = new Person("Lion","King",11,876543,654345678);
		// insert the previous objects to the data base
		insertPerson(Ahmed);
		insertPerson(Messi);
		insertPerson(John);
		insertPerson(Mickey);
		insertPerson(Simba);
		// print the data base
		printTable();
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		// will print out the row in the data base corresponding to the id number (method's parameter)
		selectPerson(4);
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		// Testing findAllPeople() method.
		ArrayList<Person> person = findAllPeople();
		System.out.println(person);  // I am not sure if that what you meant by " Demonstrate that it is working correctly. "
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		// Test deletePerson method, one with wrong parameters and one with the right parameters
		//deletePerson("Cristiano","Ronaldo");
		//deletePerson("Mickey","Mouse");
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		// print the table again to make sure we deleted the previous rows
		printTable();
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		System.out.println(findAllPeople()); 
		System.out.println("-------------------------------------------------------------------------------------------------------------");

		//insertPerson(John);
		printTable();
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		closeConnection();
	}

}
