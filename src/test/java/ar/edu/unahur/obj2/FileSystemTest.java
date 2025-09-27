package ar.edu.unahur.obj2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class FileSystemTest {

    IElemento archivo1 = new Archivo("Imagen-A",".jpg",280);
    IElemento archivo2 = new Archivo("Rock",".mp3",270);
    IElemento archivo3 = new Archivo("Notas",".txt",200);
    IElemento archivo4 = new Archivo("Dibujo-A",".jpg",200);
    IElemento carpetaA = new Carpeta("Carpeta A Nivel 1",List.of(archivo1,archivo2));
    FileSystem filesystem = new FileSystem(List.of(archivo3,archivo4,carpetaA));

    @Test
    void dadaUnaCarpetaAElTamanioTotalEsDe540Bytes() {
        assertEquals(550,carpetaA.tamanio());
    }

    @Test
    void dadaUnaCarpetaAElArchivoMasPesadoEsArchivo1() {
        assertEquals(archivo1,carpetaA.archivoMasPesado());
    }

    @Test
    void dadaUnFileSystemElTamanioTotalEs950() {
        assertEquals(950,filesystem.tamanioTotalSistema());
    }

    @Test
    void dadaUnFileSystemElArchivoMasPesadoEsLaCarpetaA() {
        assertEquals(archivo1,filesystem.archivoMasPesado());
    }

    @Test
    void listarTodoElSistemaDeArchivos() {
        filesystem.listar();
    }
}
