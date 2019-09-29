/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.controlCategoria;
import controlador.controlEmpresa;
import controlador.controlMunicipio;
import controlador.controlServicio;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelos.categoria;
import modelos.empresa;
import modelos.municipio;
import modelos.servicio;

/**
 *
 * @author luismiguel
 */
public class modelosTabla {
    
    
    controlMunicipio muni = null;
    controlCategoria cat = null;
    controlServicio ser = null;
    controlEmpresa emp = null;
    
    
    
    public void modeloTMunicipio(JTable tabla){
        
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
   
    
    public void modeloTServicio(JTable tabla){
        
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
    
    
    public void modeloTCategoria(JTable tabla){
        
        
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
    
    
    public void modeloTEmpresa(JTable tabla){
        
        
         tabla.setDefaultRenderer(Object.class,new render());
       
       DefaultTableModel d = new DefaultTableModel(){
          public boolean isCellEditable(int row,int column){
              return false;
          }  
          
        };
       
       d.addColumn("CODIGO");
       d.addColumn("NIT");
       d.addColumn("NAME");
       d.addColumn("DIRECCION");
       d.addColumn("TEL");
       d.addColumn("ZONA");
       d.addColumn("LATITUD");
       d.addColumn("LOGITUD");
       d.addColumn("MUNICIPIO");
       d.addColumn("EMAIL");
       d.addColumn("PASSWORD");
       d.addColumn("MODIFY");
       d.addColumn("DELETE");       
       
       JButton btn1 = new JButton("Modificar");
        btn1.setName("m");
        JButton btn2 = new JButton("Eliminar");
        btn2.setName("e");
        
        
        emp = new controlEmpresa();
        empresa e = new empresa();
        
        
        
        List<empresa> list = emp.obtener();
        
        if(list.size()>0){
            
            for(int i=0;i<list.size();i++){
                Object fila[] = new Object[13];
                e = list.get(i);
                fila[0] = e.getId();
                fila[1] = e.getNit();
                fila[2] = e.getNombre();
                fila[3] = e.getDireccion();
                fila[4] = e.getTelefono();
                fila[5] = e.getZona();
                fila[6] = e.getLatitud();
                fila[7] = e.getLongitud();
                fila[8] = e.getId_municipio();
                fila[9] = e.getEmail();
                fila[10] = e.getPassword();
                fila[11] = btn1;
                fila[12] = btn2;
                d.addRow(fila);
            }
            
        }
        
        tabla.setModel(d);
        tabla.setRowHeight(25);
        
        
        
    }
    
    
    
    
    
    
    
    
}
