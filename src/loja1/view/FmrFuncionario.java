package loja1.view;

import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import loja1.classes.Funcionario;
import loja1.controller.BaseController;
import loja1.controller.FuncionarioController;
import loja1.model.FuncionarioDAO;

public class FmrFuncionario extends javax.swing.JFrame {

    private int id;
    private String tipo;
    private MaskFormatter mskTelefone, mskData;

    public FmrFuncionario() {

        initComponents();
        this.setMask();
        this.setCampoMask();
        try {
            this.consultar();
        } catch (SQLException ex) {
            Logger.getLogger(FmrFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jtfSexo = new javax.swing.JComboBox<>();
        jtfLogin = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jtfSenha = new javax.swing.JPasswordField();
        jtfNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfSalario = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jtfIdade = new javax.swing.JFormattedTextField();
        jtfHierarquia = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jtfMeta = new javax.swing.JTextField();
        jtfTelefone = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtFuncionario = new javax.swing.JTable();
        jbtAlterar = new javax.swing.JButton();
        jbtNovo = new javax.swing.JButton();
        jbtExcluir = new javax.swing.JButton();
        jbtCadastrar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jtfSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino" }));

        jLabel11.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Meta Mensal:");

        jLabel1.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Nome:");

        jLabel3.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Nascimento:");

        jLabel6.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Login:");

        jLabel5.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Sexo:");

        jLabel7.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Senha:");

        jLabel2.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Telefone:");

        jtfSalario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfSalarioFocusLost(evt);
            }
        });
        jtfSalario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfSalarioKeyPressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Hierarquia:");

        jLabel10.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Salário:");

        jtfIdade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        jtfHierarquia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Adiministrador", "Funcionario" }));

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 3, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Cadastro de Funcionarios:");

