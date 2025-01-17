package evento;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import participante.Participante;

public class Evento {
	private String nome;
	private Date data;
	private String local;
	private int capacidadeMaxima;
	private List<Participante> participantes;
	private String organizador;
	public enum TipoEvento {
		WorkShop, Palestra
	}

	public Evento(String nome, Date data, String local, int capacidadeMaxima, String organizador) {
		this.nome = nome;
		this.data = data;
		this.local = local;
		this.capacidadeMaxima = capacidadeMaxima;
		this.organizador = organizador;
		this.participantes = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public Date getData() {
		return data;
	}

	public String getLocal() {
		return local;
	}

	public int getCapacidadeMaxima() {
		return capacidadeMaxima;
	}

	public String getOrganizador() {
		return organizador;
	}

	public void setOrganizador(String organizador) {
		this.organizador = organizador;
	}

	public List<Participante> getParticipantes() {
		return participantes;
	}

	public void adicionarParticipante(Participante participante) {
		if (participantes.size() < capacidadeMaxima) {
			participantes.add(participante);
		} else {
			System.out.println("Capacidade máxima atingida.");
		}
	}

	public void removerParticipante(Participante participante) {
		if (participantes.contains(participante)) {
			participantes.remove(participante);
		} else {
			System.out.println("Participante não encontrado.");
		}
	}
}
