package Vistas;

import Vistas.Paneles.jPanelFacturacion;
import Vistas.Paneles.jPanelHistorial;
import Vistas.Paneles.jpanelCategoria;
import Vistas.Paneles.jpanelClientes;

import Vistas.Paneles.jpanelInicio;
import Vistas.Paneles.jpanelProductos;
import Vistas.Paneles.jpanelUsuarios;
import java.awt.BorderLayout;

import java.awt.Color;
import javax.swing.JPanel;

import Controladores.ctrlUsuarios;


import Formatos.seguridad_InactividadManager;
import Vistas.Login;


import javax.swing.JOptionPane;

// Instancia de la ventana de agregar usuario (JDialog)
//frm_AgregarUsuario ventanaAgregar = new frm_AgregarUsuario(this);

// Abrirla de forma única y bloqueante
//ctrl_Tabla.abrirVentanaModal(this, ventanaAgregar);


public class Menu_Gerente extends javax.swing.JFrame {
    
    public Menu_Gerente() {
        initComponents();

        this.setLocationRelativeTo(null);

        //Abrir el panel del inicio
        jpanelInicio inicio = new jpanelInicio();
        abrirPanel(inicio); //Funcion para abrir los paneles

        ctrlUsuarios control = new ctrlUsuarios();
        lblnombreUsuario.setText(control.IdentificadorNombre());
        
        new seguridad_InactividadManager(this, 300000, () -> { //Se va cerrar en 5min de manera automatica cuando no exista activadad eso se pone en milisegundos
            System.out.println("Cerrando sesión por inactividad...");
            dispose();  
            new Login().setVisible(true);  
        });

    }
    


private void cerrarSesion() {
    
    System.out.println("Sesion cerrada por inactividad");
        dispose();
        new Login().setVisible(true);
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu = new javax.swing.JPanel();
        btnInicio = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnUsuario = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnCategorias = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnProducto = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnCliente = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        btnHistorial = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        btnConf = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        Contenido = new javax.swing.JPanel();
        Encabezado = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lblnombreUsuario = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PuntoVenta");
        setExtendedState(6);

        Menu.setBackground(new java.awt.Color(0, 0, 0));

        btnInicio.setBackground(new java.awt.Color(69, 93, 105));
        btnInicio.setPreferredSize(new java.awt.Dimension(151, 82));
        btnInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInicioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInicioMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnInicioMousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Inicio");

        javax.swing.GroupLayout btnInicioLayout = new javax.swing.GroupLayout(btnInicio);
        btnInicio.setLayout(btnInicioLayout);
        btnInicioLayout.setHorizontalGroup(
            btnInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnInicioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(49, 49, 49))
        );
        btnInicioLayout.setVerticalGroup(
            btnInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnInicioLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        btnUsuario.setBackground(new java.awt.Color(33, 44, 50));
        btnUsuario.setPreferredSize(new java.awt.Dimension(151, 82));
        btnUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUsuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUsuarioMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnUsuarioMousePressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Usuarios");

        javax.swing.GroupLayout btnUsuarioLayout = new javax.swing.GroupLayout(btnUsuario);
        btnUsuario.setLayout(btnUsuarioLayout);
        btnUsuarioLayout.setHorizontalGroup(
            btnUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnUsuarioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(34, 34, 34))
        );
        btnUsuarioLayout.setVerticalGroup(
            btnUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnUsuarioLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        btnCategorias.setBackground(new java.awt.Color(33, 44, 50));
        btnCategorias.setPreferredSize(new java.awt.Dimension(151, 82));
        btnCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCategoriasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCategoriasMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCategoriasMousePressed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Categorias");

        javax.swing.GroupLayout btnCategoriasLayout = new javax.swing.GroupLayout(btnCategorias);
        btnCategorias.setLayout(btnCategoriasLayout);
        btnCategoriasLayout.setHorizontalGroup(
            btnCategoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnCategoriasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(19, 19, 19))
        );
        btnCategoriasLayout.setVerticalGroup(
            btnCategoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnCategoriasLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(27, 27, 27))
        );

        btnProducto.setBackground(new java.awt.Color(33, 44, 50));
        btnProducto.setPreferredSize(new java.awt.Dimension(151, 82));
        btnProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnProductoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnProductoMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnProductoMousePressed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Productos");

        javax.swing.GroupLayout btnProductoLayout = new javax.swing.GroupLayout(btnProducto);
        btnProducto.setLayout(btnProductoLayout);
        btnProductoLayout.setHorizontalGroup(
            btnProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnProductoLayout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(27, 27, 27))
        );
        btnProductoLayout.setVerticalGroup(
            btnProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnProductoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel4)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        btnCliente.setBackground(new java.awt.Color(33, 44, 50));
        btnCliente.setPreferredSize(new java.awt.Dimension(151, 82));
        btnCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnClienteMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnClienteMousePressed(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Clientes");

        javax.swing.GroupLayout btnClienteLayout = new javax.swing.GroupLayout(btnCliente);
        btnCliente.setLayout(btnClienteLayout);
        btnClienteLayout.setHorizontalGroup(
            btnClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnClienteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(39, 39, 39))
        );
        btnClienteLayout.setVerticalGroup(
            btnClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnClienteLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel10)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        btnHistorial.setBackground(new java.awt.Color(33, 44, 50));
        btnHistorial.setPreferredSize(new java.awt.Dimension(151, 82));
        btnHistorial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHistorialMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHistorialMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnHistorialMousePressed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Historial");

        javax.swing.GroupLayout btnHistorialLayout = new javax.swing.GroupLayout(btnHistorial);
        btnHistorial.setLayout(btnHistorialLayout);
        btnHistorialLayout.setHorizontalGroup(
            btnHistorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnHistorialLayout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(42, 42, 42))
        );
        btnHistorialLayout.setVerticalGroup(
            btnHistorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnHistorialLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel11)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        btnConf.setBackground(new java.awt.Color(33, 44, 50));
        btnConf.setPreferredSize(new java.awt.Dimension(151, 82));
        btnConf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnConfMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnConfMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnConfMousePressed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Facturar");

        javax.swing.GroupLayout btnConfLayout = new javax.swing.GroupLayout(btnConf);
        btnConf.setLayout(btnConfLayout);
        btnConfLayout.setHorizontalGroup(
            btnConfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnConfLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(41, 41, 41))
        );
        btnConfLayout.setVerticalGroup(
            btnConfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnConfLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel5)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnHistorial, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
            .addComponent(btnCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
            .addComponent(btnInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
            .addComponent(btnCategorias, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
            .addComponent(btnProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
            .addComponent(btnUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
            .addComponent(btnConf, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConf, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Contenido.setBackground(new java.awt.Color(255, 255, 255));
        Contenido.setLayout(new java.awt.BorderLayout());

        Encabezado.setBackground(new java.awt.Color(51, 136, 191));

        jPanel3.setBackground(new java.awt.Color(48, 122, 169));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu.png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel9MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel9)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblnombreUsuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblnombreUsuario.setText("Nombre Usuario");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar-sesion.png"))); // NOI18N
        jLabel7.setText("Cerrar Sesión");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel7MousePressed(evt);
            }
        });

        javax.swing.GroupLayout EncabezadoLayout = new javax.swing.GroupLayout(Encabezado);
        Encabezado.setLayout(EncabezadoLayout);
        EncabezadoLayout.setHorizontalGroup(
            EncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EncabezadoLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblnombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(54, 54, 54))
        );
        EncabezadoLayout.setVerticalGroup(
            EncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(EncabezadoLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(EncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(lblnombreUsuario))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Encabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Contenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Encabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Contenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfMousePressed
        jPanelFacturacion fact = new jPanelFacturacion();
        abrirPanel(fact);
        this.colorpress(btnHistorial, btnCategorias, btnUsuario, btnInicio, btnProducto, btnCliente, btnConf);
    }//GEN-LAST:event_btnConfMousePressed

    private void btnConfMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfMouseExited
        this.resetColorPass(btnHistorial, btnCategorias, btnUsuario, btnInicio, btnProducto, btnCliente, btnConf);
    }//GEN-LAST:event_btnConfMouseExited

    private void btnConfMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfMouseEntered
        insertarColorPass(btnConf);
    }//GEN-LAST:event_btnConfMouseEntered

    private void btnHistorialMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHistorialMousePressed

        this.colorpress(btnCliente, btnCategorias, btnUsuario, btnInicio, btnProducto, btnConf, btnHistorial);
        jPanelHistorial his = new jPanelHistorial();
        abrirPanel(his);
    }//GEN-LAST:event_btnHistorialMousePressed

    private void btnHistorialMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHistorialMouseExited
        this.resetColorPass(btnCliente, btnCategorias, btnUsuario, btnInicio, btnProducto, btnConf, btnHistorial);
    }//GEN-LAST:event_btnHistorialMouseExited

    private void btnHistorialMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHistorialMouseEntered
        insertarColorPass(btnHistorial);
    }//GEN-LAST:event_btnHistorialMouseEntered

    private void btnClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClienteMousePressed
        this.colorpress(btnHistorial, btnCategorias, btnUsuario, btnInicio, btnProducto, btnConf, btnCliente);
        jpanelClientes clien = new jpanelClientes();
        abrirPanel(clien);
    }//GEN-LAST:event_btnClienteMousePressed

    private void btnClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClienteMouseExited
        this.resetColorPass(btnHistorial, btnCategorias, btnUsuario, btnInicio, btnProducto, btnConf, btnCliente);
    }//GEN-LAST:event_btnClienteMouseExited

    private void btnClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClienteMouseEntered
        insertarColorPass(btnCliente);
    }//GEN-LAST:event_btnClienteMouseEntered

    private void btnProductoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductoMousePressed
        this.colorpress(btnHistorial, btnCategorias, btnCliente, btnInicio, btnUsuario, btnConf, btnProducto);
        jpanelProductos prodc = new jpanelProductos();
        abrirPanel(prodc);
    }//GEN-LAST:event_btnProductoMousePressed

    private void btnProductoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductoMouseExited
        this.resetColorPass(btnHistorial, btnCategorias, btnCliente, btnInicio, btnUsuario, btnConf, btnProducto);
    }//GEN-LAST:event_btnProductoMouseExited

    private void btnProductoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductoMouseEntered
        insertarColorPass(btnProducto);
    }//GEN-LAST:event_btnProductoMouseEntered

    private void btnCategoriasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCategoriasMousePressed
        this.colorpress(btnHistorial, btnUsuario, btnCliente, btnInicio, btnProducto, btnConf, btnCategorias);

        jpanelCategoria categoria = new jpanelCategoria();
        abrirPanel(categoria);
    }//GEN-LAST:event_btnCategoriasMousePressed

    private void btnCategoriasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCategoriasMouseExited
        this.resetColorPass(btnHistorial, btnUsuario, btnCliente, btnInicio, btnProducto, btnConf, btnCategorias);
    }//GEN-LAST:event_btnCategoriasMouseExited

    private void btnCategoriasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCategoriasMouseEntered
        insertarColorPass(btnCategorias);
    }//GEN-LAST:event_btnCategoriasMouseEntered

    private void btnUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuarioMousePressed
        this.colorpress(btnHistorial, btnCategorias, btnCliente, btnInicio, btnProducto, btnConf, btnUsuario);

        jpanelUsuarios user = new jpanelUsuarios();
        abrirPanel(user);
    }//GEN-LAST:event_btnUsuarioMousePressed

    /**
     * Al salir el mause el color se pone de manera default OJO el del paramtero
     * 1 al 6 son de los demas botones y el ultimo (7) es para el boton que
     * queremos resetear al default
     */
    private void btnUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuarioMouseExited
        this.resetColorPass(btnHistorial, btnCategorias, btnCliente, btnInicio, btnProducto, btnConf, btnUsuario);
    }//GEN-LAST:event_btnUsuarioMouseExited

