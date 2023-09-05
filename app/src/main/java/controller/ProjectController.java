package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Project;
import util.ConnectionFactory;

/**
 *
 * @author amandasilva
 */
public class ProjectController {
    
    public void save(Project project) throws SQLException {
        String sql = "INSERT INTO Projects (name, description, createdAt, "
                + "updatedAt) VALUES (?, ?, ?, ?)";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try{
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
            statement.execute();
        } catch (SQLException ex){
            throw new SQLException("Erro ao salvar o projeto ", 
                    ex.getMessage(), ex);
        } finally{
            ConnectionFactory.closeConnection(conn, statement);
        }
    }
    
    public List<Project> getAll() throws SQLException{
        
        String sql = "SELECT * FROM Projects";
        
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        List<Project> projects = new ArrayList<>();
        
        try{
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            resultSet = statement.executeQuery();
            
//            enquanto houver valores a serem percorridos no resultset
            while(resultSet.next()){
                Project project = new Project();
                
                project.setId(resultSet.getInt("id"));
                project.setName(resultSet.getString("name"));
                project.setDescription(resultSet.getString("description"));
                project.setCreatedAt(resultSet.getDate("createdAt"));
                project.setUpdatedAt(resultSet.getDate("updatedAt"));
                
                projects.add(project);
            }
        } catch (SQLException ex){
            throw new SQLException("Erro ao buscar o(s) projeto(s)", 
                    ex.getMessage(), ex);
        } finally{
            ConnectionFactory.closeConnection(conn, statement, resultSet);
        }
        return projects;
    }
    
    public void update(Project project) throws SQLException{
        
        String sql = "UPDATE Projects SET name = ?, description = ?, createdAt = ?, "
                + "updatedAt = ? WHERE id = ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try{
//            String de conexao com o banco de dados
            conn = ConnectionFactory.getConnection();
//            Preparando o statement para ser executado de forma segura
            statement = conn.prepareStatement(sql);
//            recebendo todos os statements
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
            statement.setInt(5, project.getId());
            statement.execute();
        } catch (SQLException ex){
            throw new SQLException("Erro ao atualizar o projeto", 
                    ex.getMessage(), ex);
        } finally{
            ConnectionFactory.closeConnection(conn, statement);
        }
        
    }
    
    public void deleteById(int projectId) throws SQLException{
//        sql statement que sera executado
        String sql = "DELETE FROM Projects WHERE id = ?";
        
//        string the conexao com o banco de dados
        Connection conn = null;
        
//        PreparedStatement ajuda a prevenir ataques de injeção de SQL
//        parametriza as consultas SQL usando espaços reservados (placeholders) em vez de 
//        incorporar diretamente os valores fornecidos pelo usuário na string SQL
//        Dessa forma, os valores de entrada são devidamente tratados 
//        como dados em vez de código executável, reduzindo o risco de 
//        injeção maliciosa de SQL.
        PreparedStatement statement = null;
        
        try{
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, projectId);
            statement.execute();
        } catch (SQLException ex){
            throw new SQLException("Erro ao deletar o projeto", ex);
        } finally{
            ConnectionFactory.closeConnection(conn, statement);
        }
        
    }
    
}
