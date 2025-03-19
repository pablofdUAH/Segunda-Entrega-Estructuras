import Lista.*;

public class ArbolBinarioDeBusqueda<TipoDato extends Comparable<TipoDato>> {
    NodoArbol<TipoDato> raiz;

    public void setRaiz(NodoArbol<TipoDato> raiz) {
        this.raiz = raiz;
    }

    public NodoArbol<TipoDato> getRaiz() {
        return raiz;
    }

    protected boolean addNodoRaiz(TipoDato dato) {
        NodoArbol<TipoDato> n = new NodoArbol<>(dato);
        setRaiz(n);
        return true;
    }

    protected NodoArbol<TipoDato> buscarNodoAInsertar(TipoDato dato, NodoArbol<TipoDato> nodo) {
        if (nodo.getDato() == dato) {
            return null;
        }
        if (dato.compareTo(nodo.getDato()) < 0) {
            if (nodo.getMenor() != null) {
                return buscarNodoAInsertar(dato, nodo.getMenor());
            } else return nodo;

        } else if (dato.compareTo(nodo.getDato()) > 0) {
            if (nodo.getMayor() != null) {
                return buscarNodoAInsertar(dato, nodo.getMayor());
            } else return nodo;

        }
        return null;
    }

    protected boolean addOtrosNodos(TipoDato dato) {
        NodoArbol<TipoDato> nodoCandidato = buscarNodoAInsertar(dato, getRaiz());
        if (nodoCandidato == null) {
            return false;
        }
        NodoArbol<TipoDato> nodoNuevo = new NodoArbol<>(dato);
        if (dato.compareTo(nodoCandidato.getDato()) < 0) {
            nodoCandidato.setMenor(nodoNuevo);
        } else nodoCandidato.setMayor(nodoNuevo);
        return true;


    }

    public boolean addNodo(TipoDato dato) {
        if (getRaiz() == null) {
            return addNodoRaiz(dato);
        } else return addOtrosNodos(dato);
    }

    public int getGrado() {
        return getGradoNodo(raiz);
    }

    private int getGradoNodo(NodoArbol<TipoDato> nodo) {
        if (nodo == null) return 0; // Árbol vacío
        int grado = 0;
        if (nodo.getMenor() != null) grado++;
        if (nodo.getMayor() != null) grado++;
        return grado;
    }

    public int getAltura() {
        return getAlturaNodo(raiz);
    }

    private int getAlturaNodo(NodoArbol<TipoDato> nodo) {
        if (nodo == null) return -1; // Árbol vacío → altura -1 para que la raíz sea nivel 0

        int alturaIzquierda = getAlturaNodo(nodo.getMenor());
        int alturaDerecha = getAlturaNodo(nodo.getMayor());

        return Math.max(alturaIzquierda, alturaDerecha) + 1;
    }

    public Lista<TipoDato> getListaDatosNivel(int nivel) {
            Lista<TipoDato> lista = new ListaDoblementeEnlazada<TipoDato>();
            obtenerDatosPorNivel(raiz, nivel, 0, lista);
            return lista;
    }

    private void obtenerDatosPorNivel(NodoArbol<TipoDato> nodo, int nivelObjetivo, int nivelActual, Lista<TipoDato> lista) {
            if (nodo == null) return; // No hay nodo en este camino

            if (nivelActual == nivelObjetivo) {
                lista.add(nodo.dato); // Estamos en el nivel deseado, agregamos el dato
            } else {
                // Aún no estamos en el nivel, seguimos bajando
                obtenerDatosPorNivel(nodo.getMenor(), nivelObjetivo, nivelActual + 1, lista);
                obtenerDatosPorNivel(nodo.getMayor(), nivelObjetivo, nivelActual + 1, lista);
            }
    }


}
