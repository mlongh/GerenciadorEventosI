package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


import evento.Evento;
import evento.Evento.TipoEvento;
import evento.Palestra;
import evento.Workshop;

import participante.Participante;
import participante.Participante.TipoParticipante;


public class GerenciarEvento {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Evento> eventos = new ArrayList<>();

    public static void main(String[] args) {
        int opcao = 0;
        do {
            System.out.println("---- Gerenciador de Eventos ----");
            System.out.println("1. Adicionar Evento");
            System.out.println("2. Adicionar Participante");
            System.out.println("3. Listar Eventos");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    criarNovoEvento();
                    break;
                case 2:
                    adicionarParticipante();
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);
    }

    public static Evento criarNovoEvento() {
        System.out.print("Nome do evento: ");
        String nome = scanner.nextLine();

        System.out.print("Data do evento (dd/MM/yyyy): ");
        String dataEntrada = scanner.nextLine();
        Date data = null;
        try {
            data = new SimpleDateFormat("dd/MM/yyyy").parse(dataEntrada);
        } catch (ParseException e) {
            System.out.println("Data no formato inválido. Usando data atual.");
            data = new Date();
        }

        System.out.print("Local do evento: ");
        String local = scanner.nextLine();

        System.out.print("Capacidade máxima: ");
        int capacidadeMaxima = scanner.nextInt();
        scanner.nextLine();

        TipoEvento tipoEvento = escolherTipoEvento();

        if (tipoEvento == TipoEvento.WorkShop) {
            return criarWorkshop(nome, data, local, capacidadeMaxima);
        } else {
            return criarPalestra(nome, data, local, capacidadeMaxima);
        }
    }

    private static TipoEvento escolherTipoEvento() {
        System.out.println("Escolha o tipo de evento:");
        System.out.println("1. WorkShop");
        System.out.println("2. Palestra");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                return TipoEvento.WorkShop;
            case 2:
                return TipoEvento.Palestra;
            default:
                System.out.println("Opção inválida. O evento será considerado como Palestra por padrão.");
                return TipoEvento.Palestra;
        }
    }

    private static Workshop criarWorkshop(String nome, Date data, String local, int capacidadeMaxima) {
        System.out.println("--- Criar Workshop ---");
        System.out.print("Nome do instrutor: ");
        String instrutor = scanner.nextLine();

        System.out.print("Carga horária (em horas): ");
        int cargaHoraria = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Materiais necessários (separe por vírgula): ");
        String materiaisStr = scanner.nextLine();
        List<String> materiaisNecessarios = List.of(materiaisStr.split(","));

        Workshop workshop = new Workshop(nome, data, local, capacidadeMaxima, instrutor, materiaisNecessarios, cargaHoraria);

        eventos.add(workshop);

        System.out.println("Workshop adicionado com sucesso!");
        return workshop;
    }

    private static Palestra criarPalestra(String nome, Date data, String local, int capacidadeMaxima) {
        System.out.println("=== Criando Palestra ===");
        System.out.print("Nome do palestrante: ");
        String palestrante = scanner.nextLine();

        System.out.print("Email do palestrante: ");
        String email = scanner.nextLine();

        TipoParticipante tipo = escolherTipoParticipante();

        Participante participante = new Participante(palestrante, email, tipo);

        System.out.print("Duração da palestra (em minutos): ");
        int duracao = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Temas (separe por vírgula): ");
        String temasStr = scanner.nextLine();
        List<String> temas = List.of(temasStr.split(","));

        Palestra palestra = new Palestra(nome, data, local, capacidadeMaxima, participante, duracao, temas);

        eventos.add(palestra);

        System.out.println("Palestra adicionada com sucesso!");
        return palestra;
    }

    private static TipoParticipante escolherTipoParticipante() {
        System.out.println("Escolha o tipo de participante:");
        System.out.println("1. Normal");
        System.out.println("2. VIP");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                return TipoParticipante.Normal;
            case 2:
                return TipoParticipante.VIP;
            default:
                System.out.println("Opção inválida. O participante será do tipo Normal por padrão.");
                return TipoParticipante.Normal;
        }
    }

    private static void adicionarParticipante() {
        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento disponível para adicionar participante.");
            return;
        }

        System.out.println("Escolha o evento para adicionar o participante:");
        for (int i = 0; i < eventos.size(); i++) {
            System.out.println((i + 1) + ". " + eventos.get(i).getNome() + " - " + eventos.get(i).getData());
        }

        int eventoEscolhido = scanner.nextInt() - 1;
        scanner.nextLine();

        if (eventoEscolhido < 0 || eventoEscolhido >= eventos.size()) {
            System.out.println("Evento inválido.");
            return;
        }

        Evento evento = eventos.get(eventoEscolhido);

        System.out.print("Nome do participante: ");
        String nomeParticipante = scanner.nextLine();

        System.out.print("Email do participante: ");
        String emailParticipante = scanner.nextLine();

        TipoParticipante tipo = escolherTipoParticipante();

        Participante novoParticipante = new Participante(nomeParticipante, emailParticipante, tipo);

        evento.adicionarParticipante(novoParticipante);
        System.out.println("Participante adicionado com sucesso ao evento " + evento.getNome() + ".");
    }
}