package br.calebe.ticketmachine.exception;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class SaldoInsuficienteException extends Exception {

    public SaldoInsuficienteException(String não_é_possivel_efetuar_a_compra_saldo_ins) {
    super(não_é_possivel_efetuar_a_compra_saldo_ins);  
    }
}
