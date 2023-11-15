import java.util.Scanner;

public class SistemaBancario {
    public static void main(String[] args) {
        ControlaBanco banco = new ControlaBanco();
        var scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("------Menu-----");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Cadastrar conta");
            System.out.println("3 - Realizar Depósito");
            System.out.println("4 - Transferir Valores");
            System.out.println("5 - Verificar Saldo");
            System.out.println("6 - Exibir Clientes Cadastrados");
            System.out.println("7 - Sair");
            System.out.print("Escolha a opção desejada: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Nome: ");
                    String nome = scanner.next();
                    System.out.println("CPF: ");
                    String cpf = scanner.next();
                    System.out.print("Profissao: ");
                    String profissao = scanner.next();
                    if (banco.cadastrarCliente(nome, cpf, profissao)) {
                        System.out.println("Cliente cadastrado com sucesso!");
                    } else {
                        System.out.println("CPF já cadastrado. Cliente não cadastrado.");
                    }
                    break;
                case 2:
                    System.out.print("CPF do Cliente: ");
                    String cpfCliente = scanner.next();
                    System.out.print("Número da Conta: ");
                    String numeroConta = scanner.next();
                    if (banco.cadastrarConta(cpfCliente, numeroConta)) {
                        System.out.println("Conta cadastrada com sucesso!");
                    } else {
                        System.out.println("Cliente não encontrado. Conta não cadastrada.");
                    }
                    break;
                case 3:
                    System.out.println("Número da Conta: ");
                    String numContaDeposito = scanner.next();
                    System.out.println("Valor do Depósito: ");
                    double valorDeposito = scanner.nextDouble();
                    banco.realizarDeposito(numContaDeposito, valorDeposito);
                    break;
                case 4:
                    System.out.println("Número da conta de Origem: ");
                    String contaOrigem = scanner.next();
                    System.out.println("Número da conta de Destino: ");
                    String contaDestino = scanner.next();
                    System.out.println("Valor da Transferência: ");
                    double valorTransferencia = scanner.nextDouble();
                    banco.transferirValores(contaOrigem, contaDestino, valorTransferencia);
                    break;
                case 5:
                    System.out.println("Número da conta: ");
                    String numContaSaldo = scanner.next();
                    banco.verificarSaldo(numContaSaldo);
                    break;
                case 6:
                    banco.exibirClientesCadastrados();
                    break;
                case 7:
                    System.out.println("Saindo do sistema.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

        } while (opcao != 7);

        scanner.close();
    }
}