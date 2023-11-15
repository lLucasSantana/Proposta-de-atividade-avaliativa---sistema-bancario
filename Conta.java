public class Conta {
    String cpfCliente;
    String numeroConta;
    double saldo;

    public Conta(String cpfCliente, String numeroConta) {
        this.cpfCliente = cpfCliente;
        this.numeroConta = numeroConta;
        this.saldo = 0.0;
    }
}
