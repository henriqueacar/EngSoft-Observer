import java.util.Observable;

public class Editora extends Observable {

    private String nomeRevista;
    private Integer edicao;

    public Editora(String nomeRevista, Integer edicao) {
        this.nomeRevista = nomeRevista;
        this.edicao = edicao;
    }

    public void lancarNovaEdicao(){
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "edição lançada{" +
                "nomeRevista='" + nomeRevista + '\'' +
                ", edicao=" + edicao +
                '}';
    }
}
