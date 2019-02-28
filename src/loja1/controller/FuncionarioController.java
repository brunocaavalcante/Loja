package loja1.controller;

import javax.swing.JOptionPane;
import loja1.classes.Funcionario;
import loja1.model.FuncionarioDAO;

public class FuncionarioController {

    public void validaDados(Funcionario f, String tipo) {
        int erro = 0;
        if (f.getSalario() <= 0) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Salario corretamente!");
            erro++;
        }

        if (f.getIdade().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha a Data de Nascimento corretamente!");
            erro++;
        }
        if (f.getMeta() <= 0) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Meta corretamente!");
            erro++;
        }
        if (erro == 0) {
            FuncionarioDAO fd = new FuncionarioDAO();
            if (tipo.equals("insert")) {
                fd.insertFuncionario(f);
            } else {
                fd.updateFuncionario(f);
            }
        }
    }

    public String validaNumber(String valor) {
        if (valor.equals("")) {
            return "0";
        } else {
            return valor;
        }
    }

    public void excluir(int id) {
        FuncionarioDAO dao = new FuncionarioDAO();
        dao.deleteFuncionario(id);
    }

}
