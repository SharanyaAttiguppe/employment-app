package com.AlgoFocus.EmployeeApp.Model;

public class DAOFactory
{
	
	private  static String dbInteractionType="jdbc";
	
	public static CandidateDAO getDAOInstance()
	{
	CandidateDAO ref=null;
	if(dbInteractionType.equals("jdbc"))
	{
		ref=new JDBCImplementation();
	}
	return ref;
	
	}
}
