package loja1.model;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import loja1.classes.Produto;

/**
 *
 * @author user
 */
public class ProdutoDAO extends DAO {

    private String tabela = "produto";

    public void addProduto(Produto p) {

        String sql = "INSERT INTO " + this.tabela + "(nome,categoria,marca,valor,validade,custo,"
                + "tamanho,fornecedor,codigo_barras) VALUES(?,?,?,?,STR_TO_DATE(?,'%d/%m/%Y'),?,?,?,?)";

        try {
            this.abrir();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, p.getNome());
            ps.setString(2, p.getTipo());
            ps.setString(3, p.getMarca());
            ps.setFloat(4, p.getPreco());
            ps.setString(5, p.getValidade());
            ps.setFloat(6, p.getCusto());
            ps.setString(7, p.getTamanho());
            ps.setString(8, p.getFornecedor());
            ps.setString(9, p.getCodigobarras());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,
                    "Operação realizada com sucesso!");
            ps.close();
            this.fechar();

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Produto> showProduto() {

        ResultSet rs = null;
        String sql = "select id,nome,categoria,marca,valor,DATE_FORMAT(validade,'%d/%m/%Y') as validade,"
                + "custo,tamanho,fornecedor,codigo_barras from " + tabela + " ORDER BY categoria";

        List lista = new ArrayList();

        try {
            this.abrir();
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                Produto p = new Produto();

                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setTipo(rs.getString("categoria"));
                p.setMarca(rs.getString("marca"));
                p.setPreco(rs.getFloat("valor"));
                p.setValidade(rs.getString("validade"));
                p.setCusto(rs.getFloat("custo"));
                p.setTamanho(rs.getString("tamanho"));
                p.setFornecedor(rs.getString("fornecedor"));
                p.setCodigobarras(rs.getString("codigo_barras"));

                lista.add(p);
            }

            st.close();
            this.fechar();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Problemas com Banco de Dados:\n"
                    + e.toString());
        }
        return lista;
    }

    public void deleteProduto(int id) {
        String sql = "DELETE FROM PRODUTO WHERE ID = ?";
        try {
            this.abrir();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            ps.execute();

            ps.close();
            this.fechar();

            JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Problemas com Banco de Dados:\n" + e.toString());
        }
    }

    public void updateProduto(Produto p) {
        String sql = "UPDATE PRODUTO SET nome = ?,validade = STR_TO_DATE(?,'%d/%m/%Y'),marca = ?,"
                + "custo = ?,tamanho = ?, fornecedor =  ?,categoria = ?,valor = ?,codigo_barras = ? "
                + "WHERE id = ?";
        try {
            this.abrir();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, p.getNome());
            ps.setString(7, p.getTipo());
            ps.setString(3, p.getMarca());
            ps.setFloat(8, p.getPreco());
            ps.setString(2, p.getValidade());
            ps.setFloat(4, p.getCusto());
            ps.setString(5, p.getTamanho());
            ps.setString(6, p.getFornecedor());
            ps.setString(9, p.getCodigobarras());
            ps.setInt(10, p.getId());

            ps.executeUpdate();

            ps.close();
            this.fechar();

            JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Problemas com Banco de Dados:\n" + e.toString());
        }
    }

    public List<Produto> showCodigo() {

        ResultSet rs = null;
        String sql = "select * from produto";

        List lista = new ArrayList();

        try {
            this.abrir();
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                Produto p = new Produto();

                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setTipo(rs.getString("categoria"));
                p.setMarca(rs.getString("marca"));
                p.setPreco(rs.getFloat("valor"));
                p.setValidade(rs.getString("validade"));
                p.setCusto(rs.getFloat("custo"));
                p.setTamanho(rs.getString("tamanho"));
                p.setFornecedor(rs.getString("fornecedor"));
                p.setCodigobarras(rs.getString("codigo_barras"));

                lista.add(p);
            }

            st.close();
            this.fechar();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Problemas com Banco de Dados:\n"
                    + e.toString());
        }
        return lista;
    }

}
