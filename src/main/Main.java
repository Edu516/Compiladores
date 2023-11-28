package main;

import analisadores.AnalisadorSintatico;
import base.Automato;
import Grafico.analisadorPanel;
/**
 *
 * @author eduardo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Automato automatoIf = new Automato();
        AnalisadorSintatico analisador = new AnalisadorSintatico(automatoIf);

//        // Testa algumas entradas
//        String entrada1 = "iif where if , + -- else where if else for, foreach iff"; // Inválido
//        String entrada = "(1 a a3 if else";
//        String entrada2 = "(,),[,],{,}";
//        String entrada3 = "+,-,*,/,%,--,++,<,>,<=,>=,^,!=,==,! 999 a99 99a";
//        String entrada4 = "el els else";
//        String entrada5 = "IF ELSE FOR SWITCH WHILE DO PRINT READ FOREACH";
//        analisador.validarEntrada(entrada5);
//        System.out.println(analisador.getTokens().toString());
        
         // Criação e exibição da interface gráfica
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                analisadorPanel panel = new analisadorPanel();
                panel.setVisible(true);
            }
        });
    }

}
