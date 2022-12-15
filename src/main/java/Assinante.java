import java.util.Observable;
import java.util.Observer;

public class Assinante implements Observer {

    private String nome;
    private String notificacao;

    public Assinante(String nome){
        this.nome = nome;
    }

    public String getNotificacao() {
        return notificacao;
    }

    public void assinar(Editora editora){
        editora.addObserver(this);
    }

    public void update(Observable revista, Object obj1){
        this.notificacao = "Olá, " + this.nome + "! Nova " + revista.toString();
    }
}
