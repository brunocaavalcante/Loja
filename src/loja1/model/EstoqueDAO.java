package loja1.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import loja1.classes.Venda;

/**
 *
 * @author user
 */
public class EstoqueDAO extends DAO {

    public void entradaProduto(Venda p) {
        String sql = "insert into entrada_produto(codigo_barras,qtd,valor_unitario) values (?,?,?)";

        try {
            this.abrir();
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, p.getCodigo_barras());
            st.setInt(2, p.getQtd());
            st.setFloat(3, p.getValorProduto());
            st.executeUpdate();
            st.close();
            this.fechar();
        } catch (SQLException ex) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void saidaProduto(Venda p) {
        String sql = "insert into saida_produto(codigo_barras,qtd,valor_unitario) values (?,?,?)";

        try {
            this.abrir();
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, p.getCodigo_barras());
            st.setInt(2, p.getQtd());
            st.setFloat(3, p.getValorProduto());
            st.executeUpdate();
            st.close();
            this.fechar();
        } catch (SQLException ex) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
