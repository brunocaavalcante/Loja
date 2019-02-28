package loja1.view;

import com.sun.glass.events.KeyEvent;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Home extends javax.swing.JFrame {

    public Home() {
        initComponents();
        this.dimensionaImg();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu5 = new javax.swing.JMenu();
        try {
            lblImagemHome =(javax.swing.JLabel)java.beans.Beans.instantiate(getClass().getClassLoader(), "loja1/view.Home_lblImagemHome");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        jMenuBar2 = new javax.swing.JMenuBar();
        jmenuCliente = new javax.swing.JMenu();
        jMenuItemCadCliente = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jmenuProduto = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jmenuFuncionario = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jmenuRelatorio = new javax.swing.JMenu();
        jmenuVenda = new javax.swing.JMenu();

        jMenu5.setText("jMenu5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jMenuBar2.setBackground(new java.awt.Color(255, 255, 255));

        jmenuCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));
        jmenuCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Midias/clientes_home.png"))); // NOI18N

        jMenuItemCadCliente.setText("Cadastro/Consulta");
        jMenuItemCadCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadClienteActionPerformed(evt);
            }
        });
        jmenuCliente.add(jMenuItemCadCliente);

        jMenuItem2.setText("Consultar Debitos");
        jmenuCliente.add(jMenuItem2);

        jMenuItem3.setText("Histórico de Compras");
        jmenuCliente.add(jMenuItem3);

        jMenuItem6.setText("Débitos Pendentes");
        jmenuCliente.add(jMenuItem6);

        jMenuItem7.setText("Pontuação");
        jmenuCliente.add(jMenuItem7);

        jMenuItem8.setText("Pedidos");
        jMenuItem8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1)));
        jmenuCliente.add(jMenuItem8);

        jMenuBar2.add(jmenuCliente);

        jmenuProduto.setBorder(javax.swing.BorderFactory.createTitledBorder("Produto"));
        jmenuProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Midias/produto_home_1.png"))); // NOI18N

        jMenuItem4.setText("Cadastrar/Consultar");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jmenuProduto.add(jMenuItem4);

        jMenuItem5.setText("Estoque");
        jmenuProduto.add(jMenuItem5);

        jMenuItem9.setText("Devolução");
        jmenuProduto.add(jMenuItem9);

        jMenuBar2.add(jmenuProduto);

        jmenuFuncionario.setBorder(javax.swing.BorderFactory.createTitledBorder("Funcionario"));
        jmenuFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Midias/funcionarios_home.png"))); // NOI18N

        jMenuItem10.setText("Cadastro/Consulta");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jmenuFuncionario.add(jMenuItem10);

        jMenuItem11.setText("Vendas");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jmenuFuncionario.add(jMenuItem11);

        jMenuBar2.add(jmenuFuncionario);

        jmenuRelatorio.setBorder(javax.swing.BorderFactory.createTitledBorder("Relatórios"));
        jmenuRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Midias/relatorios_home.png"))); // NOI18N
        jmenuRelatorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmenuRelatorioMouseClicked(evt);
            }
        });
        jMenuBar2.add(jmenuRelatorio);

        jmenuVenda.setBorder(javax.swing.BorderFactory.createTitledBorder("Venda"));
        jmenuVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Midias/venda_home.png"))); // NOI18N
        jmenuVenda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jmenuVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmenuVendaMouseClicked(evt);
            }
        });
        jmenuVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuVendaActionPerformed(evt);
            }
        });
        jMenuBar2.add(jmenuVenda);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImagemHome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1040, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImagemHome, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1056, 700));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void dimensionaImg() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        ImageIcon icon = new ImageIcon("src/Midias/Home1.png");
        lblImagemHome.setSize(d.width, d.height);
        icon.setImage(icon.getImage().getScaledInstance(d.width, d.height, Image.SCALE_DEFAULT));
        lblImagemHome.setIcon(icon);
    }

    private void jmenuVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuVendaActionPerformed
        FmrVenda.main(null);


    }//GEN-LAST:event_jmenuVendaActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        FmrProduto.main(null);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jmenuVendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmenuVendaMouseClicked
        // TODO add your handling code here:
        FmrVenda.main(null);
    }//GEN-LAST:event_jmenuVendaMouseClicked

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F5) {
            FmrVenda.main(null);
        }
    }//GEN-LAST:event_formKeyPressed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        FmrFuncionario.main(null);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed

    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItemCadClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadClienteActionPerformed
    FmrCliente.main(null);
    }//GEN-LAST:event_jMenuItemCadClienteActionPerformed

    private void jmenuRelatorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmenuRelatorioMouseClicked
      JReportVendas.main(null);
    }//GEN-LAST:event_jmenuRelatorioMouseClicked

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Numbis".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem jMenuItemCadCliente;
    private javax.swing.JMenu jmenuCliente;
    private javax.swing.JMenu jmenuFuncionario;
    private javax.swing.JMenu jmenuProduto;
    private javax.swing.JMenu jmenuRelatorio;
    private javax.swing.JMenu jmenuVenda;
    private javax.swing.JLabel lblImagemHome;
    // End of variables declaration//GEN-END:variables
}
