import models.*;
import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * Classe principal para o sistema de gerenciamento de folha de pagamento.
 */

public class Main {

    /**
     * Método principal que inicia o programa.
     *
     * @param args Argumentos de linha de comando (não utilizados neste contexto)
     *
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita informações pessoais do funcionário

        String nome = getValidStringInput("Digite o nome do funcionário:", scanner);

         String sobrenome = getValidStringInput("Digite o sobrenome do funcionário:", scanner);

            String dataNascimento = getValidStringInput("Digite a data de nascimento do funcionário:", scanner);

                String cargo = getValidStringInput("Digite o cargo do funcionário:", scanner);

                    String dataAdmissao = getValidStringInput("Digite a data de admissão do funcionário:", scanner);

                         String mesReferencia = getValidStringInput("Digite o mês de referência:", scanner);

                            double salario = getValidDoubleInput("Digite o salário do funcionário:", scanner);

                                char sexo = getValidSexInput(scanner);


        // Criação do objeto Funcionario com os dados fornecidos

        DescontoInss descontoInss = new DescontoInss(salario);

          Funcionario funcionario = new Funcionario(nome, sobrenome, dataNascimento, salario, sexo);

            funcionario.setCargo(cargo);

              funcionario.setDataAdmissao(dataAdmissao);

                 funcionario.setMesReferencia(mesReferencia);


        System.out.println("\nCálculo da Folha de Pagamento");

        // Obtendo informações de horas trabalhadas e dependentes

          int horasNormais = getValidIntInput("Digite o número de horas trabalhadas no mês:", scanner);

              int horasExtras = getValidIntInput("Digite o número de horas extras trabalhadas no mês:", scanner);

                 int dependentes = getValidIntInput("Digite o número de dependentes para cálculo do IRRF:", scanner);

        // Cálculos de salário, descontos e benefícios


        SalarioHora salarioHora = new SalarioHora(funcionario.getSalario(), 8.0, 10.0, horasNormais, horasExtras);

        double valorSalarioHora = salarioHora.jornadaTrabalho(horasNormais, horasExtras);

        CalculoSalario calculoSalario = new CalculoSalario(funcionario.getSalario(), 8, 40, 1, 2);

        DescontoIRRF descontoIRRF = new DescontoIRRF(funcionario.getSalario(), dependentes);

        CalcularFGTS calcularFGTS = new CalcularFGTS(funcionario.getSalario());

        Insalubridade insalubridade = new Insalubridade(funcionario.getSalario(), true, 2);

        Periculosidade periculosidade = new Periculosidade(funcionario.getSalario(), true);

        double valorInsalubridade = insalubridade.calcularInsalubridade();

        double valorPericulosidade = periculosidade.calcularPericulosidade();

        double salarioLiquido = funcionario.getSalario() - calculoSalario.calcularHorasTrabalhadas(horasNormais, horasExtras)
                + descontoIRRF.calcularDescontoIRRF() + calcularFGTS.calcularFGTS() + valorInsalubridade + valorPericulosidade + valorSalarioHora;

        // Criando o objeto Pagamento com os valores calculados

        Pagamento pagamento = new Pagamento("01/12/2023", funcionario.getSalario(), salarioLiquido, valorPericulosidade, valorInsalubridade);

        // Armazenando dados no banco de dados

        DatabaseManager.saveFuncionario(funcionario);

        DatabaseManager.savePagamento(funcionario.getId(), pagamento);

        funcionario.adicionarPagamento(pagamento);

        // Exibindo a folha de pagamento gerada

        DecimalFormat df = new DecimalFormat("#,##0.00");

        System.out.println("\nFolha de Pagamento Gerada:");

        System.out.println("Nome: " + funcionario.getNome() + " " + funcionario.getSobrenome());

        System.out.println("Cargo: " + funcionario.getCargo());

        System.out.println("Data de Admissão: " + horasNormais);

        System.out.println("Mês de Referência: " + funcionario.getMesReferencia());

        System.out.println("Salário Bruto: " + df.format(pagamento.getBruto()));

        System.out.println("Salário Líquido: " + df.format(pagamento.getLiquido()));

        System.out.println("FGTS: " + df.format(calcularFGTS.calcularFGTS()));

        System.out.println("Desconto INSS: " + df.format(descontoInss.calcularINSS()));

        System.out.println("Desconto IRRF: " + df.format(descontoIRRF.calcularDescontoIRRF()));

        System.out.println("Valor de Insalubridade: " + df.format(valorInsalubridade));

        System.out.println("Valor de Periculosidade: " + df.format(valorPericulosidade));

        System.out.println("Salário por Hora: " + df.format(valorSalarioHora));

        System.out.println("Pagamento de vale alimentação: " + df.format(new ValeAlimentacao(20, 20).calcularValeAlimentacao()));

        System.out.println("Desconto do vale transporte: " + df.format(new ValeTransporte(100).calcularDesconto(funcionario.getSalario())));

        scanner.close();
    }

    // Métodos para entrada de dados validados

    /**
     * Método para obter entrada de string válida do usuário.
     *
     * @param message Mensagem a ser exibida ao solicitar a entrada
     * @param scanner Objeto Scanner para obter entrada do usuário
     * @return String válida inserida pelo usuário
     */
    private static String getValidStringInput(String message, Scanner scanner) {
        System.out.println(message);
        return scanner.nextLine();
    }

    /**
     * Método para obter entrada de número inteiro válido do usuário.
     *
     * @param message Mensagem a ser exibida ao solicitar a entrada
     * @param scanner Objeto Scanner para obter entrada do usuário
     * @return Número inteiro válido inserido pelo usuário
     */
    private static int getValidIntInput(String message, Scanner scanner) {
        int value = 0;
        while (value <= 0) {
            System.out.println(message);
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
            } else {
                System.out.println("Por favor, digite um valor numérico válido.");
                scanner.next(); // Limpa o buffer
            }
        }
        return value;
    }

    /**
     * Método para obter entrada de número decimal válido do usuário.
     *
     * @param message Mensagem a ser exibida ao solicitar a entrada
     * @param scanner Objeto Scanner para obter entrada do usuário
     * @return Número decimal válido inserido pelo usuário
     */
    private static double getValidDoubleInput(String message, Scanner scanner) {
        double value = 0;
        while (value <= 0) {
            System.out.println(message);
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
            } else {
                System.out.println("Por favor, digite um valor decimal válido.");
                scanner.next(); // Limpa o buffer
            }
        }
        return value;
    }

    /**
     * Método para obter entrada de sexo válido do usuário (M ou F).
     *
     * @param scanner Objeto Scanner para obter entrada do usuário
     * @return Sexo válido inserido pelo usuário
     */
    private static char getValidSexInput(Scanner scanner) {
        char sexo = ' ';
        while (sexo != 'M' && sexo != 'F') {
            System.out.println("Digite o sexo do funcionário (M/F):");
            String inputSexo = scanner.next();
            if (inputSexo.length() == 1) {
                sexo = inputSexo.charAt(0);
            } else {
                System.out.println("Por favor, digite apenas 'M' ou 'F'.");
            }
        }
        return sexo;
    }
}