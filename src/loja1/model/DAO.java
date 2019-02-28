package loja1.model;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import loja1.classes.Pesquisa;

public class DAO {

    private final String banco = "loja";
    private final String usuario = "root";
    private final String senha = "";
    public Connection con = null;

    public void abrir() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/" + this.banco,
                    this.usuario, this.senha
            );
        } catch (ClassNotFoundException | SQLException err) {
            JOptionPane.showMessageDialog(null,
                    "Problemas com Banco de Dados:\n" + err.toString());
        }
    }

    public void fechar() throws SQLException {
        con.close();
    }

    //Retorna Id de um Objeto especifico mais utilizado com JCombobox 
    public int returnCodigo(String table, String p, String p1) {
        int num = 0;
        ResultSet rs = null;
        String sql = "select id from " + table + " where " + p + " = " + "'" + p1 + "'";

        try {
            this.abrir();
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                num = rs.getInt("id");
            }

            st.close();
            this.fechar();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Problemas com Banco de Dados:\n"
                    + e.toString());
        }
        return num;
    }

    //Retona uma nome e id de uma pesquisa
    public List<Pesquisa> pesquisa(String tabela, String campo, String txtpesquisa) {
        String sql;

        if (txtpesquisa == null) {
            sql = "select * from " + tabela;
        } else {
            sql = "select * from " + tabela + " where " + campo + " like '%" + txtpesquisa + "%'";
        }
        ResultSet rs = null;
        List list = new ArrayList();

        try {
            this.abrir();
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                if (tabela.equals("categoria") || tabela.equals("marca")) {
                    Pesquisa p = new Pesquisa();
                    p.setParam1(rs.getString("nome"));
                    p.setParamInt1(rs.getInt("cod"));
                    list.add(p);
                }
                if (tabela.equals("pesquisa")) {
                    Pesquisa p = new Pesquisa();
                    p.setParam1(rs.getString("descricao"));
                    p.setParamInt1(rs.getInt("id"));
                    list.add(p);
                }
                if (tabela.equals("fornecedor")) {
                    Pesquisa p = new Pesquisa();
                    p.setParam1(rs.getString("rz_social"));
                    p.setParam2(rs.getString("cnpj"));
                    list.add(p);
                }
                if (tabela.equals("funcionario")) {
                    Pesquisa p = new Pesquisa();
                    p.setParam1(rs.getString("nome"));
                    p.setParamInt1(rs.getInt("id"));
                    list.add(p);
                }
            }
            st.close();
            this.fechar();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Problemas com Banco de Dados:\n"
                    + e.toString());
        }
        return list;
    }

    public void addPesquisa(String txt, String tabela) {

        if (tabela.equals("fornecedor")) {
            JOptionPane.showMessageDialog(null, "Faça o Cadastro de Fornecedor no Formulario do Fornecedor!");
        } else {
            String sql = "INSERT INTO " + tabela + "(nome)" + "VALUES(?)";

            try {
                this.abrir();
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, txt);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null,
                        "Operação realizada com sucesso!");
                ps.close();
                this.fechar();

            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
