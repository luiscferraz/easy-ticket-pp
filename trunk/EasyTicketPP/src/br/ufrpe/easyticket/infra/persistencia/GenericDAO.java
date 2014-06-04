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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.ufrpe.easyticket.infra.excecao.MyObjectRuntimeException;
import br.ufrpe.easyticket.infra.negocio.MyObject;


/**
 * @author Nanda
 * @param <T>
 * @param <T>
 *
 */
public abstract class GenericDAO<T> implements IGenericDAO{

	/*protected String getDriver(){
		return "com.mysql.jdbc.Driver";
	}
	
	protected String getURL(){
		return "jdbc:mysql://localhost:3306/easyticketpp";
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
			
	*//**
	 * Fecha uma conexão com o banco de dados
	 *//*
	public void fechar(Connection conn) {
		this.fechar(null,null,conn);
	}
	
	*//**
	 * Fecha o {@link Statement} e a {@link Connection} com o banco. 
	 * @param stmt o statement
	 * @param conn a conexão
	 *//*
	public void fechar(Statement stmt, Connection conn) {
		this.fechar(null, stmt, conn);
	}
	
	*//**
	 * Fecha o {@link ResultSet}, o {@link Statement} e a {@link Connection} com o banco. 
	 * @param rs o result set
	 * @param stmt o statement
	 * @param conn a conexão
	 *//*
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
    
    *//**
     * 
     *
     *//*
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
    
        
    *//**
     * Método responsável por fornecer o próximo id de determinada tabela
     *
     *//*
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
    
       
    *//**
	 * As subclasses devem implementar este método retornando o SQL utilizado para inserir a 
	 * instância <code>t</code> no banco de dados.
	 * @param t a instância
	 * @return o SQL
	 *//*
	protected abstract String getSQLInserir(Object o);
	
	*//**
	 * As subclasses devem implementar este método retornando o SQL utilizado para alterar a 
	 * instância <code>t</code> no banco de dados.
	 * @param t a instância
	 * @return o SQL
	 *//*
	protected abstract String getSQLAlterar(Object o);
	
	protected abstract String getSQLRemover(Object o);
	
	*//**
	 * Inclui os valores de <code>values</code> em <code>sb</code>, entre aspas e separados por vírgula. 
	 * Este método é utilizado ao montar os SQLs.
	 * @param sb o {@link StringBuilder}
	 * @param values o valor
	 *//*
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

		
	protected void inserir (String insertSql, Object... parametros){
		try{
			PreparedStatement pstmt = getConnection().prepareStatement(insertSql);
			for (int i = 0; i < parametros.length; i++) {
			pstmt.setObject(i+1, parametros[i]);
			}
			pstmt.execute();
			pstmt.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		
	}
	
	public void alterar(String updateSql, Object... parametros) {
		try {
			PreparedStatement pstmt = getConnection().prepareStatement(updateSql);
			for (int i = 0; i < parametros.length; i++) {
				pstmt.setObject(i+1, parametros[i]);
			}
			pstmt.execute();
			pstmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
	}
	
		
	public void remover(String deleteSql, Object... parametros) {
		try {
			PreparedStatement pstmt = getConnection().prepareStatement(deleteSql);
			for (int i = 0; i < parametros.length; i++) {
			pstmt.setObject(i+1, parametros[i]);
			}
			pstmt.execute();
			pstmt.close();
			} catch (SQLException e) {
			throw new RuntimeException(e);
			}
	}*/
	
	protected String getDriver(){
	return "com.mysql.jdbc.Driver";
	}

	protected String getURL(){
	return "jdbc:mysql://localhost:3306/easyticketpp";
	}
	
	private SimpleDateFormat dateFormatter = null;
	
	private Util util = Util.getInstance();
	
	//Abre uma conexão com o banco de dados
	 
	public Connection abrirConexao() {
		try {
            Class.forName(getDriver()); 
			Connection conn = DriverManager.getConnection(getURL());
			conn.setAutoCommit(false);
			return conn;
		} catch (ClassNotFoundException e) {
			throw new MyObjectRuntimeException("Erro ao abrir a conexão",e);
		} catch (SQLException e) {
			throw new MyObjectRuntimeException("Erro ao abrir a conexão",e);
		}
	}
	
		
	/**
	 * Sobrescrever caso queira mudar o padrão do formatador de datas ("yyyy-MM-dd HH:mm:ss").
	 * @return
	 */
	protected SimpleDateFormat createDateFormatter() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * Retorna o formatador utilizado para campos de data, de acordo com o método {@link #createDateFormatter()} 
	 * @return o formatador.
	 */
	protected final synchronized SimpleDateFormat getDateFormatter() {
		if (this.dateFormatter != null) {
			this.dateFormatter = createDateFormatter();
		}
		return this.dateFormatter;
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
			throw new MyObjectRuntimeException(causa);
		}
	}
	
