package loja1.controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import loja1.classes.Produto;
import loja1.model.ProdutoDAO;

public class ProdutoController {

    int erro = 0;

    //Função para validar dados do formulario.
    public void validaDados(Produto p, String tipo) {

        if (p.getValidade().equals("")) {
            p.setValidade("01/01/2000");
        }

        ProdutoDAO dao = new ProdutoDAO();
        try {
            List<Produto> lista = (ArrayList) dao.showCodigo();

            for (int i = 0; i < lista.size(); i++) {

                if (p.getCodigobarras().equals(lista.get(i).getCodigobarras())&& tipo.equals("insert")) {
                    erro++;
                    JOptionPane.showMessageDialog(null, "Código de Barras já cadastrado no Sistema");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Problemas com Banco de Dados:\n" + e.toString());
        }
        if (erro == 0) {
            if (tipo.equals("update")) {
                dao.updateProduto(p);
            } else {
                dao.addProduto(p);
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
}
