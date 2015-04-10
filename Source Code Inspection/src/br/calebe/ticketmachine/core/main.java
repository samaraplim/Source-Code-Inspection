/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.calebe.ticketmachine.core;

import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;

/**
 *
 * @author SAENE
 */
public class main {
    public static void main(String[] args) throws PapelMoedaInvalidaException, SaldoInsuficienteException {
        
        //criando uma maquina com o valor do bilhete a 5,00
        TicketMachine tm = new TicketMachine(5);

        // inserir 100,00
        tm.inserir(new PapelMoeda(100,1));
       

        //impressao do saldo na tela (e supostamente do bilhete)
        tm.imprimir();

        //calculo e impressao das notas para troco
        Troco tr = tm.getTroco();

         //imprimindo o valor total do troco
        tr.getValorTroco();
        

    }
    
}
