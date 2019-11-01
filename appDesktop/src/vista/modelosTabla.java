/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.controlCalificacion;
import controlador.controlCategoria;
import controlador.controlComentario;
import controlador.controlDContrato;
import controlador.controlDocumento;
import controlador.controlEmpresa;
import controlador.controlFoto;
import controlador.controlMunicipio;
import controlador.controlPago;
import controlador.controlServicio;
import controlador.controlSuscripcion;
import controlador.controlTabrajador;
import controlador.controlUsuario;
import controlador.controlVideo;
import controlador.controllistaServicio;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelos.calificacion;
import modelos.categoria;
import modelos.comentario;
import modelos.detalleContrato;
import modelos.documento;
import modelos.empresa;
import modelos.foto;
import modelos.lista_servicio;
import modelos.municipio;
import modelos.pago;
import modelos.servicio;
import modelos.suscripcion;
import modelos.trabajador;
import modelos.usuario;
import modelos.video;

/**
 *
 * @author luismiguel
 */
public class modelosTabla {
    
    
//    controlMunicipio muni = null;
//    controlCategoria cat = null;
//    controlServicio ser = null;
//    controlEmpresa emp = null;
//    controlUsuario usu = null;
//    controlPago pag = null;
//    controlTabrajador tra = null;
//    controllistaServicio ls = null;
//    controlDContrato dc = null;
//    controlComentario cm = null;
//    controlCalificacion ca = null;
//    controlFoto cf = null;
//    controlVideo vi = null;
//    controlDocumento doc = null;
//    controlSuscripcion sus = null;
    
    
    controlMunicipio muni = new controlMunicipio();
    controlCategoria cat = new controlCategoria();
    controlServicio ser = new controlServicio();
    controlEmpresa emp = new controlEmpresa();
    controlUsuario usu = new controlUsuario();
    controlPago pag = new controlPago();
    controlTabrajador tra = new controlTabrajador();
    controllistaServicio ls = new controllistaServicio();
    controlDContrato dc = new controlDContrato();
    controlComentario cm = new controlComentario();
    controlCalificacion ca = new controlCalificacion();
    controlFoto cf = new controlFoto();
    controlVideo vi = new controlVideo();
    controlDocumento doc = new controlDocumento();
    controlSuscripcion sus = new controlSuscripcion();
    
    
    public void modeloTMunicipio(JTable tabla,List<municipio> lista){
        
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
        
        //muni = new controlMunicipio();
        municipio m = new municipio();
        
        ArrayList<municipio> list =(ArrayList<municipio>) lista;
        
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
   
    
    public void modeloTServicio(JTable tabla,List<servicio> listaServicio){
        
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
        
       // ser = 
        servicio s = new servicio();
        
        
        List<servicio> list = listaServicio;
        
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
    
    
    public void modeloTCategoria(JTable tabla,List<categoria> lista){
        
        
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
        
        //cat = new controlCategoria();
        categoria c = new categoria();
        
        List<categoria> list = lista;
        
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
    
    
    public void modeloTEmpresa(JTable tabla,List<empresa> lista){
        
        
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
        
        
        //emp = new controlEmpresa();
        empresa e = new empresa();
        
        
        
        List<empresa> list = lista;
        
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
    
    
     public void modeloTUsuario(JTable tabla,List<usuario> lista){
        
        
         tabla.setDefaultRenderer(Object.class,new render());
       
       DefaultTableModel d = new DefaultTableModel(){
          public boolean isCellEditable(int row,int column){
              return false;
          }  
          
        };
       
       d.addColumn("EMAIL");
       d.addColumn("CONTRASEÑA");
       d.addColumn("DPI");
       d.addColumn("NOMBRE");
       d.addColumn("APELLIDO");
       d.addColumn("DIRECCION");
       d.addColumn("TELEFONO");
       d.addColumn("ZONA");
       d.addColumn("LATITUD");
       d.addColumn("LONGITUD");
       d.addColumn("MUNICIPIO");
       d.addColumn("MODIFY");
       d.addColumn("DELETE");       
       
       JButton btn1 = new JButton("Modificar");
        btn1.setName("m");
        JButton btn2 = new JButton("Eliminar");
        btn2.setName("e");
       
       // usu = new controlUsuario();
        usuario u = new usuario();
        
        
        
        List<usuario> list = lista;
        
        if(list.size()>0){
            
            for(int i=0;i<list.size();i++){
                Object fila[] = new Object[13];
                u = list.get(i);
                
                fila[0] = u.getEmail();
                fila[1] = u.getPassword();
                fila[2] = u.getDpi();
                fila[3] = u.getNombre();
                fila[4] = u.getApellido();
                fila[5] = u.getDireccion();
                fila[6] = u.getTelefono();
                fila[7] = u.getZona();
                fila[8] = u.getLatitud();
                fila[9] = u.getLongitud();
                fila[10] = u.getId_municipio();
                fila[11] = btn1;
                fila[12] = btn2;
                d.addRow(fila);
            }
            
        }
        
        tabla.setModel(d);
        tabla.setRowHeight(25);
    }
    
      public void modeloTPago(JTable tabla,List<pago> lista){
        
        
         tabla.setDefaultRenderer(Object.class,new render());
       
       DefaultTableModel d = new DefaultTableModel(){
          public boolean isCellEditable(int row,int column){
              return false;
          }  
          
        };
       
       d.addColumn("CODIGO");
       d.addColumn("FORMA");
       d.addColumn("MODIFY");
       d.addColumn("DELETE");       
       
       JButton btn1 = new JButton("Modificar");
        btn1.setName("m");
        JButton btn2 = new JButton("Eliminar");
        btn2.setName("e");
       
       // pag = new controlPago();
        pago p = new pago();
        
        
        
        List<pago> list = lista;
        
        if(list.size()>0){
            
            for(int i=0;i<list.size();i++){
                Object fila[] = new Object[13];
                p = list.get(i);
                
                fila[0] = p.getIdpago();
                fila[1] = p.getForma();
                fila[2] = btn1;
                fila[3] = btn2;
                d.addRow(fila);
            }
            
        }
        
        tabla.setModel(d);
        tabla.setRowHeight(25);  
    }
      
      
      
      //************************ Modelo tabla tabajador
      
      
       public void modeloTTrabajador(JTable tabla,List<trabajador> lista){
        
        
         tabla.setDefaultRenderer(Object.class,new render());
       
       DefaultTableModel d = new DefaultTableModel(){
          public boolean isCellEditable(int row,int column){
              return false;
          }  
          
        };
       
       d.addColumn("CODIGO");
       d.addColumn("EMPRESA");
       d.addColumn("EMAIL");
       d.addColumn("MODIFY");
       d.addColumn("DELETE");       
       
       JButton btn1 = new JButton("Modificar");
        btn1.setName("m");
        JButton btn2 = new JButton("Eliminar");
        btn2.setName("e");
       
       // tra = new controlTabrajador();
        trabajador t = new trabajador();
        
        
        
        List<trabajador> list = lista;
        
        if(list.size()>0){
            
            for(int i=0;i<list.size();i++){
                Object fila[] = new Object[13];
                t = list.get(i);
                
                fila[0] = t.getIdEmpleado();
                fila[1] = emp.nombreEmpresa(t.getIdEmpresa());
                fila[2] = t.getEmail();
                fila[3] = btn1;
                fila[4] = btn2;
                d.addRow(fila);
            }
            
        }
        
        tabla.setModel(d);
        tabla.setRowHeight(25);  
    }
       
       
    //********************* listado de servicio 
       
       
        public void modeloLServicio(JTable tabla,List<lista_servicio> lista){
        
        
         tabla.setDefaultRenderer(Object.class,new render());
       
       DefaultTableModel d = new DefaultTableModel(){
          public boolean isCellEditable(int row,int column){
              return false;
          }  
          
        };
       
       d.addColumn("EMPRESA");
       d.addColumn("SERVICIO");
       d.addColumn("COSTO");
       d.addColumn("MODIFY");
       d.addColumn("DELETE");       
       
       JButton btn1 = new JButton("Modificar");
        btn1.setName("m");
        JButton btn2 = new JButton("Eliminar");
        btn2.setName("e");
       
       // ls = new controllistaServicio();
        lista_servicio lss = new lista_servicio();
        
        
        
        List<lista_servicio> list = lista;
        
        if(list.size()>0){
            
            for(int i=0;i<list.size();i++){
                Object fila[] = new Object[13];
                lss = list.get(i);
                
                fila[0] = emp.nombreEmpresa(lss.getId_empresa());
                fila[1] = ser.nombreServicio(lss.getId_servicio());
                fila[2] = lss.getPrecio();
                fila[3] = btn1;
                fila[4] = btn2;
                d.addRow(fila);
            }
            
        }
        
        tabla.setModel(d);
        tabla.setRowHeight(25);  
    }
        
        
        
        //********************* MODELO DETALLE CONTRATO
       
       
        public void modeloTLContrato(JTable tabla){
        
        
         tabla.setDefaultRenderer(Object.class,new render());
       
       DefaultTableModel d = new DefaultTableModel(){
          public boolean isCellEditable(int row,int column){
              return false;
          }  
          
        };
       
       d.addColumn("CODIGO");
       d.addColumn("FECHA");
       d.addColumn("EMPRESA");
       d.addColumn("SERVICIO");
       d.addColumn("PAGO");
       d.addColumn("EMAIL");
       d.addColumn("MODIFY");
       d.addColumn("DELETE");       
       
       JButton btn1 = new JButton("Modificar");
        btn1.setName("m");
        JButton btn2 = new JButton("Eliminar");
        btn2.setName("e");
       
      //  dc = new controlDContrato();
        detalleContrato dtc;
        
        
        
        List<detalleContrato> list = dc.obtener();
        
        if(list.size()>0){
            
            for(int i=0;i<list.size();i++){
                Object fila[] = new Object[13];
                dtc = list.get(i);
                
                fila[0] = dtc.getIdContrato();
                fila[1] = dtc.getFecha();
                fila[2] = dtc.getIdEmpresa();
                fila[3] = dtc.getIdServicio();
                fila[4] = dtc.getPago();
                fila[5] = dtc.getEmail();
                fila[6] = btn1;
                fila[7] = btn2;
                d.addRow(fila);
            }
            
        }
        
        tabla.setModel(d);
        tabla.setRowHeight(25);  
    }
        
        
         //********************* MODELO COMENTARIO
       
       
        public void modeloTComentario(JTable tabla){
        
        
         tabla.setDefaultRenderer(Object.class,new render());
       
       DefaultTableModel d = new DefaultTableModel(){
          public boolean isCellEditable(int row,int column){
              return false;
          }  
          
        };
       
       d.addColumn("CODIGO");
       d.addColumn("COMENTARIO");
       d.addColumn("CONTRATO");
       d.addColumn("MODIFY");
       d.addColumn("DELETE");       
       
       JButton btn1 = new JButton("Modificar");
        btn1.setName("m");
        JButton btn2 = new JButton("Eliminar");
        btn2.setName("e");
       
       // cm = new controlComentario();
        comentario cmt;
        
        
        
        List<comentario> list = cm.obtener();
        
        if(list.size()>0){
            
            for(int i=0;i<list.size();i++){
                Object fila[] = new Object[13];
                cmt = list.get(i);
                
                fila[0] = cmt.getIdComentario();
                fila[1] = cmt.getComentario();
                fila[2] = cmt.getIdContrato();
                fila[6] = btn1;
                fila[7] = btn2;
                d.addRow(fila);
            }
            
        }
        
        tabla.setModel(d);
        tabla.setRowHeight(25);  
    }
        
        
         //********************* MODELO COMENTARIO
       
       
        public void modeloTCalificacion(JTable tabla){
        
        
         tabla.setDefaultRenderer(Object.class,new render());
       
       DefaultTableModel d = new DefaultTableModel(){
          public boolean isCellEditable(int row,int column){
              return false;
          }  
          
        };
       
       d.addColumn("CODIGO");
       d.addColumn("CALIFICACION");
       d.addColumn("CONTRATO");
       d.addColumn("MODIFY");
       d.addColumn("DELETE");       
       
       JButton btn1 = new JButton("Modificar");
        btn1.setName("m");
        JButton btn2 = new JButton("Eliminar");
        btn2.setName("e");
       
       // ca = new controlCalificacion();
            calificacion cal;
        
        
        
        List<calificacion> list = ca.obtener();
        
        if(list.size()>0){
            
            for(int i=0;i<list.size();i++){
                Object fila[] = new Object[13];
                cal = list.get(i);
                
                fila[0] = cal.getIdCalificacion();
                fila[1] = cal.getCalificacion();
                fila[2] = cal.getIdContrato();
                fila[3] = btn1;
                fila[4] = btn2;
                d.addRow(fila);
            }
            
        }
        
        tabla.setModel(d);
        tabla.setRowHeight(25);  
    }
        
        
          
         //********************* MODELO FOTOGRAFIA
       
       
        public void modeloTFoto(JTable tabla,List<foto> lista){
        
        
         tabla.setDefaultRenderer(Object.class,new render());
       
       DefaultTableModel d = new DefaultTableModel(){
          public boolean isCellEditable(int row,int column){
              return false;
          }  
          
        };
       
       d.addColumn("CODIGO");
       d.addColumn("RUTA");
       d.addColumn("EMPLEADO");
       d.addColumn("MODIFY");
       d.addColumn("DELETE");       
       
       JButton btn1 = new JButton("Modificar");
        btn1.setName("m");
        JButton btn2 = new JButton("Eliminar");
        btn2.setName("e");
       
        // cf = new controlFoto();
            foto f;
        
        
        
        List<foto> list = lista;
        
        if(list.size()>0){
            
            for(int i=0;i<list.size();i++){
                Object fila[] = new Object[13];
                f = list.get(i);
                
                fila[0] = f.getIdFoto();
                fila[1] = f.getRuta();
                fila[2] = f.getIdEmpleado();
                fila[3] = btn1;
                fila[4] = btn2;
                d.addRow(fila);
            }
            
        }
        
        tabla.setModel(d);
        tabla.setRowHeight(25);  
    }
        
        
             
         //********************* MODELO VIDEO
       
       
        public void modeloTVideo(JTable tabla){
        
        
         tabla.setDefaultRenderer(Object.class,new render());
       
       DefaultTableModel d = new DefaultTableModel(){
          public boolean isCellEditable(int row,int column){
              return false;
          }  
          
        };
       
       d.addColumn("CODIGO");
       d.addColumn("RUTA");
       d.addColumn("EMPLEADO");
       d.addColumn("MODIFY");
       d.addColumn("DELETE");       
       
       JButton btn1 = new JButton("Modificar");
        btn1.setName("m");
        JButton btn2 = new JButton("Eliminar");
        btn2.setName("e");
       
       // vi = new controlVideo();
            video v;
        
        
        
        List<video> list = vi.obtener();
        
        if(list.size()>0){
            
            for(int i=0;i<list.size();i++){
                Object fila[] = new Object[13];
                v = list.get(i);
                
                fila[0] = v.getIdVideo();
                fila[1] = v.getRuta();
                fila[2] = v.getIdEmpleado();
                fila[3] = btn1;
                fila[4] = btn2;
                d.addRow(fila);
            }
            
        }
        
        tabla.setModel(d);
        tabla.setRowHeight(25);  
    }
        
        
        //********************* MODELO DOCUMENTO
      
        
        public void modeloTDocumento(JTable tabla){
        
        
         tabla.setDefaultRenderer(Object.class,new render());
       
       DefaultTableModel d = new DefaultTableModel(){
          public boolean isCellEditable(int row,int column){
              return false;
          }  
          
        };
       
       d.addColumn("CODIGO");
       d.addColumn("DOCUMENTO");
       d.addColumn("EMPLEADO");
       d.addColumn("MODIFY");
       d.addColumn("DELETE");       
       
       JButton btn1 = new JButton("Modificar");
       btn1.setName("m");
       JButton btn2 = new JButton("Eliminar");
       btn2.setName("e");
       
       // doc = new controlDocumento();
        documento dc;
        
        
        
        List<documento> list = doc.obtener();
        
        if(list.size()>0){
            
            for(int i=0;i<list.size();i++){
                Object fila[] = new Object[13];
                dc= list.get(i);
                
                fila[0] = dc.getIdDocumento();
                fila[1] = dc.getDocumento();
                fila[2] = dc.getIdEmpleado();
                fila[3] = btn1;
                fila[4] = btn2;
                d.addRow(fila);
            }
            
        }
        
        tabla.setModel(d);
        tabla.setRowHeight(25);  
    }
        
        
        //********************* MODELO SUSCRIPCION
      
        
        public void modeloTSuscripcion(JTable tabla){
        
        
         tabla.setDefaultRenderer(Object.class,new render());
       
       DefaultTableModel d = new DefaultTableModel(){
          public boolean isCellEditable(int row,int column){
              return false;
          }  
          
        };
       
       d.addColumn("CODIGO");
       d.addColumn("FECHAINICIO");
       d.addColumn("FECHAFIN");
       d.addColumn("LIMITESERVICIO");
       d.addColumn("EMPRESA");
       d.addColumn("TOTAL");
       
       d.addColumn("MODIFY");
       d.addColumn("DELETE");       
       
       JButton btn1 = new JButton("Modificar");
       btn1.setName("m");
       JButton btn2 = new JButton("Eliminar");
       btn2.setName("e");
       
       // sus = new controlSuscripcion();
        suscripcion s;
        
        
        
        List<suscripcion> list = sus.obtener();
        
        if(list.size()>0){
            
            for(int i=0;i<list.size();i++){
                Object fila[] = new Object[13];
                s= list.get(i);
                
                fila[0] = s.getId();
                fila[2] = s.getInicioFecha();
                fila[3] = s.getFinFecha();
                fila[4] = s.getLimiteServicio();
                fila[5] = s.getIdEmpresa();
                fila[1] = s.getTotal();
                
                fila[6] = btn1;
                fila[7] = btn2;
                d.addRow(fila);
            }
            
        }
        
        tabla.setModel(d);
        tabla.setRowHeight(25);  
    }
        
        
      
      

}
