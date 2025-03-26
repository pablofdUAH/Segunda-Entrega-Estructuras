import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NodoArbolTest {

    @Test
    public void testConstructorYGetDato() {
        NodoArbol<Integer> nodo = new NodoArbol<>(10);
        assertEquals(10, nodo.getDato());
    }

    @Test
    public void testSetDato() {
        NodoArbol<Integer> nodo = new NodoArbol<>(10);
        nodo.setDato(20);
        assertEquals(20, nodo.getDato());
    }

    @Test
    public void testSetYGetMayor() {
        NodoArbol<Integer> nodo = new NodoArbol<>(10);
        NodoArbol<Integer> mayor = new NodoArbol<>(15);
        nodo.setMayor(mayor);
        assertEquals(mayor, nodo.getMayor());
    }

    @Test
    public void testSetYGetMenor() {
        NodoArbol<Integer> nodo = new NodoArbol<>(10);
        NodoArbol<Integer> menor = new NodoArbol<>(5);
        nodo.setMenor(menor);
        assertEquals(menor, nodo.getMenor());
    }
}