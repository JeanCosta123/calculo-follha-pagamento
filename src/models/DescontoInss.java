package models;

public class DescontoInss {

    private double salarioBruto;

    public DescontoInss(double salarioBruto){
        this.salarioBruto = salarioBruto;
    }

    // get e set

    public double getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    // calcular desconto inss


    public double calcularINSS() {

        if (salarioBruto <= 1302.00) {
            return salarioBruto * 0.075;

        } else if (salarioBruto <= 2571.29) {
            return salarioBruto * 0.09;

        } else if (salarioBruto <= 3856.94) {
            return salarioBruto * 0.12;

        } else if (salarioBruto <= 7507.47) {
            return salarioBruto * 0.14;

        } else {
            return 7507.49 * 0.14;
        }
    }
}