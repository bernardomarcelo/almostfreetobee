package modelo.conexao.factory;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

	public class ConexaoFactory {
	
		private static final String url = "jdbc:mysql://localhost:3306/freetobee?useUnicode=true&characterEncoding=UTF-8&serverTimezone=America/Sao_Paulo";
		private static final String host = "root";
		private static final String senha  = "root";
		
		public static Connection getConnection () throws ClassNotFoundException {
			
			try {
				 Class.forName("com.mysql.cj.jdbc.Driver");
				return DriverManager.getConnection(url,host,senha);
			
			} catch (SQLException e) {
				
				throw new RuntimeException("ERRO AO SE CONECTAR COM O BANCO DE DADOS " + e.getMessage());
				
			}
			
		}
}
