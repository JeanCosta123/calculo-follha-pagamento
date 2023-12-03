package models;

public class DescontoIRRF {

    private double salarioBruto;

    private int numerosDependentes;


    // Deduções e faixas de cálculo do IRRF

    private static final double DEDUCAO_DEPENDENTE = 189.59;
    private static final double CALCULO_1 = 1903.98;
    private static final double CALCULO_2 = 2826.65;
    private static final double CALCULO_3 = 3751.05;
    private static final double CALCULO_4 = 4664.68;

    private static final double ALIQUOTA_2 = 0.075;
    private static final double ALIQUOTA_3 = 0.15;
    private static final double ALIQUOTA_4 = 0.225;
    private static final double ALIQUOTA_5 = 0.275;

    private static final double DEDUCAO_2 = 142.80;
    private static final double DEDUCAO_3 = 354.80;
    private static final double DEDUCAO_4 = 636.13;
    private static final double DEDUCAO_5 = 869.36;

    // Construtor

    public DescontoIRRF(double salarioBruto, int numerosDependentes) {

        this.salarioBruto = salarioBruto;

        this.numerosDependentes = numerosDependentes;

    }

    // Getters e Setters

    public double getSalarioBruto() {

        return salarioBruto;
    }

    public void setSalarioBruto(double salarioBruto) {

        this.salarioBruto = salarioBruto;
    }

    public int getNumerosDependentes() {

        return numerosDependentes;
    }

    public void setNumerosDependentes(int numerosDependentes) {

        this.numerosDependentes = numerosDependentes;
    }

    // Método para calcular o desconto de IRRF

    public double calcularDescontoIRRF() {
        double baseCalculo = calcularBaseCalculo();

        double descontoIRRF = 0;

        if (baseCalculo <= CALCULO_1) {
            descontoIRRF = 0;
        } else if (baseCalculo <= CALCULO_2) {
            descontoIRRF = baseCalculo * ALIQUOTA_2 - DEDUCAO_2;
        } else if (baseCalculo <= CALCULO_3) {
            descontoIRRF = baseCalculo * ALIQUOTA_3 - DEDUCAO_3;
        } else if (baseCalculo <= CALCULO_4) {
            descontoIRRF = baseCalculo * ALIQUOTA_4 - DEDUCAO_4;
        } else {
            descontoIRRF = baseCalculo * ALIQUOTA_5 - DEDUCAO_5;
        }

        return descontoIRRF;
    }

    // Método para calcular a base de cálculo do IRRF

    private double calcularBaseCalculo() {
        return salarioBruto - (numerosDependentes * DEDUCAO_DEPENDENTE);
    }
}