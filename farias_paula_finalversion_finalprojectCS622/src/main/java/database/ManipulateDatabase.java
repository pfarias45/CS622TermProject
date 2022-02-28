package database;

import java.sql.*;

import accounts.User;
import resume.*;

/**
 * Name: Paula Farias
 * Class: CS-622
 * Date: 2/1/2022
 * Desc: Class makes changes to database (SQLite)
 * */
public abstract class ManipulateDatabase {
	
	private static String url = "jdbc:sqlite:RBDatabase.db";

	/**
	 * Desc: Method updates Users table with most recent login date
	 * Param: String username
	 * Return: 
	*/
	public static void updateLoginDate(String username) {
		// get login
		String loginDate = java.time.LocalDate.now().toString();
		//connect
		try (Connection conn = DriverManager.getConnection(url)) {
	    	// change last login date for row matching username
			String sql = "update Users "
	    			+ "	set last_login = ? "
	    			+ "	where u_name = ?";
	    	try(PreparedStatement p = conn.prepareStatement(sql)) {
				p.setString(1, loginDate);
				p.setString(2, username);
				p.executeUpdate();
			}
			catch(SQLException e) {
				System.out.println("Login date not updated.");
				e.printStackTrace();
			}
		} catch (SQLException e) {
	    	System.out.println("Unable to connect to database.");
			e.printStackTrace();
		}
	}

	/**
	 * Desc: Method updates Users table which stores all unique user names and last login date of user
	 * Param: User account
	 * Return: 
	*/
	public static void updateUsersTable(User user) {
		// get login
		String loginDate = java.time.LocalDate.now().toString();
		try (Connection conn = DriverManager.getConnection(url)) {
			// insert user data into table
	    	String sql = "INSERT INTO Users(u_name, last_login) VALUES (?,?)";
			try(PreparedStatement p = conn.prepareStatement(sql)) {
				p.setString(1, user.getUsername());
				p.setString(2, loginDate);
				p.executeUpdate();
			}
			catch(SQLException e) {
				System.out.println("User not added to database.");
				e.printStackTrace();
			}
	    
		} catch (SQLException e) {
	    	System.out.println("Unable to connect to database.");
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Desc: Method updates Resumes table which stores all resumes created by app
	 * Param: Resume obj
	 * Return: 
	*/
	public static void updateResumesTable(Resume resume) {
		try (Connection conn = DriverManager.getConnection(url)) {
	    	String resumeName = resume.getResumeName();
	    	// insert resume data into table
			String sql = "INSERT INTO Resumes(u_name, r_name, s_contact, s_summary,"
					+ "s_experience, s_education, s_skills) VALUES (?,?,?,?,?,?,?)";
			try(PreparedStatement p = conn.prepareStatement(sql)) {
				p.setString(1, ((Contact) resume.getContactSection(resumeName)).getEmail());
				p.setString(2, resumeName);
				p.setString(3, resume.getContactSection(resumeName).toString());
				p.setString(4, resume.getSummarySection(resumeName).toString());
				p.setString(5, resume.getSortedExpSection(resumeName).toString());
				p.setString(6, resume.getSortedEduSection(resumeName).toString());
				p.setString(7, resume.getSkillsection(resumeName).toString());
				p.executeUpdate();
			}
			catch(SQLException e) {
				System.out.println("Resume not added to database.");
				e.printStackTrace();
			}
	    
		} catch (SQLException e) {
	    	System.out.println("Unable to connect to database.");
			e.printStackTrace();
		}
		
	}
	
	
}