package loja1.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import loja1.classes.Produto;
import loja1.classes.Venda;

public class VendaDAO extends DAO {

    //Mostrar produtos que estão sendo adicionados para a compra
    public Produto showProdutoV(String id) throws SQLException {

        ResultSet rs = null;
        String sql = "select id,codigo_barras,nome,valor from produto where codigo_barras = " + id;

        this.abrir();

        PreparedStatement st = con.prepareStatement(sql);
        rs = st.executeQuery(sql);
        Produto p = null;
        if (rs != null) {
            p = new Produto();

            while (rs.next()) {

                p.setNome(rs.getString("nome"));
                p.setCodigobarras(rs.getString("codigo_barras"));
                p.setPreco(rs.getFloat("valor"));
                p.setId(rs.getInt("id"));

            }
            st.close();
            this.fechar();

        }
        return p;
    }

    //Insert tabela VendaItens
    public void addVendaItem(Venda v) {

        String sql = "INSERT INTO  itens_vendas(desconto,id_funcionario,cpf_cliente,quantidade,pendente,total,pago,troco,codigo_barras,quantidadeTotal"
                + ",parcelas,forma_pagamento,nf"
                + ") VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            this.abrir();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setFloat(1, v.getDesconto());
            ps.setInt(2, v.getId_funcionario());
            ps.setString(3, v.getCpf_cliente());
            ps.setInt(4, v.getQtd());
            ps.setFloat(5, v.getPendente());
            ps.setFloat(6, v.getTotal());
            ps.setFloat(7, v.getPago());
            ps.setFloat(8, v.getTroco());
            ps.setString(9, v.getCodigo_barras());
            ps.setFloat(10, v.getQtdTotal());
            ps.setString(11, v.getParcelas());
            ps.setString(12, v.getFormaPagamento());
            ps.setInt(13, v.getNf());

            ps.executeUpdate();
            ps.close();
            this.fechar();

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Insert Tabela Venda
    public void addVenda(Venda v) {
        String sql = null;

        if (v.getTipo().equals("CriarVenda")) {
            sql = "insert into venda(id_funcionario,cpf_cliente,total) values (?,?,?)";
        } else {
            sql = "update venda set id_funcionario = ?,cpf_cliente = ?,total = ? where id = "+v.getNf();
        }
        try {
            this.abrir();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, v.getId_funcionario());
            ps.setString(2, v.getCpf_cliente());
            ps.setFloat(3, v.getTotal());
            ps.executeUpdate();
            if (v.getTipo().equals("update")) {
                JOptionPane.showMessageDialog(null, "Venda Concluida!");
            }
            ps.close();
            this.fechar();

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int returnIdVenda() {
        String sql = "select max(id) as id from venda";
        this.abrir();
        ResultSet rs = null;
        PreparedStatement st;
        int id = 0;
        try {
            st = con.prepareStatement(sql);
            rs = st.executeQuery(sql);

            if (rs != null) {

                while (rs.next()) {
                    id = rs.getInt("id");
                }
            }
            st.close();
            this.fechar();
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

}


