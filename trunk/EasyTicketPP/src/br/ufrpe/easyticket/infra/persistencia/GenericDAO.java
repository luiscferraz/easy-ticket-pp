/**
 * 
 */
package br.ufrpe.easyticket.infra.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


/**
 * @author Nanda
 * @param <T>
 *
 */
public abstract class GenericDAO<T> implements IGenericDAO<T> {

	protected String getDriver(){
		return "com.mysql.jdbc.Driver";
	}
	
	protected String getURL(){
		return "jdbc:mysql://localhost:3306/easyticket";
	}
	
	public Connection getConnection()  {          
		       
        try{
        	Class.forName(this.getDriver());        	
        	Connection con  =  (Connection) DriverManager.getConnection(this.getURL(), "root", "root");
            con.setAutoCommit(false);
            System.out.println("Conexão realizada com sucesso.");  
            return con;
        } catch (ClassNotFoundException e){
        	System.out.println("Erro ao abrir a conexão: " +e.getMessage());
        	
        }catch (SQLException e){
        	System.out.println("Erro ao abrir a conexão: " +e.getMessage());
        }
		return null ;	
		
	}	
			
	/**
	 * Fecha uma conexão com o banco de dados
	 */
	public void fechar(Connection conn) {
		this.fechar(null,null,conn);
	}
	
	/**
	 * Fecha o {@link Statement} e a {@link Connection} com o banco. 
	 * @param stmt o statement
	 * @param conn a conexão
	 */
	public void fechar(Statement stmt, Connection conn) {
		this.fechar(null, stmt, conn);
	}
	
	/**
	 * Fecha o {@link ResultSet}, o {@link Statement} e a {@link Connection} com o banco. 
	 * @param rs o result set
	 * @param stmt o statement
	 * @param conn a conexão
	 */
	public void fechar(ResultSet rs, Statement stmt, Connection conn) {
		SQLException causa = null;
		try {
			rs.close();
		} catch (SQLException e) {
			causa = e;
		}
		try {
			stmt.close();
		} catch (SQLException e) {
			causa = e;
		}
		try {
			conn.close();
		} catch (SQLException e) {
			causa = e;
		}
		if (causa != null) {
			//throw new MPOORuntimeException(causa);
			System.out.println(causa);
		}
	}
	
	public Statement getStatement() throws SQLException, Exception {
        return getConnection().createStatement();
    }

    public PreparedStatement getStatement(String st) throws SQLException, Exception {
        return getConnection().prepareStatement(st);
    }
    
    /**
     * 
     *
     */
    public ResultSet executeQuery(String query,Object... params) throws Exception {
        PreparedStatement ps = this.getStatement(query);
        for (int i = 0; i < params.length; i++) {
            ps.setObject(i+1, params[i]);
        }
        return ps.executeQuery();
    }
    
    private void setParams(Statement stmt, Object... params) throws SQLException {
		if (params.length>0) {
			PreparedStatement pstmt = (PreparedStatement)stmt;
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i+1, params[i]);
			}
		}
	}
    
        
    /**
     * Método responsável por fornecer o próximo id de determinada tabela
     *
     */
     public Integer getNextId(String tableName) throws Exception {
        ResultSet rs = executeQuery("select MAX(id) from "+tableName);
        rs.next();
        Object result = rs.getObject(1);
        if (result == null) {
            rs.close();
            return 1;
        } else {
            return ((Integer)result)+1;
        }
    }
    
       
    /**
	 * As subclasses devem implementar este método retornando o SQL utilizado para inserir a 
	 * instância <code>t</code> no banco de dados.
	 * @param t a instância
	 * @return o SQL
	 */
	protected abstract String getSQLInserir(T t);
	
	/**
	 * As subclasses devem implementar este método retornando o SQL utilizado para alterar a 
	 * instância <code>t</code> no banco de dados.
	 * @param t a instância
	 * @return o SQL
	 */
	protected abstract String getSQLAlterar(T t);
	
	protected abstract String getSQLRemover(T t);
	
	/**
	 * Inclui os valores de <code>values</code> em <code>sb</code>, entre aspas e separados por vírgula. 
	 * Este método é utilizado ao montar os SQLs.
	 * @param sb o {@link StringBuilder}
	 * @param values o valor
	 */
	protected void setSQLStringValues(StringBuilder sb, String... values) {
		for (int i = 0; i < values.length; i++) {
			sb.append("'");
			sb.append(values[i]);
			sb.append("'");
			if (i < values.length-1) {
				sb.append(",");
			}
		}
	}

	private int executeUpdate(String sql, String operacao, boolean returnId) {
		Connection conn = this.getConnection();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			int result = -1; 
			if (returnId) {
				result = stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			} else {
				result = stmt.executeUpdate(sql);
			}
			return result;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			fechar(stmt, conn);
		}
		return 0;
	}

    public void inserir(String insertSql, Object... parametros ){
    	try { 
    		 this.executeQuery(query, parametros); 
    		 pstmt.close(); 
    	} catch (SQLException e) { 
    		 throw new RuntimeException(e); 
    		 }
    }
	
	@Override
	public boolean alterar(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remover(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
    
    
    
}
    

    
    /*public static void main(String[] args) throws Exception {
	GenericDAO dao = new GenericDAO();
	dao.getConnection();
	System.out.println(dao.getNextId("alunos"));
}*/
    
		
	

	

