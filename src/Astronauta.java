public class Astronauta {

    private static int contadorId = 1;

    private int id;
    private String nome;
    private String especialidade;

    public Astronauta(String nome, String especialidade) {
        this.id = contadorId++;
        this.nome = nome;
        this.especialidade = especialidade;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "---ASTRONAUTA---" +
                "\nID: " + id +
                "\nNome: " + nome +
                "\nEspecialidade: " + especialidade;
    }
}