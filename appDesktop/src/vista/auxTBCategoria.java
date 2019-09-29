/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.controlCategoria;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelos.categoria;

/**
 *
 * @author luismiguel
 */
public class auxTBCategoria {
    
    
    controlador.controlCategoria cat = null;
    
   public void verTabla(JTable tabla){
       
       DefaultTableModel d = new DefaultTableModel(){
          public boolean isCellEditable(int row,int column){
              return false;
          }  
        };
       
       d.addColumn("Codigo");
       d.addColumn("Nombre");
       d.addColumn("Modificar");
       d.addColumn("Eliminar");
       
       JButton btn1 = new JButton("Modificar");
        btn1.setName("m");
        JButton btn2 = new JButton("Eliminar");
        btn2.setName("e");
        
        cat = new controlCategoria();
        categoria c = new categoria();
        
        List<categoria> list = cat.obtener();
        
        if(list.size()>0){
            
            for(int i=0;i<list.size();i++){
                Object fila[] = new Object[4];
                c = list.get(i);
                fila[0] = c.getId();
                fila[1] = c.getNombre();
                fila[2] = btn1;
                fila[3] = btn2;
                d.addRow(fila);
            }
            
        }
        
        tabla.setModel(d);
        tabla.setRowHeight(25);
       
   }
   
   
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
