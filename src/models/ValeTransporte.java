package models;

public class ValeTransporte {
    private double valorRecebido;

    // Construtor

    public ValeTransporte(double valorRecebido){
        this.valorRecebido = valorRecebido;
    }

    // Getters e Setters

    public double getValorRecebido() {
        return valorRecebido;
    }

    public void setValorRecebido(double valorRecebido) {
        this.valorRecebido = valorRecebido;

    }

    /**
     * Método para calcular o desconto do vale transporte.
     *
     * @param salarioBruto Salário bruto do funcionário.
     * @return Valor do desconto do vale transporte.
     *
     */

    public double calcularDesconto(double salarioBruto) {

        // Calcula o limite do valor recebido para o desconto do vale transporte (6% do salário bruto)

        double limiteRecebido = salarioBruto * 0.06;

        // Verifica se o valor recebido é menor que o limite para aplicar o desconto

        if (valorRecebido < limiteRecebido)
        {
            return valorRecebido; // Retorna o valor do vale recebido

        } else {

            return limiteRecebido;

            // Retorna o limite máximo permitido para desconto
        }
    }
}