        jtfMeta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfMetaFocusLost(evt);
            }
        });
        jtfMeta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfMetaKeyPressed(evt);
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel12))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfIdade, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(jtfHierarquia, 0, 200, Short.MAX_VALUE)
                                    .addComponent(jtfNome, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(jtfTelefone)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfMeta)))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addGap(11, 11, 11))))
                                .addGap(56, 56, 56)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(21, 21, 21))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jtfSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jtfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(jtfIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6))
                            .addComponent(jtfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(jtfHierarquia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jtfMeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cadastro", jPanel1);

        jtFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Nome", "Telefone", "Data Nascimento", "Login", "Senha", "Tipo", "Meta", "Salario"
            }
        ));
        jtFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtFuncionarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtFuncionario);

        jTabbedPane1.addTab("Consulta", jScrollPane1);

        jbtAlterar.setText("Alterar");
        jbtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAlterarActionPerformed(evt);
            }
        });

        jbtNovo.setText("Novo");
        jbtNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtNovoActionPerformed(evt);
            }
        });

        jbtExcluir.setText("Excluir");
        jbtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtExcluirActionPerformed(evt);
            }
        });

        jbtCadastrar.setText("Cadastrar");
        jbtCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCadastrarActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Midias/fmr_funcionario2.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jbtNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jbtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jbtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jbtCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtExcluir)
                    .addComponent(jbtAlterar)
                    .addComponent(jbtCadastrar)
                    .addComponent(jbtNovo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(6, 6, 6))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void consultar() throws SQLException {

        FuncionarioDAO dao = new FuncionarioDAO();
        try {
            List<Funcionario> lista = (ArrayList) dao.showFuncionario();
            DefaultTableModel model = (DefaultTableModel) jtFuncionario.getModel();
            Locale locale = new Locale("pt", "BR");
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

            model.setNumRows(0);
            lista.forEach((f) -> {
                model.addRow(new Object[]{
                    f.getId(), f.getNome(), f.getTelefone(), f.getIdade(), f.getLogin(), f.getSenha(), f.getHierarquia(),
                    currencyFormatter.format(f.getMeta()), currencyFormatter.format(f.getSalario())
                }
                );
            });
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Problemas com Banco de Dados:\n" + e.toString());
        }
    }

    private void jbtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAlterarActionPerformed
        Funcionario f = new Funcionario();
        BaseController b = new BaseController();
        FuncionarioController ctr = new FuncionarioController();

        f.setId(id);
        f.setIdade(jtfIdade.getText());
        f.setLogin(jtfLogin.getText());
        f.setMeta(Double.parseDouble(b.validaMoeda(b.validaNumber(jtfMeta.getText()))));
        f.setHierarquia(jtfHierarquia.getSelectedItem().toString());
        f.setNome(jtfNome.getText());
        f.setSalario(Double.parseDouble(b.validaMoeda(b.validaNumber(jtfSalario.getText()))));
        f.setSenha(jtfSenha.getPassword().toString());
        f.setSexo(jtfSexo.getSelectedItem().toString());
        f.setTelefone(jtfTelefone.getText());

        this.tipo = "update";
        ctr.validaDados(f, tipo);
        try {
            this.consultar();
        } catch (SQLException ex) {
            Logger.getLogger(FmrFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jbtAlterarActionPerformed

    private void jbtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtNovoActionPerformed
        this.edicao();
        this.limpar();
    }//GEN-LAST:event_jbtNovoActionPerformed

    private void jbtCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCadastrarActionPerformed
        Funcionario f = new Funcionario();
        BaseController b = new BaseController();
        f.setIdade(jtfIdade.getText());
        f.setNome(jtfNome.getText());
        f.setTelefone(jtfTelefone.getText());
        f.setHierarquia(jtfHierarquia.getSelectedItem().toString());
        FuncionarioController ctr = new FuncionarioController();
        f.setMeta(Double.parseDouble(b.validaMoeda(b.validaNumber(jtfMeta.getText()))));
        f.setSalario(Double.parseDouble(b.validaMoeda(b.validaNumber(jtfSalario.getText()))));
        f.setSexo(jtfSexo.getSelectedItem().toString());
        f.setLogin(jtfLogin.getText());
        f.setSenha(jtfSenha.getPassword().toString());
        this.tipo = "insert";
        this.limpar();

        ctr.validaDados(f, tipo);
        try {
            this.consultar();
        } catch (SQLException ex) {
            Logger.getLogger(FmrFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jbtCadastrarActionPerformed

    private void jbtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtExcluirActionPerformed
        FuncionarioController ctr = new FuncionarioController();
        ctr.excluir(id);
        try {
            this.consultar();
        } catch (SQLException ex) {
            Logger.getLogger(FmrFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtExcluirActionPerformed

    private void jtFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtFuncionarioMouseClicked
        int lin = jtFuncionario.getSelectedRow();
        this.id = Integer.parseInt(jtFuncionario.getValueAt(lin, 0).toString());
        jtfNome.setText(jtFuncionario.getValueAt(lin, 1).toString());
        jtfTelefone.setText(jtFuncionario.getValueAt(lin, 2).toString());
        jtfIdade.setText(jtFuncionario.getValueAt(lin, 3).toString());
        jtfLogin.setText(jtFuncionario.getValueAt(lin, 4).toString());
        jtfSenha.setText(jtFuncionario.getValueAt(lin, 5).toString());
        jtfHierarquia.setSelectedItem(jtFuncionario.getValueAt(lin, 6).toString());
        jtfMeta.setText(jtFuncionario.getValueAt(lin, 7).toString());
        jtfSalario.setText(jtFuncionario.getValueAt(lin, 8).toString());

        this.edicao();
    }//GEN-LAST:event_jtFuncionarioMouseClicked

    private void jtfSalarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfSalarioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtfSalario.setText("R$ " + jtfSalario.getText() + ",00");
        }
    }//GEN-LAST:event_jtfSalarioKeyPressed

    private void jtfSalarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfSalarioFocusLost
        BaseController b = new BaseController();
        jtfSalario.setText(b.convertMoeda(Float.parseFloat(jtfSalario.getText())));
    }//GEN-LAST:event_jtfSalarioFocusLost

    private void jtfMetaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfMetaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtfMeta.setText("R$ " + jtfMeta.getText() + ",00");
        }
    }//GEN-LAST:event_jtfMetaKeyPressed

    private void jtfMetaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfMetaFocusLost
        BaseController b = new BaseController();
        jtfMeta.setText(b.convertMoeda(Float.parseFloat(jtfMeta.getText())));
    }//GEN-LAST:event_jtfMetaFocusLost

    public void setMask() {
        try {
            mskData = new MaskFormatter("##/##/####");
            mskData.setPlaceholderCharacter('_');
            mskTelefone = new MaskFormatter("(##)#####-####");
            mskTelefone.setPlaceholderCharacter('_');

        } catch (ParseException ex) {
            Logger.getLogger(FmrCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setCampoMask() {
        jtfIdade.setFormatterFactory(new DefaultFormatterFactory(mskData));
        jtfTelefone.setFormatterFactory(new DefaultFormatterFactory(mskTelefone));
    }

    public void edicao() {
        jtfNome.setEnabled(true);
        jtfIdade.setEnabled(true);
        jtfTelefone.setEnabled(true);
        jtfSexo.setEnabled(true);
        jtfMeta.setEnabled(true);
        jtfHierarquia.setEnabled(true);
        jtfSalario.setEnabled(true);
        jtfLogin.setEnabled(true);
        jtfSenha.setEnabled(true);

    }

    public void exibir() {
        jtfNome.setEnabled(false);
        jtfIdade.setEnabled(false);
        jtfTelefone.setEnabled(false);
        jtfSexo.setEnabled(false);
        jtfMeta.setEnabled(false);
        jtfHierarquia.setEnabled(false);
        jtfSalario.setEnabled(false);
        jtfLogin.setEnabled(false);
        jtfSenha.setEnabled(false);

    }

    public void limpar() {
        jtfNome.setText("");
        jtfIdade.setText("");
        jtfTelefone.setText("");
        jtfMeta.setText("");
        jtfSalario.setText("");
        jtfLogin.setText("");
        jtfSenha.setText("");

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
            java.util.logging.Logger.getLogger(FmrFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FmrFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FmrFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FmrFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FmrFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbtAlterar;
    private javax.swing.JButton jbtCadastrar;
    private javax.swing.JButton jbtExcluir;
    private javax.swing.JButton jbtNovo;
    private javax.swing.JTable jtFuncionario;
    private javax.swing.JComboBox<String> jtfHierarquia;
    private javax.swing.JFormattedTextField jtfIdade;
    private javax.swing.JTextField jtfLogin;
    private javax.swing.JTextField jtfMeta;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfSalario;
    private javax.swing.JPasswordField jtfSenha;
    private javax.swing.JComboBox<String> jtfSexo;
    private javax.swing.JFormattedTextField jtfTelefone;
    // End of variables declaration//GEN-END:variables
}
