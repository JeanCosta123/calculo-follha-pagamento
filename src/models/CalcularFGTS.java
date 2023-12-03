package models;

public class CalcularFGTS {
    private double salarioBruto;

    // CONSTRUTOR

    public CalcularFGTS(double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    // GETTERS E SETTERS

    public double getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    // MÉTODO PARA CÁLCULO DO FGTS


    public double calcularFGTS() {
        return salarioBruto * 0.08; // Retorna 8% do salário bruto como FGTS
    }
}