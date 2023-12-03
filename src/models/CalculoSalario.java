package models;

public class CalculoSalario {
    private double valorHora;
    private int cargaHorariaDiaria;
    private int cargaHorariaSemanal;
    private int periodoDescansoMinimo;
    private int periodoDescansoMaximo;

    // CONSTRUTOR

    public CalculoSalario(double valorHora, int cargaHorariaDiaria, int cargaHorariaSemanal, int periodoDescansoMinimo, int periodoDescansoMaximo) {
        this.valorHora = valorHora;
        this.cargaHorariaDiaria = cargaHorariaDiaria;
        this.cargaHorariaSemanal = cargaHorariaSemanal;
        this.periodoDescansoMinimo = periodoDescansoMinimo;
        this.periodoDescansoMaximo = periodoDescansoMaximo;
    }

    // GETTERS E SETTERS

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public int getCargaHorariaDiaria() {
        return cargaHorariaDiaria;
    }

    public void setCargaHorariaDiaria(int cargaHorariaDiaria) {
        this.cargaHorariaDiaria = cargaHorariaDiaria;
    }

    public int getCargaHorariaSemanal() {
        return cargaHorariaSemanal;
    }

    public void setCargaHorariaSemanal(int cargaHorariaSemanal) {
        this.cargaHorariaSemanal = cargaHorariaSemanal;
    }

    public int getPeriodoDescansoMinimo() {
        return periodoDescansoMinimo;
    }

    public void setPeriodoDescansoMinimo(int periodoDescansoMinimo) {
        this.periodoDescansoMinimo = periodoDescansoMinimo;
    }

    public int getPeriodoDescansoMaximo() {
        return periodoDescansoMaximo;
    }

    public void setPeriodoDescansoMaximo(int periodoDescansoMaximo) {
        this.periodoDescansoMaximo = periodoDescansoMaximo;
    }

    // MÉTODO PARA CALCULAR HORAS TRABALHADAS, CONSIDERANDO HORAS NORMAIS E EXTRAS


    public double calcularHorasTrabalhadas(int horasNormais, int horasExtras) {
        int horasComDesconto = horasNormais - calcularHorasDescanso(horasNormais);
        int horasTotais = horasComDesconto + horasExtras;

        return horasTotais;
    }

    // MÉTODO PARA CALCULAR HORAS DE DESCANSO COM BASE NA JORNADA DIÁRIA

    private int calcularHorasDescanso(int horasNormais) {
        if (horasNormais > cargaHorariaDiaria) {
            return Math.min(periodoDescansoMaximo, Math.max(periodoDescansoMinimo, 1));
        } else {
            return 0;
        }
    }
}