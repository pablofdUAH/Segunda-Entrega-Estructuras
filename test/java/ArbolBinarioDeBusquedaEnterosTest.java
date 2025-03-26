import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ArbolBinarioDeBusquedaEnterosTest {

    @Test
    void testGetSuma() {
        ArbolBinarioDeBusquedaEnteros arbol = new ArbolBinarioDeBusquedaEnteros();
        arbol.addNodo(10);
        arbol.addNodo(5);
        arbol.addNodo(15);
        assertEquals(30, arbol.getSuma());
    }

    @Test
    void testGetSumaPreOrden() {
        ArbolBinarioDeBusquedaEnteros arbol = new ArbolBinarioDeBusquedaEnteros();
        arbol.addNodo(10);
        arbol.addNodo(5);
        arbol.addNodo(15);
        assertEquals(30, arbol.getSumaPreOrden());
    }

    @Test
    void testGetSumaPostOrden() {
        ArbolBinarioDeBusquedaEnteros arbol = new ArbolBinarioDeBusquedaEnteros();
        arbol.addNodo(10);
        arbol.addNodo(5);
        arbol.addNodo(15);
        assertEquals(30, arbol.getSumaPostOrden());
    }

    @Test
    void testGetSubarbolIzquierda() {
        ArbolBinarioDeBusquedaEnteros arbol = new ArbolBinarioDeBusquedaEnteros();
        arbol.addNodo(10);
        arbol.addNodo(5);
        arbol.addNodo(15);
        assertNotNull(arbol.getSubarbolIzquierda());
        assertEquals(5, arbol.getSubarbolIzquierda().getRaiz().getDato());
    }

    @Test
    void testGetSubarbolDerecha() {
        ArbolBinarioDeBusquedaEnteros arbol = new ArbolBinarioDeBusquedaEnteros();
        arbol.addNodo(10);
        arbol.addNodo(5);
        arbol.addNodo(15);
        assertNotNull(arbol.getSubarbolDerecha());
        assertEquals(15, arbol.getSubarbolDerecha().getRaiz().getDato());
    }
}