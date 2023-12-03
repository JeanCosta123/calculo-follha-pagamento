package models;

public class Insalubridade {
    private double salarioBase;
    private boolean exposicaoInsalubre;
    private int grauInsalubre;

    // Construtor

    public Insalubridade(double salarioBase, boolean exposicaoInsalubre, int grauInsalubre) {
        this.salarioBase = salarioBase;
        this.exposicaoInsalubre = exposicaoInsalubre;
        this.grauInsalubre = grauInsalubre;
    }

    // Getters e Setters

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public boolean isExposicaoInsalubre() {
        return exposicaoInsalubre;
    }

    public void setExposicaoInsalubre(boolean exposicaoInsalubre) {
        this.exposicaoInsalubre = exposicaoInsalubre;
    }

    public int getGrauInsalubre() {
        return grauInsalubre;
    }

    public void setGrauInsalubre(int grauInsalubre) {
        this.grauInsalubre = grauInsalubre;
    }

    /**
     * Método para calcular o adicional de insalubridade.
     *
     * @return Valor do adicional de insalubridade com base no grau de exposição.
     */

    public double calcularInsalubridade() {
        if (exposicaoInsalubre) {

            switch (grauInsalubre) {

                case 1:
                    return salarioBase * 0.1; // 10% do salário base para grau 1

                case 2:
                    return salarioBase * 0.2; // 20% do salário base para grau 2

                case 3:
                    return salarioBase * 0.4; // 40% do salário base para grau 3

                default:

                    return 0; // Se o grau não for reconhecido, retorna 0
            }
        } else {

            return 0; // Se não houver exposição insalubre, retorna 0
        }
    }
}