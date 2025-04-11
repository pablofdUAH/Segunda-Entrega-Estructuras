import Lista.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArbolBinarioDeBusquedaTest {
    ArbolBinarioDeBusqueda<Integer> arbol;

    @BeforeEach
    public void setUp() {
        arbol = new ArbolBinarioDeBusqueda<>();
    }

    private <T> int contarElementos(Lista<T> lista) {
        int count = 0;
        Iterador<T> it = lista.getIterador();
        while (it.hasNext()) {
            it.next();
            count++;
        }
        return count;
    }

    private <T> T obtenerElemento(Lista<T> lista, int indice) {
        int i = 0;
        Iterador<T> it = lista.getIterador();
        while (it.hasNext()) {
            T elem = it.next();
            if (i == indice) return elem;
            i++;
        }
        return null;
    }

    @Test
    public void testAddNodo() {
        assertTrue(arbol.addNodo(10));
        assertTrue(arbol.addNodo(5));
        assertTrue(arbol.addNodo(15));
        assertFalse(arbol.addNodo(10)); // No se deben repetir
    }

    @Test
    public void testGetAltura() {
        arbol.addNodo(10);
        arbol.addNodo(5);
        arbol.addNodo(15);
        arbol.addNodo(3);
        assertEquals(2, arbol.getAltura());
    }

    @Test
    public void testGetGrado() {
        arbol.addNodo(10);
        assertEquals(0, arbol.getGrado());
        arbol.addNodo(5);
        assertEquals(1, arbol.getGrado());
        arbol.addNodo(15);
        assertEquals(2, arbol.getGrado());
    }

    @Test
    public void testIsArbolHomogeneo() {
        arbol.addNodo(10);
        arbol.addNodo(5);
        arbol.addNodo(15);
        assertTrue(arbol.isArbolHomogeneo());

        arbol.addNodo(3); // Nodo con solo un hijo
        assertFalse(arbol.isArbolHomogeneo());
    }

    @Test
    public void testIsArbolCompleto() {
        arbol.addNodo(10);
        arbol.addNodo(5);
        arbol.addNodo(15);
        assertTrue(arbol.isArbolCompleto());

        arbol.addNodo(3); // Ahora no es completo
        assertFalse(arbol.isArbolCompleto());
    }

    @Test
    public void testIsArbolCasiCompleto() {
        arbol.addNodo(10);
        arbol.addNodo(5);
        arbol.addNodo(15);
        assertTrue(arbol.isArbolCasiCompleto());

        arbol.addNodo(3);
        arbol.addNodo(7);
        arbol.addNodo(20);
        assertFalse(arbol.isArbolCasiCompleto());

        arbol.addNodo(1); // Ya no es casi completo
        assertFalse(arbol.isArbolCasiCompleto());
    }

    @Test
    public void testGetListaDatosNivel() {
        arbol.addNodo(10);
        arbol.addNodo(5);
        arbol.addNodo(15);
        Lista<Integer> nivel0 = arbol.getListaDatosNivel(0);
        Lista<Integer> nivel1 = arbol.getListaDatosNivel(1);
        assertEquals(1, contarElementos(nivel0));
        assertEquals(2, contarElementos(nivel1));
    }

    @Test
    public void testGetCamino() {
        arbol.addNodo(10);
        arbol.addNodo(5);
        arbol.addNodo(15);
        arbol.addNodo(3);

        Lista<Integer> camino = arbol.getCamino(3);
        assertEquals(3, contarElementos(camino)); // 10 -> 5 -> 3
        assertEquals(3, obtenerElemento(camino, 0));
        assertEquals(5, obtenerElemento(camino, 1));
        assertEquals(10, obtenerElemento(camino, 2));
    }

    @Test
    public void testGetSubarbolIzquierda() {
        arbol.addNodo(10);
        arbol.addNodo(5);
        ArbolBinarioDeBusqueda<Integer> sub = arbol.getSubarbolIzquierda();
        assertNotNull(sub);
        assertEquals(5, sub.getRaiz().getDato());
    }

    @Test
    public void testGetSubarbolDerecha() {
        arbol.addNodo(10);
        arbol.addNodo(15);
        ArbolBinarioDeBusqueda<Integer> sub = arbol.getSubarbolDerecha();
        assertNotNull(sub);
        assertEquals(15, sub.getRaiz().getDato());
    }

    @Test
    public void testRecorridos() {
        arbol.addNodo(10);
        arbol.addNodo(5);
        arbol.addNodo(15);

        Lista<Integer> pre = arbol.getListaPreOrden();
        Lista<Integer> in = arbol.getListaOrdenCentral();
        Lista<Integer> post = arbol.getListaPostOrden();

        assertEquals(3, contarElementos(pre));
        assertEquals(3, contarElementos(in));
        assertEquals(3, contarElementos(post));

        assertEquals(15, obtenerElemento(pre, 0));  // Preorden: raíz primero
        assertEquals(15, obtenerElemento(in, 0));    // Inorden: menor primero
        assertEquals(10, obtenerElemento(post, 0));  // Postorden: hoja primero
    }
}
