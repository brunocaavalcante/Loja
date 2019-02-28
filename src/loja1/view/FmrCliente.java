package loja1.view;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import loja1.classes.Cliente;
import loja1.controller.ClienteController;
import loja1.model.ClienteDAO;

public class FmrCliente extends javax.swing.JFrame {

    private int id;
    private String idade;
    MaskFormatter mskIdade;
    MaskFormatter mskCpf;
    MaskFormatter mskTelefone;

    public FmrCliente() {
        initComponents();
        this.setMask();
        this.setCampoMask();
        try {
            this.consultar();
        } catch (SQLException ex) {
            Logger.getLogger(FmrCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.exibicao();
        this.Exibirtela("p");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jtabCadastrar = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jtfNome = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtfEndereco = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtfEmail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfSexo = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jtfTelefone = new javax.swing.JFormattedTextField();
        jtfCPF = new javax.swing.JFormattedTextField();
        jtfIdade = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtCliente = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jpDebitos = new javax.swing.JPanel();
        jtxtDebitos = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtDebitos = new javax.swing.JTable();
        jbtNovo = new javax.swing.JButton();
        jbtAlterar = new javax.swing.JButton();
        jbtDeletar = new javax.swing.JButton();
        jbtCadastrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jtabCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtabCadastrarMouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 2, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Email:");

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 2, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Data de Nascimento:");

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 2, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Nome:");

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 2, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Telefone:");

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 2, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Sexo:");

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 2, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Endereco:");

        jtfSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino" }));

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 2, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("CPF:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jtfCPF, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfNome, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                                    .addComponent(jtfEndereco))
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addComponent(jtfTelefone))
                        .addGap(95, 95, 95)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel6))
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jtfEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                            .addComponent(jtfSexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtfIdade))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jtabCadastrar.addTab("Cadastrar Cliente", jPanel1);

        jtCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Nome", "Endereco", "Telefone", "Data Nascimento", "Email", "Debitos", "Sexo", "CPF"
            }
        ));
        jtCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtCliente);

        jtabCadastrar.addTab("Consultar Cliente", jScrollPane1);

        jtxtDebitos.setFont(new java.awt.Font("Trebuchet MS", 2, 14)); // NOI18N
        jtxtDebitos.setForeground(new java.awt.Color(255, 0, 51));
        jtxtDebitos.setText("Debitos do Cliente:");

        jLabel7.setFont(new java.awt.Font("Arial Narrow", 3, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 51, 51));
        jLabel7.setText("Soma Total dos Débitos do Cliente:");

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 935, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );

        jtDebitos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Funcionario", "Cliente", "Produto", "Quantidade", "Sub Valor", "Valor"
            }
        ));
        jScrollPane2.setViewportView(jtDebitos);

        javax.swing.GroupLayout jpDebitosLayout = new javax.swing.GroupLayout(jpDebitos);
        jpDebitos.setLayout(jpDebitosLayout);
        jpDebitosLayout.setHorizontalGroup(
            jpDebitosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDebitosLayout.createSequentialGroup()
                .addGroup(jpDebitosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDebitosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpDebitosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtDebitos)
                            .addComponent(jLabel7)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 747, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpDebitosLayout.setVerticalGroup(
            jpDebitosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDebitosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpDebitosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpDebitosLayout.createSequentialGroup()
                        .addComponent(jtxtDebitos)
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7))))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpDebitos, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpDebitos, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

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

        jbtDeletar.setText("Deletar");
        jbtDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtDeletarActionPerformed(evt);
            }
        });

        jbtCadastrar.setText("Cadastrar");
        jbtCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCadastrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jbtDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtabCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jtabCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbtAlterar)
                            .addComponent(jbtDeletar)
                            .addComponent(jbtNovo)
                            .addComponent(jbtCadastrar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(793, 752));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCadastrarActionPerformed
        Cliente c = new Cliente();
        c.setCpf(jtfCPF.getText());
        c.setEmail(jtfEmail.getText());
        c.setEndereco(jtfEndereco.getText());
        this.idade = jtfIdade.getText();
        c.setNome(jtfNome.getText());
        c.setSexo(jtfSexo.getSelectedItem().toString());
        c.setTelefone(jtfTelefone.getText());
        c.setTipo("insert");
        ClienteController ctr = new ClienteController();
        ctr.validaDados(idade, c);
        try {
            this.consultar();
            this.limpa();
        } catch (SQLException ex) {
            Logger.getLogger(FmrCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jbtCadastrarActionPerformed
    //Função responsável setar as variaveis com as mascaras dos campos
    public void setMask() {
        try {
            mskIdade = new MaskFormatter("##/##/####");
            mskIdade.setPlaceholderCharacter('_');
            mskCpf = new MaskFormatter("###.###.###-##");
            mskCpf.setPlaceholderCharacter('_');
            mskTelefone = new MaskFormatter("(##)#####-####");
            mskTelefone.setPlaceholderCharacter('_');
        } catch (ParseException ex) {
            Logger.getLogger(FmrCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Função responsavel por setar os TextField com as mascaras.
    public void setCampoMask() {
        jtfCPF.setFormatterFactory(new DefaultFormatterFactory(mskCpf));
        jtfIdade.setFormatterFactory(new DefaultFormatterFactory(mskIdade));
        jtfTelefone.setFormatterFactory(new DefaultFormatterFactory(mskTelefone));
    }

    private void jbtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtNovoActionPerformed
        this.edicao();
        this.limpa();
    }//GEN-LAST:event_jbtNovoActionPerformed

    private void jbtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAlterarActionPerformed

        Cliente c = new Cliente();
        c.setId(this.id);
        c.setNome(jtfNome.getText());
        c.setCpf(jtfCPF.getText());
        c.setEndereco(jtfEndereco.getText());
        c.setTelefone(jtfTelefone.getText());
        c.setEmail(jtfEmail.getText());
        c.setSexo((String) jtfSexo.getSelectedItem());
        c.setTipo("update");
        ClienteController ctr = new ClienteController();
        ctr.validaDados(jtfIdade.getText(), c);
        try {
            this.consultar();
            this.limpa();
        } catch (SQLException ex) {
            Logger.getLogger(FmrCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtAlterarActionPerformed

    private void jbtDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtDeletarActionPerformed
        ClienteDAO c = new ClienteDAO();
        c.deleteCliente(this.id);
        try {
            this.consultar();
            this.limpa();
        } catch (SQLException ex) {
            Logger.getLogger(FmrCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtDeletarActionPerformed

    private void jtabCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtabCadastrarMouseClicked
        jpDebitos.setVisible(false);
        this.edicao();
        this.Exibirtela("p");

    }//GEN-LAST:event_jtabCadastrarMouseClicked

    private void jtClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtClienteMouseClicked
        int lin = jtCliente.getSelectedRow();
        this.id = Integer.parseInt(jtCliente.getValueAt(lin, 0).toString());
        jtfCPF.setText(jtCliente.getValueAt(lin, 8).toString());
        int debito = Integer.parseInt(jtCliente.getValueAt(lin, 6).toString());
        jtfNome.setText(jtCliente.getValueAt(lin, 1).toString());
        jtfEndereco.setText(jtCliente.getValueAt(lin, 2).toString());
        jtfTelefone.setText(jtCliente.getValueAt(lin, 3).toString());
        jtfIdade.setText(jtCliente.getValueAt(lin, 4).toString());
        jtfEmail.setText(jtCliente.getValueAt(lin, 5).toString());
        jtfSexo.setSelectedItem(jtCliente.getValueAt(lin, 7).toString());
        if (debito > 0) {
            jpDebitos.setVisible(true);
            this.Exibirtela("g");

        } else {
            jpDebitos.setVisible(false);
            this.Exibirtela("p");

        }
    }//GEN-LAST:event_jtClienteMouseClicked

    public void consultar() throws SQLException {
        ClienteDAO dao = new ClienteDAO();
        try {
            List<Cliente> lista = (ArrayList) dao.showCliente();
            DefaultTableModel model = (DefaultTableModel) jtCliente.getModel();
            model.setNumRows(0);
            lista.forEach((c) -> {
                model.addRow(new Object[]{
                    c.getId(), c.getNome(), c.getEndereco(), c.getTelefone(), c.getIdade(), c.getEmail(), c.getDebitos(),
                    c.getSexo(), c.getCpf()
                }
                );
            });
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Problemas com Banco de Dados:\n" + e.toString());
        }
    }

    private void exibicao() {
        jtfEmail.setEnabled(false);
        jtfEndereco.setEnabled(false);
        jtfNome.setEnabled(false);
        jtfTelefone.setEnabled(false);
        jtfIdade.setEnabled(false);
        jtfSexo.setEnabled(false);
        jpDebitos.setVisible(false);
        jtfCPF.setEnabled(false);

    }

    private void edicao() {
        jtfEmail.setEnabled(true);
        jtfEndereco.setEnabled(true);
        jtfNome.setEnabled(true);
        jtfTelefone.setEnabled(true);
        jtfIdade.setEnabled(true);
        jtfSexo.setEnabled(true);
        jtfCPF.setEnabled(true);
    }

    private void limpa() {
        jtfNome.setText("");
        jtfEmail.setText("");
        jtfTelefone.setText("");
        jtfIdade.setText("");
        jtfEndereco.setText("");
        jtfCPF.setText("");
    }

    public void Exibirtela(String tipoTela) {
        if (tipoTela.equals("g")) {
            this.setSize(800, 700);
        } else {
            this.setSize(800, 400);
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
            java.util.logging.Logger.getLogger(FmrCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FmrCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FmrCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FmrCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FmrCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbtAlterar;
    private javax.swing.JButton jbtCadastrar;
    private javax.swing.JButton jbtDeletar;
    private javax.swing.JButton jbtNovo;
    private javax.swing.JPanel jpDebitos;
    private javax.swing.JTable jtCliente;
    private javax.swing.JTable jtDebitos;
    private javax.swing.JTabbedPane jtabCadastrar;
    private javax.swing.JFormattedTextField jtfCPF;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfEndereco;
    private javax.swing.JFormattedTextField jtfIdade;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JComboBox<String> jtfSexo;
    private javax.swing.JFormattedTextField jtfTelefone;
    private javax.swing.JLabel jtxtDebitos;
    // End of variables declaration//GEN-END:variables
}
