package Datos;

import Dominio.Publicacion;
import Excepciones.ExcepcionesAccesoDatos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ArrayAccesoDatos implements AccesoDatos,Serializable {

    private Publicacion arreglo[];
    private int n;

    public ArrayAccesoDatos(int tam) {
        this.arreglo = new Publicacion[tam];
    }

    @Override
    public void insertaPublicacion(Publicacion p) throws ExcepcionesAccesoDatos {
        if (this.n >= this.arreglo.length)//No hay espacio
        {
            throw new ExcepcionesAccesoDatos("El limite del arreglo fue excedido");
        }
        if (p == null) {
            throw new ExcepcionesAccesoDatos("El objeto no existe");
        }
        this.arreglo[this.n] = p;
        this.n++;
    }

    @Override
    public List<Publicacion> leerPublicaciones() throws ExcepcionesAccesoDatos {
        if (this.n == 0) {
            throw new ExcepcionesAccesoDatos("No hay publicaciones");
        }

        List<Publicacion> resultado = new ArrayList();
        for (int i = 0; i < this.n; i++) {

            Publicacion p = this.arreglo[i];
            resultado.add(p);
        }
        return resultado;
    }

    @Override
    public Publicacion buscarPublicacion(Publicacion p) throws ExcepcionesAccesoDatos {
        if (this.n == 0) {
            throw new ExcepcionesAccesoDatos("No hay publicaciones");
        }
        if (p == null) {
            throw new ExcepcionesAccesoDatos("El objeto no existe");
        }

        if (p.getIsbn() == null || p.getIsbn() == "" || p.getIsbn().equals("")) {
            throw new ExcepcionesAccesoDatos("El ISBN no existe");
        }
        Publicacion encontrado = null;
        for (int i = 0; i < this.n; i++) {

            Publicacion pub = this.arreglo[i];
            if (pub.getIsbn().equals(p.getIsbn())) {
                encontrado = pub;
                break;
            }

        }
        return encontrado;

    }

    @Override
    public boolean eliminarPublicacion(Publicacion p, String isbn) throws ExcepcionesAccesoDatos {

        boolean eliminado = false;
        for (int i = 0; i < this.n; i++) {
            Publicacion pub = this.arreglo[i];
            if (pub.getIsbn().equals(p.getIsbn())) {
                this.arreglo[i] = null;
                eliminado = true;
                this.n--;
                System.out.println("Publicacion No registrada");
            } else {
                System.out.println("Publicacion eliminada: ");
                System.out.println(eliminado);
                eliminado = false;
            }
            
        }
        return eliminado;

    }
}
