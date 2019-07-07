package util;


import java.sql.*;

public class DBConn {

	private String URL = "jdbc:mariadb://localhost:3306/people_flow_detection";
	private String USER = "root";
	private String PASSWD = "123456";
	private static DBConn INSTANCE;

	static {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static DBConn getINSTANCE() {
		synchronized (DBConn.class) {
			if (INSTANCE == null) {
				INSTANCE = new DBConn();
			}
		}
		return INSTANCE;
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWD);
	}

	public static void closeConnection(Connection conn, Statement st, ResultSet rs) throws SQLException {
		conn.close();
		st.close();
		rs.close();
	}
}
