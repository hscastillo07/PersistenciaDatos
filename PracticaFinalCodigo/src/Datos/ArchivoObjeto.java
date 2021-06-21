/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Dominio.Publicacion;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author usuario
 */
public class ArchivoObjeto implements AccesoDatos {

    private File archivo;
    private FileInputStream aLectura;
    private FileOutputStream aEscritura;
    
    
    public ArchivoObjeto(String name) {
        this.archivo = new File(name);
    }
    public ArchivoObjeto() {
        this("Publiacion.obj");
    }
    @Override
    public void insertaPublicacion(Publicacion p) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Publicacion> leerPublicaciones() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Publicacion buscarPublicacion(Publicacion p) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarPublicacion(Publicacion p, String isbn) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
