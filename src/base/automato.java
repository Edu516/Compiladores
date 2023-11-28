package base;

import java.util.ArrayList;
import java.util.List;

public class Automato {

    private List<Estado> estados;
    private Estado estadoInicial;

    public Automato() {
        estados = new ArrayList<>();
        addTabelaTransicao();
    }

    public void setEstadoInicial(Estado estado) {
        estadoInicial = estado;
    }

    public Estado getEstadoInicial() {
        return estadoInicial;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    private void addTabelaTransicao() {
        String[] caracteresIgnorados;

        Estado est = new Estado(0, false);
        //Reservadas
        est.addTransicao(1, "i");
        est.addTransicao(4, "e");
        est.addTransicao(8, "f");
        est.addTransicao(38, "d");
        est.addTransicao(40, "r");
        est.addTransicao(44, "p");
        est.addTransicao(49, "s");
        est.addTransicao(55, "w");
        //Separadores
        est.addTransicao(23, "(");
        est.addTransicao(24, ")");
        est.addTransicao(25, "{");
        est.addTransicao(26, "}");
        est.addTransicao(27, "[");
        est.addTransicao(28, "]");
        //Operadores
        est.addTransicao(20, "^");
        est.addTransicao(17, ">");
        est.addTransicao(15, "<");
        est.addTransicao(13, "+");
        est.addTransicao(12, "%");
        est.addTransicao(9, "-");
        est.addTransicao(21, "!");
        est.addTransicao(19, "*");
        est.addTransicao(11, "/");
        est.addTransicao(35, "=");
        caracteresIgnorados = new String[]{"i", "e","f","d","r","p","s","w"};
        
        alfabeto(caracteresIgnorados, est,3);
        numeros(caracteresIgnorados, est,37);
        addEstado(est);
        setEstadoInicial(est);
        //Constante
        est = new Estado(37, true);
        caracteresIgnorados = new String[]{""};
        alfabeto(caracteresIgnorados, est,3);
        numeros(caracteresIgnorados, est,37);
        addEstado(est);
        //----- Palavras Reservadas ---------
        // IF
        est = new Estado(1, false);
        est.addTransicao(2, "f");
        caracteresIgnorados = new String[]{"f"};
        alfabeto(caracteresIgnorados, est,3);
        numeros(caracteresIgnorados, est,3);
        addEstado(est);

        est = new Estado(2, true);
        caracteresIgnorados = new String[]{""};
        alfabeto(caracteresIgnorados, est,3);
        numeros(caracteresIgnorados, est,3);
        addEstado(est);

        // else
        est = new Estado(4, false);
        est.addTransicao(5, "l");
        caracteresIgnorados = new String[]{"l"};
        alfabeto(caracteresIgnorados, est,3);
        numeros(caracteresIgnorados, est,3);
        addEstado(est);

        est = new Estado(5, false);
        caracteresIgnorados = new String[]{"s"};
        est.addTransicao(6, "s");
        alfabeto(caracteresIgnorados, est,3);
        numeros(caracteresIgnorados, est,3);
        addEstado(est);

        est = new Estado(6, false);
        caracteresIgnorados = new String[]{"e"};
        est.addTransicao(7, "e");
        alfabeto(caracteresIgnorados, est,3);
        numeros(caracteresIgnorados, est,3);
        addEstado(est);

        est = new Estado(7, true);
        caracteresIgnorados = new String[]{""};
        alfabeto(caracteresIgnorados, est,3);
        numeros(caracteresIgnorados, est,3);
        addEstado(est);
        
        // for
        
        est = new Estado(8, false);
        caracteresIgnorados = new String[]{"o"};
        est.addTransicao(29, "o");
        alfabeto(caracteresIgnorados, est,3);
        numeros(caracteresIgnorados, est,3);
        addEstado(est);
        
        est = new Estado(29, false);
        caracteresIgnorados = new String[]{"r"};
        est.addTransicao(30, "r");
        alfabeto(caracteresIgnorados, est,3);
        numeros(caracteresIgnorados, est,3);
        addEstado(est);
        
        est = new Estado(30, true);
        caracteresIgnorados = new String[]{"e"};
        est.addTransicao(31, "e");
        alfabeto(caracteresIgnorados, est,3);
        numeros(caracteresIgnorados, est,3);
        addEstado(est);
        
        //foreach
        
        est = new Estado(31, false);
        caracteresIgnorados = new String[]{"a"};
        est.addTransicao(32, "a");
        alfabeto(caracteresIgnorados, est,3);
        numeros(caracteresIgnorados, est,3);
        addEstado(est);
        
        est = new Estado(32, false);
        caracteresIgnorados = new String[]{"c"};
        est.addTransicao(33, "c");
        alfabeto(caracteresIgnorados, est,3);
        numeros(caracteresIgnorados, est,3);
        addEstado(est);
        
        est = new Estado(33, false);
        caracteresIgnorados = new String[]{"h"};
        est.addTransicao(34, "h");
        alfabeto(caracteresIgnorados, est,3);
        numeros(caracteresIgnorados, est,3);
        addEstado(est);
        
        est = new Estado(34, true);
        caracteresIgnorados = new String[]{""};
        alfabeto(caracteresIgnorados, est,3);
        numeros(caracteresIgnorados, est,3);
        addEstado(est);
        
        //do
        est = new Estado(38, false);
        caracteresIgnorados = new String[]{"o"};
        est.addTransicao(39, "o");
        alfabeto(caracteresIgnorados, est,3);
        numeros(caracteresIgnorados, est,3);
        addEstado(est);
        
        est = new Estado(39, true);
        caracteresIgnorados = new String[]{""};
        alfabeto(caracteresIgnorados, est,3);
        numeros(caracteresIgnorados, est,3);
        addEstado(est);
        
        //read
        est = new Estado(40, false);
        caracteresIgnorados = new String[]{"e"};
        est.addTransicao(41, "e");
        alfabeto(caracteresIgnorados, est,3);
        numeros(caracteresIgnorados, est,3);
        addEstado(est);
        
        est = new Estado(41, false);
        caracteresIgnorados = new String[]{"a"};
        est.addTransicao(42, "a");
        alfabeto(caracteresIgnorados, est,3);
        numeros(caracteresIgnorados, est,3);
        addEstado(est);
        
        est = new Estado(42, false);
        caracteresIgnorados = new String[]{"d"};
        est.addTransicao(43, "d");
        alfabeto(caracteresIgnorados, est,3);
        numeros(caracteresIgnorados, est,3);
        addEstado(est);
        
        est = new Estado(43, true);
        caracteresIgnorados = new String[]{""};
        alfabeto(caracteresIgnorados, est,3);
        numeros(caracteresIgnorados, est,3);
        addEstado(est);
        
        //print
        est = new Estado(44, false);
        caracteresIgnorados = new String[]{"r"};
        est.addTransicao(45, "r");
        alfabeto(caracteresIgnorados, est,3);
        numeros(caracteresIgnorados, est,3);
        addEstado(est);
        
        est = new Estado(45, false);
        caracteresIgnorados = new String[]{"i"};
        est.addTransicao(46, "i");
        alfabeto(caracteresIgnorados, est,3);
        numeros(caracteresIgnorados, est,3);
        addEstado(est);
        
        est = new Estado(46, false);
        caracteresIgnorados = new String[]{"n"};
        est.addTransicao(47, "n");
        alfabeto(caracteresIgnorados, est,3);
        numeros(caracteresIgnorados, est,3);
        addEstado(est);
        
        est = new Estado(47, false);
        caracteresIgnorados = new String[]{"t"};
        est.addTransicao(48, "t");
        alfabeto(caracteresIgnorados, est,3);
        numeros(caracteresIgnorados, est,3);
        addEstado(est);
        
        est = new Estado(48, true);
        caracteresIgnorados = new String[]{""};
        alfabeto(caracteresIgnorados, est,3);
        numeros(caracteresIgnorados, est,3);
        addEstado(est);
        
        //switch
        est = new Estado(49, false);
        caracteresIgnorados = new String[]{"w"};
        est.addTransicao(50, "w");
        alfabeto(caracteresIgnorados, est,3);
        numeros(caracteresIgnorados, est,3);
        addEstado(est);
        
        est = new Estado(50, false);
        caracteresIgnorados = new String[]{"i"};
        est.addTransicao(51, "i");
        alfabeto(caracteresIgnorados, est,3);
        numeros(caracteresIgnorados, est,3);
        addEstado(est);
        
        est = new Estado(51, false);
        caracteresIgnorados = new String[]{"t"};
        est.addTransicao(52, "t");
        alfabeto(caracteresIgnorados, est,3);
        numeros(caracteresIgnorados, est,3);
        addEstado(est);
        
        est = new Estado(52, false);
        caracteresIgnorados = new String[]{"c"};
        est.addTransicao(53, "c");
        alfabeto(caracteresIgnorados, est,3);
        numeros(caracteresIgnorados, est,3);
        addEstado(est);
        
        est = new Estado(53, false);
        caracteresIgnorados = new String[]{"h"};
        est.addTransicao(54, "h");
        alfabeto(caracteresIgnorados, est,3);
        numeros(caracteresIgnorados, est,3);
        addEstado(est);
        
        est = new Estado(54, true);
        caracteresIgnorados = new String[]{""};
        alfabeto(caracteresIgnorados, est,3);
        numeros(caracteresIgnorados, est,3);
        addEstado(est);
        
        //WHILE
        est = new Estado(55, false);
        caracteresIgnorados = new String[]{"h"};
        est.addTransicao(56, "h");
        alfabeto(caracteresIgnorados, est,3);
        numeros(caracteresIgnorados, est,3);
        addEstado(est);
        
        est = new Estado(56, false);
        caracteresIgnorados = new String[]{"i"};
        est.addTransicao(57, "i");
        alfabeto(caracteresIgnorados, est,3);
        numeros(caracteresIgnorados, est,3);
        addEstado(est);
        
        est = new Estado(57, false);
        caracteresIgnorados = new String[]{"l"};
        est.addTransicao(58, "l");
        alfabeto(caracteresIgnorados, est,3);
        numeros(caracteresIgnorados, est,3);
        addEstado(est);
        
        est = new Estado(58, false);
        caracteresIgnorados = new String[]{"e"};
        est.addTransicao(59, "e");
        alfabeto(caracteresIgnorados, est,3);
        numeros(caracteresIgnorados, est,3);
        addEstado(est);
        
        est = new Estado(59, true);
        caracteresIgnorados = new String[]{""};
        alfabeto(caracteresIgnorados, est,3);
        numeros(caracteresIgnorados, est,3);
        addEstado(est);
        
        //-- Fim palavras reservadas--------

        //---- Operadores -----------
        est = new Estado(20, true);
        addEstado(est);

        est = new Estado(17, true);
        est.addTransicao(18, "=");
        addEstado(est);

        est = new Estado(15, true);
        est.addTransicao(16, "=");
        addEstado(est);

        est = new Estado(13, true);
        est.addTransicao(14, "+");
        addEstado(est);

        est = new Estado(12, true);
        addEstado(est);

        est = new Estado(9, true);
        est.addTransicao(10, "-");
        addEstado(est);

        est = new Estado(21, true);
        est.addTransicao(22, "=");
        addEstado(est);

        est = new Estado(19, true);
        addEstado(est);

        est = new Estado(11, true);
        addEstado(est);

        est = new Estado(35, true);
        est.addTransicao(36, "=");
        addEstado(est);

        est = new Estado(36, true);
        addEstado(est);

        est = new Estado(18, true);
        addEstado(est);

        est = new Estado(16, true);
        addEstado(est);

        est = new Estado(14, true);
        addEstado(est);

        est = new Estado(12, true);
        addEstado(est);

        est = new Estado(10, true);
        addEstado(est);

        est = new Estado(22, true);
        addEstado(est);

        //--- Fim Operadores --------
        //---- Separadores -----------
        est = new Estado(23, true);
        addEstado(est);

        est = new Estado(24, true);
        addEstado(est);

        est = new Estado(25, true);
        addEstado(est);

        est = new Estado(26, true);
        addEstado(est);

        est = new Estado(27, true);
        addEstado(est);

        est = new Estado(28, true);
        addEstado(est);

        //--- Fim Separadores --------
        // ID
        est = new Estado(3, true);
        caracteresIgnorados = new String[]{""};
        alfabeto(caracteresIgnorados, est,3);
        numeros(caracteresIgnorados, est, 3);
        addEstado(est);

        est = new Estado(0, false);
        est.addTransicao(1, "i");
    }

    public void alfabeto(String[] ignorados, Estado est, int cod) {
        String[] alfa = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        for (String letra : alfa) {
            if (!contem(ignorados, letra)) {
                est.addTransicao(cod, letra);
            }
        }
    }

    public void numeros(String[] ignorados, Estado est, int cod) {
        String[] numeros = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        for (String numero : numeros) {
            if (!contem(ignorados, numero)) {
                est.addTransicao(cod, numero);
            }
        }
    }

    private boolean contem(String[] array, String elemento) {
        for (String str : array) {
            if (str.equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    public void addEstado(Estado estado) {
        estados.add(estado);
    }

    public String getTipoToken(int cod) {
        switch (cod) {
            case 2:
                return "Palavra Reservada - IF";
            case 3:
                return "ID";
            case 7:
                return "Palavra Reservada - ELSE";
            case 30:
                return "Palavra Reservada - FOR";
            case 34:
                return "Palavra Reservada - FOREACH";
            case 39:
                return "Palavra Reservada - DO";
            case 43:
                return "Palavra Reservada - READ";
            case 48:
                return "Palavra Reservada - PRINT";
            case 54:
                return "Palavra Reservada - SWITCH";
            case 59:
                return "Palavra Reservada - WHILE";
            case 23:
                return "Separador - Abre Parênteses";
            case 24:
                return "Separador - Fecha Parênteses";
            case 25:
                return "Separador - Abre Chaves";
            case 26:
                return "Separador - Fecha Chaves";
            case 27:
                return "Separador - Abre Colchetes";
            case 28:
                return "Separador - Fecha Colchetes";
            case 17:
                return "Operador - Maior que";
            case 15:
                return "Operador - Menor que";
            case 13:
                return "Operador - Soma";
            case 12:
                return "Operador - Módulo";
            case 9:
                return "Operador - Subtração";
            case 21:
                return "Operador - Negação";
            case 19:
                return "Operador - Multiplicação";
            case 11:
                return "Operador - Divisão";
            case 35:
                return "Operador - Atribuição";
            case 20:
                return "Operador - Elevado";
            case 36:
                return "Operador - Equivalente";
            case 18:
                return "Operador - Maior ou Igual";
            case 16:
                return "Operador - Menor ou Igual";
            case 14:
                return "Operador - Icrementar";
            case 10:
                return "Operador - Decrementar";
            case 22:
                return "Operador - Diferente";
            case 37:
                return "Constante";

            default:
                return "Não aceita";
        }
    }
}
