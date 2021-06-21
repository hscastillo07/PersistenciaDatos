package Negocio;

import Datos.*;
import Dominio.Publicacion;
import Excepciones.ExcepcionesAccesoDatos;
import java.util.List;

public class RegistroPublicacion {

    private AccesoDatos datos;

    public RegistroPublicacion() {
        this.datos = new ArrayAccesoDatos(100);
    }

    public void addPublicacion(Publicacion p) throws ExcepcionesAccesoDatos {
        this.datos.insertaPublicacion(p);
    }

    public List<Publicacion> consultaPublicaciones() throws ExcepcionesAccesoDatos {
        return this.datos.leerPublicaciones();
    }

    public Publicacion buscarPublicacion(Publicacion p) throws ExcepcionesAccesoDatos {
        return this.datos.buscarPublicacion(p);
    }

    public boolean eliminarPublicacion(Publicacion p, String isbn) throws ExcepcionesAccesoDatos {
        return this.datos.eliminarPublicacion(p, isbn);
    }

}
