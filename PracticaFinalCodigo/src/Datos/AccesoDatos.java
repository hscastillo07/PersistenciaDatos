package Datos;

import Dominio.Publicacion;
import Excepciones.ExcepcionesAccesoDatos;
import java.io.IOException;
import java.util.List;

public interface AccesoDatos {

    void insertaPublicacion(Publicacion p) throws IOException;

    List<Publicacion> leerPublicaciones() throws IOException;

    Publicacion buscarPublicacion(Publicacion p) throws IOException;

    boolean eliminarPublicacion(Publicacion p, String isbn) throws IOException;
}
