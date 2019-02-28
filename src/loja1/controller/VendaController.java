package loja1.controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import loja1.classes.Cliente;
import loja1.classes.Produto;
import loja1.classes.Venda;
import loja1.model.ClienteDAO;
import loja1.model.EstoqueDAO;
import loja1.model.ProdutoDAO;
import loja1.model.VendaDAO;
import loja1.view.FmrVenda;

public class VendaController extends VendaDAO {

    //Valida Código de Barras do Produto;
    public int validaCodigoBarras(String codigo) {
        ProdutoDAO dao = new ProdutoDAO();
        int erro = 1;
        List<Produto> lista = (ArrayList) dao.showCodigo();

        for (int i = 0; i < lista.size(); i++) {

            if (codigo.equals(lista.get(i).getCodigobarras())) {
                erro = 0;
            }
        }
        return erro;
    }

    public int validaCpf(Venda v) {
        ClienteDAO d = new ClienteDAO();
        List<Cliente> listCliente = (ArrayList) d.showCliente();

        //Verificando se o CPF do cliente ja esta cadastrado
        for (int i = 0; i < listCliente.size(); i++) {
            if (listCliente.get(i).getCpf().equals(v.getCpf_cliente())) {
                return 0;
            }
        }
        if (v.getTipo().equals("itens")) {
        } else {
            JOptionPane.showMessageDialog(null, "Cpf Não Cadastrado");
        }
        return 1;

    }

    public int Validadados(Venda v, FmrVenda ve, String tabela) {
        int erro = 1;
        VendaDAO dao = new VendaDAO();
        EstoqueDAO es = new EstoqueDAO();

        if (tabela.equals("vendaItens")) {

            v.setTipo("itens");
            erro = this.validaCpf(v);
            erro = this.validaCodigoBarras(v.getCodigo_barras());
            
            if (erro == 0) {
                dao.addVendaItem(v);
                es.saidaProduto(v);
            }

        } else if (tabela.equals("venda")) {
            //Criando a venda
            if (v.getTipo().equals("CriarVenda")) {
                dao.addVenda(v);
            }
            //Atualizando para inserir itens
            if (v.getTipo().equals("update")) {
                v.setTipo("venda");
                erro = this.validaCpf(v);

                if (erro == 0) {
                    dao.addVenda(v);

                    int resposta;
                    resposta = JOptionPane.showConfirmDialog(null, "Deseja imprimir cupom fiscal?", "Escolha um", JOptionPane.YES_NO_OPTION);
                    if (resposta == JOptionPane.YES_OPTION) {

                    } else if (resposta == JOptionPane.NO_OPTION) {

                    }
                    //Fecha tela de Vendas.
                    ve.dispose();
                    return 0;
                }

            }
        }
        return 1;
    }
    
}
