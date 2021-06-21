/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Dominio.Publicacion;
import Excepciones.ExcepcionesAccesoDatos;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class ArchivoTexto implements AccesoDatos {

    private File archivo;
    private FileWriter modoEscritura;
    private Scanner modoLectura;

    public ArchivoTexto() {
        this.archivo = new File("Publicacion.dat");
    }

    public ArchivoTexto(String nombreArchivo) {
        this.archivo = new File(nombreArchivo);
    }

    @Override
    public void insertaPublicacion(Publicacion p) throws IOException {
        PrintWriter pw = null;
        try {
            this.modoEscritura = new FileWriter(this.archivo, true); // modo edicion
            pw = new PrintWriter(this.modoEscritura);
            pw.println(p.getDataText());
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            if (pw != null) {
                pw.close();
            }
            this.modoEscritura.close();
        }

    }

    private Publicacion crearPublicacion(String linea) {

        String datos[] = linea.split(";");

        Publicacion p = new Publicacion() {

            @Override
            public Publicacion getInfo() {
                p.setIsbn(datos[0]);
                p.setTitulo(datos[1]);
                p.setAnio(Integer.parseInt(datos[2]));
                p.setAutor(datos[3]);
                p.setCosto(Double.parseDouble(datos[4]));
                return p;
            }

        };
    }

    @Override
    public List<Publicacion> leerPublicaciones() throws IOException {
        List<Publicacion> listado = new ArrayList();
        try {
            this.modoLectura = new Scanner(this.archivo);

            while (this.modoLectura.hasNext()) {
                String linea = this.modoLectura.nextLine();
                Publicacion p = this.crearPublicacion(linea);
                listado.add(p);
            }
            return listado;
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            if (this.modoLectura != null) {
                this.modoLectura.close();
            }
        }
    }

    @Override
    public Publicacion buscarPublicacion(Publicacion p) throws IOException {
        List<Publicacion> listado = new ArrayList();
        try {
            this.modoLectura = new Scanner(this.archivo);
            while (this.modoLectura.hasNext()) {
                String linea = this.modoLectura.nextLine();
                Publicacion p = this.crearPublicacion(linea);
                if (p.getIsbn().equalsIgnoreCase(linea)) {
                    listado.add(p);
                }
            }
            return (Publicacion) listado;
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            if (this.modoLectura != null) {
                this.modoLectura.close();
            }
        }
    }

    private void renombrarArchivo(File nvoArchivo) throws IOException {
        // se crea el archivo temporal si no existe
        if (!nvoArchivo.exists()) {
            nvoArchivo.createNewFile();
        }

        //se elimina el archivo original
        if (!this.archivo.delete()) {
            throw new IOException("No fue posible eliminar el archivo original");
        }

        //se renombra el archivo temporal
        if (!nvoArchivo.renameTo(this.archivo)) {
            throw new IOException("No fue posible renombrar el archivo temporal");
        }

    }

    @Override
    public boolean eliminarPublicacion(Publicacion p, String isbn) throws IOException {
        int contador = 0;
        try {

            this.modoLectura = new Scanner(this.archivo);
            ArchivoTexto archivoTemporal = new ArchivoTexto("Temporal.dat");
            while (this.modoLectura.hasNext()) {
                String linea = this.modoLectura.nextLine();
                Publicacion p = this.crearPublicacion(linea);
                if (modo == 0) { // valores por encima
                    if (p.getIsbn() > isbn) {// eliminar
                        contador++;
                    } else {
                        archivoTemporal.registrarJugador(jugador);
                    }
                } else { // valores por debajo
                    if (jugador.getValor() < valor) { // eliminar
                        contador++;
                    } else {
                        archivoTemporal.registrarJugador(jugador);
                    }
                }
            }
            this.modoLectura.close();
            this.renombrarArchivo(archivoTemporal.archivo);
            return contador;
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            this.modoLectura.close();
        }

    }
}

private Publicacion crearPublicacion(String linea) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
