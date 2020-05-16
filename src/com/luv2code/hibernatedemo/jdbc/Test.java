package com.luv2code.hibernatedemo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String uName = "hbstudent";
		String pass = "hbstudent";
		try {
			Connection con = DriverManager.getConnection(jdbcUrl,uName,pass);
			
			if(con!=null)
			System.out.println("Connection Successfullly!!!");
			else
				System.out.println("Connection Failure!!!");
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
