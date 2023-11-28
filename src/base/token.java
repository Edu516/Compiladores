package base;

/**
 *
 * @author eduardo
 */
public class token {
    private static int proximoCodigo = 1;  // Campo estático para rastrear o próximo código disponível

    
    private int cod;
    private String lexema;
    private String tipo;
    private int posInicial;
    private int posFinal;
    
    public token() {
        this.cod = proximoCodigo++;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPosInicial() {
        return posInicial;
    }

    public void setPosInicial(int posInicial) {
        this.posInicial = posInicial;
    }

    public int getPosFinal() {
        return posFinal;
    }

    public void setPosFinal(int posFinal) {
        this.posFinal = posFinal;
    }

    @Override
    public String toString() {
        return "token{" + "cod = " + cod + ", lexema = " + lexema + ", tipo = " + tipo + ", posInicial = " + posInicial + ", posFinal = " + posFinal + '}'+"\n";
    }
    
}
