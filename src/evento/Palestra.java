package evento;

import java.util.Date;
import java.util.List;

public class Palestra extends Evento {
    private String palestrante;
    private int duracao;
    private List<String> temas;

    public Palestra(String nome, Date data, String local, int capacidadeMaxima, String palestrante, int duracao, List<String> temas) {
        super(nome, data, local, capacidadeMaxima);
        this.palestrante = palestrante;
        this.duracao = duracao;
        this.temas = temas;
        this.adicionarParticipante(palestrante);
    }

    public String getPalestrante() {
        return palestrante;
    }

    public void setPalestrante(String palestrante) {
        this.palestrante = palestrante;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public List<String> getTemas() {
        return temas;
    }

    public void setTemas(List<String> temas) {
        this.temas = temas;
    }
}
