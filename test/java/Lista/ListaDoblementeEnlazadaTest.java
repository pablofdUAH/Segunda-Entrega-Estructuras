package Lista;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListaDoblementeEnlazadaTest {

    private ListaDoblementeEnlazada<Integer> lista;

    @BeforeEach
    void setUp() {
        // Inicializa la lista antes de cada prueba
        lista = new ListaDoblementeEnlazada<Integer>();
    }

    @Test
    void testAdd() {
        // Añadir un solo elemento
        assertTrue(lista.add(1));
        assertEquals(1, lista.getNumElementos());

        // Añadir más elementos
        assertTrue(lista.add(2));
        assertTrue(lista.add(3));
        assertEquals(3, lista.getNumElementos());

        // Comprobar el contenido de la lista
        assertEquals("[ 3, 2, 1, ]", lista.toString());
    }

    @Test
    void testInsertAtEnd() {
        // Insertar un solo elemento al final
        assertTrue(lista.insertAtEnd(1));
        assertEquals(1, lista.getNumElementos());

        // Insertar más elementos al final
        assertTrue(lista.insertAtEnd(2));
        assertTrue(lista.insertAtEnd(3));
        assertEquals(3, lista.getNumElementos());

        // Comprobar el contenido de la lista
        assertEquals("[ 1, 2, 3, ]", lista.toString());
    }

    @Test
    void testDelete() {
        // Añadir elementos a la lista
        lista.add(1);
        lista.add(2);
        lista.add(3);
        assertEquals(3, lista.getNumElementos());

        // Eliminar un elemento
        assertTrue(lista.delete(2));
        assertEquals(2, lista.getNumElementos());
        assertEquals("[ 3, 1, ]", lista.toString());

        // Eliminar el primer elemento
        assertTrue(lista.delete(3));
        assertEquals(1, lista.getNumElementos());
        assertEquals("[ 1, ]", lista.toString());

        // Eliminar el último elemento
        assertTrue(lista.delete(1));
        assertEquals(0, lista.getNumElementos());
        assertEquals("[ ]", lista.toString());

        // Intentar eliminar de una lista vacía
        assertFalse(lista.delete(1));
    }

    @Test
    void testGetIterador() {
        // Añadir elementos
        lista.add(1);
        lista.add(2);
        lista.add(3);

        // Crear un iterador
        Iterador<Integer> iterador = lista.getIterador();

        // Verificar el comportamiento del iterador
        assertTrue(iterador.hasNext());
        assertEquals(3, iterador.next());
        assertTrue(iterador.hasNext());
        assertEquals(2, iterador.next());
        assertTrue(iterador.hasNext());
        assertEquals(1, iterador.next());
        assertFalse(iterador.hasNext());
    }

    @Test
    void testToString() {
        // Comprobar la representación en cadena de una lista vacía
        assertEquals("[ ]", lista.toString());

        // Comprobar la representación en cadena de una lista con elementos
        lista.add(1);
        lista.add(2);
        lista.add(3);
        assertEquals("[ 3, 2, 1, ]", lista.toString());
    }
}