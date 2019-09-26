/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.controlMunicipio;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelos.municipio;

/**
 *
 * @author luismiguel
 */
public class tablaAux {
    
    controlMunicipio muni = null;
    
    
    public void verTabla(JTable tabla){
        
        tabla.setDefaultRenderer(Object.class,new render());
        
       
        
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
        
        muni = new controlMunicipio();
        municipio m = new municipio();
        
        ArrayList<municipio> list =(ArrayList<municipio>)muni.obtener();
        
        if(list.size() > 0){
            for(int i = 0;i<list.size();i++){
                Object fila[] = new Object[4];
                m = list.get(i);
                fila[0] = m.getId();
                fila[1] = m.getNombre();
                fila[2] = btn1;
                fila[3] = btn2;
                d.addRow(fila);
            }
        }
        
       
        
        tabla.setModel(d);
        tabla.setRowHeight(25);
        
        
        
    }
    
    
    
}
