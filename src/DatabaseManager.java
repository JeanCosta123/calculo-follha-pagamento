import models.Funcionario;
import models.Pagamento;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseManager {

    public static void saveFuncionario(Funcionario funcionario) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:payroll.db");
            if (conn != null) {
                String query = "INSERT INTO Funcionario (nome, sobrenome, data_nascimento, cargo, data_admissao, salario, sexo) VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setString(1, funcionario.getNome());
                pstmt.setString(2, funcionario.getSobrenome());
                pstmt.setString(3, funcionario.getDataNascimento());
                pstmt.setString(4, funcionario.getCargo());
                pstmt.setString(5, funcionario.getDataAdmissao());
                pstmt.setDouble(6, funcionario.getSalario());
                pstmt.setString(7, String.valueOf(funcionario.getSexo()));
                pstmt.executeUpdate();
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void savePagamento(int funcionarioId, Pagamento pagamento) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:payroll.db");
            if (conn != null) {
                String query = "INSERT INTO Pagamento (funcionario_id, data_pagamento, salario_bruto, salario_liquido, valor_periculosidade, valor_insalubridade) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setInt(1, funcionarioId);
                pstmt.setString(2, pagamento.getDataPagamento());
                pstmt.setDouble(3, pagamento.getBruto());
                pstmt.setDouble(4, pagamento.getLiquido());
                pstmt.setDouble(5, pagamento.getValorPericulosidade());
                pstmt.setDouble(6, pagamento.getValorInsalubridade());
                pstmt.executeUpdate();
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}