package participante;

public class Participante {
    private String nome;
    private String email;
    private TipoParticipante tipo;

    public enum TipoParticipante {
        Normal, VIP
    }

    public Participante(String nome, String email, TipoParticipante tipo) {
        this.nome = nome;
        this.email = email;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoParticipante getTipo() {
        return tipo;
    }

    public void setTipo(TipoParticipante tipo) {
        this.tipo = tipo;
    }
}
