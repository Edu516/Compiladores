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
        int pos = 0;

        for (char c : entrada.toCharArray()) {
            pos++;

            estado proximoEstado = obterProximoEstado(estadoAtual, Character.toString(c));

            if (proximoEstado != null) {
                // Caractere válido para o estado atual
                estadoAtual = proximoEstado;
                posFinal = pos;
            } else {
                // Caractere não válido para o estado atual, processa o token formado até agora
                if (estadoAtual.getFim()) {
                    criarTokenEsperado(entrada.substring(posInicial, posFinal), posInicial, posFinal - 1, automato.getTipoToken(estadoAtual.getCod()));
                } else {
                    criarTokenNaoEsperado(Character.toString(c), pos - 1, pos - 1); // Cria um token para o caractere não esperado
                }

                // Reinicia para o próximo token
                estadoAtual = automato.getEstadoInicial();
                posInicial = pos;
                posFinal = pos;
            }
        }

        // Processa o último token se não terminou com um caractere inválido
        if (estadoAtual.getFim()) {
            criarTokenEsperado(entrada.substring(posInicial, posFinal), posInicial, posFinal - 1, automato.getTipoToken(estadoAtual.getCod()));
        } else {
            criarTokenNaoEsperado(entrada.substring(posInicial, posFinal), posInicial, posFinal - 1);
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
