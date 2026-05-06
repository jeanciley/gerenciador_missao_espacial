import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GerenciadorExploracaoEspacial {

    private List<Missao> missoes = new ArrayList<>();
    private List<NaveEspacial> naves = new ArrayList<>();
    private List<Astronauta> astronautas = new ArrayList<>();


    private Missao buscarMissao(int id) {
        for (Missao m : missoes) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }

    private NaveEspacial buscarNave(int id) {
        for (NaveEspacial n : naves) {
            if (n.getId() == id) {
                return n;
            }
        }
        return null;
    }

    private Astronauta buscarAstronauta(int id) {
        for (Astronauta a : astronautas) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    public void iniciar() {

        missoes.add(new Missao("Missão Marte", "Explorar a superfície de Marte", "2025-01-15", "Planejada"));
        missoes.add(new Missao("Missão Lua", "Explorar a superfície da lua", "2026-07-13", "Em planejamento"));
        naves.add(new NaveEspacial("Discovery One", "Exploração", 5));
        astronautas.add(new Astronauta("Neil Armstrong", "Comandante"));
        astronautas.add(new Astronauta("Buzz Aldrin", "Piloto"));
        astronautas.add(new Astronauta("Jean Ciley", "Capitão"));
        astronautas.add(new Astronauta("Fernando", "Comunicação"));
        astronautas.add(new Astronauta("Luigi", "Copiloto"));


        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {

            System.out.println("\n--- Sistema de Gerenciamento de Exploração Espacial ---");
            System.out.println("[1] Adicionar Missão");
            System.out.println("[2] Adicionar Nave Espacial");
            System.out.println("[3] Adicionar Astronauta");
            System.out.println("[4] Listar Missões");
            System.out.println("[5] Listar Naves");
            System.out.println("[6] Listar Astronautas");
            System.out.println("[7] Associar Nave a Missão");
            System.out.println("[8] Associar Astronauta a Missão");
            System.out.println("[9] Atualizar Status da Missão");
            System.out.println("[0] Sair");
            System.out.print("Sua opção -> ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    adicionarMissao();
                    break;

                case 2:
                    adicionarNaveEspacial();
                    break;

                case 3:
                    adicionarAstronauta();
                    break;

                case 4:
                    for (Missao m : missoes) {
                        System.out.println(m);
                    }
                    break;

                case 5:
                    for (NaveEspacial n : naves) {
                        System.out.println(n);
                    }
                    break;

                case 6:
                    for (Astronauta a : astronautas) {
                        System.out.println(a);
                    }
                    break;

                case 7:
                    associarNaveAMissao();
                    break;

                case 8:
                    assciarAstronautaAMissao();
                    break;

                case 9:
                    atualizarStatusDaMissao();
                    break;
            }

        } while (opcao != 0);

        scanner.close();
    }

    private void atualizarStatusDaMissao() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("ID da Missão: ");
        int idAtualizar = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Novo Status: ");
        String novoStatus = scanner.nextLine();

        Missao missaoAtualizar = buscarMissao(idAtualizar);

        if (missaoAtualizar != null) {
            missaoAtualizar.atualizarStatus(novoStatus);
            System.out.println("Status atualizado com sucesso!");
        } else {
            System.out.println("Missão não encontrada.");
        }

    }

    private void assciarAstronautaAMissao() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("ID da Missão: ");
        int idM = scanner.nextInt();

        System.out.print("ID do Astronauta: ");
        int idA = scanner.nextInt();
        scanner.nextLine();

        Missao m = buscarMissao(idM);
        Astronauta a = buscarAstronauta(idA);

        if (m != null && a != null) {
            m.associarAstronauta(a);
            System.out.println("Astronauta associado com sucesso!");
        } else {
            System.out.println("Missão ou Astronauta não encontrado.");
        }

    }

    private void associarNaveAMissao() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("ID da Missão: ");
        int idMissao = scanner.nextInt();

        System.out.print("ID da Nave: ");
        int idNave = scanner.nextInt();
        scanner.nextLine();

        Missao missao = buscarMissao(idMissao);
        NaveEspacial nave = buscarNave(idNave);

        if (missao != null && nave != null) {
            missao.associarNave(nave);
            System.out.println("Nave associada com sucesso!");
        } else {
            System.out.println("Missão ou Nave não encontrada.");
        }

    }

    private void adicionarAstronauta() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome do Astronauta: ");
        String nomeAstronauta = scanner.nextLine();

        System.out.print("Especialidade: ");
        String especialidade = scanner.nextLine();

        astronautas.add(new Astronauta(nomeAstronauta, especialidade));

        System.out.println("Astronauta " + nomeAstronauta + " adicionado com sucesso!");

    }

    private void adicionarNaveEspacial() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome da Nave: ");
        String nomeNave = scanner.nextLine();

        System.out.print("Tipo da Nave: ");
        String tipo = scanner.nextLine();

        System.out.print("Capacidade: ");
        int capacidade = scanner.nextInt();
        scanner.nextLine();

        naves.add(new NaveEspacial(nomeNave, tipo, capacidade));

        System.out.println("Nave " + nomeNave + " adicionada com sucesso!");

    }

    private void adicionarMissao() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome da Missão: ");
        String nomeMissao = scanner.nextLine();

        System.out.print("Objetivo da Missão: ");
        String objetivoMissao = scanner.nextLine();

        System.out.print("Data de Lançamento: ");
        String data = scanner.nextLine();

        System.out.print("Status: ");
        String status = scanner.nextLine();

        missoes.add(new Missao(nomeMissao, objetivoMissao, data, status));

        System.out.println("Missão " + nomeMissao + " adicionado com sucesso!");

    }
}
