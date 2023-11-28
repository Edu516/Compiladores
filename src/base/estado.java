package base;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eduardo
 */
public class Estado {
    private int cod;
    private boolean fim;
    private List<transicao> transicoes;

    public Estado(int cod, boolean fim) {
        this.cod = cod;
        this.fim = fim;
        this.transicoes = new ArrayList<>();
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public boolean getFim() {
        return fim;
    }

    public void setFim(boolean fim) {
        this.fim = fim;
    }

    public List<transicao> getTransicoes() {
        return transicoes;
    }

    public void setTransicoes(List<transicao> transicoes) {
        this.transicoes = transicoes;
    }
    
    public void addTransicao(int cod, String caracter) {
        transicao t = new transicao();
        t.setCod(cod);
        t.setCaracter(caracter);
        transicoes.add(t);
    }
}
