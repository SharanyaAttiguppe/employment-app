package com.AlgoFocus.EmployeeApp.Model;

public interface CandidateDAO {

	boolean registeration(String fname, String mname, String lname,
			String dateofbirth, String email,
			String Mobilenumber, String highQual, String highestPerc,
			String graduation, String degreePerc, String puc, String pucPerc,
			String sslc, String sslcPerc, String resume,String address);

}
