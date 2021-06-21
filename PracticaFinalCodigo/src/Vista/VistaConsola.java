
package Vista;

import Dominio.*;
import Excepciones.ExcepcionesAccesoDatos;
import Negocio.RegistroPublicacion;
import java.util.*;

/**
 *
 * @author usuario
 */
public class VistaConsola {

    private String titulos[] = {"1.Registrar publicacion",
        "2. Ver publicaciones",
        "3. Buscar publicaciones",
        "4. Eliminar publicaciones",
        "0.Salir"
    };
    private int opcion;
    private Scanner lector;
    private RegistroPublicacion logica;

    public VistaConsola() {
        this.lector = new Scanner(System.in);
        this.logica = new RegistroPublicacion();

    }

    public VistaConsola(Publicacion AudioLibro) {
        this.lector = new Scanner(System.in);
        this.logica = new RegistroPublicacion();

        try {
            this.logica.addPublicacion(AudioLibro);
        } catch (ExcepcionesAccesoDatos ex) {

        }

    }

    public void ejecutarMenu() {
        do {
            this.imprimirTitulos();
            this.leerOpcion();
            this.ejecutarOpcion();
        } while (this.opcion != 0);
    }

    public void imprimirTitulos() {
        System.out.println("\nMENU DE LA APLICACION");

        for (int i = 0; i < this.titulos.length; i++) {
            System.out.println(this.titulos[i]);
        }
    }

    public void leerOpcion() {
        boolean excepcion = true;
        do {
            try {
                System.out.println("\nSeleccione una opcion: ");
                this.opcion = this.lector.nextInt();
                excepcion = false;
            } catch (java.util.InputMismatchException ime) {
                System.out.println("Se requiere valor entero.");
                excepcion = true;
                this.lector.nextLine();
            }

        } while (excepcion);
    }

    public void ejecutarOpcion() {
        switch (this.opcion) {
            case 1:
                System.out.println("Ingrese tipo (libro o audiolibro): ");
                String tipo = this.lector.next();
                switch (tipo) {
                    case "libro":
                        vistaInsertaPublicacion();
                        break;
                    case "audiolibro":
                        vistaInsertaPublicacion(tipo);
                        break;
                }

                break;
            case 2:
                vistaConsultarPublicacion();
                break;
            case 3:
                vistaBuscarPublicacion();
                break;
            case 4:
                vistaEliminarPublicacion();
                break;
            case 0:
                System.out.println("Ha salido de la aplicacion");
                break;
            default:
                System.out.println("Opcion no valida");
        }

    }

    public void vistaInsertaPublicacion() {
        System.out.println(this.titulos[this.opcion - 1]);

        try {
            System.out.println("");
            System.out.println("-------------LIBRO-------------- ");
            System.out.println("Inserte numero de paginas: ");
            String snPaginas = this.lector.next();
            int nPaginas = Integer.parseInt(snPaginas);
            System.out.println("Inserte año de edicion: ");
            String sEdicion = this.lector.next();
            int Edicion = Integer.parseInt(sEdicion);
            System.out.println("Inserte el ISBN: ");
            String isbn = this.lector.next();
            System.out.println("Inserte el titulo: ");
            String Titulo = this.lector.next();
            System.out.println("Inserte nombre del autor: ");
            String Autor = this.lector.next();
            System.out.println("Inserte año de publicación: ");
            String sAnio = this.lector.next();
            int Anio = Integer.parseInt(sAnio);
            System.out.println("Inserte el costo del libro: ");
            String sCosto = this.lector.next();
            int Costo = Integer.parseInt(sCosto);

            Publicacion Libro = new Libro(nPaginas, Edicion, isbn, Titulo, Autor, Anio, Costo);
            this.logica.addPublicacion(Libro);
        } catch (ExcepcionesAccesoDatos ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void vistaInsertaPublicacion(String tipo) {
        System.out.println(this.titulos[this.opcion - 1]);
        
        try {
            System.out.println("-------------AUDIOLIBRO-----------");
            System.out.println("Inserte la duración: ");
            String sDuracion = this.lector.next();
            double Duracion = Double.parseDouble(sDuracion);
            System.out.println("Inserte el formato: ");
            String Formato = this.lector.next();
            System.out.println("Inserte el peso: ");
            String sPeso = this.lector.next();
            double Peso = Double.parseDouble(sPeso);
            System.out.println("Inserte el ISBN: ");
            String isbn = this.lector.next();
            System.out.println("Inserte el titulo: ");
            String Titulo = this.lector.next();
            System.out.println("Inserte nombre del autor: ");
            String Autor = this.lector.next();
            System.out.println("Inserte año de publicación: ");
            String sAnio = this.lector.next();
            int Anio = Integer.parseInt(sAnio);
            System.out.println("Inserte el costo del libro: ");
            String sCosto = this.lector.next();
            int Costo = Integer.parseInt(sCosto);

            Publicacion AudioLibro = new AudioLibro(Duracion, Formato, Peso, isbn, Titulo, Autor, Anio, Costo);
            this.logica.addPublicacion(AudioLibro);
        } catch (ExcepcionesAccesoDatos ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void vistaBuscarPublicacion() {
        System.out.println("");
        System.out.println(this.titulos[this.opcion - 1]);
        System.out.println("ISBN a buscar: ");
        String isbn = this.lector.next();
        try {
            Publicacion pub = this.logica.buscarPublicacion(new Libro(isbn));
            if (pub == null) {

                Publicacion pub1 = this.logica.buscarPublicacion(new AudioLibro(isbn));
                if (pub1 == null) {
                    System.out.println("La publicacion no está registrada");
                } else {
                    System.out.println(pub1);
                }
            } else {
                System.out.println("6");
                System.out.println(pub);
            }
            System.out.println("7");
        } catch (ExcepcionesAccesoDatos ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void vistaConsultarPublicacion() {

        try {

            System.out.println("-------------LISTA DE PUBLICACIONES-----------");
            System.out.println(this.titulos[this.opcion - 1]);
            List<Publicacion> lista = this.logica.consultaPublicaciones();

            for (Publicacion i : lista) {
                System.out.println(i);
            }
        } catch (ExcepcionesAccesoDatos ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void vistaEliminarPublicacion() {

        System.out.println("-------------ELIMINACIÓN DE PUBLICACIONES-----------");
        System.out.println(this.titulos[this.opcion - 1]);
        System.out.println("ISBN a eliminar: ");
        String isbn = this.lector.next();
        try {
            List<Publicacion> lista = this.logica.consultaPublicaciones();
            Publicacion pub = this.logica.buscarPublicacion(new Libro(isbn));
            this.logica.eliminarPublicacion(pub, isbn);
        } catch (ExcepcionesAccesoDatos ex) {
            System.out.println(ex.getMessage());
        }

    }
}
