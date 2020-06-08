package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

   static {
      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
      } 
      catch (ClassNotFoundException e) {
         throw new RuntimeException("erro na conexão: ", e);
      }
   }

   public static Connection obtemConexao() throws SQLException {
      String servidor = "localhost";
      String porta = "3306";
      String database = "portal_realnews";
      return DriverManager.getConnection("jdbc:mysql://"+servidor+":"+porta+"/"+database+"?useTimezone=true&serverTimezone=UTC", "root", "Batata2001!"); 
   }

   public static void fechaConexao(Connection conn) throws SQLException {
      conn.close();
   }
}