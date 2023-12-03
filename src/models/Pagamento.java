package models;

public class Pagamento {
    private String data;
    private double bruto;
    private double liquido;
    private double periculosidade;
    private double insalubridade;

    // Construtor
    public Pagamento(String data, double bruto, double liquido, double periculosidade, double insalubridade) {
        this.data = data;
        this.bruto = bruto;
        this.liquido = liquido;
        this.periculosidade = periculosidade;
        this.insalubridade = insalubridade;
    }

    // Getters e Setters
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getBruto() {
        return bruto;
    }

    public void setBruto(double bruto) {
        this.bruto = bruto;
    }

    public double getLiquido() {
        return liquido;
    }

    public void setLiquido(double liquido) {
        this.liquido = liquido;
    }

    public double getPericulosidade() {
        return periculosidade;
    }

    public void setPericulosidade(double periculosidade) {
        this.periculosidade = periculosidade;
    }

    public double getInsalubridade() {
        return insalubridade;
    }

    public void setInsalubridade(double insalubridade) {
        this.insalubridade = insalubridade;
    }

    public String getDataPagamento() {

        return null;
    }

    public double getValorPericulosidade() {

        return 0;
    }

    public double getValorInsalubridade() {

        return 0;

    }
}