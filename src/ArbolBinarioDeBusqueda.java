public class ArbolBinarioDeBusqueda<TipoDato extends Comparable<TipoDato>> {
    NodoArbol<TipoDato> raiz;

    public void setRaiz(NodoArbol<TipoDato> raiz) {
        this.raiz = raiz;
    }

    public NodoArbol<TipoDato> getRaiz() {
        return raiz;
    }

    protected boolean addNodoRaiz(TipoDato dato){
        NodoArbol<TipoDato> n= new NodoArbol<>(dato);
        setRaiz(n);
        return true;
    }
    protected NodoArbol<TipoDato> buscarNodoAInsertar(TipoDato dato, NodoArbol<TipoDato> nodo){
        if (nodo.getDato()==dato){
            return null;
        }
        if (dato.compareTo(nodo.getDato())<0){
            if (nodo.getMenor()!=null){
                return buscarNodoAInsertar(dato,nodo.getMenor());
            } else return nodo;

        } else if (dato.compareTo(nodo.getDato())>0) {
            if(nodo.getMayor()!=null){
                return buscarNodoAInsertar(dato,nodo.getMayor());
            }else return nodo;

        }
        return null;
    }
    protected boolean addOtrosNodos(TipoDato dato){
        NodoArbol<TipoDato> nodoCandidato = buscarNodoAInsertar(dato,getRaiz());
        if (nodoCandidato == null){
            return false;
        }
        NodoArbol<TipoDato> nodoNuevo = new NodoArbol<>(dato);
        if (dato.compareTo(nodoCandidato.getDato())<0){
            nodoCandidato.setMenor(nodoNuevo);
        }else nodoCandidato.setMayor(nodoNuevo);
        return true;


    }
    public boolean addNodo(TipoDato dato){
        if (getRaiz()==null){
            return addNodoRaiz(dato);
        }else return addOtrosNodos(dato);
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
}
