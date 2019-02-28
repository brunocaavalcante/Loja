package loja1.view;

import java.awt.Color;
import java.awt.Component;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import loja1.classes.Pesquisa;
import loja1.controller.RelatorioController;
import loja1.model.DAO;
import loja1.model.RelatorioDAO;

public class jifVendas extends javax.swing.JInternalFrame {

    private MaskFormatter data1, data2, cpf;
    private int cod;
    private String aux = "";

    public jifVendas() {
        initComponents();
        this.preencheComboF("funcionario", "nome");
        this.setMask();
        this.setCamposMask();
        this.consultar();

    }

    public void preencheComboF(String tabela, String coluna) {
        DAO dao = new DAO();
        List<Pesquisa> listPesquisa = (ArrayList) dao.pesquisa(tabela, coluna, null);
        List<String> listAux = new ArrayList<String>();

        for (int i = 0; i < listPesquisa.size(); i++) {
            listAux.add(listPesquisa.get(i).getParam1());
        }
        DefaultComboBoxModel defaultComboModel = new DefaultComboBoxModel(listAux.toArray());
        jtfFuncionario.setModel(defaultComboModel);
    }

    public void setMask() {
        try {
            data1 = new MaskFormatter("##/##/####");
            data2 = new MaskFormatter("##/##/####");
            cpf = new MaskFormatter("###.###.###-##");
            data1.setPlaceholderCharacter('_');
            data2.setPlaceholderCharacter('_');
            cpf.setPlaceholderCharacter('_');
        } catch (ParseException ex) {
            Logger.getLogger(JReportVendas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setCamposMask() {
        jtfData1.setFormatterFactory(new DefaultFormatterFactory(data1));
        jtfData2.setFormatterFactory(new DefaultFormatterFactory(data2));
        jtfCPF.setFormatterFactory(new DefaultFormatterFactory(cpf));
    }

    public void consultar() {
        RelatorioDAO dao = new RelatorioDAO();
        List<Pesquisa> list = (ArrayList) dao.showVendas(this.aux, "");
        DefaultTableModel model = (DefaultTableModel) jtVendas.getModel();
        model.setNumRows(0);
        list.forEach((p) -> {
            model.addRow(new Object[]{
                p.getParamInt1(), p.getParam1(), p.getParam2(), p.getCpf(), p.getParamFloat1(), p.getPago(), p.getParamFloat2(),
                p.getPendente(), p.getData_ini(), p.getForma_pagamento()
            }
            );
        });
        this.colorirTable();

    }

    public void colorirTable() {
        
        jtVendas.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtVendas, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel label = (JLabel) super.getTableCellRendererComponent(jtVendas, value, isSelected, hasFocus, row, column);

                Color c = Color.BLACK;
                float texto = Float.parseFloat(jtVendas.getValueAt(row, 7).toString());
                if (texto > 0.0) 
                    c = Color.RED;
                
                label.setForeground(c);

                return label;
            }
        });
    }

    public void consultaItens() {
        RelatorioDAO dao = new RelatorioDAO();
        List<Pesquisa> list = (ArrayList) dao.showVendaItens(this.cod);
        DefaultTableModel model = (DefaultTableModel) jtItens.getModel();
        model.setNumRows(0);
        list.forEach((p) -> {
            model.addRow(new Object[]{
                p.getCodigo_barras(), p.getParam1(), p.getParamInt1(), p.getParamFloat1(),
                p.getParamInt1() * p.getParamFloat1()
            }
            );
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtVendas = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtItens = new javax.swing.JTable();
        jtfData1 = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jtfData2 = new javax.swing.JFormattedTextField();
        jbtPesquisar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfCPF = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfFuncionario = new javax.swing.JComboBox<>();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Todas as Vendas");

        jtVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Funcionario", "Cliente", "CPF Cliente", "Valor", "Pago", "Troco ", "Pendente", "Data", "Forma de Pagamento"
            }
        ));
        jtVendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtVendasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtVendas);

        jTabbedPane1.addTab("Vendas Realizadas", jScrollPane1);

        jtItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo Barras", "Produto", "Quatidade", "Valor Unidade", "Valor Total"
            }
        ));
        jScrollPane2.setViewportView(jtItens);

        jTabbedPane1.addTab("Detalhes da Venda", jScrollPane2);

        jLabel1.setText("Até");

        jbtPesquisar.setText("Pesquisar");
        jbtPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtPesquisarActionPerformed(evt);
            }
        });

        jLabel2.setText("Pesquise as Vendas por intervalos de datas:");

        jLabel3.setText("Pesquise por CPF do Cliente:");

        jLabel4.setText("Pesquise por funcionario:");

        jtfFuncionario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtfData1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfData2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfCPF)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtfFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addComponent(jbtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4))
                        .addGap(0, 39, Short.MAX_VALUE))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfData1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jtfData2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtPesquisar)
                    .addComponent(jtfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtPesquisarActionPerformed
        RelatorioController rctr = new RelatorioController();
        Pesquisa p = new Pesquisa();

        //setando os campos
        p.setData_ini(jtfData1.getText());
        p.setData_fim(jtfData2.getText());
        p.setCpf(jtfCPF.getText());
        p.setParam1(jtfFuncionario.getSelectedItem().toString());
        this.aux = rctr.validaFiltrosPesq(p);
        this.consultar();
        jtfCPF.setText("");
        jtfData1.setText("");
        jtfData2.setText("");


    }//GEN-LAST:event_jbtPesquisarActionPerformed

    private void jtVendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtVendasMouseClicked
        int lin = jtVendas.getSelectedRow();
        cod = Integer.parseInt(jtVendas.getValueAt(lin, 0).toString());
        jtVendas.setSelectionBackground(new Color(220, 220, 220));
        this.consultaItens();
    }//GEN-LAST:event_jtVendasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbtPesquisar;
    private javax.swing.JTable jtItens;
    private javax.swing.JTable jtVendas;
    private javax.swing.JFormattedTextField jtfCPF;
    private javax.swing.JFormattedTextField jtfData1;
    private javax.swing.JFormattedTextField jtfData2;
    private javax.swing.JComboBox<String> jtfFuncionario;
    // End of variables declaration//GEN-END:variables
}
