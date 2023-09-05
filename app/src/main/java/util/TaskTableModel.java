
package util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Task;

/**
 *
 * @author amandasilva
 */
public class TaskTableModel extends AbstractTableModel{
    
    private String[] columns = {"Nome", "Descrição", "Prazo", "Tarefa Concluída", "Editar", "Excluir"};
    private List<Task> tasks = new ArrayList();

    @Override
//    qtd linhas que vou ter na minha JTable
    public int getRowCount() {
        return tasks.size();
    }
    
    @Override
    public String getColumnName(int columnIndex){
        return columns[columnIndex];
    }

    @Override
//    retornar qtd colunas que vou ter na minha JTable
    public int getColumnCount() {
        return columns.length;
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        
        return columnIndex == 3 ? true : false;
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        tasks.get(rowIndex).setStatus((boolean) aValue);
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return tasks.isEmpty()? Object.class : this.getValueAt(0, columnIndex).getClass();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return tasks.get(rowIndex).getName();
                
            case 1:
                return tasks.get(rowIndex).getDescription();
                
            case 2:
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                return dateFormat.format(tasks.get(rowIndex).getDueDate());
                
            case 3:
                return tasks.get(rowIndex).isStatus();
            
            case 4:
                return "";
            
            case 5:
                return "";
                
            default:
                return "Dado não encontrado";
        }

    }

    public String[] getColumns() {
        return columns;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
    
    
}
