package models;

public class SalarioLiquido {

    private double salarioBruto;
    private double descontoINSS;
    private double descontoIRRF;
    private double deducoes;

    // Construtor

    public SalarioLiquido(double salarioBruto, double descontoINSS, double descontoIRRF, double deducoes) {
        this.salarioBruto = salarioBruto;
        this.descontoINSS = descontoINSS;
        this.descontoIRRF = descontoIRRF;
        this.deducoes = deducoes;
    }

    // Getters e Setters

    public double getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public double getDescontoINSS() {
        return descontoINSS;
    }

    public void setDescontoINSS(double descontoINSS) {
        this.descontoINSS = descontoINSS;
    }

    public double getDescontoIRRF() {
        return descontoIRRF;
    }

    public void setDescontoIRRF(double descontoIRRF) {
        this.descontoIRRF = descontoIRRF;
    }

    public double getDeducoes() {
        return deducoes;
    }

    public void setDeducoes(double deducoes) {
        this.deducoes = deducoes;
    }

    /**
     * Método para calcular o salário líquido.
     * Calcula o salário líquido subtraindo as deduções do salário bruto.
     *
     * @return O valor do salário líquido.
     */

    public double calcularSalarioLiquido() {

        double salarioLiquido = salarioBruto - (descontoINSS - descontoIRRF);

        // Subtrai os descontos das deduções do salário bruto

        return salarioLiquido;
    }

    // Método privado utilizado internamente para obter o salário bruto (pode ser expandido no futuro)

    private double salarioBrutoCalculo() {
        return salarioBruto;
    }
}