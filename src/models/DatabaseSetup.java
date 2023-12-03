package models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSetup {

    public static void createTables() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:payroll.db");
            if (conn != null) {
                Statement stmt = conn.createStatement();

                // Criação da tabela Funcionario

                String createFuncionarioTable = "CREATE TABLE IF NOT EXISTS Funcionario (" +

                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "nome TEXT NOT NULL," +
                        "sobrenome TEXT NOT NULL," +
                        "data_nascimento TEXT NOT NULL," +
                        "cargo TEXT NOT NULL," +
                        "data_admissao TEXT NOT NULL," +
                        "salario REAL NOT NULL," +
                        "sexo TEXT NOT NULL" +
                        ");";


                // Criação da tabela Pagamento

                String createPagamentoTable = "CREATE TABLE IF NOT EXISTS Pagamento (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "funcionario_id INTEGER," +
                        "data_pagamento TEXT NOT NULL," +
                        "salario_bruto REAL NOT NULL," +
                        "salario_liquido REAL NOT NULL," +
                        "valor_periculosidade REAL NOT NULL," +
                        "valor_insalubridade REAL NOT NULL," +
                        "FOREIGN KEY (funcionario_id) REFERENCES Funcionario(id)" +
                        ");";

                stmt.execute(createFuncionarioTable);
                stmt.execute(createPagamentoTable);
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}