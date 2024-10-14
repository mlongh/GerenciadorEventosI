package evento;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Evento {
    private String nome;
    private Date data;
    private String local;
    private int capacidadeMaxima;
    private List<String> participantes;

    public Evento(String nome, Date data, String local, int capacidadeMaxima) {
        this.nome = nome;
        this.data = data;
        this.local = local;
        this.capacidadeMaxima = capacidadeMaxima;
        this.participantes = new ArrayList<>();
    }

    public boolean adicionarParticipante(String participante) {
        if (participantes.size() < capacidadeMaxima) {
            participantes.add(participante);
            return true;
        } else {
            System.out.println("Capacidade máxima atingida.");
            return false;
        }
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacidadeMaxima(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public List<String> getParticipantes() {
        return participantes;
    }
}
