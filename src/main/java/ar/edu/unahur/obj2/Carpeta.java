package ar.edu.unahur.obj2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Carpeta implements IElemento{

    private String nombre;
    private List<IElemento> elementos = new ArrayList<>();

    

    public Carpeta(String nombre, List<IElemento> elementos) {
        this.nombre = nombre;
        this.elementos = elementos;
    }
    @Override
    public String nombre() {
        return nombre;
    }

    @Override
    public Integer tamanio() {
        return elementos.stream().mapToInt(e -> e.tamanio()).sum();
    }

    @Override
    public void mostrar(Integer identacion) {
        System.out.println(nombre() + "( " + this.tamanio()+ "-Bytes)\n");
        elementos.stream().forEach(e -> e.mostrar(identacion + 1));
    }

    @Override
    public IElemento archivoMasPesado() {
        return elementos.stream()
        .filter(e -> e instanceof Archivo)
        .max(Comparator.comparingInt(e -> e.tamanio()))
        .orElse(null);
    }

    public List<IElemento> getElementos() {
        return elementos;
    }
}
