package Lista;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class IteradorDoblementeEnlazadaTest {

    @Test
    void testHasNextAndNext() {
        // Crear una lista doblemente enlazada con algunos elementos
        ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<Integer>();
        lista.add(1);
        lista.add(2);
        lista.add(3);

        // Crear un iterador para la lista
        IteradorDoblementeEnlazada<Integer> iterador = new IteradorDoblementeEnlazada<Integer>(lista);

        // Comprobar si el iterador tiene un siguiente elemento
        assertTrue(iterador.hasNext());

        // Obtener el siguiente valor y comprobar que es correcto
        assertEquals(3, iterador.next());

        // Avanzar y comprobar el siguiente valor
        assertEquals(2, iterador.next());

        // Comprobar que tiene un siguiente elemento
        assertTrue(iterador.hasNext());

        // Obtener el siguiente valor
        assertEquals(1, iterador.next());

        // Comprobar que ya no tiene siguiente
        assertFalse(iterador.hasNext());
    }

    @Test
    void testDelete() {
        // Crear una lista doblemente enlazada con algunos elementos
        ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<Integer>();
        lista.add(1);
        lista.add(2);
        lista.add(3);

        // Crear un iterador para la lista
        IteradorDoblementeEnlazada<Integer> iterador = new IteradorDoblementeEnlazada<Integer>(lista);

        // Eliminar
    }
}