package loja1.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import loja1.classes.Pesquisa;
import loja1.classes.Produto;
import loja1.controller.ProdutoController;
import loja1.model.ProdutoDAO;

public class FmrProduto extends javax.swing.JFrame {

    private int id;
    private String tipo;
    private int key;

    public FmrProduto() {
        initComponents();
        this.exibicao();
        key = 0;

        try {
            this.consultar();
        } catch (SQLException ex) {
            Logger.getLogger(FmrProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")

    private void limpar() {
        jtfNome.setText("");
        jtfTipo.setText("");
        jtfCusto.setText("");
        jtfFornecedor.setText("");
        jtfMarca.setText("");
        jtfPreco.setText("");
        jtfTamanho.setText("");
        jtfValidade.setText("");
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtProduto = new javax.swing.JTable();
        jbtCadastrar = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtfTamanho = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtfValidade = new javax.swing.JTextField();
        jtfMarca = new javax.swing.JTextField();
        jtfNome = new javax.swing.JTextField();
        jtfPreco = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfFornecedor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfCusto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jtfCodigoBarras = new javax.swing.JTextField();
        jtfTipo = new javax.swing.JTextField();
        jbtDelete = new javax.swing.JToggleButton();
        jbtNovo = new javax.swing.JToggleButton();
        jbtAlterar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jtProduto.setBackground(new java.awt.Color(159, 235, 182));
        jtProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "cod", "Código Barras", "Nome", "Fornecedor", "Marca", "Preço", "Categoria", "Validade", "Custo", "Tamanho"
            }
        ));
        jtProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtProdutoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtProduto);

        jbtCadastrar.setText("Cadastrar");
        jbtCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCadastrarActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome");

        jLabel6.setText("Validade");

        jLabel7.setText("Custo:");

        jtfMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfMarcaKeyPressed(evt);
            }
        });

        jLabel2.setText("Categoria");

        jLabel3.setText("Marca:");

        jtfFornecedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfFornecedorKeyPressed(evt);
            }
        });

        jLabel4.setText("Preço:");

        jLabel5.setText("Fornecedor:");

        jLabel8.setText("Tamanho:");

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel11.setText("Código de Barras");

        jtfTipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfTipoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel11)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel3))
                                    .addGap(14, 14, 14))
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfMarca)
                            .addComponent(jtfPreco)
                            .addComponent(jtfNome, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                            .addComponent(jtfTipo))
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jtfFornecedor))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtfValidade, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtfCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(29, 29, 29)
                                .addComponent(jtfTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(jtfValidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(jtfCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jtfTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jtfFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(30, 30, 30)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfCodigoBarras, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        jbtDelete.setText("Deletar");
        jbtDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtDeleteActionPerformed(evt);
            }
        });

        jbtNovo.setText("Novo");
        jbtNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtNovoActionPerformed(evt);
            }
        });

        jbtAlterar.setText("Alterar");
        jbtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAlterarActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Microsoft Sans Serif", 2, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 153, 153));
        jLabel10.setText("Produtos Cadastrados:");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Midias/icon_produtos.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 642, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(543, 701, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtCadastrar)
                    .addComponent(jbtDelete)
                    .addComponent(jbtNovo)
                    .addComponent(jbtAlterar))
                .addGap(17, 17, 17))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCadastrarActionPerformed

        Produto p = new Produto();

        p.setNome(jtfNome.getText());
        p.setTipo(jtfTipo.getText());
        p.setFornecedor(jtfFornecedor.getText());
        p.setMarca(jtfMarca.getText());
        p.setTamanho(jtfTamanho.getText());
        p.setValidade(jtfValidade.getText());
        p.setCodigobarras(jtfCodigoBarras.getText());
        ProdutoController pctr = new ProdutoController();
        p.setCusto(Float.parseFloat(pctr.validaNumber(jtfCusto.getText())));
        p.setPreco(Float.parseFloat(pctr.validaNumber(jtfPreco.getText())));
        this.tipo = "insert";

        pctr.validaDados(p, tipo);

        this.limpar();
        try {
            this.consultar();
        } catch (SQLException ex) {
            Logger.getLogger(FmrProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtCadastrarActionPerformed

    private void jbtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtNovoActionPerformed
        this.edicao();
        jtfNome.setVisible(true);
        jtfTipo.setVisible(true);
        jtfValidade.setVisible(true);
        jtfCusto.setVisible(true);
        jtfPreco.setVisible(true);
        jtfFornecedor.setVisible(true);
        jtfMarca.setVisible(true);
        jtfTamanho.setVisible(true);
        this.limpar();
    }//GEN-LAST:event_jbtNovoActionPerformed

    private void jbtDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtDeleteActionPerformed
        ProdutoDAO p = new ProdutoDAO();
        p.deleteProduto(this.id);
        try {
            this.consultar();
        } catch (SQLException ex) {
            Logger.getLogger(FmrProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtDeleteActionPerformed

    private void jtProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProdutoMouseClicked
        int lin = jtProduto.getSelectedRow();
        this.id = Integer.parseInt(jtProduto.getValueAt(lin, 0).toString());
        jtfCodigoBarras.setText(jtProduto.getValueAt(lin, 1).toString());
        jtfNome.setText(jtProduto.getValueAt(lin, 2).toString());
        jtfFornecedor.setText(jtProduto.getValueAt(lin, 3).toString());
        jtfMarca.setText(jtProduto.getValueAt(lin, 4).toString());
        jtfPreco.setText(jtProduto.getValueAt(lin, 5).toString());
        jtfTipo.setText(jtProduto.getValueAt(lin, 6).toString());
        jtfValidade.setText(jtProduto.getValueAt(lin, 7).toString());
        jtfCusto.setText(jtProduto.getValueAt(lin, 8).toString());
        jtfTamanho.setText(jtProduto.getValueAt(lin, 9).toString());

        this.jPanel1.setVisible(true);
        this.edicao();
    }//GEN-LAST:event_jtProdutoMouseClicked

    private void jbtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAlterarActionPerformed

        Produto p = new Produto();
        p.setId(this.id);
        p.setNome(jtfNome.getText());
        p.setTipo(jtfTipo.getText());
        p.setFornecedor(jtfFornecedor.getText());
        p.setMarca(jtfMarca.getText());
        p.setTamanho(jtfTamanho.getText());
        p.setValidade(jtfValidade.getText());
        p.setCodigobarras(jtfCodigoBarras.getText());
        ProdutoController pctr = new ProdutoController();
        p.setCusto(Float.parseFloat(pctr.validaNumber(jtfCusto.getText())));
        p.setPreco(Float.parseFloat(pctr.validaNumber(jtfPreco.getText())));
        this.tipo = "update";
        pctr.validaDados(p, tipo);

        try {
            this.consultar();
        } catch (SQLException ex) {
            Logger.getLogger(FmrProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtAlterarActionPerformed

    private void jtfTipoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfTipoKeyPressed

        FmrPesquisar m = new FmrPesquisar("categoria", "nome", "produto", this, null, null);
        m.setVisible(true);


    }//GEN-LAST:event_jtfTipoKeyPressed

    private void jtfMarcaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfMarcaKeyPressed

        FmrPesquisar m = new FmrPesquisar("marca", "nome", "produto", this, null, null);
        m.setVisible(true);

    }//GEN-LAST:event_jtfMarcaKeyPressed

    private void jtfFornecedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfFornecedorKeyPressed

        FmrPesquisar m = new FmrPesquisar("fornecedor", "rz_social", "produto", this, null, null);
        m.setVisible(true);

    }//GEN-LAST:event_jtfFornecedorKeyPressed

    public void consultar() throws SQLException {
        ProdutoDAO dao = new ProdutoDAO();
        try {
            List<Produto> lista = (ArrayList) dao.showProduto();
            DefaultTableModel model = (DefaultTableModel) jtProduto.getModel();
            model.setNumRows(0);
            lista.forEach((p) -> {
                model.addRow(new Object[]{
                    p.getId(), p.getCodigobarras(), p.getNome(), p.getFornecedor(), p.getMarca(), p.getPreco(), p.getTipo(), p.getValidade(),
                    p.getCusto(), p.getTamanho()
                }
                );
            });
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Problemas com Banco de Dados:\n" + e.toString());
        }
    }

    public void exibicao() {
        jtfNome.setEnabled(false);
        jtfTipo.setEnabled(false);
        jtfValidade.setEnabled(false);
        jtfCusto.setEnabled(false);
        jtfPreco.setEnabled(false);
        jtfFornecedor.setEnabled(false);
        jtfMarca.setEnabled(false);
        jtfTamanho.setEnabled(false);
        this.jPanel1.setVisible(false);
    }

    public void edicao() {
        jtfNome.setEnabled(true);
        jtfTipo.setEnabled(true);
        jtfValidade.setEnabled(true);
        jtfCusto.setEnabled(true);
        jtfPreco.setEnabled(true);
        jtfFornecedor.setEnabled(true);
        jtfMarca.setEnabled(true);
        jtfTamanho.setEnabled(true);
        jPanel1.setVisible(true);
    }

    public void setCampo(Pesquisa p) {

        if (p.getTabela().equals("categoria")) {
            this.jtfTipo.setText(p.getTxt());
        }
        if (p.getTabela().equals("marca")) {
            jtfMarca.setText(p.getTxt());
        }
        if (p.getTabela().equals("fornecedor")) {
            jtfFornecedor.setText(p.getTxt());
        }

    }

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
            java.util.logging.Logger.getLogger(FmrProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FmrProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FmrProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FmrProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FmrProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtAlterar;
    private javax.swing.JToggleButton jbtCadastrar;
    private javax.swing.JToggleButton jbtDelete;
    private javax.swing.JToggleButton jbtNovo;
    private javax.swing.JTable jtProduto;
    private javax.swing.JTextField jtfCodigoBarras;
    private javax.swing.JTextField jtfCusto;
    private javax.swing.JTextField jtfFornecedor;
    private javax.swing.JTextField jtfMarca;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfPreco;
    private javax.swing.JTextField jtfTamanho;
    private javax.swing.JTextField jtfTipo;
    private javax.swing.JTextField jtfValidade;
    // End of variables declaration//GEN-END:variables
}
