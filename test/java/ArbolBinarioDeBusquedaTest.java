import Lista.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ArbolBinarioDeBusquedaTest {

    @Test
    void testInsertarYBuscar() {
        ArbolBinarioDeBusqueda<Integer> arbol = new ArbolBinarioDeBusqueda<>();
        assertTrue(arbol.addNodo(10));
        assertTrue(arbol.addNodo(5));
        assertTrue(arbol.addNodo(15));
        assertEquals(10, arbol.getRaiz().getDato());
        assertEquals(5, arbol.getRaiz().getMenor().getDato());
        assertEquals(15, arbol.getRaiz().getMayor().getDato());
    }

    @Test
    void testAltura() {
        ArbolBinarioDeBusqueda<Integer> arbol = new ArbolBinarioDeBusqueda<>();
        assertEquals(-1, arbol.getAltura());
        arbol.addNodo(10);
        arbol.addNodo(5);
        arbol.addNodo(15);
        arbol.addNodo(2);
        assertEquals(2, arbol.getAltura());
    }

    @Test
    void testGrado() {
        ArbolBinarioDeBusqueda<Integer> arbol = new ArbolBinarioDeBusqueda<>();
        assertEquals(0, arbol.getGrado());
        arbol.addNodo(10);
        arbol.addNodo(5);
        arbol.addNodo(15);
        assertEquals(2, arbol.getGrado());
    }

    @Test
    void testArbolHomogeneo() {
        ArbolBinarioDeBusqueda<Integer> arbol = new ArbolBinarioDeBusqueda<>();
        assertTrue(arbol.isArbolHomogeneo());
        arbol.addNodo(10);
        arbol.addNodo(5);
        arbol.addNodo(15);
        assertTrue(arbol.isArbolHomogeneo());
        arbol.addNodo(20);
        assertFalse(arbol.isArbolHomogeneo());
    }

    @Test
    void testArbolCompleto() {
        ArbolBinarioDeBusqueda<Integer> arbol = new ArbolBinarioDeBusqueda<>();
        assertTrue(arbol.isArbolCompleto());
        arbol.addNodo(10);
        arbol.addNodo(5);
        arbol.addNodo(15);
        assertTrue(arbol.isArbolCompleto());
        arbol.addNodo(3);
        assertFalse(arbol.isArbolCompleto());
    }

    @Test
    void testGetListaPreOrden() {
        ArbolBinarioDeBusqueda<Integer> arbol = new ArbolBinarioDeBusqueda<>();
        arbol.addNodo(10);
        arbol.addNodo(5);
        arbol.addNodo(15);
    }
}