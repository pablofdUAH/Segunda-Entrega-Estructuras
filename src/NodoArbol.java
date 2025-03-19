public class NodoArbol<TipoDato extends Comparable<TipoDato>> {
    TipoDato dato;

    NodoArbol<TipoDato> mayor;
    NodoArbol<TipoDato> menor;


    public TipoDato getDato() {
        return dato;
    }

    public void setDato(TipoDato dato) {
        this.dato = dato;
    }

    public NodoArbol<TipoDato> getMayor() {
        return mayor;
    }

    public void setMayor(NodoArbol<TipoDato> mayor) {
        this.mayor = mayor;
    }

    public NodoArbol<TipoDato> getMenor() {
        return menor;
    }

    public void setMenor(NodoArbol<TipoDato> menor) {
        this.menor = menor;
    }
    private NodoArbol(){}
    public NodoArbol(TipoDato dato){
        setDato(dato);
    }

}
