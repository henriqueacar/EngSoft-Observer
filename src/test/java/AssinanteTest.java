import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssinanteTest {
    Editora revistaCarros;
    Editora revistaModa;
    Assinante assinante1;
    Assinante assinante2;

    @BeforeEach
    void setUp(){
        revistaCarros = new Editora("Carros", 5);
        revistaModa = new Editora("Moda", 2);
        assinante1 = new Assinante("João");
        assinante2 = new Assinante("Maria");
    }

    @Test
    void deveNotificarUmAssinante(){
        assinante1.assinar(revistaCarros);
        revistaCarros.lancarNovaEdicao();
        assertEquals("Olá, João! Nova edição lançada{nomeRevista='Carros', edicao=5}", assinante1.getNotificacao());
    }

    @Test
    void deveNotificarAssinantes(){
        assinante2.assinar(revistaCarros);
        assinante1.assinar(revistaCarros);
        revistaCarros.lancarNovaEdicao();
        assertEquals("Olá, João! Nova edição lançada{nomeRevista='Carros', edicao=5}", assinante1.getNotificacao());
        assertEquals("Olá, Maria! Nova edição lançada{nomeRevista='Carros', edicao=5}", assinante2.getNotificacao());
    }

    @Test
    void naoDeveNotificarAssinante(){
        revistaCarros.lancarNovaEdicao();
        assertEquals(null, assinante1.getNotificacao());
        assertEquals(null, assinante2.getNotificacao());
    }

    @Test
    void deveNotificarAssinanteCarros(){
        assinante1.assinar(revistaCarros);
        assinante2.assinar(revistaModa);
        revistaCarros.lancarNovaEdicao();
        assertEquals("Olá, João! Nova edição lançada{nomeRevista='Carros', edicao=5}", assinante1.getNotificacao());
        assertEquals(null, assinante2.getNotificacao());
    }

    @Test
    void deveNotificarAssinanteModa(){
        assinante1.assinar(revistaCarros);
        assinante2.assinar(revistaModa);
        revistaModa.lancarNovaEdicao();
        assertEquals("Olá, Maria! Nova edição lançada{nomeRevista='Moda', edicao=2}", assinante2.getNotificacao());
        assertEquals(null, assinante1.getNotificacao());
    }

}