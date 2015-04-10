package br.calebe.ticketmachine.core;

import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import java.util.Iterator;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class TicketMachine {

    protected int valorDoBilhete;
    protected int saldo;
    protected int[] papelMoeda = {2, 5, 10, 20, 50, 100};
    protected Troco troco;

    public TicketMachine(int valor) {
        this.valorDoBilhete = valor;
        this.saldo = 0;
    }

    public void inserir(PapelMoeda quantiaInserida) throws PapelMoedaInvalidaException {
        boolean achou = false;
        for (int i = 0; i < papelMoeda.length && !achou; i++) {
            if (papelMoeda[i] == quantiaInserida.getValor()) {
                achou = true;
            }
        }
        if (achou == false) {
            throw new PapelMoedaInvalidaException("Nota Inválida");
        }
        else{
        
        this.saldo += quantiaInserida.getValor() * quantiaInserida.getQuantidade();
        }
    }    

    public int getSaldo() {
        return this.saldo;
    }

    public Troco getTroco() {
       troco = new Troco(saldo);
        troco.calculaTroco();
        PapelMoeda[] papeisMoedaTroco = troco.getPapapeisMoeda();
        for (int i = 0; i < papeisMoedaTroco.length - 1 && papeisMoedaTroco[i] != null; i++) {
            System.out.println(papeisMoedaTroco[i].getQuantidade() + " nota(s) de " + papeisMoedaTroco[i].getValor());
        }
        return troco;
    }

    public void imprimir() throws SaldoInsuficienteException {
        if (saldo < valorDoBilhete) {
            throw new SaldoInsuficienteException("Não é possivel efetuar a compra, saldo insuficiente");
        }
        String result = "*****************\n";
        
        result += "*** Bilhete comprado com sucesso!*** \n";
        result += "*** Valor do bilhete : R$ " + valorDoBilhete + ",00 ****\n\n";
        
         this.saldo = this.saldo - this.valorDoBilhete;
        
        result += "***  Seu saldo é : ****\n";
        result += "*** R$ " + saldo + ",00 ****\n";
        result += "*****************\n";
        
        this.saldo = this.saldo - this.valorDoBilhete;
        
        System.out.println( result);
    }
}
