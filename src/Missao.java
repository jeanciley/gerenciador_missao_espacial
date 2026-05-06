import java.util.ArrayList;
import java.util.List;

public class Missao extends EntidadeIdentificavel {

    private static int contadorId = 1;

    private String nome;
    private String objetivo;
    private String dataLancamento;
    private String status;

    private NaveEspacial nave;
    private List<Astronauta> astronautas;

    public Missao(String nome, String objetivo,
                  String dataLancamento, String status) {

        super(contadorId++);
        this.nome = nome;
        this.objetivo = objetivo;
        this.dataLancamento = dataLancamento;
        this.status = status;
        this.astronautas = new ArrayList<>();
    }

    public int getId() {
        return super.getId();
    }

    public void associarNave(NaveEspacial nave) {

        if (this.nave != null) {
            System.out.println("Essa missão já possui uma nave associada!");
            return;
        }

        this.nave = nave;
        System.out.println("Nave associada com sucesso!");
    }

    public void associarAstronauta(Astronauta astronauta) {

        if (nave == null) {
            System.out.println("Associe uma nave antes de adicionar astronautas.");
            return;
        }

        if (astronautas.size() >= nave.getCapacidade()) {
            System.out.println("Capacidade máxima da nave atingida!");
            return;
        }

        for (Astronauta ast : astronautas) {
            if(ast.getId() == astronauta.getId()){
                System.out.println("Esse astronauta já está associado a essa missão!");
                return;
            }
        }

        astronautas.add(astronauta);
        System.out.printf("%s\nAdicionado com sucesso!", astronauta);
    }

    public void atualizarStatus(String novoStatus) {
        this.status = novoStatus;
    }

    @Override
    public String toString() {

        String nomesAstronautas = null;

        if (!astronautas.isEmpty()) {
            nomesAstronautas = "";
            for (Astronauta a : astronautas) {
                nomesAstronautas += a.getNome() + " | ";
            }
        }

        return "---DADOS DA MISSÃO---" +
                "\nID: " + super.getId() +
                "\nNome: " + nome +
                "\nObjetivo: " + objetivo +
                "\nData: " + dataLancamento +
                "\nStatus: " + status +
                "\nNave: " + (nave != null ? nave.getNome() : "N/A") +
                "\nAstronautas: " + (nomesAstronautas != null ? nomesAstronautas : "N/A");
    }
}