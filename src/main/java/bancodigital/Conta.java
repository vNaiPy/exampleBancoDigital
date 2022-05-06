package bancodigital;

import exceptions.SaldoInsuficienteException;
import exceptions.ValorInvalidoException;
import lombok.Data;

import javax.swing.*;

@Data
public abstract class Conta implements InterfaceConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {

        try{
            if(this.saldo < valor) throw new SaldoInsuficienteException("Saldo insuficiente para sacar");
            this.saldo -= valor;
        } catch(SaldoInsuficienteException e){
            e.printStackTrace();
        }
    }

    @Override
    public void depositar(double valor) {

        try{
            if(valor <= 0) throw new ValorInvalidoException("Valor inválido", valor);
            this.saldo += valor;
        } catch(ValorInvalidoException e){
            e.printStackTrace();
        }
    }

    @Override
    public void transferir(double valor, InterfaceConta contaDestino) {
        try{
            if(this.saldo < valor) throw new SaldoInsuficienteException("Saldo insuficiente para transferir");
            this.sacar(valor);
            contaDestino.depositar(valor);
        } catch(SaldoInsuficienteException e){
            e.printStackTrace();
        }
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }
}
