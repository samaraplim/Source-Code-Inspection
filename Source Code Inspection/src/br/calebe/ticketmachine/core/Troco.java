package br.calebe.ticketmachine.core;

import java.util.Iterator;

/**
 *
 * @author Calebe de Paula Bianchini
 */
class Troco {

    protected PapelMoeda[] papeisMoeda;
    private int[] notasValidas = {2, 5, 10, 20, 50, 100};
    private int troco;

    public Troco(int valor) {
    this.papeisMoeda = new PapelMoeda[6];
        this.troco = valor;
    }
       

    void calculaTroco() {
        int valor = this.troco;
        int qtde = 0;

        int cont = 0;
        int i = notasValidas.length - 1;
        while (valor != 0) {
            qtde = valor / notasValidas[i];

            if (qtde != 0) {
                valor = valor % notasValidas[i];
                papeisMoeda[cont] = new PapelMoeda(notasValidas[i], qtde);
                cont++;
            }
            i = i - 1;
        }

    }

   
}
