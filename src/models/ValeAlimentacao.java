package models;

public class ValeAlimentacao {

    private double valorDia;
    private double diasTrabalhados;

    // Construtor

    public ValeAlimentacao(double valorDia, double diasTrabalhados) {
        this.valorDia = valorDia;
        this.diasTrabalhados = diasTrabalhados;
    }


    // Getters e Setters
    public double getValorDia() {
        return valorDia;
    }

    public void setValorDia(double valorDia) {
        this.valorDia = valorDia;
    }

    public double getDiasTrabalhados() {
        return diasTrabalhados;
    }

    public void setDiasTrabalhados(double diasTrabalhados) {
        this.diasTrabalhados = diasTrabalhados;
    }

    /**
     * Método para calcular o valor total do vale alimentação.
     *
     * @return Valor total do vale alimentação.
     */

    public double calcularValeAlimentacao() {
        return valorDia * diasTrabalhados;
    }
}