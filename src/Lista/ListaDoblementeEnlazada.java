package Lista;

public class ListaDoblementeEnlazada<T> implements Lista<T> {
    // ZONA DE ATRIBUTOS
    ElementoDoble<T> cabeza;
    ElementoDoble<T> cola;
    protected int numElementos = 0;


    // ZONA DE METODOS
    // Constructor

    // Metodos de la interfaz

    // Metodos propios
    public boolean add(T dato){
        boolean result = false;
        ElementoDoble<T> elemento= new ElementoDoble<T>(dato);
        if (cabeza==null){
            cabeza = elemento;
            cola = elemento;
            numElementos = numElementos+1;
            result=true;
        }else{
            elemento.setSiguente(cabeza);
            cabeza.setAnterior(elemento);
            cabeza=elemento;
            result=true;
            numElementos = numElementos+1;
        }
        return result;
    }
    public boolean insertAtEnd(T dato) { // corregir el nombre del método
        boolean result = false;
        ElementoDoble<T> elemento= new ElementoDoble<T>(dato);
        if (cabeza==null){
            cabeza = elemento;
            cola = elemento;
            numElementos = numElementos + 1;
            result = true;
        } else {
            cola.setSiguente(elemento); // Corregir esta línea
            elemento.setAnterior(cola);
            cola = elemento;
            result = true;
            numElementos = numElementos + 1;
        }
        return result;
    }

    public boolean delete(T dato) {
        boolean result = false;
        if (numElementos != 0) {
            ElementoDoble<T> elementoIterador = this.cabeza;
            while (elementoIterador != null && !elementoIterador.getDato().equals(dato)) { // Corregir la comparación
                elementoIterador = elementoIterador.getSiguente();
            }
            if (elementoIterador != null) {
                if (numElementos == 1) {
                    cabeza = null;
                    cola = null;
                    numElementos -= 1;
                    result = true;
                } else if (cabeza == elementoIterador || cola == elementoIterador) {
                    if (cabeza == elementoIterador) {
                        elementoIterador.getSiguente().setAnterior(null);
                        cabeza = elementoIterador.getSiguente();
                    } else if (cola == elementoIterador) {
                        elementoIterador.getAnterior().setSiguente(null);
                        cola = elementoIterador.getAnterior();
                    }
                    result = true;
                    numElementos -= 1;
                } else {
                    elementoIterador.getAnterior().setSiguente(elementoIterador.getSiguente());
                    elementoIterador.getSiguente().setAnterior(elementoIterador.getAnterior());
                    result = true;
                    numElementos -= 1;
                }
            }
        }
        return result;
    }

    public Iterador<T> getIterador(){
        return new IteradorDoblementeEnlazada<T>(this);
    }
    @Override
    public int getNumElementos(){
        return this.numElementos;
    }
}