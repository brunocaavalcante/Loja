package loja1.view;

import java.awt.Color;
import java.awt.Component;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import loja1.classes.Pesquisa;
import loja1.controller.BaseController;
import loja1.controller.RelatorioController;
import loja1.model.RelatorioDAO;

/**
 *
 * @author user
 */
public class jifVendasPend extends javax.swing.JInternalFrame {

    private MaskFormatter data1, data2, cpf;
    private int cod;
    private String aux = "";
    BaseController b;
    private int lin;

    public jifVendasPend() {
        initComponents();
        this.setMask();
        this.setCamposMask();
        this.consultar();
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
        List<Pesquisa> list = (ArrayList) dao.showVendas(this.aux, "pendentes");
        DefaultTableModel model = (DefaultTableModel) jtVendas.getModel();
        /* jtVendas.setAutoResizeMode(jtVendas.AUTO_RESIZE_ALL_COLUMNS);
        tca = new TableColumnAdjuster(jtVendas, 0);
        tca.adjustColumns();*/
        model.setNumRows(0);
        list.forEach((p) -> {
            model.addRow(new Object[]{
                p.getParamInt1(), p.getParam1(), p.getParam2(), p.getCpf(),p.getParamFloat1(),p.getPago(),
                p.getParamFloat2(),
               p.getPendente(), p.getData_ini(), p.getForma_pagamento()
            }
            );
        });
        this.colorirTable();

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

    public void colorirTable() {

        jtVendas.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            BaseController b = new BaseController();
            @Override     
            public Component getTableCellRendererComponent(JTable jtVendas, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel label = (JLabel) super.getTableCellRendererComponent(jtVendas, value, isSelected, hasFocus, row, column);

                Color c = Color.BLACK;
                float texto = Float.parseFloat(b.validaMoeda(jtVendas.getValueAt(row, 7).toString()));
                if (texto > 0.0) {
                    c = Color.RED;
                }

                label.setForeground(c);

                return label;
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfCPF = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfData2 = new javax.swing.JFormattedTextField();
        jtfData1 = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jbtPesquisar = new javax.swing.JButton();
        jbtPago = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtVendas = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtItens = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Vendas Pendentes");
        setToolTipText("");

        jLabel1.setText("CPF do Cliente:");

        jLabel2.setText("Datas:");

        jLabel3.setText("Até");

        jbtPesquisar.setText("Pesquisar");
        jbtPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtPesquisarActionPerformed(evt);
            }
        });

        jbtPago.setText("Pagar");
        jbtPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtPagoActionPerformed(evt);
            }
        });

        jButton3.setText("Fechar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jtVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Funcionario", "Cliente", "CPF Cliente", "Total Venda", "Pago", "Troco", "Pendente", "Data", "Forma de Pagamento"
            }
        ));
        jtVendas.getTableHeader().setReorderingAllowed(false);
        jtVendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtVendasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtVendas);
        if (jtVendas.getColumnModel().getColumnCount() > 0) {
            jtVendas.getColumnModel().getColumn(2).setResizable(false);
            jtVendas.getColumnModel().getColumn(2).setPreferredWidth(200);
            jtVendas.getColumnModel().getColumn(3).setResizable(false);
            jtVendas.getColumnModel().getColumn(3).setPreferredWidth(200);
            jtVendas.getColumnModel().getColumn(9).setResizable(false);
            jtVendas.getColumnModel().getColumn(9).setPreferredWidth(200);
        }

        jTabbedPane1.addTab("Vendas Pendentes", jScrollPane1);

        jtItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código Barras", "Produto", "Quantidade", "Valor Unitario", "Valor Total"
            }
        ));
        jScrollPane2.setViewportView(jtItens);

        jTabbedPane1.addTab("Detalhes da Venda", jScrollPane2);

        jScrollPane3.setViewportView(jTabbedPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1)
                        .addGap(4, 4, 4)
                        .addComponent(jtfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jtfData1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3)
                        .addGap(12, 12, 12)
                        .addComponent(jtfData2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jbtPesquisar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(380, 380, 380)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtPago, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(126, Short.MAX_VALUE))
            .addComponent(jScrollPane3)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1))
                    .addComponent(jtfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jLabel2)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jtfData1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jtfData2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jbtPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtPago)
                    .addComponent(jButton3)))
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
        p.setParam1("Não Selecionado");
        this.aux = rctr.validaFiltrosPesq(p);
        this.consultar();
        jtfCPF.setText("");
        jtfData1.setText("");
        jtfData2.setText("");
    }//GEN-LAST:event_jbtPesquisarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jtVendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtVendasMouseClicked
        lin = jtVendas.getSelectedRow();
        cod = Integer.parseInt(jtVendas.getValueAt(lin, 0).toString());
        jtVendas.setSelectionBackground(new Color(220, 220, 220));
        this.consultaItens();
    }//GEN-LAST:event_jtVendasMouseClicked

    private void jbtPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtPagoActionPerformed
        Pesquisa p = new Pesquisa();
        p.setPago(Float.parseFloat(JOptionPane.showInputDialog(null, "Digite o Valor Pago")));
        p.setPendente(Float.parseFloat(jtVendas.getValueAt(lin, 7).toString()) - p.getPago());
        if (p.getPago() - p.getPendente() > 0) {
            p.setParamFloat1(p.getPago() - p.getPendente());
        } else {
            p.setParamFloat1(0);
        }
        RelatorioDAO r = new RelatorioDAO();
        r.baixaVendaPend(cod, p);
        this.consultar();
        this.consultaItens();
    }//GEN-LAST:event_jbtPagoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbtPago;
    private javax.swing.JButton jbtPesquisar;
    private javax.swing.JTable jtItens;
    private javax.swing.JTable jtVendas;
    private javax.swing.JFormattedTextField jtfCPF;
    private javax.swing.JFormattedTextField jtfData1;
    private javax.swing.JFormattedTextField jtfData2;
    // End of variables declaration//GEN-END:variables
}
