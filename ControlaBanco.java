import java.util.ArrayList;

public class ControlaBanco {
    ArrayList<Cliente> clientes;
    ArrayList<Conta> contas;

    public ControlaBanco() {
        this.clientes = new ArrayList<>();
        this.contas = new ArrayList<>();
    }

    public boolean cadastrarCliente(String nome, String cpf, String profissao) {
        for (Cliente cliente : clientes) {
            if (cliente.cpf.equals(cpf)) {
                return false; // Cliente já cadastrado
            }
        }

        Cliente novoCliente = new Cliente(nome, cpf, profissao);
        clientes.add(novoCliente);
        return true;
    }

    public boolean cadastrarConta(String cpf, String numeroConta) {
        for (Cliente cliente : clientes) {
            if (cliente.cpf.equals(cpf)) {
                Conta novaConta = new Conta(cpf, numeroConta);
                contas.add(novaConta);
                return true;
            }
        }
        return false; // Cliente não encontrado
    }

    public boolean realizarDeposito(String numeroConta, double valorDeposito) {
        for (Conta conta : contas) {
            if (conta.numeroConta.equals(numeroConta)) {
                conta.saldo += valorDeposito;
                System.out.println("Depósito realizado com sucesso. Saldo atualizado: " + conta.saldo + " reais");
                return true;
            }
        }
        System.out.println("Conta não encontrada.");
        return false;
    }

    public boolean transferirValores(String contaOrigem, String contaDestino, double valorTransferencia) {
        Conta origem = null;
        Conta destino = null;

        // Procura as contas de origem e destino
        for (Conta conta : contas) {
            if (conta.numeroConta.equals(contaOrigem)) {
                origem = conta;
            }
            if (conta.numeroConta.equals(contaDestino)) {
                destino = conta;
            }
        }

        // Verifica se as contas existem e se há saldo suficiente na conta de origem
        if (origem != null && destino != null && origem.saldo >= valorTransferencia) {
            origem.saldo -= valorTransferencia;
            destino.saldo += valorTransferencia;
            System.out.println("Transferência realizada com sucesso.");
            System.out.println("Saldo atualizado da conta de origem: " + origem.saldo + " reais");
            System.out.println("Saldo atualizado da conta de destino: " + destino.saldo + " reais");
            return true;
        } else {
            System.out.println("Transferência não realizada. Verifique as contas e o saldo disponível.");
            return false;
        }
    }

    public void verificarSaldo(String numeroConta) {
        for (Conta conta : contas) {
            if (conta.numeroConta.equals(numeroConta)) {
                System.out.println("Saldo da conta " + numeroConta + ": " + conta.saldo + " reais");
                return;
            }
        }
        System.out.println("Conta não encontrada");
    }

    public void exibirClientesCadastrados() {
        System.out.println("Clientes cadastrados:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente.nome);
        }
    }
}
