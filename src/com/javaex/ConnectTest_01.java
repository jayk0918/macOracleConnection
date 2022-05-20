package com.javaex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/* 오라클 접속 테스트 */
public class ConnectTest_01 {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@webdb_high?TNS_ADMIN=/Users/jaykim0918/Dropbox/Wallet_webdb";
		String userid = "admin";
		String pwd = "Jayk09180918";
		
		//oracle DB연결 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("JDBC 드라이버 로딩 성공");
			}
		catch(ClassNotFoundException e) {
			System.out.println("error : 드라이버 로딩 실패 - " + e);
			}
		
		//DBMS와 연결
		try {
			System.out.println("DB 연결 준비......");
	        Connection conn =DriverManager.getConnection(url, userid, pwd);
	        PreparedStatement pstmt = null;
            ResultSet rs = null;
            if(conn!=null) {
	        	System.out.println("DB 연결 성공...");
	        }
            
            // SQL문 준비 / 바인딩 / 실행
	        // try_catch_finally문
			
		}catch(SQLException e) {
			System.out.println("error" + e);
		}
       
	}// main end
}// class end