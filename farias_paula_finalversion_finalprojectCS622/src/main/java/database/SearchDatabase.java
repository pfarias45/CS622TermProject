package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class SearchDatabase {

	private static String url = "jdbc:sqlite:RBDatabase.db";

	/**
	 * Desc: Method finds resume name of specific user (used to make sure resume names are always unique)
	 * Param: String username, resume name
	 * Return: true if resume name found
	*/
	public static boolean findResumeName(String username, String resumeName) {
		try (Connection conn = DriverManager.getConnection(url)) {
			// find whether a resume name matches the user's account
			String sql = "SELECT * from Resumes WHERE u_name = ? AND r_name = ?";
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, username);
			s.setString(2, resumeName);
			ResultSet results = s.executeQuery();
			if (results.isBeforeFirst()) {
				System.out.println("\nResume name already exists for this user. Please enter another one.");
				return true;
			}
		}
		catch (SQLException e) {
			System.out.println("\nUnable to connect to database.");
			e.printStackTrace();
		} 
		return false;
	}
	
	/**
	 * Desc: Method finds specific user (used to make sure users don't have duplicate accounts on users table)
	 * Param: String username
	 * Return: true if user found
	*/
	public static boolean findUser(String username) {
		try (Connection conn = DriverManager.getConnection(url)) {
			// find whether username exists in table
			String sql = "SELECT u_name from Resumes WHERE u_name = ?";
			PreparedStatement s = conn.prepareStatement(sql);
			// set values for each ?
			s.setString(1, username);
			ResultSet results = s.executeQuery();	
			if (!results.isBeforeFirst()) return false;
		} catch (SQLException e) {
			System.out.println("\nUnable to connect to database.");
			e.printStackTrace();
		}
		return true;
	}
		
	/**
	 * Desc: Method lists all resumes names for a specific user
	 * Param: String username
	 * Return: 
	*/
	public static void listResumeNames(String username) {
		try (Connection conn = DriverManager.getConnection(url)) {
			// list resume names for user in ascending order
			String sql = "SELECT r_name from Resumes WHERE u_name = ?"
					+ "order by r_name";
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, username);
			ResultSet results = s.executeQuery();
			if (!results.isBeforeFirst()) System.out.println("\nUser not in database.");
			else {
				System.out.println("\nHere is the list of resume names for that user:\n");
				System.out.printf("RESUME NAMES");
				System.out.println();
				while(results.next()) {
					System.out.println(results.getString(1));      
				}	
			}
		}
		catch (SQLException e) {
			System.out.println("\nUnable to connect to database.");
			e.printStackTrace();
		} 
	
	}
	
	/**
	 * Desc: Method lists all users
	 * Param: 
	 * Return: 
	*/
	public static void listUsers() {
		try (Connection conn = DriverManager.getConnection(url)) {
			// count number of resumes for each login date, order by date
			String sql =  "SELECT * from Users "
					+ "order by u_name";
			PreparedStatement s = conn.prepareStatement(sql);
			ResultSet results = s.executeQuery();
			if (!results.isBeforeFirst()) System.out.println("\nNo users in database.");
			else {
				System.out.println("\nHere is a list of all users:\n");
				System.out.printf("%1s %30s", "USER", "LOGIN");
				System.out.println();
				while(results.next()) {
					System.out.printf("%5s %30s", results.getString(1), results.getString(2));  
					System.out.println();
				}	
			}
		}
		catch (SQLException e) {
			System.out.println("\nUnable to connect to database.");
			e.printStackTrace();
		} 
	}
	
	/**
	 * Desc: Method lists total count of resumes per login date of users
	 * Param: 
	 * Return: 
	*/
	public static void listResumeCount() {
		try (Connection conn = DriverManager.getConnection(url)) {
			// count number of resumes for each login date, order by date
			String sql =  "SELECT t1.last_login, count(r_name) from Resumes as t2 "
					+ "inner join Users as t1 on t1.u_name = t2.u_name "
					+ "group by t1.last_login "
					+ "order by t1.last_login";
			PreparedStatement s = conn.prepareStatement(sql);
			ResultSet results = s.executeQuery();
			if (!results.isBeforeFirst()) System.out.println("\nNo users in database.");
			else {
				System.out.println("\nHere is a count of resumes per login date of users:\n");
				System.out.printf("%1s %40s", "LOGIN", "RESUME COUNT");
				System.out.println();
				while(results.next()) {
					System.out.printf("%5s %30s", results.getString(1), results.getString(2));  
					System.out.println();
				}	
			}
		}
		catch (SQLException e) {
			System.out.println("\nUnable to connect to database.");
			e.printStackTrace();
		} 
	}
		
	/**
	 * Desc: Method lists content of resume for specific user
	 * Param: String username, resumeName
	 * Return: 
	*/
	public static void listResumeContent(String username, String resumeName) {
		try (Connection conn = DriverManager.getConnection(url)) {
			// list resume content of resume matching resume name and username
			String sql = "SELECT * from Resumes WHERE u_name = ? AND r_name = ?";
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, username);
			s.setString(2, resumeName);
			ResultSet results = s.executeQuery();	
			if (!results.isBeforeFirst()) System.out.println("\nResume name not found for given username.");
			else {	
				
				System.out.println("\nHere is the requested resume " + resumeName + " for user " + username + ":\n");
				while (results.next()) {
			        System.out.println(results.getString(3) + "\n" + results.getString(4) + "\n" 
			        					+ results.getString(5) + "\n" + results.getString(6) + "\n" 
			        					+ results.getString(7));
			    }
			}
		}
		catch (SQLException e) {
			System.out.println("\nUnable to connect to database.");
			e.printStackTrace();
		}
	}

}
