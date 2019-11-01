/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.controlCategoria;
import controlador.controlEmpresa;
import controlador.controlFoto;
import controlador.controlMunicipio;
import controlador.controlPago;
import controlador.controlServicio;
import controlador.controlTabrajador;
import controlador.controlUsuario;
import controlador.controllistaServicio;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import modelos.categoria;
import modelos.empresa;
import modelos.foto;
import modelos.lista_servicio;
import modelos.municipio;
import modelos.pago;
import modelos.servicio;
import modelos.trabajador;
import modelos.usuario;

/**
 *
 * @author luismiguel
 */
public class panelPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form panelPrincipal
     */
    public panelPrincipal() {
       
        
        
        initComponents();
        //ingresarTabla();
     
        
      
        
        listaMunicipio = controlM.obtener();
        listaServicio =  controlS.obtener();
        listaCategoria =  controlC.obtener();
        listaEmpresa =  controlE.obtener();
        listaLServicio = controlLS.obtener();
        listaUsuario =  controlU.obtener();
        listaTabajador = controlEmp.obtener();
        listaPago =  controlP.obtener();
        listaFoto = controlF.obtener();
        
        
        modeloTabla.modeloTMunicipio(tabla1,listaMunicipio);
        //modeloTabla.modeloTServicio(tablaServicio);
        //modeloTabla.modeloTCategoria(tablaCategoria);
        //modeloTabla.modeloTEmpresa(tablaEmpresa);
        //modeloTabla.modeloTUsuario(tablaUsuario);
        //modeloTabla.modeloLServicio(tablalservicio);
        
        nombrePestana();
       
        disableComponents();
        
    }
    
    //************************ LISTADO DE TODAS LAS TABLAS 
    
    List<municipio> listaMunicipio;
    List<servicio> listaServicio;
    List<categoria> listaCategoria;
    List<empresa> listaEmpresa;
    List<lista_servicio> listaLServicio;
    List<usuario> listaUsuario;
    List<trabajador> listaTabajador;
    List<pago> listaPago;
    
    List<foto> listaFoto;
    
    
    public void asignarLMunicipio(){
        listaMunicipio.clear();
        listaMunicipio = controlM.obtener();
    }
    public void asignarLServicio(){
        listaServicio.clear();
        listaServicio =  controlS.obtener();
    }
    
    public void asignarLCategoria(){
        
        listaCategoria.clear();
        listaCategoria = controlC.obtener();
    }
    
    public void asignarLEmpresa(){
        listaEmpresa.clear();
        listaEmpresa =  controlE.obtener();
    }
    public void asignarLLServicio(){
        listaLServicio.clear();
        listaLServicio = controlLS.obtener();
    }
    
    public void asignarUsuario(){
        listaUsuario.clear();
        listaUsuario = controlU.obtener();
    }
    
    public void asignarEmpleado(){
        listaTabajador.clear();
        listaTabajador = controlEmp.obtener();
    }
    
    public void asignarFoto(){
        listaFoto.clear();
        listaFoto = controlF.obtener();
    }
    
    public void asignarPago(){
        listaPago.clear();
        listaPago =  controlP.obtener();
    }
            
    
    
    //************************ Nombre de pestañas
    
    public void nombrePestana(){
        
        panel1.setName("panelM");
        panel2.setName("panelS");
        panel3.setName("panelC");
        panel4.setName("panelE");
        panel5.setName("panelLS");
        panel6.setName("panelU");
        panel7.setName("panelEmp");
        panel8.setName("panelP");
        panel9.setName("panelF");
        
        
    }
    
  
    
    //**************************** Modelos de tabla 
    
    modelosTabla modeloTabla = new modelosTabla();
    
    int clicTabla = 0;
    
    controlMunicipio controlM = new controlMunicipio();
    controlCategoria controlC = new controlCategoria();
    controlServicio controlS = new controlServicio();
    controlEmpresa controlE = new controlEmpresa();
    controlUsuario controlU = new controlUsuario();
    controllistaServicio controlLS = new controllistaServicio();
    controlTabrajador controlEmp = new controlTabrajador();
    controlFoto controlF = new controlFoto();
    
    controlPago controlP = new controlPago();
    
    //--------- variable globales para setearlos de municipio 
    
    String cM = "";
    String nM = "";
            
   
    //**************** Llenar categorias 
    
    public void llenarCategoria(){
        
        List<categoria> list = listaCategoria;
        
        DefaultComboBoxModel value = new DefaultComboBoxModel();
        cbxCategoria.setModel(value);
        cbxCategoria1.setModel(value);
        
        for(categoria item : list){
            value.addElement(new categoria(item.getId(),item.getNombre()));
        } 
    }
    
   //**************** llenar municipio 
    
    public void llenarMunicipio(){
        List<municipio> list = listaMunicipio;
        
        DefaultComboBoxModel value = new DefaultComboBoxModel();
        cbxempresa.setModel(value);
        cbxUsuario.setModel(value);
        
        for(municipio item:list){
            value.addElement(new municipio(item.getId(),item.getNombre()));
        }
           
    }
    
    //********** LLENAR COMBO EMPRESA 
    
    
    public void llenarEmpresa(){
    
      List<empresa> list = listaEmpresa;
      
      DefaultComboBoxModel value =  new DefaultComboBoxModel();
      cbxlempresa.setModel(value);
      cbxempleado1.setModel(value);
      
      for(empresa item:list){
          value.addElement(new empresa(item.getId(),item.getNombre()));
      }
  
    }
    
    
    //********** LLENAR SERVICIO 
    
    public void llenarServicio(){
        List<servicio> list = listaServicio;
        
        DefaultComboBoxModel value = new DefaultComboBoxModel();
        cbxlservicio.setModel(value);
        
        for(servicio item:list){
            value.addElement(new servicio(item.getId(),item.getNombre()));
        }
        
    }
    
    //*********** LLENAR USUARIO
    
    public void llenarUsuario(){
        
        List<usuario> list = listaUsuario;
        
        DefaultComboBoxModel value =  new DefaultComboBoxModel();
        cbxempleado2.setModel(value);
        
        for(usuario item: list){
            value.addElement(new usuario(item.getEmail()));
        }    
    }
    
    //*************** LLENAR EMPLEADO
    
    public void llenarEmpleado(){
        
        List<trabajador> list = listaTabajador;
        
        DefaultComboBoxModel value =  new DefaultComboBoxModel();
        cbxFoto1.setModel(value);
        
        for(trabajador item: list){
            value.addElement(new trabajador(item.getIdEmpleado(),item.getIdEmpresa(),item.getEmail()));
        } 
    }
    
    
    //********************** desabilitar texbox pra verificar el codigo 
    
    
    public void disableComponents(){
        txtmuni1.setEnabled(false);
        txtservicio2.setEnabled(false);
        txtservicio4.setEnabled(false);
        txtcategoria2.setEnabled(false);
        txtempresa1.setEnabled(false);
        txtempleado1.setEnabled(false);
        txtpago1.setEnabled(false);
        txtfoto1.setEnabled(false);
    }
            
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuP = new javax.swing.JTabbedPane();
        panel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtmuni2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtmuni1 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();
        panel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtservicio1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbxCategoria = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtservicio2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtservicio3 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtservicio4 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cbxCategoria1 = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaServicio = new javax.swing.JTable();
        panel3 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtcategoria1 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtcategoria2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaCategoria = new javax.swing.JTable();
        panel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        txtempresa1 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtempresa2 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtempresa7 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtempresa4 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtempresa6 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtempresa3 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txtempresa8 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        cbxempresa = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtempresa9 = new javax.swing.JTextField();
        txtempresa5 = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaEmpresa = new javax.swing.JTable();
        panel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cbxlempresa = new javax.swing.JComboBox<>();
        cbxlservicio = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        txtlsprecio = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        tablalservicio = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        panel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        txtUsuario1 = new javax.swing.JTextField();
        txtUsuario2 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txtUsuario3 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        txtUsuario4 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        txtUsuario5 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        txtUsuario6 = new javax.swing.JTextField();
        txtUsuario7 = new javax.swing.JTextField();
        txtUsuario8 = new javax.swing.JTextField();
        txtUsuario9 = new javax.swing.JTextField();
        txtUsuario10 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        cbxUsuario = new javax.swing.JComboBox<>();
        jPanel11 = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tablaUsuario = new javax.swing.JTable();
        panel7 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtempleado1 = new javax.swing.JTextField();
        cbxempleado1 = new javax.swing.JComboBox<>();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        cbxempleado2 = new javax.swing.JComboBox<>();
        jScrollPane9 = new javax.swing.JScrollPane();
        tablaEmpleado = new javax.swing.JTable();
        panel8 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtpago1 = new javax.swing.JTextField();
        txtpago2 = new javax.swing.JTextField();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        tablaPago = new javax.swing.JTable();
        panel9 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        txtfoto1 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtfoto2 = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        cbxFoto1 = new javax.swing.JComboBox<>();
        jScrollPane11 = new javax.swing.JScrollPane();
        tablaFoto = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuPMouseClicked(evt);
            }
        });

        panel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Crear Municipio"));

        jLabel2.setText("NOMBRE");

        jButton2.setBackground(new java.awt.Color(153, 255, 102));
        jButton2.setText("MODIFICAR MUNICIPIO");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel13.setText("CODIGO");

        jButton7.setBackground(new java.awt.Color(153, 153, 255));
        jButton7.setText("CREAR MUNICIPIO");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtmuni1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtmuni2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 256, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtmuni1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtmuni2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(69, 69, 69))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla1);

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5))
                .addContainerGap())
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 861, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        menuP.addTab("MUNICIPIO", panel1);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Crear Servicio"));

        jLabel4.setText("NOMBRE");

        jLabel5.setText("CATEGORIA");

        cbxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton3.setText("Crear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(txtservicio1)
                    .addComponent(cbxCategoria, 0, 130, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtservicio1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(cbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Modificar Categoria"));

        jLabel6.setText("CODIGO");

        jLabel7.setText("NOMBRE");

        jLabel8.setText("CATEGORIA");

        jLabel9.setText("NEW CATEGORIA");

        cbxCategoria1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton4.setText("Modificar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtservicio2)
                            .addComponent(txtservicio3)
                            .addComponent(txtservicio4)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(cbxCategoria1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtservicio2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtservicio3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtservicio4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(cbxCategoria1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        tablaServicio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaServicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaServicioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaServicio);

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
                .addContainerGap())
        );

        menuP.addTab("SERVICIO", panel2);

        panel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Crear Categoria"));

        jLabel10.setText("NOMBRE");

        jButton5.setBackground(new java.awt.Color(153, 153, 255));
        jButton5.setText("CREAR CATEGORIA");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel3.setText("CODIGO");

        jButton1.setBackground(new java.awt.Color(102, 255, 51));
        jButton1.setText("MODIFICAR CATEGORIA");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(txtcategoria2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtcategoria1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(183, 183, 183)
                        .addComponent(jLabel10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 216, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcategoria2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcategoria1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        tablaCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaCategoriaMouseClicked(evt);
            }
        });
        tablaCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaCategoriaKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(tablaCategoria);

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 851, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(172, Short.MAX_VALUE))
        );

        menuP.addTab("CATEGORIA", panel3);

        panel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Creacion y Modificacion"));

        jLabel22.setText("CODIGO");

        jLabel23.setText("NIT");

        jLabel24.setText("NOMBRE");

        jLabel25.setText("DIRECCION");

        jLabel26.setText("ZONA");

        jLabel27.setText("LATITUD");

        jLabel28.setText("LOGITUD");

        jLabel29.setText("MUNICIPIO");

        jLabel30.setText("EMAIL");

        jButton9.setBackground(new java.awt.Color(102, 255, 102));
        jButton9.setText("MODIFICAR EMPRESA");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(153, 153, 255));
        jButton10.setText("CREAR EMPRESA");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        cbxempresa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("TELEFONO");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25)
                    .addComponent(jLabel1))
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtempresa2)
                    .addComponent(txtempresa1)
                    .addComponent(txtempresa3)
                    .addComponent(txtempresa4)
                    .addComponent(txtempresa5))
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel28)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(jLabel27)))
                    .addComponent(jLabel29)
                    .addComponent(jLabel30))
                .addGap(13, 13, 13)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxempresa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtempresa8)
                    .addComponent(txtempresa7)
                    .addComponent(txtempresa6)
                    .addComponent(txtempresa9))
                .addGap(16, 16, 16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(txtempresa1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtempresa2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27)
                            .addComponent(txtempresa7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtempresa3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28)
                            .addComponent(txtempresa8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtempresa4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25)
                            .addComponent(jLabel29)
                            .addComponent(cbxempresa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtempresa6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel26)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addComponent(txtempresa9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtempresa5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        tablaEmpresa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEmpresaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tablaEmpresa);

        jScrollPane6.setViewportView(jScrollPane4);

        javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 929, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );

        menuP.addTab("EMPRESA", panel4);

        panel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setText("EMPRESA");

        jLabel12.setText("SERVICIO");

        cbxlempresa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxlservicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel14.setText("PRECIO");

        tablalservicio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablalservicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalservicioMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tablalservicio);

        jButton6.setText("CREAR");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton8.setText("MODIFICAR PRECIO");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxlempresa, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(cbxlservicio, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(txtlsprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
                .addGap(22, 22, 22))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11)
                                .addComponent(jLabel14)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbxlempresa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxlservicio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtlsprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panel5Layout = new javax.swing.GroupLayout(panel5);
        panel5.setLayout(panel5Layout);
        panel5Layout.setHorizontalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel5Layout.setVerticalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        menuP.addTab("LISTASERVICIO", panel5);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Creacion y Modificacion"));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel32.setText("EMAIL");

        jLabel33.setText("PASSWORD");

        jLabel34.setText("DPI");

        jLabel35.setText("NOMBRE");

        jLabel36.setText("APELLIDO");

        jLabel37.setText("DIRECCION");

        jLabel38.setText("TELEFONO");

        jLabel39.setText("ZONA");

        jLabel40.setText("LATITUD");

        jLabel41.setText("LONGITUD");

        jLabel42.setText("MUNICIPIO");

        cbxUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton11.setText("CREAR USUARIO");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("MODIFICAR USUARIO");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33)
                    .addComponent(jLabel34)
                    .addComponent(jLabel35)
                    .addComponent(jLabel36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUsuario5, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(txtUsuario4)
                    .addComponent(txtUsuario2)
                    .addComponent(txtUsuario1)
                    .addComponent(txtUsuario3))
                .addGap(51, 51, 51)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel37)
                    .addComponent(jLabel38)
                    .addComponent(jLabel39)
                    .addComponent(jLabel40)
                    .addComponent(jLabel41))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUsuario10)
                    .addComponent(txtUsuario9, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(txtUsuario8)
                    .addComponent(txtUsuario7)
                    .addComponent(txtUsuario6))
                .addGap(30, 30, 30)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel42)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cbxUsuario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(txtUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37)
                    .addComponent(txtUsuario6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUsuario2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33)
                            .addComponent(txtUsuario7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUsuario3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34)
                            .addComponent(txtUsuario8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsuario9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtUsuario4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel35)
                                .addComponent(jLabel40)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUsuario5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36)
                            .addComponent(txtUsuario10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel41)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(cbxUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tablaUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaUsuarioMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tablaUsuario);

        javax.swing.GroupLayout panel6Layout = new javax.swing.GroupLayout(panel6);
        panel6.setLayout(panel6Layout);
        panel6Layout.setHorizontalGroup(
            panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 929, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel6Layout.setVerticalGroup(
            panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        menuP.addTab("USUARIO", panel6);

        jLabel15.setText("CODIGO");

        jLabel16.setText("EMPRESA");

        jLabel17.setText("CORREO");

        cbxempleado1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton13.setText("CREAR EMPLEADO");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setText("ACTUALIZAR EMPLEADO");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        cbxempleado2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(txtempleado1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxempleado1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(cbxempleado2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                            .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtempleado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxempleado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton13)
                    .addComponent(cbxempleado2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton14)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        tablaEmpleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEmpleadoMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tablaEmpleado);

        javax.swing.GroupLayout panel7Layout = new javax.swing.GroupLayout(panel7);
        panel7.setLayout(panel7Layout);
        panel7Layout.setHorizontalGroup(
            panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane9))
                .addContainerGap())
        );
        panel7Layout.setVerticalGroup(
            panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
        );

        menuP.addTab("EMPLEADO", panel7);

        jLabel18.setText("CODIGO");

        jLabel19.setText("FORMA");

        jButton15.setText("MODIFICAR");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setText("CREAR");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(txtpago1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(txtpago2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(226, 226, 226))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jButton16))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtpago1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtpago2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton15))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        tablaPago.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaPago.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPagoMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tablaPago);

        javax.swing.GroupLayout panel8Layout = new javax.swing.GroupLayout(panel8);
        panel8.setLayout(panel8Layout);
        panel8Layout.setHorizontalGroup(
            panel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel8Layout.createSequentialGroup()
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 798, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 131, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel8Layout.setVerticalGroup(
            panel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(172, Short.MAX_VALUE))
        );

        menuP.addTab("FORMAPAGO", panel8);

        jLabel20.setText("CODIGO");

        jLabel21.setText("RUTA");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 219, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jButton17.setText("CREAR");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setText("MODIFICAR");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jLabel31.setText("EMPLEADO");

        cbxFoto1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel20)
                        .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
                    .addComponent(txtfoto1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel21)
                    .addComponent(txtfoto2)
                    .addComponent(jLabel31)
                    .addComponent(cbxFoto1, 0, 216, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfoto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfoto2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton17)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton18)
                    .addComponent(cbxFoto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(74, Short.MAX_VALUE))
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tablaFoto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaFotoMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tablaFoto);

        javax.swing.GroupLayout panel9Layout = new javax.swing.GroupLayout(panel9);
        panel9.setLayout(panel9Layout);
        panel9Layout.setHorizontalGroup(
            panel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel9Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 797, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel9Layout.setVerticalGroup(
            panel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(188, Short.MAX_VALUE))
        );

        menuP.addTab("FOTO", panel9);

        jLabel43.setText("CODIGO");

        jLabel44.setText("RUTA");

        jButton19.setText("CREAR");

        jButton20.setText("ACTUALIZAR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton20)
                    .addComponent(jButton19)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel43)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel44)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(408, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(jLabel44))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton19)
                .addGap(18, 18, 18)
                .addComponent(jButton20)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(449, Short.MAX_VALUE))
        );

        menuP.addTab("VIDEO", jPanel13);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 949, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 648, Short.MAX_VALUE)
        );

        menuP.addTab("DOCUMENTO", jPanel14);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 949, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 648, Short.MAX_VALUE)
        );

        menuP.addTab("SUSCRIPCION", jPanel18);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 949, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 648, Short.MAX_VALUE)
        );

        menuP.addTab("COMENTARIO", jPanel19);

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 949, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 648, Short.MAX_VALUE)
        );

        menuP.addTab("CALIFICACION", jPanel20);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 949, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 648, Short.MAX_VALUE)
        );

        menuP.addTab("FORMA-PAGO", jPanel21);

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 949, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 648, Short.MAX_VALUE)
        );

        menuP.addTab("CONTRATO", jPanel22);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menuP)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuP, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPMouseClicked

        //modeloTabla.modeloTServicio(tablaServicio);

        String nPestana = menuP.getSelectedComponent().getName();
        if(nPestana.equals("panelM")){
            modeloTabla.modeloTMunicipio(tabla1,listaMunicipio);
        }
        if(nPestana.equals("panelS")){
            modeloTabla.modeloTServicio(tablaServicio, listaServicio);
            llenarCategoria();
        }
        if(nPestana.equals("panelC")){
            modeloTabla.modeloTCategoria(tablaCategoria, listaCategoria);
        }

        if(nPestana.equals("panelE")){
            modeloTabla.modeloTEmpresa(tablaEmpresa, listaEmpresa);
        }

        if(nPestana.equals("panelLS")){
            modeloTabla.modeloLServicio(tablalservicio, listaLServicio);
            llenarEmpresa();
            llenarServicio();
        }
        if(nPestana.equals("panelU")){
            modeloTabla.modeloTUsuario(tablaUsuario, listaUsuario);
            llenarMunicipio();
        }

        if(nPestana.equals("panelEmp")){
            modeloTabla.modeloTTrabajador(tablaEmpleado, listaTabajador);
            llenarEmpresa();
            llenarUsuario();
        }
        
        if(nPestana.equals("panelF")){
            modeloTabla.modeloTFoto(tablaFoto, listaFoto);
            llenarEmpleado();
        }
        
        // falta todavia lo de la foto 
        

        if(nPestana.equals("panelP")){
            modeloTabla.modeloTPago(tablaPago, listaPago);
        }

        //        switch(nPestana){
            //            case "panelM":
            //                modeloTabla.modeloTMunicipio(tabla1,listaMunicipio);
            //                break;
            //            case "panelS":
            //                modeloTabla.modeloTServicio(tablaServicio, listaServicio);
            //                llenarCategoria();
            //                break;
            //            case "panelC":
            //                modeloTabla.modeloTCategoria(tablaCategoria, listaCategoria);
            //                break;
            //            case "panelE":
            //                modeloTabla.modeloTEmpresa(tablaEmpresa, listaEmpresa);
            //                llenarMunicipio();
            //                break;
            //            case "panelLS":
            //                modeloTabla.modeloLServicio(tablalservicio, listaLServicio);
            //                llenarEmpresa();
            //                llenarServicio();
            //            case "panelU":
            //                modeloTabla.modeloTUsuario(tablaUsuario, listaUsuario);
            //                llenarMunicipio();
            //                break;
            //
            //            default:
            //                System.out.println("No se selecciono ningun panel ");
            //                break;
            //
            //        }
    }//GEN-LAST:event_menuPMouseClicked

    private void tablaPagoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPagoMouseClicked

        clicTabla = this.tablaPago.rowAtPoint(evt.getPoint());
        String codigo = ""+tablaPago.getValueAt(clicTabla,0);
        String forma = ""+tablaPago.getValueAt(clicTabla,1);

        int column = tablaPago.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/tablaPago.getRowHeight();

        if(row < tablaPago.getRowCount() && row >=0  && column < tablaPago.getColumnCount() && column >=0 ){
            Object value = tablaPago.getValueAt(row,column);
            if(value instanceof JButton){
                ((JButton)value).doClick();
                JButton boton = (JButton)value;

                if(boton.getName().equals("m")){

                    txtpago1.setText(codigo);
                    txtpago2.setText(forma);

                }
                if(boton.getName().equals("e")){

                    controlP.eliminar(Integer.parseInt(codigo));
                    asignarPago();
                    modeloTabla.modeloTPago(tablaPago, listaPago);
                }

            }
        }

    }//GEN-LAST:event_tablaPagoMouseClicked

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        crearPago();
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        modificarPago();
    }//GEN-LAST:event_jButton15ActionPerformed

    private void tablaEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEmpleadoMouseClicked
        // TODO add your handling code here:

        clicTabla = this.tablaEmpleado.rowAtPoint(evt.getPoint());
        String codigo = ""+tablaEmpleado.getValueAt(clicTabla,0);
        String empresa = ""+tablaEmpleado.getValueAt(clicTabla,1);
        String correo = ""+tablaEmpleado.getValueAt(clicTabla,2);

        int column = tablaEmpleado.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/tablaEmpleado.getRowHeight();

        if(row < tablaEmpleado.getRowCount() && row >=0  && column < tablaEmpleado.getColumnCount() && column >=0 ){
            Object value = tablaEmpleado.getValueAt(row,column);
            if(value instanceof JButton){
                ((JButton)value).doClick();
                JButton boton = (JButton)value;

                if(boton.getName().equals("m")){

                    txtempleado1.setText(codigo);

                }
                if(boton.getName().equals("e")){

                    controlEmp.eliminar(Integer.parseInt(codigo));
                    asignarEmpleado();
                    modeloTabla.modeloTTrabajador(tablaEmpleado, listaTabajador);
                }

            }
        }

    }//GEN-LAST:event_tablaEmpleadoMouseClicked

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        modificarEmpleado();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        crearEmpleado();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void tablaUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaUsuarioMouseClicked
        // TODO add your handling code here:

        clicTabla = this.tablaUsuario.rowAtPoint(evt.getPoint());
        String email = ""+tablaUsuario.getValueAt(clicTabla,0);
        String password = ""+tablaUsuario.getValueAt(clicTabla,1);
        String dpi = ""+tablaUsuario.getValueAt(clicTabla,2);
        String nombre = ""+tablaUsuario.getValueAt(clicTabla,3);
        String apellido = ""+tablaUsuario.getValueAt(clicTabla,4);
        String direccion = ""+tablaUsuario.getValueAt(clicTabla,5);
        String telefono = ""+tablaUsuario.getValueAt(clicTabla,6);
        String zona = ""+tablaUsuario.getValueAt(clicTabla,7);
        String latitud = ""+tablaUsuario.getValueAt(clicTabla,8);
        String longitud = ""+tablaUsuario.getValueAt(clicTabla,9);
        String municipio = ""+tablaUsuario.getValueAt(clicTabla,10);

        int column = tablaUsuario.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/tablaUsuario.getRowHeight();

        if(row < tablaUsuario.getRowCount() && row >=0  && column < tablaUsuario.getColumnCount() && column >=0 ){
            Object value = tablaUsuario.getValueAt(row,column);
            if(value instanceof JButton){
                ((JButton)value).doClick();
                JButton boton = (JButton)value;

                if(boton.getName().equals("m")){

                    txtUsuario1.setText(email);
                    txtUsuario2.setText(password);
                    txtUsuario3.setText(dpi);
                    txtUsuario4.setText(nombre);
                    txtUsuario5.setText(apellido);
                    txtUsuario6.setText(direccion);
                    txtUsuario7.setText(telefono);
                    txtUsuario8.setText(zona);
                    txtUsuario9.setText(latitud);
                    txtUsuario10.setText(longitud);

                }
                if(boton.getName().equals("e")){

                    controlU.eliminar(email);
                    asignarUsuario();
                    modeloTabla.modeloTUsuario(tablaUsuario,listaUsuario);
                }

            }
        }
    }//GEN-LAST:event_tablaUsuarioMouseClicked

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        modificarUsuario();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        crearUsuario();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        modificarListaservicio();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        crearListaservicio();

    }//GEN-LAST:event_jButton6ActionPerformed

    private void tablalservicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalservicioMouseClicked
        // TODO add your handling code here:

        clicTabla = this.tablalservicio.rowAtPoint(evt.getPoint());
        String empresa = ""+tablalservicio.getValueAt(clicTabla,0);
        String servicio = ""+tablalservicio.getValueAt(clicTabla,1);
        String precio = ""+tablalservicio.getValueAt(clicTabla,2);

        int column = tablalservicio.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/tablalservicio.getRowHeight();

        if(row < tablalservicio.getRowCount() && row >=0  && column < tablalservicio.getColumnCount() && column >=0 ){
            Object value = tablalservicio.getValueAt(row,column);
            if(value instanceof JButton){
                ((JButton)value).doClick();
                JButton boton = (JButton)value;

                if(boton.getName().equals("m")){

                    lsempresa = idEmpresa(empresa);
                    lsservicio = idServicio(servicio);

                    txtlsprecio.setText(precio);
                }
                if(boton.getName().equals("e")){
                    System.out.println(idEmpresa(empresa));
                    System.out.println(idServicio(servicio));
                    controlLS.eliminar(idEmpresa(empresa),idServicio(servicio));
                    asignarLLServicio();
                    modeloTabla.modeloLServicio(tablalservicio,listaLServicio);
                }

            }
        }
    }//GEN-LAST:event_tablalservicioMouseClicked

    private void tablaEmpresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEmpresaMouseClicked

        // TODO add your handling code here:

        clicTabla = this.tablaEmpresa.rowAtPoint(evt.getPoint());
        String codigo = ""+tablaEmpresa.getValueAt(clicTabla,0);
        String nit = ""+tablaEmpresa.getValueAt(clicTabla,1);
        String nombre = ""+tablaEmpresa.getValueAt(clicTabla,2);
        String direccion = ""+tablaEmpresa.getValueAt(clicTabla,3);
        String telefono = ""+tablaEmpresa.getValueAt(clicTabla,4);
        String zona = ""+tablaEmpresa.getValueAt(clicTabla,5);
        String latitud = ""+tablaEmpresa.getValueAt(clicTabla,6);
        String longitud = ""+tablaEmpresa.getValueAt(clicTabla,7);
        String muni = ""+tablaEmpresa.getValueAt(clicTabla,8);
        String email = ""+tablaEmpresa.getValueAt(clicTabla,9);

        int column = tablaEmpresa.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/tablaEmpresa.getRowHeight();

        if(row < tablaEmpresa.getRowCount() && row >=0  && column < tablaEmpresa.getColumnCount() && column >=0 ){
            Object value = tablaEmpresa.getValueAt(row,column);
            if(value instanceof JButton){
                ((JButton)value).doClick();
                JButton boton = (JButton)value;

                if(boton.getName().equals("m")){

                    txtempresa1.setText(codigo);
                    txtempresa2.setText(nit);
                    txtempresa3.setText(nombre);
                    txtempresa4.setText(direccion);
                    txtempresa5.setText(telefono);
                    txtempresa6.setText(zona);
                    txtempresa7.setText(latitud);
                    txtempresa8.setText(longitud);
                    txtempresa9.setText(email);

                }
                if(boton.getName().equals("e")){

                    controlE.eliminar(Integer.parseInt(codigo));
                    asignarLEmpresa();
                    modeloTabla.modeloTEmpresa(tablaEmpresa,listaEmpresa);
                }

            }
        }

    }//GEN-LAST:event_tablaEmpresaMouseClicked

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed

        municipio m =(municipio) cbxempresa.getSelectedItem();
        int nit = Integer.parseInt(txtempresa2.getText());
        String nom = txtempresa3.getText();
        String dir = txtempresa4.getText();
        String tel = txtempresa5.getText();
        int zon = Integer.parseInt(txtempresa6.getText());
        double lat = Double.parseDouble(txtempresa7.getText());
        double lon = Double.parseDouble(txtempresa8.getText());
        String email = txtempresa9.getText();

        controlE.registrar(nit, nom, dir, tel, zon, lat, lon,m.getId(), email,Integer.toString(nit));
        asignarLEmpresa();
        modeloTabla.modeloTEmpresa(tablaEmpresa,listaEmpresa);

        txtempresa1.setText("");
        txtempresa2.setText("");
        txtempresa3.setText("");
        txtempresa4.setText("");
        txtempresa5.setText("");
        txtempresa6.setText("");
        txtempresa7.setText("");
        txtempresa8.setText("");
        txtempresa9.setText("");

    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        municipio m =(municipio) cbxempresa.getSelectedItem();
        int nit = Integer.parseInt(txtempresa2.getText());
        String nom = txtempresa3.getText();
        String dir = txtempresa4.getText();
        String tel = txtempresa5.getText();
        int zon = Integer.parseInt(txtempresa6.getText());
        double lat = Double.parseDouble(txtempresa7.getText());
        double lon = Double.parseDouble(txtempresa8.getText());
        String email = txtempresa9.getText();

        //controlE.registrar(nit, nom, dir, tel, zon, lat, lon,m.getId(), email,Integer.toString(nit));
        controlE.actualizar(Integer.parseInt(txtempresa1.getText()), nit, nom, dir, tel, zon, lat, lon,m.getId(), email,Integer.toString(nit));
        asignarLEmpresa();
        modeloTabla.modeloTEmpresa(tablaEmpresa,listaEmpresa);
        txtempresa1.setText("");
        txtempresa2.setText("");
        txtempresa3.setText("");
        txtempresa4.setText("");
        txtempresa5.setText("");
        txtempresa6.setText("");
        txtempresa7.setText("");
        txtempresa8.setText("");
        txtempresa9.setText("");

    }//GEN-LAST:event_jButton9ActionPerformed

    private void tablaCategoriaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaCategoriaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaCategoriaKeyPressed

    private void tablaCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCategoriaMouseClicked
        // TODO add your handling code here:

        clicTabla = this.tablaCategoria.rowAtPoint(evt.getPoint());
        String codigo = ""+tablaCategoria.getValueAt(clicTabla,0);
        String nombre = ""+tablaCategoria.getValueAt(clicTabla,1);

        int column = tablaCategoria.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/tablaCategoria.getRowHeight();

        if(row < tablaCategoria.getRowCount() && row >=0  && column < tablaCategoria.getColumnCount() && column >=0 ){
            Object value = tablaCategoria.getValueAt(row,column);
            if(value instanceof JButton){
                ((JButton)value).doClick();
                JButton boton = (JButton)value;

                if(boton.getName().equals("m")){

                    txtcategoria2.setText(codigo);
                    txtcategoria1.setText(nombre);

                }
                if(boton.getName().equals("e")){

                    controlC.eliminar(Integer.parseInt(codigo));
                    asignarLCategoria();
                    modeloTabla.modeloTCategoria(tablaCategoria,listaCategoria);
                }

            }
        }

    }//GEN-LAST:event_tablaCategoriaMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        controlC.actualizar(Integer.parseInt(txtcategoria2.getText()),txtcategoria1.getText());
        asignarLCategoria();
        modeloTabla.modeloTCategoria(tablaCategoria,listaCategoria);
        txtcategoria2.setText("");
        txtcategoria1.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        controlC.registrar(txtcategoria1.getText());
        asignarLCategoria();
        modeloTabla.modeloTCategoria(tablaCategoria,listaCategoria);
        txtcategoria1.setText("");

    }//GEN-LAST:event_jButton5ActionPerformed

    private void tablaServicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaServicioMouseClicked

        clicTabla = this.tablaServicio.rowAtPoint(evt.getPoint());
        String codigo = ""+tablaServicio.getValueAt(clicTabla,0);
        String nombre = ""+tablaServicio.getValueAt(clicTabla,1);
        String categoria = ""+tablaServicio.getValueAt(clicTabla,2);

        int column = tablaServicio.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/tablaServicio.getRowHeight();

        if(row < tablaServicio.getRowCount() && row >=0  && column < tablaServicio.getColumnCount() && column >=0 ){
            Object value = tablaServicio.getValueAt(row,column);
            if(value instanceof JButton){
                ((JButton)value).doClick();
                JButton boton = (JButton)value;

                if(boton.getName().equals("m")){

                    txtservicio2.setText(codigo);
                    txtservicio3.setText(nombre);
                    txtservicio4.setText(categoria);

                }
                if(boton.getName().equals("e")){

                    controlS.eliminar(Integer.parseInt(codigo));
                    asignarLServicio();
                    modeloTabla.modeloTServicio(tablaServicio,listaServicio);
                }

            }
        }
    }//GEN-LAST:event_tablaServicioMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        int id = Integer.parseInt(txtservicio2.getText());
        String nombre = txtservicio3.getText();
        categoria c =(categoria) cbxCategoria1.getSelectedItem();

        System.err.println(id+nombre+c.getId());
        controlS.Actulizar(id, nombre,c.getId());
        asignarLServicio();
        modeloTabla.modeloTServicio(tablaServicio,listaServicio);

        txtservicio2.setText("");
        txtservicio3.setText("");
        txtservicio4.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        categoria c =(categoria)cbxCategoria.getSelectedItem();
        String nombre = txtservicio1.getText();

        controlS.registrar(nombre,c.getId());
        asignarLServicio();
        modeloTabla.modeloTServicio(tablaServicio,listaServicio);
        txtservicio1.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tabla1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla1MouseClicked

        clicTabla = this.tabla1.rowAtPoint(evt.getPoint());

        String codigo = ""+tabla1.getValueAt(clicTabla,0);
        String nombre = ""+tabla1.getValueAt(clicTabla,1);

        int column = tabla1.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/tabla1.getRowHeight();

        if(row < tabla1.getRowCount() && row >=0  && column < tabla1.getColumnCount() && column >=0 ){

            Object value = tabla1.getValueAt(row,column);

            if(value instanceof JButton){
                ((JButton)value).doClick();
                JButton boton = (JButton)value;

                if(boton.getName().equals("m")){

                    txtmuni1.setText(codigo);
                    txtmuni2.setText(nombre);

                }
                if(boton.getName().equals("e")){

                    controlM.eliminar(Integer.parseInt(codigo));
                    asignarLMunicipio();
                    modeloTabla.modeloTMunicipio(tabla1,listaMunicipio);
                }

            }

        }
    }//GEN-LAST:event_tabla1MouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        controlM.registrar(txtmuni2.getText());
        asignarLMunicipio();
        modeloTabla.modeloTMunicipio(tabla1,listaMunicipio);
        txtmuni2.setText("");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        controlM.actualizar(Integer.parseInt(txtmuni1.getText()),txtmuni2.getText());
        asignarLMunicipio();
        modeloTabla.modeloTMunicipio(tabla1,listaMunicipio);

        txtmuni1.setText("");
        txtmuni2.setText("");

    }//GEN-LAST:event_jButton2ActionPerformed

    //********************* CREAR FOTO 
    
    public void crearFoto(){
        
        trabajador t = (trabajador) cbxFoto1.getSelectedItem();
        String ruta = txtfoto2.getText();
        
        controlF.registrar(ruta,t.getIdEmpleado());
        asignarFoto();
        modeloTabla.modeloTFoto(tablaFoto,listaFoto);
        
        txtfoto2.setText("");
    }
    
    //******************** MODIFICAR FOTO 
    
    public void moficarFoto(){
        
        trabajador t = (trabajador) cbxFoto1.getSelectedItem();
        int id = Integer.parseInt(txtfoto1.getText());
        String ruta = txtfoto2.getText();
        
        controlF.actualizar(id,ruta,t.getIdEmpleado());
        asignarFoto();
        
        modeloTabla.modeloTFoto(tablaFoto, listaFoto); 
        
        txtfoto1.setText("");
        txtfoto2.setText("");
        
        
    }
    
    
    private void tablaFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaFotoMouseClicked
        // TODO add your handling code here:
        
        
        clicTabla = this.tablaFoto.rowAtPoint(evt.getPoint());

        String codigo = ""+tablaFoto.getValueAt(clicTabla,0);
        String ruta = ""+tablaFoto.getValueAt(clicTabla,1);

        int column = tablaFoto.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/tablaFoto.getRowHeight();

        if(row < tablaFoto.getRowCount() && row >=0  && column < tablaFoto.getColumnCount() && column >=0 ){

            Object value = tablaFoto.getValueAt(row,column);

            if(value instanceof JButton){
                ((JButton)value).doClick();
                JButton boton = (JButton)value;

                if(boton.getName().equals("m")){

                    txtfoto1.setText(codigo);
                    txtfoto2.setText(ruta);

                }
                if(boton.getName().equals("e")){

                    controlF.eliminar(Integer.parseInt(codigo));
                    asignarFoto();
                    modeloTabla.modeloTFoto(tablaFoto,listaFoto);
                }

            }

        }
        
        
    }//GEN-LAST:event_tablaFotoMouseClicked

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        crearFoto();
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
        moficarFoto();
    }//GEN-LAST:event_jButton18ActionPerformed

    
    //*************** METODO CREACION USUARIO 
    
    public void crearUsuario(){
        
     municipio m =(municipio) cbxUsuario.getSelectedItem();
     
     String email = txtUsuario1.getText();
     String password = txtUsuario2.getText();
     String dpi = txtUsuario3.getText();
     String nombre = txtUsuario4.getText();
     String apellido = txtUsuario5.getText();
     String direccion = txtUsuario6.getText();
     String telefono = txtUsuario7.getText();
     int zona = Integer.parseInt(txtUsuario8.getText());
     double latitud = Double.parseDouble(txtUsuario9.getText());
     double longitud = Double.parseDouble(txtUsuario10.getText());
     
     boolean exist = controlU.verificarInsercion(email);
    
     controlU.registrar(email, password, dpi, nombre, apellido, direccion, telefono, zona, latitud, longitud,m.getId());
     asignarUsuario();
     modeloTabla.modeloTUsuario(tablaUsuario,listaUsuario);
    
     txtUsuario1.setText("");
     txtUsuario2.setText("");
     txtUsuario3.setText("");
     txtUsuario4.setText("");
     txtUsuario5.setText("");
     txtUsuario6.setText("");
     txtUsuario7.setText("");
     txtUsuario8.setText("");
     txtUsuario9.setText("");
     txtUsuario10.setText("");
        
    }
    
    //***************** MODIFICAR USUARIO 
    
    public void modificarUsuario (){
        
     municipio m =(municipio) cbxUsuario.getSelectedItem();
     
     String email = txtUsuario1.getText();
     String password = txtUsuario2.getText();
     String dpi = txtUsuario3.getText();
     String nombre = txtUsuario4.getText();
     String apellido = txtUsuario5.getText();
     String direccion = txtUsuario6.getText();
     String telefono = txtUsuario7.getText();
     int zona = Integer.parseInt(txtUsuario8.getText());
     double latitud = Double.parseDouble(txtUsuario9.getText());
     double longitud = Double.parseDouble(txtUsuario10.getText());
     
     boolean exist = controlU.verificarInsercion(email);
    
     controlU.actualizar(email, password, dpi, nombre, apellido, direccion, telefono, zona, latitud, longitud,m.getId());
     asignarUsuario();
     modeloTabla.modeloTUsuario(tablaUsuario,listaUsuario);
    
     txtUsuario1.setText("");
     txtUsuario2.setText("");
     txtUsuario3.setText("");
     txtUsuario4.setText("");
     txtUsuario5.setText("");
     txtUsuario6.setText("");
     txtUsuario7.setText("");
     txtUsuario8.setText("");
     txtUsuario9.setText("");
     txtUsuario10.setText("");
    }
    
    
    
    //************* CREAR LISTA SERVICIO 
    public void crearListaservicio(){
       
        servicio s = (servicio) cbxlservicio.getSelectedItem();
        empresa e = (empresa) cbxlempresa.getSelectedItem();
        int precio = Integer.parseInt(txtlsprecio.getText());
        
        controlLS.registrar(e.getId(),s.getId(), precio);
        txtlsprecio.setText("");
        asignarLLServicio();
        modeloTabla.modeloLServicio(tablalservicio,listaLServicio);
        
    }
    
    //*********** MODIFICAR LISTA SERVICIO 
    
    public void modificarListaservicio(){
        int precio = Integer.parseInt(txtlsprecio.getText());
        controlLS.actualizar(lsempresa, lsservicio, precio);
        asignarLLServicio();
        modeloTabla.modeloLServicio(tablalservicio, listaLServicio);
        txtlsprecio.setText("");
        lsempresa = 0;
        lsservicio = 0;
        
    }
    
    //********** retornar id empresa 
    
    public int idEmpresa(String nombre){
        
        List<empresa> list = listaEmpresa;
        
        for(empresa item: list){
            if(item.getNombre().equals(nombre)){
                return item.getId();
            }
        }
        return 0;
    }
    
    //********* retornar id servicio
    
    public int idServicio(String nombre){
        List<servicio> list = listaServicio;
        for(servicio item:list){
            if(item.getNombre().equals(nombre)){
                return item.getId();
            }
        }
        return 0;
    }
    
    int lsempresa = 0;
    int lsservicio = 0;
    
    //************* CREAR EMPLEADO 
    
    public void crearEmpleado(){
       
        empresa e = (empresa) cbxempleado1.getSelectedItem();
        usuario s = (usuario) cbxempleado2.getSelectedItem();
        
        controlEmp.registrar(e.getId(),s.getEmail());
        
        asignarEmpleado();
        modeloTabla.modeloTTrabajador(tablaEmpleado,listaTabajador);
        
    }
    
    //************ MODIFICAR EMPLEADO
    
    public void modificarEmpleado(){
        
        empresa e = (empresa) cbxempleado1.getSelectedItem();
        usuario s =  (usuario) cbxempleado2.getSelectedItem();
        int id = Integer.parseInt(txtempleado1.getText());
        int empresa = e.getId();
        String correo = s.getEmail();
        
        controlEmp.actualizar(id,empresa,correo);
        asignarEmpleado();
        modeloTabla.modeloTTrabajador(tablaEmpleado, listaTabajador);
        txtempleado1.setText("");

        
    }
       
    
    
    //***************** CREAR PAGO 
    
    public void crearPago(){
        
        String forma = txtpago2.getText();
        controlP.registrar(forma);
        asignarPago();
        modeloTabla.modeloTPago(tablaPago, listaPago);
        
        
        txtpago2.setText("");

    }
        
    //**************** MOFICAR PAGO
    
    public void modificarPago(){
        int id = Integer.parseInt(txtpago1.getText());
        String forma =  txtpago2.getText();
        controlP.actualizar(id, forma);
        asignarPago();
        modeloTabla.modeloTPago(tablaPago, listaPago);
        
        txtpago1.setText("");
        txtpago2.setText("");
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(panelPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(panelPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(panelPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(panelPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new panelPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxCategoria;
    private javax.swing.JComboBox<String> cbxCategoria1;
    private javax.swing.JComboBox<String> cbxFoto1;
    private javax.swing.JComboBox<String> cbxUsuario;
    private javax.swing.JComboBox<String> cbxempleado1;
    private javax.swing.JComboBox<String> cbxempleado2;
    private javax.swing.JComboBox<String> cbxempresa;
    private javax.swing.JComboBox<String> cbxlempresa;
    private javax.swing.JComboBox<String> cbxlservicio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTabbedPane menuP;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JPanel panel3;
    private javax.swing.JPanel panel4;
    private javax.swing.JPanel panel5;
    private javax.swing.JPanel panel6;
    private javax.swing.JPanel panel7;
    private javax.swing.JPanel panel8;
    private javax.swing.JPanel panel9;
    private javax.swing.JTable tabla1;
    private javax.swing.JTable tablaCategoria;
    private javax.swing.JTable tablaEmpleado;
    private javax.swing.JTable tablaEmpresa;
    private javax.swing.JTable tablaFoto;
    private javax.swing.JTable tablaPago;
    private javax.swing.JTable tablaServicio;
    private javax.swing.JTable tablaUsuario;
    private javax.swing.JTable tablalservicio;
    private javax.swing.JTextField txtUsuario1;
    private javax.swing.JTextField txtUsuario10;
    private javax.swing.JTextField txtUsuario2;
    private javax.swing.JTextField txtUsuario3;
    private javax.swing.JTextField txtUsuario4;
    private javax.swing.JTextField txtUsuario5;
    private javax.swing.JTextField txtUsuario6;
    private javax.swing.JTextField txtUsuario7;
    private javax.swing.JTextField txtUsuario8;
    private javax.swing.JTextField txtUsuario9;
    private javax.swing.JTextField txtcategoria1;
    private javax.swing.JTextField txtcategoria2;
    private javax.swing.JTextField txtempleado1;
    private javax.swing.JTextField txtempresa1;
    private javax.swing.JTextField txtempresa2;
    private javax.swing.JTextField txtempresa3;
    private javax.swing.JTextField txtempresa4;
    private javax.swing.JTextField txtempresa5;
    private javax.swing.JTextField txtempresa6;
    private javax.swing.JTextField txtempresa7;
    private javax.swing.JTextField txtempresa8;
    private javax.swing.JTextField txtempresa9;
    private javax.swing.JTextField txtfoto1;
    private javax.swing.JTextField txtfoto2;
    private javax.swing.JTextField txtlsprecio;
    private javax.swing.JTextField txtmuni1;
    private javax.swing.JTextField txtmuni2;
    private javax.swing.JTextField txtpago1;
    private javax.swing.JTextField txtpago2;
    private javax.swing.JTextField txtservicio1;
    private javax.swing.JTextField txtservicio2;
    private javax.swing.JTextField txtservicio3;
    private javax.swing.JTextField txtservicio4;
    // End of variables declaration//GEN-END:variables
}
