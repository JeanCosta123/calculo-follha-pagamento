package models;

/**
 * Classe que calcula o salário com base nas horas trabalhadas e os valores das horas normais e extras.
 */
public class SalarioHora {

    // Atributos que representam o salário base, horas normais, horas extras, valor da hora normal e valor da hora extra

    private double salarioBase;
    private int horasNormais;
    private int horasExtras;
    private double valorHoraNormal;
    private double valorHoraExtra;

    /**
     * Construtor da classe SalarioHora.
     *
     * @param salarioBase     Salário base do funcionário.
     * @param valorHoraNormal Valor da hora normal.
     * @param valorHoraExtra  Valor da hora extra.
     * @param horasNormais    Quantidade de horas trabalhadas no período normal.
     * @param horasExtras     Quantidade de horas extras trabalhadas.
     */
    public SalarioHora(double salarioBase, double valorHoraNormal, double valorHoraExtra, int horasNormais, int horasExtras) {
        this.salarioBase = salarioBase;
        this.valorHoraNormal = valorHoraNormal;
        this.valorHoraExtra = valorHoraExtra;
        this.horasNormais = horasNormais;
        this.horasExtras = horasExtras;
    }

    /**
     * Calcula o salário com base nas horas trabalhadas, valor da hora normal e valor da hora extra.
     *
     * @param horasNormais Quantidade de horas trabalhadas no período normal.
     * @param horasExtras  Quantidade de horas extras trabalhadas.
     * @return O valor do salário com base nas horas trabalhadas.
     */
    public double jornadaTrabalho(int horasNormais, int horasExtras) {

        // Calcula o valor do salário considerando as horas normais e horas extras

        return (horasNormais * valorHoraNormal) + (horasExtras * valorHoraExtra);
    }
}