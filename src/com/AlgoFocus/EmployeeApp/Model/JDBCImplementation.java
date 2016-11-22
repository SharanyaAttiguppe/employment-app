package com.AlgoFocus.EmployeeApp.Model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Clob;

import java.sql.PreparedStatement;


public class JDBCImplementation implements CandidateDAO {

	Connection con = null;
	PreparedStatement pstmt = null;

	public boolean registeration(String fname, String mname, String lname,
			String dateofbirth, String email, String Mobilenumber,
			String highQual, String highestPerc, String graduation,
			String degreePerc, String puc, String pucPerc, String sslc,
			String sslcPerc, String resume, String address) 
	{

		try {
			// 1. Load the Driver

			Class.forName("com.mysql.jdbc.Driver");

			// 2.Get the DB Connection via Driver

			String url = "jdbc:mysql://localhost:3306/employement";
			
			FileReader reader = new FileReader("E:\\My Workspace\\EmployeementApp\\WebContent\\credenti.properties");
			Properties prop = new Properties();
			prop.load(reader);

			con=DriverManager.getConnection(url, prop);

			// 3. Issue Sql Queries via Connection

			String query = " insert into candidates_table values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, fname);
			pstmt.setString(2, mname);
			pstmt.setString(3, lname);
			pstmt.setString(4, dateofbirth);
			pstmt.setString(5, email);
			pstmt.setString(6,Mobilenumber);
			pstmt.setString(7, highQual);
			pstmt.setDouble(8, Double.parseDouble(highestPerc));
			pstmt.setString(9, graduation);
			pstmt.setDouble(10, Double.parseDouble(degreePerc));
			pstmt.setString(11, puc);
			pstmt.setDouble(12, Double.parseDouble(pucPerc));
			pstmt.setString(13, sslc);
			pstmt.setDouble(14, Double.parseDouble(sslcPerc));
			pstmt.setString(15, resume);
			pstmt.setString(16, address);
			
			int count = pstmt.executeUpdate();

			// 4. process the result
			if (count == 1) 
			{

				//System.out.println("Successfully entered Candidate Details");
				return true;
			} else {
				System.out.println("Please retry");
				return false;
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {

			try {
				if (con != null) {
					con.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
