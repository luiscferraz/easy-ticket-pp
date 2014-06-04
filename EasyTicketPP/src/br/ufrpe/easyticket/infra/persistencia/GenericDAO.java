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
            System.out.println("Conex�o realizada com sucesso.");  
            return con;
        } catch (ClassNotFoundException e){
        	System.out.println("Erro ao abrir a conex�o: " +e.getMessage());
        	
        }catch (SQLException e){
        	System.out.println("Erro ao abrir a conex�o: " +e.getMessage());
        }
		return null ;	
		
	}	
			
	*//**
	 * Fecha uma conex�o com o banco de dados
	 *//*
	public void fechar(Connection conn) {
		this.fechar(null,null,conn);
	}
	
	*//**
	 * Fecha o {@link Statement} e a {@link Connection} com o banco. 
	 * @param stmt o statement
	 * @param conn a conex�o
	 *//*
	public void fechar(Statement stmt, Connection conn) {
		this.fechar(null, stmt, conn);
	}
	
	*//**
	 * Fecha o {@link ResultSet}, o {@link Statement} e a {@link Connection} com o banco. 
	 * @param rs o result set
	 * @param stmt o statement
	 * @param conn a conex�o
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
     * M�todo respons�vel por fornecer o pr�ximo id de determinada tabela
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
	 * As subclasses devem implementar este m�todo retornando o SQL utilizado para inserir a 
	 * inst�ncia <code>t</code> no banco de dados.
	 * @param t a inst�ncia
	 * @return o SQL
	 *//*
	protected abstract String getSQLInserir(Object o);
	
	*//**
	 * As subclasses devem implementar este m�todo retornando o SQL utilizado para alterar a 
	 * inst�ncia <code>t</code> no banco de dados.
	 * @param t a inst�ncia
	 * @return o SQL
	 *//*
	protected abstract String getSQLAlterar(Object o);
	
	protected abstract String getSQLRemover(Object o);
	
	*//**
	 * Inclui os valores de <code>values</code> em <code>sb</code>, entre aspas e separados por v�rgula. 
	 * Este m�todo � utilizado ao montar os SQLs.
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
	
	//Abre uma conex�o com o banco de dados
	 
	public Connection abrirConexao() {
		try {
            Class.forName(getDriver()); 
			Connection conn = DriverManager.getConnection(getURL());
			conn.setAutoCommit(false);
			return conn;
		} catch (ClassNotFoundException e) {
			throw new MyObjectRuntimeException("Erro ao abrir a conex�o",e);
		} catch (SQLException e) {
			throw new MyObjectRuntimeException("Erro ao abrir a conex�o",e);
		}
	}
	
		
	/**
	 * Sobrescrever caso queira mudar o padr�o do formatador de datas ("yyyy-MM-dd HH:mm:ss").
	 * @return
	 */
	protected SimpleDateFormat createDateFormatter() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * Retorna o formatador utilizado para campos de data, de acordo com o m�todo {@link #createDateFormatter()} 
	 * @return o formatador.
	 */
	protected final synchronized SimpleDateFormat getDateFormatter() {
		if (this.dateFormatter != null) {
			this.dateFormatter = createDateFormatter();
		}
		return this.dateFormatter;
	}
	
	/**
	 * Fecha uma conex�o com o banco de dados
	 */
	public void fechar(Connection conn) {
		this.fechar(null,null,conn);
	}
	
	/**
	 * Fecha o {@link Statement} e a {@link Connection} com o banco. 
	 * @param stmt o statement
	 * @param conn a conex�o
	 */
	public void fechar(Statement stmt, Connection conn) {
		this.fechar(null, stmt, conn);
	}
	
	/**
	 * Fecha o {@link ResultSet}, o {@link Statement} e a {@link Connection} com o banco. 
	 * @param rs o result set
	 * @param stmt o statement
	 * @param conn a conex�o
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
	 * Insere a inst�ncia <code>t</code> no banco
	 * @param t a inst�ncia
	 * @return <code>true</code> se houver alguma altera��o no BD e <code>false</code> caso contr�rio
	 */
	public boolean inserir(T t) {
		String sql = getSQLInserir(t);
		String operacao = "inserir";
		int id = executeUpdate(sql, operacao, true);
		((MyObject) t).setId(id);
		return id > 0;
	}
	
	/**
	 * As subclasses devem implementar este m�todo retornando o SQL utilizado para inserir a 
	 * inst�ncia <code>t</code> no banco de dados.
	 * @param t a inst�ncia
	 * @return o SQL
	 */
	protected abstract String getSQLInserir(T t);
	
	/**
	 * Altera a inst�ncia <code>t</code> no banco.
	 * @param t a inst�ncia
	 * @return <code>true</code> se houver alguma altera��o no BD e <code>false</code> caso contr�rio
	 */
	public boolean alterar(T t) {
		String sql = getSQLAlterar(t);
		String operacao = "alterar";
		return executeUpdate(sql, operacao, false) > 0;
	}

	/**
	 * As subclasses devem implementar este m�todo retornando o SQL utilizado para alterar a 
	 * inst�ncia <code>t</code> no banco de dados.
	 * @param t a inst�ncia
	 * @return o SQL
	 */
	protected abstract String getSQLAlterar(T t);
	
	/**
	 * Remove a inst�ncia <code>t</code> no banco.
	 * @param t a inst�ncia
	 * @return <code>true</code> se houver alguma altera��o no BD e <code>false</code> caso contr�rio
	 */
	public boolean remover(T t) {
		String sql = getSQLRemover(t);
		String operacao = "remover";
		return executeUpdate(sql, operacao, false) > 0;
	}

	/**
	 * As subclasses devem implementar este m�todo retornando o SQL utilizado para alterar a 
	 * inst�ncia <code>t</code> no banco de dados.
	 * @param t a inst�ncia
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
	 * Retorna a inst�ncia de <code>T</code> com o id informado, ou <code>null</code>, caso n�o encontre.
	 * @param id o id
	 * @return a inst�ncia de <code>T</code>
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
	 * Retorna todas as int�ncias de <code>T</code> armazenadas.
	 * @return as inst�ncias de T.
	 */
	public List<T> getAll() {
		return executeQuery("SELECT * FROM " + this.getTable());
	}
	
	/**
	 * Executa a query passada como par�metro e retorna um objeto do tipo <code>T</code>. Se a query retornar mais de um objeto, ser� retornado o primeiro registro encontrado.
	 * @param sql a query
	 * @param params a lista de par�metros do prepared statement
	 * @return o objeto <code>T</code>
	 */
	protected T executeQuerySingleResult(String sql, Object... params) {
		List<T> result = executeQuery(sql, 1, params);
		return result.size() > 0 ? result.get(0) : null;
	}
	
	/**
	 * Executa a query passada como par�metro e retorna uma lista de <code>T</code>
	 * @param sql a query
	 * @param params a lista de par�metros do prepared statement
	 * @return a lista de <code>T</code>
	 */
	protected List<T> executeQuery(String sql, Object... params) {
		return executeQuery(sql, 0, params);
	}
	
	/**
	 * Executa a query passada como par�metro e retorna uma lista de <code>T</code>, retornando os primeiros <code>maxResult</code> resultados.
	 * @param sql a query
	 * @param maxResult a quantidade m�xima de resultados (se for menor ou igual a zero, retorna todos os resultados da query).
	 * @param params a lista de par�metros do prepared statement
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
	 * Executa a query passada como par�metro e retorna uma lista de <code>T</code>
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
	 * M�todo repons�vel por converter o conte�do do linha do ResultSet em um objeto do tipo <code>T</code>.
	 * Este m�todo � utilizado em conjunto com o m�todo {@link #executeQuery(String)}. 
	 * <br/>
	 * N�o se deve navegar pelo ResultSet, chamando seus m�todos {@link ResultSet#next()} ou {@link ResultSet#previous()}, por exemplo.
	 * <br/>
	 * N�o � necess�rio setar os dados de {@link MPOOObject} (id, data de cria��o e de atualiza��o).
	 *  
	 * @param rs o ResultSet
	 * @return o objeto do tipo T
	 * @throws SQLException 
	 */
	protected abstract T convert(ResultSet rs) throws SQLException;
	
	/**
	 * Inclui os valores de <code>values</code> em <code>sb</code>, entre aspas e separados por v�rgula. 
	 * Este m�todo � utilizado ao montar os SQLs.
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
	 * Inclui os valores de <code>values</code> em <code>sb</code>, entre aspas e separados por v�rgula. 
	 * Este m�todo � utilizado ao montar os SQLs.
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
	 * Inclui os valores de <code>values</code> em <code>sb</code>, entre aspas e separados por v�rgula, com o formato espec�fico do banco de dados para timestamp. 
	 * Este m�todo � utilizado ao montar os SQLs.
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
	 * Inclui a cl�usula "WHERE ID = X" em <code>sb</code>, onde X � o valor do id de <code>o</code>.
	 * @param sb o {@link StringBuilder}
	 * @param o o objeto
	 */
	protected void setWhereIdClause(StringBuilder sb, MyObject o) {
		sb.append(" WHERE ID=");
		sb.append(o.getId());
		sb.append(";");
	}
	
	/* M�todo repons�vel por converter o conte�do do linha do ResultSet em um objeto do tipo <code>T</code>.
	 * Este m�todo utiliza o m�todo {@link #convert(ResultSet)} que cria o objeto espec�fico e depois seta 
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
		
	

	

