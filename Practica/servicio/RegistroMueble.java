package servicio;

import java.util.*;

import modelo.persona.empleado.*;
import modelo.persona.cliente.*;
import modelo.pedido.Pedido;
import modelo.mueble.Mueble;
import modelo.mueble.mesa.*;
import modelo.mueble.silla.*;
import modelo.enumerable.Operacion;
import servicio.RegistroEmpleado;
import servicio.RegistroMueble;
import servicio.RegistroPedido;
import servicio.Entrada;
import servicio.Salida;

/**
 * Clase encargada de almacenar, insertar, editar y eliminar los muebles que figuran en el sistema.
 * 
 * @author Arturo Barba
 */
public class RegistroMueble
{
    /**
     * Variable estática con el listado de todos los muebles que figuran en el sistema
     */
    public static List<Mueble> muebles = new ArrayList<Mueble>();
    
    /**
     * Getter Mueble. Devuelve un Mueble dado su ID.
     * @param id El id
     */
    public static Mueble getMueble(int id) {
        Iterator<Mueble> iter  = muebles.iterator();
        boolean encontrado = false;
        Mueble mueble;
        while (iter.hasNext() && !encontrado) { 
            mueble = iter.next();
            if (id == mueble.getId()) {
                encontrado = !encontrado;
                return mueble;
            }
        }
        return null;
    }
    
    /**
     * Lista todos los muebles que figuran en el sistema
     */
    public static void listaMuebles() {
        Iterator<Mueble> iter  = muebles.iterator();
        Mueble mueble;
        while (iter.hasNext()) { 
            Salida.mostrar(iter.next().toString());
        }
    }
    
    /**
     * Añade un mueble al sistema
     * @param b El mueble
     */
    public static void addMueble(Mueble b) {
        muebles.add(b);
    }

    /**
     * Muestra un submenú y requiere que el usuario seleccione una opción para añadir muebles al sistema
     */
    public static void addMuebles() {
        int opcion;
        do {
            Salida.mostrarMensajeMuebles();
            opcion = Entrada.getInt();
        } while ( opcion > 2 || opcion < 0);

        if (opcion == 0) return;

        switch (opcion) {
            case 1:
            addMesas();
            break;
            case 2:
            addSillas();
            break;
            default:
            return;
        }
    }

    /**
     * Muestra el listado de muebles en stock del sistema y pide la selección de uno
     * para eliminarlo del sistema
     */
    public static void eliminarMueble() {
        listaMuebles();
        if (muebles.size() == 0)
            return;
        Salida.mostrar("Introduzca el id del mueble que quiere eliminar");
        deleteMueble(Entrada.getInt());
    }

    /**
     * Muestra un submenú y requiere que el usuario seleccione una opción para añadir mesas al sistema
     */
    private static void addMesas() {
        int opcion;
        do {
            Salida.mostrarMensajeMesas();
            opcion = Entrada.getInt();
        } while ( opcion > 3 || opcion < 0);

        if (opcion == 0) return;

        switch (opcion) {
            case 1:
            int tipo;
            do {
                Salida.mostrarMensajeMesaCafe();
                tipo = Entrada.getInt();
            } while ( tipo > 2 || opcion < 0);

            if (tipo == 1){
                    MesaCafeCristal mesa = new MesaCafeCristal();
                    muebles.add(mesa);
                    Salida.mostrar("Se ha añadido al sistema: "+mesa.toString());
            } else if (tipo == 2){
                    MesaCafeMadera mesa = new MesaCafeMadera();
                    muebles.add(mesa);
                    Salida.mostrar("Se ha añadido al sistema: "+mesa.toString());
            }
            break;
            case 2:
                MesaDeDormitorio mesa = new MesaDeDormitorio();
                muebles.add(mesa);
                Salida.mostrar("Se ha añadido al sistema: "+mesa.toString());
            break;
            case 3:
                MesaDeComedor m = new MesaDeComedor();
                muebles.add(m);
                Salida.mostrar("Se ha añadido al sistema: "+m.toString());
            break;
            default:
            return;
        }
    }

    /**
     * Muestra un submenú y requiere que el usuario seleccione una opción para añadir mesas al sistema
     */
    private static void addSillas() {
        int opcion;
        do {
            Salida.mostrarMensajeSillas();
            opcion = Entrada.getInt();
        } while ( opcion > 3 || opcion < 0);

        if (opcion == 0) return;

        switch (opcion) {
             case 1:
            int tipo;
            do {
                Salida.mostrarMensajeSillaOficina();
                tipo = Entrada.getInt();
            } while ( tipo > 2 || opcion < 0);

            if (tipo == 1){
                    SillaConRuedas s = new SillaConRuedas();
                    muebles.add(s);
                    Salida.mostrar("Se ha añadido al sistema: "+s.toString());
            } else if (tipo == 2){
                    SillaSinRuedas s = new SillaSinRuedas();
                    muebles.add(s);
                    Salida.mostrar("Se ha añadido al sistema: "+s.toString());
            }
            break;
            case 2:
                SillaPlegable s = new SillaPlegable();
                muebles.add(s);
                Salida.mostrar("Se ha añadido al sistema: "+s.toString());
            break;
            case 3:
                SillaCocina m = new SillaCocina();
                muebles.add(m);
                Salida.mostrar("Se ha añadido al sistema: "+m.toString());
            break;
            default:
            return;
        }
    }
    
    /**
     * Método encargado de devolver un valor comprendido en un rango
     * @param min La cota inferior
     * @param max La cota superior
     * @return int El valor
     */
    private static int leerCantidad(int min, int max) {
        int cantidad;
        do {
            Salida.mostrar("Entre "+min+" y "+max+".");
            cantidad = Entrada.getInt();
        } while ( cantidad > max || cantidad < min);
        return cantidad;
    }

    /**
     * Elimina un mueble del sistema. Muestra un mensaje de éxito o error.
     * @param id El ID del mueble
     */
    private static void deleteMueble(int id) {
        Mueble mueble = getMueble(id);
        if (mueble==null) {
            Salida.mostrar("No existe el mueble con id: "+id);
            return;
        }
        muebles.remove(getMueble(id));
    }
}
