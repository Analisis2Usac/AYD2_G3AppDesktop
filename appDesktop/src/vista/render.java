/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import static com.sun.management.jmx.Trace.isSelected;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import sun.swing.table.DefaultTableCellHeaderRenderer;

/**
 *
 * @author luismiguel
 */
public class render extends DefaultTableCellHeaderRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
        
        if(o instanceof JButton){
            
            JButton btn = (JButton)o;
            
            if(bln1){
                btn.setForeground(jtable.getSelectionForeground());
                btn.setBackground(jtable.getSelectionBackground());
            }else{
             btn.setForeground(jtable.getForeground());
             btn.setBackground(UIManager.getColor("Button.background"));
            }
            return btn;
            
        }
        
        
        
        
        return super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
    }
   
  
    
  
}




