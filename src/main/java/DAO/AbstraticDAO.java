package DAO;

	import java.sql.Connection;
	import java.sql.SQLException;
	import java.util.List;
    import Factory.FactoryConexao;
	
	public abstract class AbstraticDAO<T>{
	protected Connection conn;

    public AbstraticDAO() {
          try {
                 conn = FactoryConexao.getInstance().getConexao();
          } catch (SQLException e) {
                 throw new RuntimeException(e);
          }
    }

	public abstract List<T> getLista();
	
	public abstract void adicionar(T objeto);
}
