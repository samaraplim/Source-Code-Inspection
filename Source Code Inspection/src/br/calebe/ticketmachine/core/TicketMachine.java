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

    public void inserir(int quantiaInserida) throws PapelMoedaInvalidaException {
        boolean achou = false;
        for (int i = 0; i < papelMoeda.length && !achou; i++) {
            if (papelMoeda[1] == quantiaInserida) {
                achou = true;
            }
        }
        if (!achou) {
            throw new PapelMoedaInvalidaException("Nota Inválida");
        }
        else{
        
        this.saldo += quantiaInserida;
        }
    }    

    public int getSaldo() {
        return this.saldo;
    }

    public Troco getTroco() {
       troco = new Troco(saldo);
        troco.calculaNotas();
        return troco;
    }

    public void imprimir() throws SaldoInsuficienteException {
        if (saldo < valorDoBilhete) {
            throw new SaldoInsuficienteException();
        }
        String result = "*****************\n";
        result += "*** R$ " + saldo + ",00 ****\n";
        result += "*****************\n";
        
        this.saldo = this.saldo - this.valorDoBilhete;
        System.out.println( result);
    }
}
