/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Forms;

import DAO.Conexao;
import DAO.FeriasDAO;
import Entidades.AptoFerias;
import Entidades.Atestados;
import Entidades.Ferias;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Airton Robson
 */
public class FeriasForm extends javax.swing.JFrame {
    Conexao con = new Conexao();
    
    /**
     * Creates new form FeriasForm
     */
    List<AptoFerias> minhaList = new ArrayList<AptoFerias>();
    public FeriasForm() throws ParseException, IOException {
        initComponents();
        preencherTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tf_pesq = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_func_fer = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        tf_pesq.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tf_pesq.setToolTipText("");
        tf_pesq.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_pesqKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_pesqKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("Nome:");

        tb_func_fer.setModel(new javax.swing.table.DefaultTableModel(
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
        tb_func_fer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tb_func_ferKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tb_func_fer);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButton1.setText("Conceder Férias");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });

        jButton2.setText("Gerar Relatório");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton2KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(136, 136, 136)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tf_pesq, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tf_pesq, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(707, 509));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tf_pesqKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_pesqKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ESCAPE)  
            dispose();
        else if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE)
            tf_pesq.setText("");
    }//GEN-LAST:event_tf_pesqKeyPressed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ESCAPE)  
            dispose();
    }//GEN-LAST:event_jButton1KeyPressed

    private void tb_func_ferKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_func_ferKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ESCAPE)  
            dispose();
    }//GEN-LAST:event_tb_func_ferKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       AptoFerias apto = new AptoFerias();
        if (tb_func_fer.getSelectedRow() != -1) {
            
          apto = (AptoFerias) minhaList.get(tb_func_fer.getSelectedRow()); 
          
          ConcederFerForm dialog = null;            
           try {
               dialog = new ConcederFerForm(this, true, apto, this);
           } catch (IOException ex) {
               Logger.getLogger(FeriasForm.class.getName()).log(Level.SEVERE, null, ex);
           }
          dialog.setVisible(true);
          dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um registro", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tf_pesqKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_pesqKeyReleased
        // TODO add your handling code here:
        if (tf_pesq.getText().equals("")) {
            try {
                preencherTable();
            } catch (ParseException ex) {
                System.out.println(ex);
            } catch (IOException ex) {
                Logger.getLogger(FeriasForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            List<AptoFerias> filterList = new LinkedList<AptoFerias>();
            for (AptoFerias apto : minhaList) {
                if (apto.getFuncionario().getNome().contains(tf_pesq.getText().toUpperCase())) {
                    filterList.add(apto);
                }
                
                try {
                    minhaList = filterList;
                    preencherTabela(minhaList);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro" + ex);
                }
            }
        }
    }//GEN-LAST:event_tf_pesqKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            // TODO add your handling code here:
            JasperReport jr = (JasperReport) JRLoader.loadObject("src/Reports/FuncFerias.jasper");
            JasperPrint jpPrint = JasperFillManager.fillReport(jr, new HashMap(), con.getConnection());
            JasperViewer jv = new JasperViewer(jpPrint, false);
            jv.setVisible(true);
            jv.toFront();
        } catch (JRException ex) {
            Logger.getLogger(FeriasForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FeriasForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FeriasForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ESCAPE)  
            dispose();
    }//GEN-LAST:event_jButton2KeyPressed

    /**
     * @param args the command line arguments
     */
 
    
    public void preencherTable() throws ParseException, IOException{
         try {
            FeriasDAO dao = new FeriasDAO();
            dao.encerrarFerias();
            minhaList = dao.List();
            MyTableModel mtb = new MyTableModel(AptoFerias.class, minhaList, tb_func_fer);
            tb_func_fer.setModel(mtb);
            tb_func_fer.getColumnModel().getColumn(0).setPreferredWidth(300);
            tb_func_fer.getColumnModel().getColumn(1).setPreferredWidth(150);
            tb_func_fer.getColumnModel().getColumn(2).setPreferredWidth(80);
            tb_func_fer.getColumnModel().getColumn(3).setPreferredWidth(80);
        } catch (SQLException ex) {
            Logger.getLogger(AptoFerias.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    public void preencherTabela(List<AptoFerias> lista) throws ParseException {
        try {
            MyTableModel mtb = new MyTableModel(AptoFerias.class, lista, tb_func_fer);
            tb_func_fer.setModel(mtb);
            tb_func_fer.getColumnModel().getColumn(0).setPreferredWidth(300);
            tb_func_fer.getColumnModel().getColumn(1).setPreferredWidth(150);
            tb_func_fer.getColumnModel().getColumn(2).setPreferredWidth(80);
            tb_func_fer.getColumnModel().getColumn(3).setPreferredWidth(80);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro" + ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_func_fer;
    private javax.swing.JTextField tf_pesq;
    // End of variables declaration//GEN-END:variables
}