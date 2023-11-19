package base;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eduardo
 */
public class automato {

    private List<estado> estados;
    private estado estadoInicial;

    public automato() {
        estados = new ArrayList<>();
        addTabelaTransicao();
    }

    public void setEstadoInicial(estado e) {
        estadoInicial = e;
    }

    public estado getEstadoInicial() {
        return estadoInicial;
    }

    public List<estado> getEstados() {
        return estados;
    }

    private void addTabelaTransicao() {
        String[] caracteresIgnorados = {""};
        
        estado est = new estado(0, false);
        est.addTransicao(1, "i");
        caracteresIgnorados = new String[]{"i"};
        alfabeto(caracteresIgnorados, est);
        addEstado(est);
        setEstadoInicial(est);

        est = new estado(1, false);
        est.addTransicao(2, "f");
        caracteresIgnorados = new String[]{"f"};
        alfabeto(caracteresIgnorados, est);
        addEstado(est);

        est = new estado(2, true);
        caracteresIgnorados = new String[]{""};
        alfabeto(caracteresIgnorados, est);
        addEstado(est);

        est = new estado(3, true);
        caracteresIgnorados = new String[]{""};
        alfabeto(caracteresIgnorados, est);
        addEstado(est);

        est = new estado(0, false);
        est.addTransicao(1, "i");
    }

    public void alfabeto(String[] ignorados, estado est) {
        String[] alfa = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        for (int i = 0; i < alfa.length; i++) {
            if (!contem(ignorados, alfa[i])) {
                est.addTransicao(3, alfa[i]);
            }
        }
    }

    public void numeros(String[] ignorados, estado est) {
        String[] alfa = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        for (int i = 0; i < alfa.length; i++) {
            if (!contem(ignorados, alfa[i])) {
                est.addTransicao(0, alfa[i]);
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

    public void addEstado(estado est) {
        estados.add(est);
    }

    public String getTipoToken(int cod) {
        switch (cod) {
            case 2:
                return "Palavra Reservada";
            case 3:
                return "ID";
            default:
                return "Não aceita";
        }
    }
}
