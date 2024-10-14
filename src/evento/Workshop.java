package evento;

import java.util.Date;
import java.util.List;

public class Workshop extends Evento {
    private String instrutor;
    private List<String> materiaisNecessarios;
    private int cargaHoraria;

    public Workshop(String nome, Date data, String local, int capacidadeMaxima, String instrutor, List<String> materiaisNecessarios, int cargaHoraria) {
        super(nome, data, local, capacidadeMaxima);
        this.instrutor = instrutor;
        this.materiaisNecessarios = materiaisNecessarios;
        this.cargaHoraria = cargaHoraria;
    }

    public String getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(String instrutor) {
        this.instrutor = instrutor;
    }

    public List<String> getMateriaisNecessarios() {
        return materiaisNecessarios;
    }

    public void setMateriaisNecessarios(List<String> materiaisNecessarios) {
        this.materiaisNecessarios = materiaisNecessarios;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
}