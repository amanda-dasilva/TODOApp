package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Task;
import util.ConnectionFactory;

/**
 *
 * @author amandasilva
 */
public class TaskController {
    
    public void save(Task task) throws SQLException{
        String sql = "INSERT INTO Tasks (project_id, name, description, status, "
                + "notes, dueDate, createdAt, updatedAt) VALUES (?, ?, ?, ?, ?, "
                + "?, ?, ?)";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try{
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, task.getProject_id());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isStatus());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDueDate().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            statement.execute();
        } catch (SQLException ex){
            throw new SQLException("Erro ao salvar a tarefa ", 
                    ex.getMessage(), ex);
        } finally{
            ConnectionFactory.closeConnection(conn, statement);
        }
    }
    
    public List<Task> getAll(int project_id) throws SQLException{
        
        String sql = "SELECT * FROM Tasks WHERE project_id = ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        List<Task> tasks = new ArrayList<Task>();
        
        try{
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, project_id);
            resultSet = statement.executeQuery();
            
//            enquanto houver valores a serem percorridos no resultset
            while(resultSet.next()){
                Task task = new Task();
                task.setId(resultSet.getInt("id"));
                task.setProject_id(resultSet.getInt("project_id"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setStatus(resultSet.getBoolean("status"));
                task.setNotes(resultSet.getString("notes"));
                task.setDueDate(resultSet.getDate("dueDate"));
                task.setCreatedAt(resultSet.getDate("createdAt"));
                task.setUpdatedAt(resultSet.getDate("updatedAt"));
                
                tasks.add(task);
            }
        } catch (SQLException ex){
            throw new SQLException("Erro ao buscar a(s) tarefa(s)", 
                    ex.getMessage(), ex);
        } finally{
            ConnectionFactory.closeConnection(conn, statement, resultSet);
        }
        return tasks;
    }
    
    public void update(Task task) throws SQLException{
        
        String sql = "UPDATE Tasks SET project_id = ?, name = ?, description = ?, status = ?, "
                + "notes = ?, dueDate = ?, createdAt = ?, updatedAt = ? WHERE id = ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try{
//            String de conexao com o banco de dados
            conn = ConnectionFactory.getConnection();
//            Preparando o statement para ser executado de forma segura
            statement = conn.prepareStatement(sql);
//            recebendo todos os statements
            statement.setInt(1, task.getProject_id());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isStatus());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDueDate().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            statement.setInt(9, task.getId());
            
            statement.execute();
        } catch (SQLException ex){
            throw new SQLException("Erro ao atualizar a tarefa", 
                    ex.getMessage(), ex);
        } finally{
            ConnectionFactory.closeConnection(conn, statement);
        }
        
    }
    
    public void deleteById(int taskId) throws SQLException{
//        sql statement que sera executado
        String sql = "DELETE FROM Tasks WHERE id = ?";
        
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
            statement.setInt(1, taskId);
            statement.execute();
        } catch (SQLException ex){
            throw new SQLException("Erro ao deletar a tarefa", ex);
        } finally{
            ConnectionFactory.closeConnection(conn, statement);
        }
        
    }
}
