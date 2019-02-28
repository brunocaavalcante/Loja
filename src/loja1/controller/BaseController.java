//Classe destinada a metodos que podem ser usados em todas as classes
package loja1.controller;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import loja1.classes.Cliente;
import loja1.model.ClienteDAO;
import loja1.model.DAO;

public class BaseController extends DAO {

    //Usado para se o usuario não colocar nada no jtf não gere um erro quando for converter para number
    public String validaNumber(String valor) {
        if (valor.equals("")) {
            return "0";
        } else {
            return valor;
        }
    }

    public String validaMoeda(String s) {
        char letra = s.charAt(0);
        int ponto = 0;
        //Verifica se o numero e negativo
        if (letra == '-') {
            s = s.replace("-", "");
            letra = s.charAt(0);

        }
        // Verifica se o textfiel mandou formato moeda = R$ 10,00 ou o usuario digitou um numero exemplo = 10 
        // Caso mandou um numero convertemos para moeda
        if (letra != 'R') {
            Double ax = Double.parseDouble(s);
            //pegando o valor da moedal local do pais para depois formatar os campos que vao exibir
            Locale locale = new Locale("pt", "BR");
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
            s = "" + currencyFormatter.format(ax);
        }

        //Recebemos a String no seguinte Formato R$ X.XXX,XX e Separandob retorna X.XXX,XX
        String aux = s.substring(3);

        //Verificado o numero de pontos para retorna um valor aceitavel para o number X.XXX.XXX,XX retona XXXXXXX,XX
        for (int i = 0; i < aux.length(); i++) {
            if (aux.charAt(i) == '.') {
                ponto++;
            }
        }
        if (ponto > 0) {
            aux = aux.replace(".", "");
        }
        /*Troca a virgula pelo ponto para depois ser formatado no formato Decimal XXXXXXX,XX retorna XXXXXXX.XX pois
        uma variavel tipo double não aceita a seguinte atribuição: variavel = 1.500.000.00; o formato correto: variavel = 1500.00*/

        String valorComVirgula = aux;
        String valorComPonto = valorComVirgula.replace(',', '.');
        return valorComPonto + "";

    }

    //Usado para setar jtf no formato moeda
    public String convertMoeda(Float num) {
        String s;
        Locale locale = new Locale("pt", "BR");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        s = "" + currencyFormatter.format(num);
        return s;
    }

    public int validaCpfCliente(String cpf) {
        ClienteDAO d = new ClienteDAO();
        List<Cliente> listCliente = (ArrayList) d.showCliente();

        //Verificando se o CPF do cliente ja esta cadastrado
        for (int i = 0; i < listCliente.size(); i++) {
            if (listCliente.get(i).getCpf().equals(cpf)) {
                return 0;
            }
        }
        JOptionPane.showMessageDialog(null, "Cpf Não Cadastrado");
        return 1;

    }

    //Verifica qual a data maior.
    public int getDataMaior(String data, String data1) {
        int i = data.compareTo(data1);
        //se i > 0 a primeira maior que a segunda
        //se i < 0 a primeira menor que a segunda
        //se i == 0 as duas são iguais
        if (i > 0) {
            JOptionPane.showMessageDialog(null, "A data de inicio não pode se maior que a de fim");
            return 1;
        }

        return 0;
    }

    public int validaData(String dt) {
        if (dt.equals("__/__/____")) {
            JOptionPane.showMessageDialog(null, "Preencha a data corretamente");
            return 1;
        }
        return 0;
    }
}
