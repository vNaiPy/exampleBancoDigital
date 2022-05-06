import bancodigital.*;

public class Main {
    public static void main(String[] args) {

        Cliente handrei = new Cliente();
        handrei.setNome("Handrei");

        Conta cc = new ContaCorrente(handrei);
        Conta poupanca = new ContaPoupanca(handrei);

        cc.sacar(10);
        cc.depositar(70);
        cc.transferir(60, poupanca);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
    }
}
