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


public class GenericDAO {

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
			
	
	public Statement getStatement() throws SQLException, Exception {
        return getConnection().createStatement();
    }

    public PreparedStatement getStatement(String st) throws SQLException, Exception {
        return getConnection().prepareStatement(st);
    }
    
    public ResultSet executeQuery(String query,Object... params) throws Exception {
        PreparedStatement ps = this.getStatement(query);
        for (int i = 0; i < params.length; i++) {
            ps.setObject(i+1, params[i]);
        }
        return ps.executeQuery();
    }
    
    public Integer getNextId(String tableName) throws Exception {
        ResultSet rs = executeQuery("select MAX(idALuno) from "+tableName);
        rs.next();
        Object result = rs.getObject(1);
        if (result == null) {
            rs.close();
            return 1;
        } else {
            return ((Integer)result)+1;
        }
    }
    
    public static void main(String[] args) throws Exception {
		GenericDAO dao = new GenericDAO();
		dao.getConnection();
		System.out.println(dao.getNextId("alunos"));
	}
    
	
	
	

	
}
