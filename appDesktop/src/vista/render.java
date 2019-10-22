/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.JTableHeader;
import sun.swing.table.DefaultTableCellHeaderRenderer;

/**
 *
 * @author luismiguel
 */
public class render extends DefaultTableCellHeaderRenderer {
    
    


    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
        
        //jtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
       // JScrollPane pane = new JScrollPane(jtable);
       // pane.setVisible(true);
        
         
        
        
        if(o instanceof JButton){
            
            JButton btn = (JButton)o;
            
            if(bln1){
                //btn.setForeground(jtable.getSelectionForeground());
                //btn.setBackground(jtable.getSelectionBackground());
                btn.setForeground(Color.WHITE);
                btn.setBackground(Color.black);
            }else{
             btn.setForeground(jtable.getForeground());
             btn.setBackground(UIManager.getColor("Button.background"));
            }
            return btn;
            
        }
        
        JTableHeader header = jtable.getTableHeader();
        header.setBackground(Color.GRAY);
        
       final Component c = super.getTableCellRendererComponent(jtable, o, bln,bln1,i,i1);
       
        c.setBackground(i % 2 == 1 ? Color.green : Color.WHITE);
        return c;
    
        
        //return super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
    }
   
  
    
  
}




