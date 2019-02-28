package loja1.classes;

public class Venda {

    private float desconto;
    private int id;
    private int id_funcionario;
    private String nome_produto;
    private String cpf_cliente;
    private String codigo_barras; //Codigo do Produto
    private float pago;
    private float troco;
    private int qtd;   //Quantidade cada iten na venda
    private int qtdTotal;  // Quantidade de Registro na venda linhas da tabela
    private float pendente;
    private float total;
    private float valorProduto; //valor do produto
    private float subTotal;
    private String parcelas;
    private String formaPagamento;
    private String tipo;
    private int nf;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNf() {
        return nf;
    }

    public void setNf(int nf) {
        this.nf = nf;
    }
    public String getParcelas() {
        return parcelas;
    }

    public void setParcelas(String parcelas) {
        this.parcelas = parcelas;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public float getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(float valorProduto) {
        this.valorProduto = valorProduto;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public int getQtdTotal() {
        return qtdTotal;
    }

    public void setQtdTotal(int qtdTotal) {
        this.qtdTotal = qtdTotal;
    }

    public String getCodigo_barras() {
        return codigo_barras;
    }

    public void setCodigo_barras(String codigo_barras) {
        this.codigo_barras = codigo_barras;
    }

    public float getTroco() {
        return troco;
    }

    public void setTroco(float troco) {
        this.troco = troco;
    }

    public float getPago() {
        return pago;
    }

    public void setPago(float pago) {
        this.pago = pago;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getPendente() {
        return pendente;
    }

    public void setPendente(float pendente) {
        this.pendente = pendente;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public String getCpf_cliente() {
        return cpf_cliente;
    }

    public void setCpf_cliente(String cpf_cliente) {
        this.cpf_cliente = cpf_cliente;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float taxa_desconto) {
        this.desconto = taxa_desconto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

}
