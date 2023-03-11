package DAO;



	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;
	import MODEL.Usuario;

public class UsuarioDAO extends AbstraticDAO<Usuario>{
      private List<Usuario> lista;

      public UsuarioDAO() {
            super();
            lista = new ArrayList<Usuario>();
      }

      public List<Usuario> getLista() {
            try {
                   PreparedStatement ptmt = conn.prepareStatement
                     ("select * from usuario");
                   ResultSet rs = ptmt.executeQuery();
                   while(rs.next()){
Usuario usuario = new Usuario(rs.getString("nome"),
rs.getString("endereco"));
                          lista.add(usuario);
                   }
                   rs.close();
                   ptmt.close();
            } catch (SQLException e) {
                   throw new RuntimeException(e);
            }
            return lista;
      }

      public void adicionar(Usuario usuario) {
            try {
                   PreparedStatement ptmt = conn.prepareStatement("insert into usuario(nome,endereco) values (?, ?)");
                   ptmt.setString(1, usuario.getNome());
                   ptmt.setString(2, usuario.getEndereco());
                   ptmt.executeUpdate();
                   ptmt.close();
            } catch (SQLException e) {
                   throw new RuntimeException(e);
            }
      }

}
