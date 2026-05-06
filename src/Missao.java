import java.util.ArrayList;
import java.util.List;

public class Missao extends EntidadeIdentificavel {

    private static int contadorId = 1;

    private String nome;
    private String objetivo;
    private String dataLancamento;
    private String status;
    private int capacidade;

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
        this.nave = nave;
    }

    public void associarAstronauta(Astronauta astronauta) {
        astronautas.add(astronauta);
    }

    public void atualizarStatus(String novoStatus) {
        this.status = novoStatus;
    }

    @Override
    public String toString() {

        String nomesAstronautas = "N/A";

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
                "\nAstronautas: " + nomesAstronautas;
    }
}