//Cambiar de color al pasar el mouse por un btn(panel)    
    private void btnUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuarioMouseEntered
        insertarColorPass(btnUsuario);
    }//GEN-LAST:event_btnUsuarioMouseEntered

    //Asignarle el color de manera permanente cuando se le seleccionar
    //OJO el ultimo parametro es para cambiarle el color al seleccionado y los demas para resetearlo
    private void btnInicioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInicioMousePressed
        this.colorpress(btnHistorial, btnCategorias, btnCliente, btnUsuario, btnProducto, btnConf, btnInicio);

        jpanelInicio inicio = new jpanelInicio();
        abrirPanel(inicio);
    }//GEN-LAST:event_btnInicioMousePressed

    private void btnInicioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInicioMouseExited
        this.resetColorPass(btnHistorial, btnCategorias, btnCliente, btnUsuario, btnProducto, btnConf, btnInicio);
    }//GEN-LAST:event_btnInicioMouseExited

    private void btnInicioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInicioMouseEntered
        insertarColorPass(btnInicio);
    }//GEN-LAST:event_btnInicioMouseEntered

    private void jLabel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MousePressed

        int respuesta = JOptionPane.showConfirmDialog(
                null, // Componente padre (null para centrado en pantalla)
                "¿Deseas Cerrar secion?", // Mensaje
                "Confirmación", // Título de la ventana
                JOptionPane.YES_NO_OPTION // Tipo de opciones
        );

        if (respuesta == JOptionPane.YES_OPTION) {
            cerrarSesion();
        }
    }//GEN-LAST:event_jLabel7MousePressed

    private void jLabel9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MousePressed
        if (Menu.isVisible()) {
            new Thread(() -> {
                Animacion.Animacion.mover_izquierda(0, -264, 2, 2, Menu);
                try {
                    Thread.sleep(300); // duracion de espera para animacion
                } catch (InterruptedException e) {
                }
                Menu.setVisible(false);
            }).start();
        } else {
            Menu.setVisible(true);
            Animacion.Animacion.mover_derecha(-264, 0, 2, 2, Menu);
        }


    }//GEN-LAST:event_jLabel9MousePressed

    public static void main(String args[]) {

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
            java.util.logging.Logger.getLogger(Menu_Gerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Gerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Gerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Gerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Menu_Gerente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Contenido;
    private javax.swing.JPanel Encabezado;
    private javax.swing.JPanel Menu;
    private javax.swing.JPanel btnCategorias;
    private javax.swing.JPanel btnCliente;
    private javax.swing.JPanel btnConf;
    private javax.swing.JPanel btnHistorial;
    private javax.swing.JPanel btnInicio;
    private javax.swing.JPanel btnProducto;
    private javax.swing.JPanel btnUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblnombreUsuario;
    // End of variables declaration//GEN-END:variables

    private Color colorDefault = new Color(33, 44, 50); //Color predeterminado de los botones de menu lateral izquiero (paneles)
    private Color colorSelect = new Color(69, 93, 105); //Color al pasar o seleccionar  el mouse  de los botones de menu lateral izquiero (paneles)

    //Funcion para verificar el color y luego cambiarlo del jpanel (boton)
    private void insertarColorPass(JPanel panel) {
        if (panel.getBackground().equals(colorDefault)) {
            insertarColor(panel);
        }
    }

    private void resetColorPass(JPanel panel1, JPanel panel2, JPanel panel3, JPanel panel4, JPanel panel5, JPanel panel6, JPanel panelR) {
        if (!panel1.getBackground().equals(colorDefault)
                || !panel2.getBackground().equals(colorDefault)
                || !panel3.getBackground().equals(colorDefault)
                || !panel4.getBackground().equals(colorDefault)
                || !panel5.getBackground().equals(colorDefault)
                || !panel6.getBackground().equals(colorDefault)) {

            resetColor(panelR);

        }

    }

    //Funcion para asignarle el color nuevo si se le da click y se le pone el default a los demas
    private void colorpress(JPanel panel1, JPanel panel2, JPanel panel3, JPanel panel4, JPanel panel5, JPanel panel6, JPanel panelselect) {
        this.insertarColor(panelselect);
        this.resetColor(panel6);

        this.resetColor(panel5);
        this.resetColor(panel4);
        this.resetColor(panel3);
        this.resetColor(panel2);
        this.resetColor(panel1);
    }

    //Funcion para cambiar el color del boton (jpanel)
    private void insertarColor(JPanel panel) {
        panel.setBackground(colorSelect);
    }

    private void resetColor(JPanel panel) {
        panel.setBackground(colorDefault);
    }

    //Funcion para abrir los JPaneles
    private void abrirPanel(JPanel panelvista) {

        panelvista.setLocation(0, 0); //Locacion del panel (se pone 0 porque despues lo vamos meter adentro del panel contenido

        Contenido.removeAll(); //Eliminamos todo lo que hay en el panel de contenido
        Contenido.add(panelvista, BorderLayout.CENTER); //añadimos el panel adentro del contenido
        Contenido.revalidate(); //Revalidamos
        Contenido.repaint(); //y refrescamos pantalla
    }
    }