	/**
	 * Insere a instância <code>t</code> no banco
	 * @param t a instância
	 * @return <code>true</code> se houver alguma alteração no BD e <code>false</code> caso contrário
	 */
	public boolean inserir(T t) {
		String sql = getSQLInserir(t);
		String operacao = "inserir";
		int id = executeUpdate(sql, operacao, true);
		((MyObject) t).setId(id);
		return id > 0;
	}
	
	/**
	 * As subclasses devem implementar este método retornando o SQL utilizado para inserir a 
	 * instância <code>t</code> no banco de dados.
	 * @param t a instância
	 * @return o SQL
	 */
	protected abstract String getSQLInserir(T t);
	
	/**
	 * Altera a instância <code>t</code> no banco.
	 * @param t a instância
	 * @return <code>true</code> se houver alguma alteração no BD e <code>false</code> caso contrário
	 */
	public boolean alterar(T t) {
		String sql = getSQLAlterar(t);
		String operacao = "alterar";
		return executeUpdate(sql, operacao, false) > 0;
	}

	/**
	 * As subclasses devem implementar este método retornando o SQL utilizado para alterar a 
	 * instância <code>t</code> no banco de dados.
	 * @param t a instância
	 * @return o SQL
	 */
	protected abstract String getSQLAlterar(T t);
	
	/**
	 * Remove a instância <code>t</code> no banco.
	 * @param t a instância
	 * @return <code>true</code> se houver alguma alteração no BD e <code>false</code> caso contrário
	 */
	public boolean remover(T t) {
		String sql = getSQLRemover(t);
		String operacao = "remover";
		return executeUpdate(sql, operacao, false) > 0;
	}

	/**
	 * As subclasses devem implementar este método retornando o SQL utilizado para alterar a 
	 * instância <code>t</code> no banco de dados.
	 * @param t a instância
	 * @return o SQL
	 */
	protected abstract String getSQLRemover(T t);
	
