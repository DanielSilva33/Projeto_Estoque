/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.ClienteDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import negocio.Cliente;

/**
 *
 * @author Default
 */
public class Consultar_Clientes extends javax.swing.JFrame {

    /**
     * Creates new form Consultar_Clientes
     */
    List<Cliente> listCliente = new ArrayList<Cliente>();

    public Consultar_Clientes() {
        initComponents();
        loadClientes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void loadClientes() {
        ClienteDAO clienteBd = new ClienteDAO();
        listCliente = clienteBd.getListarClientes();
        Object[] row = new Object[8]; // linha com 8 colunas;
        DefaultTableModel tabela = (DefaultTableModel) GridClient.getModel();
        tabela.setRowCount(0); //limpar os itens do grid

        //criando a ordem para ir para a tabela;
        for (Cliente item : listCliente) {
            row[0] = item.getNome();
            row[1] = item.getEndereco();
            row[2] = item.getNumero();
            row[3] = item.getBairro();
            row[4] = item.getCpf();
            row[5] = item.getTelefone();
            row[6] = item.getCelular();
            row[7] = item.getCep();
            tabela.addRow(row);
        }

    }

    public void pesquisaProduto(String nome) {
        Cliente objCliente = new Cliente();
        ClienteDAO clienteBd = new ClienteDAO();
        listCliente = clienteBd.pesquisaCliente(nome);
        Object[] row = new Object[8]; // linha com 4 colunas;
        DefaultTableModel tabela = (DefaultTableModel) GridClient.getModel();
        tabela.setRowCount(0); //limpar os itens do grid

        //criando a ordem para ir para a tabela;
        for (Cliente item : listCliente) {
            row[0] = item.getNome();
            row[1] = item.getEndereco();
            row[2] = item.getNumero();
            row[3] = item.getBairro();
            row[4] = item.getCpf();
            row[5] = item.getTelefone();
            row[6] = item.getCelular();
            row[7] = item.getCep();
            tabela.addRow(row);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        GridClient = new javax.swing.JTable();
        txtPesquisar = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(817, 492));
        getContentPane().setLayout(null);

        GridClient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Endereço", "Numero", "Bairro", "CPF/CNPJ", "Telefone", "Celular", "CEP"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(GridClient);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 40, 790, 370);

        txtPesquisar.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        getContentPane().add(txtPesquisar);
        txtPesquisar.setBounds(10, 7, 376, 27);

        jButton2.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(412, 9, 131, 23);

        jButton1.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(693, 413, 100, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/FUNDOLOGIN.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(4, 3, 800, 450);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Controle().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (txtPesquisar.getText().isEmpty()) {
            loadClientes();
            return;
        }
        pesquisaProduto(txtPesquisar.getText());

    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Consultar_Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consultar_Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consultar_Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consultar_Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Consultar_Clientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable GridClient;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtPesquisar;
    // End of variables declaration//GEN-END:variables
}
