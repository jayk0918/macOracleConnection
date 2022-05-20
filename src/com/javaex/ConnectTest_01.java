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

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// oracle DB연결 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("JDBC 드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("error : 드라이버 로딩 실패 - " + e);
		}

		// DBMS와 연결
		try {
			System.out.println("DB 연결 준비......");
			conn = DriverManager.getConnection(url, userid, pwd);

			if (conn != null) {
				System.out.println("DB 연결 성공...");
			}

			try {
				// SQL문 준비
				String query = "";
				System.out.println(query);
				// 바인딩
				pstmt = conn.prepareStatement(query);
				// pstmt.setString(0, query);
				// pstmt.setInt(0, 0);

				// 실행
				int count = pstmt.executeUpdate();

				// 결과처리보고
				System.out.println(count + "건이 등록되었습니다.");

			} catch (SQLException e) {
				System.out.println("error:" + e);
			} finally {
				try {
					// 자원 정리
					if (rs != null) {
						rs.close();
					}
					if (pstmt != null) {
						pstmt.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					System.out.println("error:" + e);
				}
			}

		} catch (SQLException e) {
			System.out.println("error" + e);
		}

	}// main end
}// class end