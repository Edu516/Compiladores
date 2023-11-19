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

    public void adicionarEstado(estado e) {
        estados.add(e);
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
        // Crie estados
        estado est = new estado(0, false);
        est.addTransicao(1, "i");
        addEstado(est);
        setEstadoInicial(est);
        
        est = new estado(1, false);
        est.addTransicao(2, "f");
        addEstado(est);
        
        est = new estado(2, true);
        String[] caracteresIgnorados = {""};
        alfabeto(caracteresIgnorados, est);
        addEstado(est);
        
        // Adicione estados ao autômato
        adicionarEstado(est);

        est = new estado(0, false);
        est.addTransicao(1, "i");

    }

    public void alfabeto(String[] ignora, estado est) {
        String[] alfa = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        for (int i = 0; i < alfa.length; i++) {
            if (!alfa.equals(ignora)) {
                est.addTransicao(0, alfa[i]);
            }
        }
    }

    public void numeros(String[] ignora, estado est) {
        String[] alfa = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        for (int i = 0; i < alfa.length; i++) {
            if (!alfa.equals(ignora)) {
                est.addTransicao(0, alfa[i]);
            }
        }
    }

    public void addEstado(estado est ) {
        estados.add(est);
    }
    
    public String getTipoToken(int cod){
        switch (cod) {
            case 2:
                return "Palavra Reservada";
            default:
                return "Não aceita";
        }
    }
}
