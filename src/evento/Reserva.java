package reserva;

import evento.Evento;
import participante.Participante;

public class Reserva {
    private Participante participante;
    private Evento evento;

    public Reserva(Participante participante, Evento evento) {
        this.participante = participante;
        this.evento = evento;
    }

    public Participante getParticipante() {
        return participante;
    }

    public Evento getEvento() {
        return evento;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "participante=" + participante.getNome() +
                ", evento=" + evento.getNome() +
                '}';
    }
}
