public class NaveEspacial extends EntidadeIdentificavel {

    private static int contadorId = 1;

    private String nome;
    private String tipo;
    private int capacidade;

    public NaveEspacial(String nome, String tipo, int capacidade) {
        super(contadorId++);
        this.nome = nome;
        this.tipo = tipo;
        this.capacidade = capacidade;
    }

    public int getId() {
        return super.getId();
    }

    public String getNome() {
        return nome;
    }

    public int getCapacidade() {
        return capacidade;
    }

    @Override
    public String toString() {
        return "---NAVE---" +
                "\nID: " + super.getId() +
                "\nNome: " + nome +
                "\nTipo: " + tipo +
                "\nCapacidade: " + capacidade;
    }
}