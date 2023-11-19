package main;

import analisadores.AnalisadorSintatico;
import base.automato;

/**
 *
 * @author eduardo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Cria um automato simples para a palavra-chave "if"
        automato automatoIf = new automato();


        // Cria um analisador sintático com o automato
        AnalisadorSintatico analisador = new AnalisadorSintatico(automatoIf);

        // Testa algumas entradas
        String entrada1 = "iif"; // Inválido
        String entrada2 = "where if ";  // Válido
        String entrada3 = "iff"; // Inválido

        analisador.validarEntrada(entrada1);
        System.out.println(analisador.getTokens().toString());
    }

}
