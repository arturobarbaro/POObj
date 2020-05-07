package servicio;

import java.util.*;
import modelo.enumerable.*;
import modelo.pedido.*;

/**
 * Clase encargada la gestión de piezas.
 * 
 * @author Arturo Barba
 */
public class RegistroPieza
{
    /**
     * Muestra un listado con todas las posibles piezas
     */
    public static void listarPiezas() {
        for (int i = 0; Pieza.values().length > i; i++) {
            Salida.mostrar("["+i+1+"] "+Pieza.values()[i].toString());
        }
    }

    /**
     * Muestra un listado con todas las posibles piezas
     */
     public static void listarPiezas(Pedido p) {
        for (int i = 0; p.getPiezas().size() > i; i++) {
            Salida.mostrar("["+i+1+"] "+p.getPiezas().get(i).toString());
        }
    }

    /**
     * Muestra un listado con todas las posibles piezas
     */
    public static void mostrarMenu() {
        Salida.salto();
        Salida.mostrar("[1] Notificar que faltan piezas");
        Salida.mostrar("Pulse cualquier otra letra si no faltan piezas");
    }

    /**
     * Muestra un listado con todas las posibles piezas 
     * y devuelve una lista con toda las piezas seleccionadas
     */
    public static ArrayList<Pieza> recogerPiezas() {
        ArrayList<Pieza> piezas = new ArrayList<Pieza>();
        Pieza pieza;
        do {
            listarPiezas();
            Salida.mostrar("[0] Continuar y notificar las piezas seleccionadas");
            pieza = leerPieza();
            if (pieza!=null) piezas.add(pieza);
        } while(pieza!=null || (pieza==null&& piezas.size()>0));
        return piezas;
    }

    /**
     * Muestra un listado con todas las posibles piezas 
     * y devuelve una lista con toda las piezas seleccionadas
     */
    public static Pieza leerPieza() {
        int id = Entrada.getInt(0,Pieza.values().length-1);
        if (id == 0) {
            return null;
        }
        return Pieza.values()[id-1];
    }
}
