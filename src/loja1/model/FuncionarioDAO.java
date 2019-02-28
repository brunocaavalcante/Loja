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
import loja1.classes.Funcionario;

public class FuncionarioDAO extends DAO {

    public void insertFuncionario(Funcionario f) {
        String sql = "insert into funcionario(login,hierarquia,meta,salario,nome,telefone,"
                + "idade,sexo,senha) value (?,?,?,?,?,?,STR_TO_DATE(?,'%d/%m/%Y'),?,?)";

        try {
            this.abrir();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, f.getLogin());
            ps.setString(2, f.getHierarquia());
            ps.setDouble(3, f.getMeta());
            ps.setDouble(4, f.getSalario());
            ps.setString(5, f.getNome());
            ps.setString(6, f.getTelefone());
            ps.setString(7, f.getIdade());
            ps.setString(8, f.getSexo());
            ps.setString(9, f.getSenha());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,
                    "Operação realizada com sucesso!");
            ps.close();
            this.fechar();

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void updatePontuacao(float p, int id) {
        String sql = "UPDATE funcionario SET pontuacao = " + p + " where cpf = " + id;
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


    public List<Funcionario> showFuncionario() {

        ResultSet rs = null;
        String sql = "select id,nome,telefone,DATE_FORMAT(idade,'%d/%m/%Y') as idade,"
                + "pontuacao,hierarquia,login,senha,meta,sexo,salario from funcionario";

        List lista = new ArrayList();

        try {
            this.abrir();
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                Funcionario f = new Funcionario();

                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setHierarquia(rs.getString("hierarquia"));
                f.setTelefone(rs.getString("telefone"));
                f.setSalario(rs.getDouble("salario"));
                f.setIdade(rs.getString("idade"));
                f.setSexo(rs.getString("sexo"));
                f.setMeta(rs.getDouble("meta"));
                f.setSenha(rs.getString("senha"));
                f.setLogin(rs.getString("login"));
                f.setPontuacao(rs.getInt("pontuacao"));

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

    public void deleteFuncionario(int id) {
        String sql = "DELETE FROM FUNCIONARIO WHERE ID = ?";
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

    public void updateFuncionario(Funcionario f) {
        String sql = "UPDATE FUNCIONARIO SET nome = ?,IDADE = STR_TO_DATE(?,'%d/%m/%Y'),TELEFONE = ?,"
                + "HIERARQUIA = ?,META = ?, SALARIO =  ?,SEXO = ?,LOGIN = ?,SENHA = ? "
                + "WHERE id = ?";
        try {
            this.abrir();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, f.getNome());
            ps.setString(2, f.getIdade());
            ps.setString(3, f.getTelefone());
            ps.setString(4, f.getHierarquia());
            ps.setDouble(5, f.getMeta());
            ps.setDouble(6, f.getSalario());
            ps.setString(7, f.getSexo());
            ps.setString(8, f.getLogin());
            ps.setString(9, f.getSenha());
            ps.setInt(10, f.getId());

            ps.executeUpdate();

            ps.close();
            this.fechar();

            JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Problemas com Banco de Dados:\n" + e.toString());
        }
    }

}
