package br.calebe.ticketmachine.exception;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class PapelMoedaInvalidaException extends Exception {

    public PapelMoedaInvalidaException(String nota_Inválida) {
         
        super(nota_Inválida); 
    }
    
}
