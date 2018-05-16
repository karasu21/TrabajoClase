package jdbcPruebas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlPruebas {

	public static void main(String[] args) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn = DriverManager.getConnection("jdbc:mysql://172.26.104.200/programacion", "alumno", "alumno");
			
			 // Creamos el Statement para poder hacer consultas
		    Statement st = cn.createStatement();
		 
		    // La consulta es un String con código SQL
		    String sql1 = "SELECT * FROM poblaciones";
		 
		    // Ejecuta una consulta que devuelve resultados   
		    String sql2 = "insert into poblaciones values(28280, El Escorial)";
		    st.executeQuery(sql2);
		    ResultSet rs = st.executeQuery(sql1);  
		    System.out.println(" Codigo" + " " + "Poblacion");
		    System.out.println("+------" + "+" + "---------+" );
		    while (rs.next())
		    {
		    	String codigo=rs.getString (1);
		    	String poblacion=rs.getString (2);
		        System.out.println (codigo + "\t" + poblacion );
		    }            
		}catch(ClassNotFoundException ex){
			System.out.println("No se encontro el Driver MySql para JDBC.");
		}

	}

}
