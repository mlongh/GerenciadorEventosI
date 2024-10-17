package evento;

import java.util.Date;
import java.util.List;
import participante.Participante;

public class Palestra extends Evento {
    private Participante palestrante;
    private int duracao;
    private List<String> temas;

    public Palestra(String nome, Date data, String local, int capacidadeMaxima, Participante palestrante, int duracao, List<String> temas) {
        super(nome, data, local, capacidadeMaxima, palestrante.getNome());
        this.palestrante = palestrante;
        this.duracao = duracao;
        this.temas = temas;
        this.adicionarParticipante(palestrante);
    }

    public Participante getPalestrante() {
        return palestrante;
    }

    public void setPalestrante(Participante palestrante) {
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
