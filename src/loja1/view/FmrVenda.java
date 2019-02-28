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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import loja1.classes.Funcionario;
import loja1.classes.Produto;
import loja1.classes.Venda;
import loja1.controller.BaseController;
import loja1.controller.VendaController;
import loja1.model.FuncionarioDAO;

public class FmrVenda extends javax.swing.JFrame {

    private MaskFormatter mskCpf;
    private String cod;
    private int qtd = 1, itens = 1, aux = 0;
    ;
    private Double bruto = 0.0, desconto = 0.0, pago = 0.0, troco = 0.0, liquido = 0.0;
    int i = 0;
    private String op;
    private List<Produto> list = new ArrayList<Produto>();

    public FmrVenda() {
        initComponents();
        this.preencheComboF();
        this.setMask();
        this.setCampoMask();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtVendas = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jtfItens = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfLiquido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfTroco = new javax.swing.JTextField();
        jtfPago = new javax.swing.JTextField();
        jtfBruto = new javax.swing.JTextField();
        jtfDesconto = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jtfFormaPagamento = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jtfFuncionario = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jtfNumParcelas = new javax.swing.JComboBox<>();
        jbtFinalizar = new javax.swing.JButton();
        jbtLimpar = new javax.swing.JButton();
        jbtCancelar = new javax.swing.JButton();
        jbtExcluir = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        jbtCliente = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jbtProduto = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jButton7 = new javax.swing.JButton();
        jtfCodigo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jbtAdd = new javax.swing.JButton();
        jtfQtd = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        jtfPendente = new javax.swing.JTextField();
        jtfMatricula = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jtfCPF = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jtVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod Produto", "Descrição", "Valor", "Quantidade", "Total"
            }
        ));
        jScrollPane1.setViewportView(jtVendas);

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel3.setText("Total Liquido:");

        jtfItens.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtfItens.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfItens.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel6.setText("Troco:");

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel5.setText("Total Pago:");

        jtfLiquido.setBackground(new java.awt.Color(255, 255, 51));
        jtfLiquido.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtfLiquido.setForeground(new java.awt.Color(255, 0, 0));
        jtfLiquido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfLiquido.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel4.setText("Total de Itens:");

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel1.setText("Total Bruto:");

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("Desconto:");

        jtfTroco.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtfTroco.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfTroco.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jtfPago.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtfPago.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfPago.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jtfPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfPagoKeyPressed(evt);
            }
        });

        jtfBruto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtfBruto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfBruto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jtfDesconto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jtfDesconto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfDesconto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtfDesconto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfDescontoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jtfBruto, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1)))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jtfDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jtfLiquido, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfItens, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jtfPago, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jtfTroco, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfBruto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfLiquido, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtfItens, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtfPago, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtfTroco, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtfDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel7.setText("Forma de Pagamento:");

        jtfFormaPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dinheiro", "Debito", "Crédito", "Fiado" }));

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel8.setText("CPF do Cliente:");

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel9.setText("Funcionario:");

        jtfFuncionario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "I", "Item 2", "Item 3", "Item 4" }));
        jtfFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfFuncionarioActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel10.setText("N° de Parcelas:");

        jtfNumParcelas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sem Parcela", "1 X", "2 X", "3 X", "4 X", "5 X" }));

        jbtFinalizar.setText("Finalizar");
        jbtFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtFinalizarActionPerformed(evt);
            }
        });

        jbtLimpar.setText("Limpar");
        jbtLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtLimparActionPerformed(evt);
            }
        });

        jbtCancelar.setText("Cancelar");
        jbtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCancelarActionPerformed(evt);
            }
        });

        jbtExcluir.setText("Excluir");
        jbtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtExcluirActionPerformed(evt);
            }
        });

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setRollover(true);

        jbtCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Midias/icon_cliente.png"))); // NOI18N
        jbtCliente.setText("Cadastro de Cliente");
        jbtCliente.setFocusable(false);
        jbtCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtCliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtClienteActionPerformed(evt);
            }
        });
        jToolBar1.add(jbtCliente);
        jToolBar1.add(jSeparator2);

        jbtProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Midias/icon_produto.png"))); // NOI18N
        jbtProduto.setText("Cadatrar Produto");
        jbtProduto.setFocusable(false);
        jbtProduto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtProduto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtProdutoActionPerformed(evt);
            }
        });
        jToolBar1.add(jbtProduto);
        jToolBar1.add(jSeparator1);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Midias/icon_impressao.jpg"))); // NOI18N
        jButton7.setText("Imprimir Venda");
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton7);

        jLabel11.setText("Codigo Barras:");

        jLabel12.setText("Quantidade:");

        jbtAdd.setText("Adicionar");
        jbtAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAddActionPerformed(evt);
            }
        });

        jtfQtd.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        jtfQtd.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 51, 51));
        jLabel13.setText("Pendente:");

        jtfPendente.setBackground(new java.awt.Color(255, 255, 102));
        jtfPendente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfPendente.setForeground(new java.awt.Color(255, 51, 102));

        jtfMatricula.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtfMatricula.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfMatricula.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Cod:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(jtfPendente, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jbtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jbtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jbtLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jbtFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jtfFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(33, 33, 33)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addComponent(jtfNumParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(36, 36, 36)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addGap(59, 59, 59))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jtfCPF)
                                                .addGap(26, 26, 26)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jtfFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(18, 18, 18)
                                        .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jtfQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jbtAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jbtAdd)
                    .addComponent(jtfQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jtfPendente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfNumParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtFinalizar)
                    .addComponent(jbtLimpar)
                    .addComponent(jbtCancelar)
                    .addComponent(jbtExcluir))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Função responsável setar as variaveis com as mascaras dos campos
    public void setMask() {
        try {
            mskCpf = new MaskFormatter("###.###.###-##");
            mskCpf.setPlaceholderCharacter('_');

        } catch (ParseException ex) {
            Logger.getLogger(FmrCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setCampoMask() {
        jtfCPF.setFormatterFactory(new DefaultFormatterFactory(mskCpf));
    }

    //Funcao para Preencher os txt do formulario venda
    private void preencheCampos() {
        BaseController ctr = new BaseController();
        //pegando o valor da moedal local do pais para depois formatar os campos que vao exibir
        Locale locale = new Locale("pt", "BR");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

        //Pegando a soma do valor total de Produtos para preencher o campo total bruto
        this.bruto = 0.0;
        for (int i = 0; i <= jtVendas.getRowCount() - 1; i++) {

            this.bruto += Double.parseDouble(ctr.validaMoeda(jtVendas.getValueAt(i, 4).toString()));
            this.itens = jtVendas.getRowCount();

        }
        this.liquido = bruto - desconto;
        //Setando os Valores 
        jtfBruto.setText("" + currencyFormatter.format(bruto));
        jtfLiquido.setText("" + currencyFormatter.format(liquido));
        jtfDesconto.setText(currencyFormatter.format(this.desconto));
        jtfPago.setText("" + currencyFormatter.format(this.pago));
        jtfTroco.setText("" + currencyFormatter.format(this.troco));
        jtfPendente.setText("" + currencyFormatter.format(pago - liquido));
        jtfItens.setText("" + itens);

    }

    //Preenche comboBox
    public void preencheComboF() {
        FuncionarioDAO dao = new FuncionarioDAO();
        List<Funcionario> listFuncionario = (ArrayList) dao.showFuncionario();
        List<String> listAux = new ArrayList<String>();

        for (int i = 0; i < listFuncionario.size(); i++) {
            listAux.add(listFuncionario.get(i).getNome());
        }
        DefaultComboBoxModel defaultComboModel = new DefaultComboBoxModel(listAux.toArray());
        jtfFuncionario.setModel(defaultComboModel);
    }

    private void jbtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtClienteActionPerformed
        FmrCliente.main(null);
    }//GEN-LAST:event_jbtClienteActionPerformed

    private void jbtProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtProdutoActionPerformed
        FmrProduto.main(null);
    }//GEN-LAST:event_jbtProdutoActionPerformed

    private void jbtAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAddActionPerformed

        Locale locale = new Locale("pt", "BR");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        BaseController ctr = new BaseController();
        VendaController ctrv = new VendaController();

        //Setando Variaveis
        this.cod = jtfCodigo.getText();
        this.qtd = Integer.parseInt(ctr.validaNumber(jtfQtd.getText()));
        this.bruto = Double.parseDouble("0");
        //verifica se o codigo existe se sim retorna 0 se não retorna 1
        int aux = ctrv.validaCodigoBarras(cod);
        if (aux == 0) {
            try {
                //pegando valores do banco de dados
                this.list.add(ctrv.showProdutoV(this.cod));
                //adicionando valores obtidos em uma lista
                list.get(i).setQtd(qtd);
                i++;
                jtfQtd.setText("1");
                jtfCodigo.setText("");

                DefaultTableModel model = (DefaultTableModel) jtVendas.getModel();
                //Adiciona os objetos a tabela
                model.setNumRows(0);
                list.forEach((p) -> {
                    model.addRow(new Object[]{
                        p.getCodigobarras(), p.getNome(), currencyFormatter.format(p.getPreco()), p.getQtd(), currencyFormatter.format(p.getQtd() * p.getPreco())
                    });
                });
                this.preencheCampos();
            } catch (SQLException ex) {
                Logger.getLogger(FmrVenda.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Produto nao Cadastrado!!");
        }
    }//GEN-LAST:event_jbtAddActionPerformed

    private void jtfPagoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPagoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            BaseController ctr = new BaseController();
            VendaController ctrv = new VendaController();
            this.pago = Double.parseDouble(ctr.validaMoeda(jtfPago.getText()));
            this.liquido = bruto - desconto;

            //pegando o valor da moedal local do pais para depois formatar os campos que vao exibir
            Locale locale = new Locale("pt", "BR");
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
            if ((pago - liquido) > 0) {
                jtfTroco.setText("" + currencyFormatter.format(this.pago - this.liquido));
                jtfPendente.setText("" + currencyFormatter.format(0.0));
            } else {
                jtfTroco.setText("" + currencyFormatter.format(0.0));
                jtfPendente.setText("" + currencyFormatter.format(pago - liquido));
            }
            if (this.pago > 0 && this.pago < this.liquido) {
                jtfLiquido.setText("" + currencyFormatter.format((liquido - pago)));
            } else {
                jtfLiquido.setText("" + currencyFormatter.format((liquido)));
            }
            jtfPago.setText("" + currencyFormatter.format(pago));
        }
    }//GEN-LAST:event_jtfPagoKeyPressed

    private void jbtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jbtCancelarActionPerformed

    private void jbtFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtFinalizarActionPerformed

        Venda v = new Venda();
        BaseController ctr = new BaseController();
        VendaController ctrv = new VendaController();

        v.setTipo(" ");
        if (aux == 0) {
            v.setTipo("CriarVenda");
            v.setCpf_cliente(jtfCPF.getText());
            aux++;
        }
        ctrv.Validadados(v, this, "venda");

        for (int i = 0; i < jtVendas.getRowCount(); i++) {
            v.setCpf_cliente(jtfCPF.getText());
            v.setDesconto(Float.parseFloat(ctr.validaNumber(ctr.validaMoeda(jtfDesconto.getText()))));
            v.setId_funcionario(Integer.parseInt(ctr.validaNumber(jtfMatricula.getText())));
            v.setCodigo_barras(jtVendas.getValueAt(i, 0).toString());
            v.setPago(Float.parseFloat(ctr.validaMoeda(jtfPago.getText())));
            v.setPendente(Float.parseFloat(ctr.validaMoeda(jtfPendente.getText())));
            v.setTotal(Float.parseFloat(ctr.validaMoeda(jtfBruto.getText())));
            v.setQtd(Integer.parseInt(jtVendas.getValueAt(i, 3).toString()));
            v.setQtdTotal(Integer.parseInt(jtfItens.getText()));
            v.setTroco(Float.parseFloat(ctr.validaMoeda(jtfTroco.getText())));
            v.setFormaPagamento(jtfFormaPagamento.getSelectedItem().toString());
            v.setParcelas(jtfNumParcelas.getSelectedItem().toString());
            v.setValorProduto(Float.parseFloat(ctr.validaMoeda(jtVendas.getValueAt(i, 2).toString())));
            v.setNf(ctrv.returnIdVenda());
            int a=0;
               System.out.println("" + (a+1));
            ctrv.Validadados(v, this, "vendaItens");
        }
        v.setTipo("update");
        aux = ctrv.Validadados(v, this, "venda");
    }//GEN-LAST:event_jbtFinalizarActionPerformed

    private void jtfFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfFuncionarioActionPerformed
        BaseController b = new BaseController();
        int aux;
        aux = b.returnCodigo("funcionario", "nome", jtfFuncionario.getSelectedItem().toString());
        jtfMatricula.setText("" + aux);
    }//GEN-LAST:event_jtfFuncionarioActionPerformed

    private void jbtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtExcluirActionPerformed
        DefaultTableModel tb = (DefaultTableModel) jtVendas.getModel();
        int lin = jtVendas.getSelectedRow();

        if (jtVendas.getSelectedRow() >= 0) {
            //removendo objeto da lista
            list.remove(lin);
            //removendo a linha da tabela
            tb.removeRow(jtVendas.getSelectedRow());
            jtVendas.setModel(tb);
            //Preenchendo os campos sem os produtos que foram excluidos
            this.itens--;
            i--;
            this.preencheCampos();

        } else {
            JOptionPane.showMessageDialog(null, "Favor selecionar uma linha");
        }

    }//GEN-LAST:event_jbtExcluirActionPerformed

    private void jbtLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtLimparActionPerformed
        DefaultTableModel tb = (DefaultTableModel) jtVendas.getModel();
        tb.setNumRows(0);
        list.removeAll(list);
        this.itens = 0;
        this.i = 0;
        this.desconto = 0.0;
        this.pago = 0.0;
        jtfCPF.setText("");
        this.preencheCampos();
    }//GEN-LAST:event_jbtLimparActionPerformed

    private void jtfDescontoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDescontoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            VendaController ctrv = new VendaController();
            BaseController ctr = new BaseController();
            this.desconto = Double.parseDouble(ctr.validaMoeda(jtfDesconto.getText()));
            this.liquido = bruto - desconto;

            //pegando o valor da moedal local do pais para depois formatar os campos que vao exibir
            Locale locale = new Locale("pt", "BR");
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
            if ((this.pago - liquido) > 0) {
                jtfTroco.setText("" + currencyFormatter.format(this.pago - (this.liquido)));
                jtfPendente.setText("" + currencyFormatter.format(0.0));
            } else {
                jtfTroco.setText("" + currencyFormatter.format(0.0));
                jtfPendente.setText("" + currencyFormatter.format(pago - liquido));
            }
            jtfLiquido.setText("" + currencyFormatter.format(liquido));
            jtfDesconto.setText("" + currencyFormatter.format(desconto));
        }
    }//GEN-LAST:event_jtfDescontoKeyPressed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FmrVenda.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FmrVenda.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FmrVenda.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FmrVenda.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FmrVenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton jbtAdd;
    private javax.swing.JButton jbtCancelar;
    private javax.swing.JButton jbtCliente;
    private javax.swing.JButton jbtExcluir;
    private javax.swing.JButton jbtFinalizar;
    private javax.swing.JButton jbtLimpar;
    private javax.swing.JButton jbtProduto;
    private javax.swing.JTable jtVendas;
    private javax.swing.JTextField jtfBruto;
    private javax.swing.JFormattedTextField jtfCPF;
    private javax.swing.JTextField jtfCodigo;
    private javax.swing.JFormattedTextField jtfDesconto;
    private javax.swing.JComboBox<String> jtfFormaPagamento;
    private javax.swing.JComboBox<String> jtfFuncionario;
    private javax.swing.JTextField jtfItens;
    private javax.swing.JTextField jtfLiquido;
    private javax.swing.JTextField jtfMatricula;
    private javax.swing.JComboBox<String> jtfNumParcelas;
    private javax.swing.JTextField jtfPago;
    private javax.swing.JTextField jtfPendente;
    private javax.swing.JFormattedTextField jtfQtd;
    private javax.swing.JTextField jtfTroco;
    // End of variables declaration//GEN-END:variables
}
