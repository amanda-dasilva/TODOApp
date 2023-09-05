
package util;

import java.awt.Color;
import java.awt.Component;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import model.Task;

/**
 *
 * @author amandasilva
 */
public class DueDateRenderer extends DefaultTableCellRenderer{
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                          boolean isSelected, boolean hasFocus, int row, int column) {
        
        JLabel label;
        label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        label.setHorizontalAlignment(CENTER);
        
        TaskTableModel taskmodel = (TaskTableModel)table.getModel();
        Task task = taskmodel.getTasks().get(row);
        
        if(task.getDueDate().after(new Date())){
            label.setBackground(Color.GREEN);
        } else {
            label.setBackground(Color.RED);
        }
        
        return label;
    }
    
}
