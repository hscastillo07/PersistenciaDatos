/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Dominio.Publicacion;
import Excepciones.ExcepcionesAccesoDatos;
import java.util.List;

/**
 *
 * @author usuario
 */
public class ListAccesoDatos implements AccesoDatos{

    @Override
    public void insertaPublicacion(Publicacion p) throws ExcepcionesAccesoDatos {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Publicacion> leerPublicaciones() throws ExcepcionesAccesoDatos {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Publicacion buscarPublicacion(Publicacion p) throws ExcepcionesAccesoDatos {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarPublicacion(Publicacion p, String isbn) throws ExcepcionesAccesoDatos {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
