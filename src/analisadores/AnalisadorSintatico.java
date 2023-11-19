package analisadores;

import base.automato;
import base.estado;
import base.token;
import base.transicao;
import java.util.ArrayList;
import java.util.List;

public class AnalisadorSintatico {

    private automato automato;
    private List<token> tokens;

    public AnalisadorSintatico(automato automato) {
        tokens = new ArrayList<>();
        this.automato = automato;
    }

    public void validarEntrada(String entrada) {
        estado estadoAtual = automato.getEstadoInicial();
        int posInicial = 0;
        int posFinal = 0;
        String lexema = "";
        for (int i = 0; i < entrada.length(); i++) {
            if (Character.isWhitespace(entrada.charAt(i)) || i == entrada.length()) {
                // Encontrou um espaço em branco, processa o lexema formado até agora
                if (!lexema.isEmpty()) {
                    posFinal = i;
                    processarLexema(lexema, posInicial, posFinal);
                    lexema = ""; // Reinicia o lexema para o próximo
                    posInicial = 0;
                }
                posFinal = 0;
            } else {
                if (posInicial == 0) {
                    posInicial = i;
                }
                lexema = lexema + entrada.charAt(i);
            }
        }
    }

    private void processarLexema(String lexema, int posInicial, int posFinal) {
        estado estadoAtual = automato.getEstadoInicial();
        for (char c : lexema.toCharArray()) {
            estadoAtual = obterProximoEstado(estadoAtual, Character.toString(c));
        }

        if (estadoAtual != null) {
            criarTokenEsperado(lexema, posInicial, posFinal,automato.getTipoToken(estadoAtual.getCod()));
        }else{
            criarTokenNaoEsperado(lexema, posInicial, posFinal);
        }
    }

    private estado obterProximoEstado(estado estadoAtual, String entrada) {
        if (estadoAtual == null) {
            return null;
        }
        
        // Obtém as transições do estado atual
        List<transicao> transicoes = estadoAtual.getTransicoes();

        // Procura a transição que corresponde à entrada
        for (transicao transicao : transicoes) {
            if (transicao.getCaracter().equals(entrada)) {
                // Retorna o próximo estado se houver uma correspondência
                return automato.getEstados().get(transicao.getCod());
            }
        }

        // Retorna nulo se não houver correspondência
        return null;
    }
    
    private void criarTokenEsperado(String lexema, int posInicial, int posFinal, String tipo) {
        token tk = new token();
        tk.setLexema(lexema);
        tk.setPosInicial(posInicial);
        tk.setPosFinal(posFinal);
        tk.setTipo(tipo);
        addToken(tk);
    }

    private void criarTokenNaoEsperado(String lexema, int posInicial, int posFinal) {
        // Cria um token com o tipo "Não esperado pelo automato"
        token tk = new token();
        tk.setLexema(lexema);
        tk.setPosInicial(posInicial);
        tk.setPosFinal(posFinal);
        tk.setTipo("Não esperado pelo automato");
        addToken(tk);
    }

    public List<token> getTokens() {
        return tokens;
    }

    public void setTokens(List<token> tokens) {
        this.tokens = tokens;
    }

    public void addToken(token tk) {
        tokens.add(tk);
    }
}
