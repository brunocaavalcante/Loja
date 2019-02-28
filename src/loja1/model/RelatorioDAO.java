package loja1.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import loja1.classes.Pesquisa;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class RelatorioDAO extends DAO {

    public List<Pesquisa> showVendas(String aux, String tipo) {
        ResultSet rs = null;
        String aux2 = "";
        if (tipo.equals("pendentes")) {
            aux2 = " and i.pendente > 0";
        }
        //Foi colocado as datas

        String sql = "select v.id,f.nome as funcionario,c.nome as cliente,c.cpf,i.total,i.pago,i.troco,i.pendente,"
                + "v.dt as data, i.forma_pagamento from venda as v join "
                + "funcionario as f on f.id = v.id_funcionario join "
                + "cliente as c on v.cpf_cliente = c.cpf join "
                + "itens_vendas as i on v.id = i.nf " + aux + "" + aux2 + " group by i.nf";

        List lista = new ArrayList();

        try {
            this.abrir();
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Pesquisa p = new Pesquisa();
                p.setParamInt1(rs.getInt("id"));
                p.setParam1(rs.getString("funcionario"));
                p.setParam2(rs.getString("cliente"));
                p.setCpf(rs.getString("cpf"));
                p.setParamFloat1(rs.getFloat("total"));
                p.setPago(rs.getFloat("pago"));
                p.setParamFloat2(rs.getFloat("troco"));
                p.setPendente(rs.getFloat("pendente"));
                p.setData_ini(rs.getString("data"));
                p.setForma_pagamento(rs.getString("forma_pagamento"));
                lista.add(p);
            }
            st.close();
            this.fechar();
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public List<Pesquisa> showVendaItens(int cod) {
        ResultSet rs = null;
        String sql = "select i.codigo_barras as codigo, p.nome as produto, i.quantidade as qtd,"
                + "p.valor as valor_unitario,i.total "
                + "from itens_vendas as i "
                + "join produto as p on p.codigo_barras = i.codigo_barras where nf = " + cod;

        List lista = new ArrayList();
        try {
            this.abrir();
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Pesquisa p = new Pesquisa();
                p.setCodigo_barras(rs.getString("codigo"));
                p.setParam1(rs.getString("produto"));
                p.setParamInt1(rs.getInt("qtd"));
                p.setParamFloat1(rs.getFloat("valor_unitario"));
                p.setParamFloat2(rs.getFloat("total"));
                lista.add(p);
            }
            st.close();
            this.fechar();
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public void baixaVendaPend(int cod, Pesquisa p) {
        //atualizando tabela de itens.
        String sql = "update itens_vendas set pendente = ?,pago = ?,troco = ? where nf = '" + cod + "'";
        try {
            this.abrir();
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ps.setFloat(1, p.getPendente());
            ps.setFloat(2, p.getPago());
            ps.setFloat(3, p.getParamFloat1());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!");
            ps.close();
            this.fechar();
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void reportProd() throws JRException {

        try {
            this.abrir();
            JasperReport reporte = null;
            String path = "src\\Reports\\RelatorioIDO.jasper";
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(reporte,null,con);
            JasperViewer view = new JasperViewer(jprint,false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);
            
            this.fechar();
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
