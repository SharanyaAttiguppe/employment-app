package com.AlgoFocus.EmployeeApp.Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AlgoFocus.EmployeeApp.Model.CandidateDAO;
import com.AlgoFocus.EmployeeApp.Model.DAOFactory;
import com.AlgoFocus.EmployeeApp.SendMail.SendMail;

public class CandidateController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException

	{
		
		BufferedOutputStream bufferout=null;

		PrintWriter output = resp.getWriter();
		resp.setContentType("text/html");

		String fname = req.getParameter("fname");
		String mname = req.getParameter("mname");
		String lname = req.getParameter("lname");
		String dateOfBirth = req.getParameter("dateofbirth");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		System.out.println(address);
		String mobNmber = req.getParameter("Mobilenumber");
		String highQualification = req.getParameter("highQual");
		String highPercent = req.getParameter("highestPerc");
		String graduate = req.getParameter("graduation");
		String degreePercent = req.getParameter("degreePerc");
		String puc = req.getParameter("puc");
		String pucPercent = req.getParameter("pucPerc");
		String sslc = req.getParameter("sslc");
		String sslcPercent = req.getParameter("sslcPerc");
		String resumeUpload = req.getParameter("resume");
		
		/*String strFile = "C:\\Users\\Sharanya\\Desktop\\ResumeFolder";
		File fos = new File(strFile);
		bufferout=new BufferedOutputStream();
		bufferout.write(2000);
		fos.ge*/

		CandidateDAO cdao = DAOFactory.getDAOInstance();
		boolean result = cdao.registeration(fname, mname, lname, dateOfBirth,
				email, mobNmber, highQualification, highPercent,
				graduate, degreePercent, puc, pucPercent, sslc, sslcPercent,
				resumeUpload, address);

		if (result == true) {
			
			
			output.print("Successfully created");
			
			
			

			SendMail smail = new SendMail();
			smail.sendMailToCandidate(fname, mname, lname, dateOfBirth, email,
					 mobNmber, highQualification, highPercent,
					graduate, degreePercent, puc, pucPercent, sslc,
					sslcPercent, resumeUpload);
			output.println("<h3>Credentials has been Sent to " + fname
					+ " Email</h3>");
			
			
			
		} else {
			output.print("Unable to Create");
		}

	}
}
