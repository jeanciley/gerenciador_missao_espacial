public class NaveEspacial {

    private static int contadorId = 1;

    private int id;
    private String nome;
    private String tipo;
    private int capacidade;

    public NaveEspacial(String nome, String tipo, int capacidade) {
        this.id = contadorId++;
        this.nome = nome;
        this.tipo = tipo;
        this.capacidade = capacidade;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "---NAVE---" +
                "\nID: " + id +
                "\nNome: " + nome +
                "\nTipo: " + tipo +
                "\nCapacidade: " + capacidade;
    }
}