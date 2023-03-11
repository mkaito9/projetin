package Factory;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
public class FactoryConexao {
	String driverConexaoBD = "com.mysql.jdbc.Driver";
    String urlConexaoBD = "jdbc:mysql://localhost:3306/devmedia";
    String usuario = "root";
    String senha = "";

    private static FactoryConexao fabricaConexao = null;

    private FactoryConexao() {
          try {
                 Class.forName(driverConexaoBD);
          } catch (ClassNotFoundException e) {
                 throw new RuntimeException(e);
          }
    }

    public Connection getConexao() throws SQLException {
          Connection conn = null;
          conn = DriverManager.getConnection(urlConexaoBD, usuario, senha);
          return conn;
    }

    public static FactoryConexao getInstance() {
          if (fabricaConexao == null) {
                 fabricaConexao = new FactoryConexao();
          }
          return fabricaConexao;
    }
	
	
	
}
