/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.controlServicio;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelos.servicio;

/**
 *
 * @author luismiguel
 */
public class auxTCategoria {
    
    controlador.controlServicio ser = null;
    
    public void verTabla(JTable tabla){
        
        tabla.setDefaultRenderer(Object.class,new render());
        
        DefaultTableModel d = new DefaultTableModel(){
          public boolean isCellEditable(int row,int column){
              return false;
          }  
        };
        
        d.addColumn("Codigo");
        d.addColumn("Nombre");
        d.addColumn("Categoria");
        d.addColumn("Modificar");
        d.addColumn("Eliminar");
        
        JButton btn1 = new JButton("Modificar");
        btn1.setName("m");
        JButton btn2 = new JButton("Eliminar");
        btn2.setName("e");
        
        ser = new controlServicio();
        servicio s = new servicio();
        
        
        List<servicio> list = ser.obtener();
        
        if(list.size() > 0){
            for(int i = 0;i<list.size();i++){
                Object fila[] = new Object[5];
                s = list.get(i);
                fila[0] = s.getId();
                fila[1] = s.getNombre();
                fila[2] =  ser.nombreCategoria(s.getId_categoria());
                fila[3] = btn1;
                fila[4] = btn2;
                d.addRow(fila);
            }
            
        }
        
        tabla.setModel(d);
        tabla.setRowHeight(25);
        
       
    }
    
}
