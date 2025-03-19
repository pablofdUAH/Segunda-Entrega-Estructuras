package Lista;

public class Cola<T> {
    // ZONA DE ATRIBUTOS


    // ZONA DE METODOS
    // Constructor
    private ListaDoblementeEnlazada<T> cola = new ListaDoblementeEnlazada<T>();

    // Las colas no tienen metodos de interfaz porque no necesitan una

    // Metodos propios
    public void enqueue(T dato){
        cola.add(dato);
    }
    public T dequeue(){
        Iterador<T>iterator=cola.getIterador();
        T dato = null;
        while (iterator.hasNext()){
            dato = iterator.next();
        }
        cola.delete(dato);
        return dato;
    }

}