package Lista;
import Lista.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ColaTest {

    @Test
    void testEnqueueDequeue() {
        // Crear una cola de enteros
        Cola<Integer> cola = new Cola<Integer>();

        // Añadir elementos
        cola.enqueue(1);
        cola.enqueue(2);
        cola.enqueue(3);

        assertEquals(1, cola.dequeue()); // El primer elemento agregado debería ser el primero en salir (FIFO)
        assertEquals(2, cola.dequeue()); // El siguiente elemento
        assertEquals(3, cola.dequeue()); // El último elemento
    }

    @Test
    void testDequeueWhenEmpty() {
        // Crear una cola vacía
        Cola<Integer> cola = new Cola<Integer>();

        // Intentar hacer un dequeue en una cola vacía
        // Dependiendo de cómo esté implementado dequeue, puede devolver null o lanzar una excepción
        // Si lanzara una excepción, necesitarías usar assertThrows:
        // assertThrows(NoSuchElementException.class, () -> cola.dequeue());

        // Si devuelve null en vez de lanzar una excepción:
        assertNull(cola.dequeue());
    }
}
