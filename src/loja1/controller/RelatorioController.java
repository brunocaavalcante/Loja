package loja1.controller;

import loja1.classes.Pesquisa;

public class RelatorioController extends ClienteController {

    public String validaFiltrosPesq(Pesquisa p) {
        String sql = "";
        int param = 0;
        int erro = 1;

        if (p.getData_ini().equals("__/__/____")) {

        } else {
            param++;
            erro = this.getDataMaior(p.getData_ini(), p.getData_fim());
            if (erro == 0) {
                
                sql = "where cast(v.dt as date) between STR_TO_DATE('" + p.getData_ini() + "','%d/%m/%Y') and STR_TO_DATE('" + p.getData_fim() + "','%d/%m/%Y')";
            }
        }
        if (p.getCpf().equals("___.___.___-__")) {

        } else {
            if (param > 0) {
                erro = this.validaCpfCliente(p.getCpf());
                if (erro == 0) {
                    param++;
                    sql = sql + " and cpf = '" + p.getCpf()+"'";
                }
            } else {
                erro = this.validaCpfCliente(p.getCpf());
                if (erro == 0) {
                    param++;
                    sql = "where cpf = '" + p.getCpf()+"'";
                }
            }
        }
        if (p.getParam1().equals("Não Selecionado")) {

        } else {
            if (param > 0) {
                sql = sql + " and f.nome = '" + p.getParam1()+"'";
            } else {
                sql = "where f.nome = '" + p.getParam1()+"'";
            }
        }
        return sql;

    }

}
