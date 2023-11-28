package analisadores;

import base.Automato;
import base.Estado;
import base.token;
import base.transicao;
import java.util.ArrayList;
import java.util.List;

public class AnalisadorSintatico {

    private Automato automato;
    private List<token> tokens;

    public AnalisadorSintatico(Automato automato) {
        tokens = new ArrayList<>();
        this.automato = automato;
    }

    public void validarEntrada(String entrada) {
        Estado estadoAtual = automato.getEstadoInicial();
        int posInicial = 0;
        int posFinal = 0;
        int pos = 0;

        for (char c : entrada.toCharArray()) {
            pos++;

            Estado proximoEstado = obterProximoEstado(estadoAtual, Character.toString(c));

            if (proximoEstado != null) {
                // Caractere válido para o estado atual
                estadoAtual = proximoEstado;
                posFinal = pos;
            } else {
                // Processa o token formado até agora
                processarToken(estadoAtual, entrada, posInicial, posFinal - 1);

                // Reinicia para o próximo token
                estadoAtual = automato.getEstadoInicial();
                posInicial = pos;
                posFinal = pos;

                // Verifica novamente o caractere atual após reiniciar
                proximoEstado = obterProximoEstado(estadoAtual, Character.toString(c));

                if (proximoEstado != null) {
                    estadoAtual = proximoEstado;
                    posFinal = pos;
                }
            }
        }

        // Processa o último token se não terminou com um caractere inválido
        processarToken(estadoAtual, entrada, posInicial, posFinal - 1);
    }

    private void processarToken(Estado estadoAtual, String entrada, int posInicial, int posFinal) {
        if (estadoAtual.getFim()) {
            criarTokenEsperado(entrada.substring(posInicial, posFinal + 1), posInicial, posFinal, automato.getTipoToken(estadoAtual.getCod()));
        } else {
            criarTokenNaoEsperado(entrada.substring(posInicial, posFinal + 1), posInicial, posFinal);
        }
    }

    private Estado obterProximoEstado(Estado estadoAtual, String entrada) {
        if (estadoAtual == null) {
            return null;
        }

        // Obtém as transições do estado atual
        List<transicao> transicoes = estadoAtual.getTransicoes();

        // Procura a transição que corresponde à entrada
        for (transicao transicao : transicoes) {
            if (transicao.getCaracter().equalsIgnoreCase(entrada)) {
                // Retorna o próximo estado se houver uma correspondência
                int codigoProximoEstado = transicao.getCod();
                return automato.getEstados().stream()
                        .filter(e -> e.getCod() == codigoProximoEstado)
                        .findFirst()
                        .orElse(null);
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
