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
import loja1.classes.Fornecedor;


/**
 *
 * @author user
 */
public class FornecedorDAO extends DAO {

    public void insertFornecedor(Fornecedor f) {

        String sql = "insert into fornecedor(rz_social,cnpj,endereco,telefone,cidade,uf) values(?,?,?,?,?,?)";
        try {
            this.abrir();
            PreparedStatement ps;

            ps = con.prepareStatement(sql);

            ps.setString(1, f.getRazaoSocial());
            ps.setLong(2, f.getCnpj());
            ps.setString(3, f.getEndereco());
            ps.setString(4, f.getTelefone());
            ps.setString(5, f.getCidade());
            ps.setString(6, f.getEstado());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,
                    "Operação realizada com sucesso!");
            ps.close();
            this.fechar();
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    
    public List<Fornecedor> showFornecedor() {

        ResultSet rs = null;
        String sql ="select id,rz_social,telefone,endereco,cnpj,uf,cidade from fornecedor";

        List lista = new ArrayList();

        try {
            this.abrir();
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                Fornecedor f = new Fornecedor();

                f.setId(rs.getInt("id"));
                f.setTelefone(rs.getString("telefone"));
                f.setEndereco(rs.getString("endereco"));
                f.setRazaoSocial(rs.getString("rz_social"));
                f.setCnpj(rs.getLong("cnpj"));
                f.setEstado(rs.getString("uf"));
                f.setCidade(rs.getString("cidade"));
                
                lista.add(f);
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
