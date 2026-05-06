public class Astronauta extends EntidadeIdentificavel {

    private static int contadorId = 1;

    private String nome;
    private String especialidade;

    public Astronauta(String nome, String especialidade) {
        super(contadorId++);
        this.nome = nome;
        this.especialidade = especialidade;
    }

    public int getId() {
        return super.getId();
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "---ASTRONAUTA---" +
                "\nID: " + super.getId() +
                "\nNome: " + nome +
                "\nEspecialidade: " + especialidade;
    }

}