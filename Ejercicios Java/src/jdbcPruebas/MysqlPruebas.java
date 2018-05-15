package jdbcPruebas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlPruebas {

	public static void main(String[] args) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost", "root", "");
		}catch(ClassNotFoundException ex){
			System.out.println("No se encontro el Driver MySql para JDBC.");
		}

	}

}
