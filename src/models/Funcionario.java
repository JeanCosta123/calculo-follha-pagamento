package models;

import java.util.ArrayList;
import java.util.List;

public class Funcionario {
    private String nome;
    private String sobrenome;
    private String dataNascimento;
    private double salario;
    private char sexo;
    private String cargo;
    private String dataAdmissao;
    private String mesReferencia;
    private List<Pagamento> pagamentos;

    // CONSTRUTOR

    public Funcionario(String nome, String sobrenome, String dataNascimento, double salario, char sexo) {

         this.nome = nome;
            this.sobrenome = sobrenome;
                 this.sexo = sexo;
                     this.dataNascimento = dataNascimento;this.salario = salario;
                        this.cargo = cargo;
                             this.dataAdmissao = dataAdmissao;
                                 this.mesReferencia = mesReferencia;
                                    this.pagamentos = new ArrayList<>();

    }

    // GETTERS E SETTERS

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(String dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getMesReferencia() {
        return mesReferencia;
    }

    public void setMesReferencia(String mesReferencia) {
        this.mesReferencia = mesReferencia;
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    // Adiciona um pagamento à lista de pagamentos do funcionário

    public void adicionarPagamento(Pagamento pagamento) {
        pagamentos.add(pagamento);
    }

    public int getId() {

        return 0;
    }
}