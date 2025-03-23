import Lista.*;

public class ArbolBinarioDeBusquedaEnteros extends ArbolBinarioDeBusqueda<Integer>{
    public ArbolBinarioDeBusquedaEnteros(){
        super();
    }
    public int getSuma(){
        Lista<Integer> lista = getListaOrdenCentral();
        Iterador<Integer> iterador = lista.getIterador();
        int suma=0;
        while (iterador.hasNext()){
            suma= suma+iterador.next();
        }
        return suma;
    }
    public int getSumaPreOrden(){
        Lista<Integer> lista = getListaPreOrden();
        Iterador<Integer> iterador = lista.getIterador();
        int suma=0;
        while (iterador.hasNext()){
            suma= suma+iterador.next();
        }
        return suma;
    }
    public int getSumaPostOrden(){
        Lista<Integer> lista = getListaPostOrden();
        Iterador<Integer> iterador = lista.getIterador();
        int suma=0;
        while (iterador.hasNext()){
            suma= suma+iterador.next();
        }
        return suma;
    }
    @Override
    public ArbolBinarioDeBusquedaEnteros getSubarbolIzquierda() {
        if (getRaiz() == null || getRaiz().getMenor() == null) {
            return null; // No hay subárbol izquierdo
        }
        ArbolBinarioDeBusquedaEnteros subarbol = new ArbolBinarioDeBusquedaEnteros();
        subarbol.setRaiz(getRaiz().getMenor());
        return subarbol;
    }
    @Override
    public ArbolBinarioDeBusquedaEnteros getSubarbolDerecha() {
        if (getRaiz() ==null || getRaiz().getMayor() == null) {
            return null; // No hay subárbol izquierdo
        }
        ArbolBinarioDeBusquedaEnteros subarbol = new ArbolBinarioDeBusquedaEnteros();
        subarbol.setRaiz(getRaiz().getMayor());
        return subarbol;
    }
}
