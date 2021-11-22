package bikepublisher;

import java.sql.*;
import java.sql.PreparedStatement;


import cubrid.jdbc.driver.CUBRIDDriver;

public class DBConnect {
	private static Connection conn = null;
	private static final String DB_URL = "jdbc:cubrid:localhost:30000:20165122:::?charset=UTF-8"; // DB 접속 주소 
	private static final String USERNAME = "dba"; // DB ID static final 
	private static String PASSWORD = "hello"; // DB Password
	static Statement stmt = null;
	String sql = "";
	


	public void DBConnct(String createdate, String stationname, int parkingbiketotcnt, String stationid){
			
			if(stationid.equals("ST-73")) {
				System.out.println(stationid);
				sql = "INSERT INTO st4(createdate, stationname, parkingbiketotcnt, stationid)" + "VALUES (?, ?, ?, ?)";
			}else if(stationid.equals("ST-279")) {
				System.out.println(stationid);
				sql = "INSERT INTO st279(createdate, stationname, parkingbiketotcnt, stationid)" + "VALUES (?, ?, ?, ?)";
			}
			
			System.out.println(sql);
			
		
			System.out.print("User Table 접속 : "); 
			
			try {
				System.out.println("생성자");
				Class.forName("cubrid.jdbc.driver.CUBRIDDriver");
				conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
				System.out.println("드라이버 로딩 성공");
				
				PreparedStatement pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, createdate);
				pstmt.setString(2, stationname);
				pstmt.setInt(3, parkingbiketotcnt);
				pstmt.setString(4, stationid);
				pstmt.executeUpdate();
				
				pstmt.close();
		
				conn.close();
				
				
				/*데이터 출력하고 싶을 때
				 * ResultSet rs = stmt.executeQuery("SELECT * FROM st4");
				 * while(rs.next()) {
					String qfw = rs.getString("createdate");
					
					System.out.println(qfw);
				}*/
				
			} catch (Exception e) {
				System.out.println("드라이버 로딩 실패" + e.getMessage());
				try {
					conn.close();
				} catch(SQLException e1) { }
			}
			
			
			
		
		}
		
		
			

}
		
		


