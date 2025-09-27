package ar.edu.unahur.obj2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FileSystem {
    private List<IElemento> listaElementos = new ArrayList<>();

    public FileSystem(List<IElemento> listaElementos) {
        this.listaElementos = listaElementos;
    }

    public List<IElemento> getListaElementos() {
        return listaElementos;
    }

    public Integer tamanioTotalSistema(){
        return listaElementos.stream().mapToInt(e -> e.tamanio()).sum();
    }

    public IElemento archivoMasPesado() {
        return listaElementos.stream()
        .map(IElemento::archivoMasPesado)
        .max(Comparator.comparingInt(e -> e.tamanio()))
        .orElse(null);
    }

    public void listar(){
        listaElementos.stream().forEach(e -> e.mostrar(1));
    }
}
