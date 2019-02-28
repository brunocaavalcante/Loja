package loja1.controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import loja1.classes.Cliente;
import loja1.model.ClienteDAO;

public class ClienteController extends BaseController {

    public int validaCpf(Cliente c) {
        ClienteDAO dao = new ClienteDAO();
        List<Cliente> listCliente = (ArrayList) dao.showCliente();
        //Verificando se o CPF do cliente ja esta cadastrado
        if (c.getTipo().equals("insert")) {
            for (int i = 0; i < listCliente.size(); i++) {
                if (listCliente.get(i).getCpf().equals(c.getCpf())) {
                    JOptionPane.showMessageDialog(null, "CPF já Cadastrado");
                    return 1;
                }
            }
        }
        if (c.getTipo().equals("update")) {
            for (int i = 0; i < listCliente.size(); i++) {
                if (c.getId() == listCliente.get(i).getId()) {
                    if (c.getCpf().equals(listCliente.get(i).getCpf())) {
                        return 0;
                    }
                } else {
                    if (listCliente.get(i).getCpf().equals(c.getCpf())) {
                        JOptionPane.showMessageDialog(null, "CPF já Cadastrado");
                        return 1;
                    }
                }

            }
        }
        return 0;
    }

    public void validaData(Cliente c, String idade) {
        if (c.equals("__/__/____")) {
            c.setIdade("01/01/2000");
        } else {
            c.setIdade(idade);
        }
    }

    public void validaDados(String idade, Cliente c) {
        ClienteDAO dao = new ClienteDAO();
        int err = 0;
        this.validaData(c, idade);
        err = validaCpf(c);

        if (err == 0) {
            if (c.getTipo().equals("insert")) {
                dao.insertCliente(c);
            } else {
                dao.updateCliente(c);
            }
        }

    }

}