	private int executeUpdate(String sql, String operacao, boolean returnId) {
		Connection conn = this.abrirConexao();
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
			throw new MyObjectRuntimeException("Erro ao " + operacao + " o registro", e);
		} finally {
			fechar(stmt, conn);
		}
	}
	
	/**
	 * Retorna a instância de <code>T</code> com o id informado, ou <code>null</code>, caso não encontre.
	 * @param id o id
	 * @return a instância de <code>T</code>
	 */
	public MyObject getById(int id) {
		Connection conn = this.abrirConexao();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM "+this.getTable()+" WHERE ID = " + id);
			T result = null;
			if (rs.next()) {
				result = convertInternal(rs);
			}
			return (MyObject) result;
		} catch (SQLException e) {
			throw new MyObjectRuntimeException("Erro ao consultar os registros", e);
		} finally {
			fechar(rs, stmt, conn);
		}
	}

	/**
	 * Retorna o nome da tabela da classe persistida.
	 * @return o nome da tabela
	 */
	protected abstract String getTable();

	/**
	 * Retorna todas as intâncias de <code>T</code> armazenadas.
	 * @return as instâncias de T.
	 */
	public List<T> getAll() {
		return executeQuery("SELECT * FROM " + this.getTable());
	}
	
	/**
	 * Executa a query passada como parâmetro e retorna um objeto do tipo <code>T</code>. Se a query retornar mais de um objeto, será retornado o primeiro registro encontrado.
	 * @param sql a query
	 * @param params a lista de parâmetros do prepared statement
	 * @return o objeto <code>T</code>
	 */
	protected T executeQuerySingleResult(String sql, Object... params) {
		List<T> result = executeQuery(sql, 1, params);
		return result.size() > 0 ? result.get(0) : null;
	}
	
	/**
	 * Executa a query passada como parâmetro e retorna uma lista de <code>T</code>
	 * @param sql a query
	 * @param params a lista de parâmetros do prepared statement
	 * @return a lista de <code>T</code>
	 */
	protected List<T> executeQuery(String sql, Object... params) {
		return executeQuery(sql, 0, params);
	}
	
	/**
	 * Executa a query passada como parâmetro e retorna uma lista de <code>T</code>, retornando os primeiros <code>maxResult</code> resultados.
	 * @param sql a query
	 * @param maxResult a quantidade máxima de resultados (se for menor ou igual a zero, retorna todos os resultados da query).
	 * @param params a lista de parâmetros do prepared statement
	 * @return a lista de <code>T</code>
	 */
	protected List<T> executeQuery(String sql, int maxResults, Object... params) {
		Connection conn = this.abrirConexao();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			setParams(stmt, params);
			rs = stmt.executeQuery(sql);
			List<T> result = new ArrayList<T>();
			int results = 0;
			while (rs.next()) {
				T t = convertInternal(rs);
				result.add(t);
				results++;
				if (maxResults > 0 && results == maxResults) {
					break;
				}
			}
			return result;
		} catch (SQLException e) {
			throw new MyObjectRuntimeException("Erro ao consultar os registros", e);
		} finally {
			fechar(rs, stmt, conn);
		}
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
	 * Executa a query passada como parâmetro e retorna uma lista de <code>T</code>
	 * @param sql a query
	 * @return a lista de <code>T</code>
	 */
	protected List<T> executeQuery(String sql) {
		Connection conn = this.abrirConexao();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			List<T> result = new ArrayList<T>();
			while (rs.next()) {
				T t = convertInternal(rs);
				result.add(t);
			}
			return result;
		} catch (SQLException e) {
			throw new MyObjectRuntimeException("Erro ao consultar os registros", e);
		} finally {
			fechar(rs, stmt, conn);
		}
	}

	
	/**
	 * Preenche as propriedades do {@link MPOOObject}
	 * @param rs o result set
	 * @param objeto o objeto
	 * @throws SQLException
	 */
	protected void preencherMPOOObjectProperties(ResultSet rs, MyObject objeto) throws SQLException {
		objeto.setId(rs.getInt("ID"));
	}
	
	/**
	 * Método reponsável por converter o conteúdo do linha do ResultSet em um objeto do tipo <code>T</code>.
	 * Este método é utilizado em conjunto com o método {@link #executeQuery(String)}. 
	 * <br/>
	 * Não se deve navegar pelo ResultSet, chamando seus métodos {@link ResultSet#next()} ou {@link ResultSet#previous()}, por exemplo.
	 * <br/>
	 * Não é necessário setar os dados de {@link MPOOObject} (id, data de criação e de atualização).
	 *  
	 * @param rs o ResultSet
	 * @return o objeto do tipo T
	 * @throws SQLException 
	 */
	protected abstract T convert(ResultSet rs) throws SQLException;
	
	/**
	 * Inclui os valores de <code>values</code> em <code>sb</code>, entre aspas e separados por vírgula. 
	 * Este método é utilizado ao montar os SQLs.
	 * @param sb o {@link StringBuilder}
	 * @param values o valor
	 */
	protected void setSQLValues(StringBuilder sb, Object... values) {
		for (int i = 0; i < values.length; i++) {
			sb.append(values[i]);
			if (i < values.length-1) {
				sb.append(",");
			}
		}
	}
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

	/**
	 * Inclui os valores de <code>values</code> em <code>sb</code>, entre aspas e separados por vírgula, com o formato específico do banco de dados para timestamp. 
	 * Este método é utilizado ao montar os SQLs.
	 * @param sb o {@link StringBuilder}
	 * @param values o valor
	 */
	protected void setSQLTimestampValues(StringBuilder sb, Date... values) {
		for (int i = 0; i < values.length; i++) {
			sb.append("'");
			sb.append(getDateFormatter().format(values[i]));
			sb.append("'");
			if (i < values.length-1) {
				sb.append(",");
			}
		}
	}
	
	/**
	 * Inclui a cláusula "WHERE ID = X" em <code>sb</code>, onde X é o valor do id de <code>o</code>.
	 * @param sb o {@link StringBuilder}
	 * @param o o objeto
	 */
	protected void setWhereIdClause(StringBuilder sb, MyObject o) {
		sb.append(" WHERE ID=");
		sb.append(o.getId());
		sb.append(";");
	}
	
	/* Método reponsável por converter o conteúdo do linha do ResultSet em um objeto do tipo <code>T</code>.
	 * Este método utiliza o método {@link #convert(ResultSet)} que cria o objeto específico e depois seta 
	 * as propriedades comuns, presentes em {@link MPOOObject}. 
	 * @param rs o ResultSet
	 * @return o objeto do tipo T
	 * @throws SQLException 
	 */
	protected T convertInternal(ResultSet rs) throws SQLException {
		T result = this.convert(rs);
		preencherMyObjectProperties(rs, result);
		return result;
	}
	 
	 /**
		 * Preenche as propriedades do {@link MPOOObject}
		 * @param rs o result set
		 * @param result o objeto
		 * @throws SQLException
		 */
		protected void preencherMyObjectProperties(ResultSet rs, T result) throws SQLException {
			((MyObject) result).setId(rs.getInt("ID"));
		}

	
 }
		
	

	

