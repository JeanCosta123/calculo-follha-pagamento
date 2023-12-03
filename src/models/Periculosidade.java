package models;

public class Periculosidade {

    private double salarioBase;
    private boolean atividadePerigosa;

    // Construtor

    public Periculosidade(double salarioBase, boolean atividadePerigosa) {
        this.salarioBase = salarioBase;
        this.atividadePerigosa = atividadePerigosa;
    }

    // Getters e Setters

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public boolean isAtividadePerigosa() {
        return atividadePerigosa;
    }

    public void setAtividadePerigosa(boolean atividadePerigosa) {
        this.atividadePerigosa = atividadePerigosa;
    }

    /**
     * Método para calcular o valor adicional de periculosidade.
     *
     * @return O valor adicional de periculosidade baseado na atividade perigosa.
     */

    public double calcularPericulosidade() {

        if (atividadePerigosa) {
            return salarioBase * 0.3;

            // Retorna 30% do salário base como adicional de periculosidade se houver atividade perigosa
        } else {
            return 0;

            // Se não houver atividade perigosa, retorna 0 de adicional de periculosidade
        }
    }
}