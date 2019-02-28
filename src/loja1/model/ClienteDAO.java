package loja1.model;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import loja1.classes.Cliente;

/**
 *
 * @author user
 */
public class ClienteDAO extends DAO {

    public void insertCliente(Cliente c) {
        String sql = "insert into cliente(cpf,idade,nome,endereco,telefone,email,sexo) value "
                + "(?,STR_TO_DATE(?,'%d/%m/%Y'),?,?,?,?,?)";
        try {
            this.abrir();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, c.getCpf());
            ps.setString(2, c.getIdade());
            ps.setString(3, c.getNome());
            ps.setString(4, c.getEndereco());
            ps.setString(5, c.getTelefone());
            ps.setString(6, c.getEmail());
            ps.setString(7, c.getSexo());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,
                    "Operação realizada com sucesso!");
            ps.close();
            this.fechar();

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);   
        }
    }

    public void updatePontuacao(float p, String cpf) {
        String sql = "UPDATE CLIENTE SET pontuacao = " + p + " where cpf = " + cpf;
        try {
            this.abrir();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();

            ps.close();
            this.fechar();

            JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Problemas com Banco de Dados:\n" + e.toString());
        }
    }

    public void updateCliente(Cliente c) {
        String sql = "UPDATE CLIENTE SET cpf = ?,nome = ?,IDADE = STR_TO_DATE(?,'%d/%m/%Y'),EMAIL = ?,"
                + "TELEFONE = ?,ENDERECO = ?, SEXO =  ? WHERE id = ?";
        try {
            this.abrir();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, c.getCpf());
            ps.setString(2, c.getNome());
            ps.setString(3, c.getIdade());
            ps.setString(4, c.getEmail());
            ps.setString(5, c.getTelefone());
            ps.setString(6, c.getEndereco());
            ps.setString(7, c.getSexo());
            ps.setInt(8, c.getId());
            ps.executeUpdate();

            ps.close();
            this.fechar();

            JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Problemas com Banco de Dados:\n" + e.toString());
        }
    }

    public void deleteCliente(int id) {
        String sql = "delete from cliente where id = ?";

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

    public List<Cliente> showCliente() {

        ResultSet rs = null;
        String sql = "select id,nome,endereco,telefone,email,DATE_FORMAT(idade,'%d/%m/%Y') as idade,"
                + "email,pontuacao,debitos,sexo,cpf from cliente";

        List lista = new ArrayList();

        try {
            this.abrir();
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                Cliente c = new Cliente();

                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setEndereco(rs.getString("endereco"));
                c.setTelefone(rs.getString("telefone"));
                c.setIdade(rs.getString("idade"));
                c.setEmail(rs.getString("email"));
                c.setPontuacao(rs.getInt("pontuacao"));
                c.setDebitos(rs.getInt("debitos"));
                c.setSexo(rs.getString("Sexo"));

                lista.add(c);
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
