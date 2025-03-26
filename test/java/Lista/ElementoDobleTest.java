package Lista;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ElementoDobleTest {

    @Test
    void testSetAndGet() {
        // Crear un elemento doble con un dato de tipo Integer
        ElementoDoble<Integer> elemento = new ElementoDoble<>(10);

        // Comprobar que el dato se establece correctamente
        assertEquals(10, elemento.getDato());

        // Crear otros elementos para establecerlos como anterior y siguiente
        ElementoDoble<Integer> anterior = new ElementoDoble<>(5);
        ElementoDoble<Integer> siguiente = new ElementoDoble<>(15);

        // Establecer los elementos anterior y siguiente
        elemento.setAnterior(anterior);
        elemento.setSiguente(siguiente);

        // Comprobar que los métodos setAnterior y setSiguente funcionan correctamente
        assertEquals(anterior, elemento.getAnterior());
        assertEquals(siguiente, elemento.getSiguente());
    }

    @Test
    void testConstructor() {
        // Crear un elemento con un dato de tipo String
        ElementoDoble<String> elemento = new ElementoDoble<>("dato");

        // Comprobar que el dato es el correcto
        assertEquals("dato", elemento.getDato());

        // Comprobar que los elementos anterior y siguiente son null por defecto
        assertNull(elemento.getAnterior());
        assertNull(elemento.getSiguente());
    }

    @Test
    void testSetDato() {
        // Crear un elemento doble de tipo Double
        ElementoDoble<Double> elemento = new ElementoDoble<>(3.14);

        // Establecer un nuevo dato
        elemento.setDato(2.71);

        // Comprobar que el dato se ha actualizado correctamente
        assertEquals(2.71, elemento.getDato());
    }

    @Test
    void testSetAnteriorYSetSiguente() {
        // Crear un elemento doble
        ElementoDoble<Integer> elemento = new ElementoDoble<>(100);

        // Establecer elementos anterior y siguiente
        ElementoDoble<Integer> anterior = new ElementoDoble<>(50);
        ElementoDoble<Integer> siguiente = new ElementoDoble<>(150);
        elemento.setAnterior(anterior);
        elemento.setSiguente(siguiente);

        // Comprobar que los elementos anterior y siguiente se han establecido correctamente
        assertEquals(anterior, elemento.getAnterior());
        assertEquals(siguiente, elemento.getSiguente());
    }
}
