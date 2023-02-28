package com.mycompany.concesionaria.igu;

import com.mycompany.concesionaria.logica.Automovil;
import com.mycompany.concesionaria.logica.ControladoraLogica;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VerDatos extends javax.swing.JFrame {

    ControladoraLogica controlLogica = new ControladoraLogica();
    
    public VerDatos() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAutos = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setText("VISTA DE DATOS");

        tablaAutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaAutos);

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon("D:\\PoloTic\\FullStack con Java\\Concesionaria\\pngwing.com (5).png")); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon("D:\\PoloTic\\FullStack con Java\\Concesionaria\\pngwing.com (1).png")); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(210, 210, 210))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(btnModificar)
                .addGap(107, 107, 107)
                .addComponent(btnEliminar)
                .addGap(0, 164, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        cargarTabla();
        
    }//GEN-LAST:event_formWindowOpened

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        //control de que la tabla no este vacia
        if(tablaAutos.getRowCount() > 0){
            //validar que se haya seleccionado un registro
            if(tablaAutos.getSelectedRow() != -1){
                //Obtener la id del auto a borrar
                //traigo el id que esta en tipo objeto, lo convierto a strig y luego a entero
                int idAuto = Integer.parseInt(String.valueOf(tablaAutos.getValueAt(tablaAutos.getSelectedRow(), 0)));
                
                //mensaje de confirmacion para el borrado
                int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea borrar el auto seleccionado?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    
                    //Llamo a la controladora de la logica
                    controlLogica.borrarAuto(idAuto);
                    
                    mostrarMensaje("Borrado con exito", "Info", "Borrado Exitoso");
                    
                    //lamamos al cargar tabla para refrescar la tabla
                    cargarTabla();
                    
                }
            
            }else{
                mostrarMensaje("No selecciono un registro para eliminar", "Error", "Error al eliminar");
            }

        }else{
            mostrarMensaje("La tabla se encuntra vacia", "Error", "Error al eliminar");
        }
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if(tablaAutos.getRowCount() > 0){
            //validar que se haya seleccionado un registro
            if(tablaAutos.getSelectedRow() != -1){
                //Obtener la id del auto a modificar
                //traigo el id que esta en tipo objeto, lo convierto a strig y luego a entero
                int idAuto = Integer.parseInt(String.valueOf(tablaAutos.getValueAt(tablaAutos.getSelectedRow(), 0)));
                
                ModificarAuto modificarAuto = new ModificarAuto(idAuto);//le paso a la IGU de modificar el id del auto a modificar
                modificarAuto.setVisible(true);
                modificarAuto.setLocationRelativeTo(null);
                
                this.dispose();
                
        }else{
                mostrarMensaje("No selecciono un registro para modificar", "Error", "Error al modificar");
            }

        }else{
            mostrarMensaje("La tabla se encuntra vacia", "Error", "Error al modificar");
        }    
    }//GEN-LAST:event_btnModificarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaAutos;
    // End of variables declaration//GEN-END:variables

    
    public void mostrarMensaje(String mensaje, String tipo, String titulo){
         
        JOptionPane optionPane = new JOptionPane(mensaje);
        if(tipo.equals("Info")){
            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        }else if(tipo.equals("Error")){
            optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
        }
        
        JDialog dialog = optionPane.createDialog(titulo);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    }
    
    
    private void cargarTabla() {
        
        //crea el modelo de la tabla y dice a la tabla que no va aser editable
        DefaultTableModel modeloTabla  = new DefaultTableModel(){
            
            @Override
            public boolean isCellEditable(int row, int colum){
                return false;
            }
        };
        
        //ponemos titulo a las columnas
        String titulos[] = {"Id", "Modelo", "Marca", "Motor", "Color", "Patente", "Puertas"};
        modeloTabla.setColumnIdentifiers(titulos);
        
        //traer los autos desde la base de datos
        List<Automovil> listaAuto = controlLogica.traerAutos();
        
        //Setear los datos en la tabla
        if(listaAuto != null){
            for(Automovil auto : listaAuto){
                //tiene que estar en el mismo orden que las columnas
                Object[] object = {auto.getId(), auto.getModelo(), auto.getMarca(), auto.getMotor(), auto.getColor(),
                                    auto.getPatente(), auto.getCantPuertas()}; 
                
                //el objeto que cree arriba lo agrego como fila a la tabla
                modeloTabla.addRow(object);
            }
        }
        
        //Asignamos el modelo a la tabla 
        tablaAutos.setModel(modeloTabla);
        
        
    }
}
