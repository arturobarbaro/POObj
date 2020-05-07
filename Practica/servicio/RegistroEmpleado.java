package servicio;

import java.util.*;
import modelo.persona.empleado.*;
import modelo.persona.cliente.*;
import modelo.pedido.Pedido;
import modelo.mueble.Mueble;
import modelo.mueble.mesa.*;
import modelo.mueble.silla.*;
import modelo.enumerable.*;
import servicio.*;
import servicio.Salida;

/**
 * Clase encargada de almacenar, insertar, editar y eliminar los empleados que figuran en el sistema.
 * 
 * @author Arturo Barba
 */
public class RegistroEmpleado
{
    /**
     * Variable estática con el listado de todos los empleados
     */
    private static List<Empleado> empleados = new ArrayList<Empleado>();

    /**
     * Devuelve un empleado
     * @param id El ID
     * return Empleado El empleado
     */
    public static Empleado getEmpleado(final int id) {
        final Iterator<Empleado> iter  = empleados.iterator();
        Empleado empleado;
        while (iter.hasNext()) { 
            empleado = iter.next();
            if (id == empleado.getEmpleadoId()) {
                return empleado;
            }
        }
        return null;
    }

    /**
     * Devuelve un empleado que figura en un puesto
     * @param id El ID
     * @param cargo El puesto
     * return Empleado El empleado
     */
    public static Empleado getEmpleado(final int id, final String cargo) {
        final Iterator<Empleado> iter  = empleados.iterator();
        Empleado empleado;
        while (iter.hasNext()) { 
            empleado = iter.next();
            if (id == empleado.getEmpleadoId() 
            && empleado.getClass().getSimpleName().equals(cargo)) {
                return empleado;
            }
        }
        return null;
    }

    /**
     * Getter. Devuelve un artesano
     * 
     * @param id El id del empleado
     * @return Artesano El artesano
     */
    public static Artesano getArtesano(final int id) {
        final Iterator<Empleado> iter = empleados.iterator();
        final boolean encontrado = false;
        Empleado e;
        while (iter.hasNext()) {
            e = iter.next();
            if ((e.getClass().getSimpleName().equals("ArtesanoHora")
                || e.getClass().getSimpleName().equals("ArtesanoPlantilla")) && e.getEmpleadoId() == id) {
                return (Artesano) e;
            }
        }
        return null;
    }

    /**
     * Muestra todos los empleados que figuran en el sistema
     */
    public static void listarEmpleados() {
        Salida.separadorGordo();
        Salida.mostrar("LISTADO DE EMPLEADOS");
        Salida.separadorFino();
        if (empleados.size()<=0) {
            Salida.mostrar("No dispone de ningun empleado en su plantilla");
            Salida.separadorGordo();
            return;
        }
        final Iterator<Empleado> iter  = empleados.iterator();
        Empleado empleado;

        while (iter.hasNext()) { 
            empleado = iter.next();
            Salida.mostrar(empleado.toString());
        }
        Salida.separadorGordo();
    }

    /**
     * Muestra todos los empleados que figuran en el sistema en un puesto
     * @param cargo El puesto
     */
    public static void listarEmpleados(final String cargo) {
        Salida.separadorGordo();
        Salida.mostrar("LISTADO DE "+cargo.toUpperCase());
        Salida.separadorFino();
        if (!tiene(cargo)) {
            Salida.mostrar("No dispone de ningun "+cargo+" en su plantilla");
            Salida.separadorGordo();
            return;
        }
        final Iterator<Empleado> iter  = empleados.iterator();
        final Empleado empleado;

        Empleado puesto;
        while (iter.hasNext()) { 
            puesto = iter.next();
            if (puesto.getClass().getSimpleName().equals(cargo)) {
                Salida.mostrar(puesto.toString());
            }
        }
        Salida.separadorGordo();
    }

    /**
     * Muestra todos los artesanos y subtipos de Artesano que figuran en el sistema
     */
    public static void listarArtesanos() {
        Salida.separadorGordo();
        Salida.mostrar("LISTADO DE ARTESANOS");
        Salida.separadorFino();
        if (!tiene("ArtesanoHora") && !tiene("ArtesanoPlantilla")) {
            Salida.mostrar("No dispone de ningun artesano en su plantilla");
            Salida.separadorGordo();
            return;
        }
        final Iterator<Empleado> iter  = empleados.iterator();
        final Empleado empleado;

        Empleado puesto;
        while (iter.hasNext()) { 
            puesto = iter.next();
            if (puesto.getClass().getSimpleName().equals("ArtesanoHora") 
            || puesto.getClass().getSimpleName().equals("ArtesanoPlantilla")) {
                Salida.mostrar(puesto.toString());
            }
        }
        Salida.separadorGordo();
    }

    /**
     * Muestra todos los pedidos de un artesano a seleccionar
     */
    public static void verPedidosArtesano() {
        listarArtesanos();
        
        if (!tiene("ArtesanoHora") && !tiene("ArtesanoPlantilla")) {
            return;
        }

        Salida.mostrar("Introduzca el id del empleado");
        final int id = Entrada.getInt();
        final Artesano empleado = getArtesano(id);
        if (empleado==null) {
            Salida.mostrar("No existe el empleado con id: "+id);
            return;
        }

        RegistroPedido.listarPedidos(Estado.PARADO, empleado);
        RegistroPedido.listarPedidos(Estado.COLA_FABRICACION, empleado);
        RegistroPedido.listarPedidos(Estado.FABRICACION, empleado);
        RegistroPedido.listarPedidos(Estado.FABRICADO, empleado);
    }

    /**
     * Comprueba si existe algun empleado en el puesto indicado
     * @param cargo El puesto del empleado
     * @return boolean Si tiene empleados en el puesto
     */
    public static boolean tiene(final String cargo) {
        final Iterator<Empleado> iter  = empleados.iterator();
        String puesto;
        while (iter.hasNext()) { 
            puesto = iter.next().getClass().getSimpleName();
            if (puesto.equals(cargo)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Muestra un submenú de selección. Permite que un jefe repongan las 
     * piezas necesarias para continuar con la fabricación de un pedido
     */
    public static void reponerPiezas() {
        if (!tiene("Jefe")) {
            Salida.mostrar("Necesita tener un jefe en su plantilla");
            return;
        }
        Jefe j;
        int op;
        do {
            listarEmpleados("Jefe");
            Salida.mostrar("Introduzca el ID del jefe o 0 para salir");
            op = Entrada.getInt();
            if (op==0) {
                return;
            }
            j = (Jefe) getEmpleado(op,"Jefe");
        } while(j==null);
        
        RegistroPedido.listarPedidosPendientesDePiezas();
        
        if (RegistroPedido.getPedidosPendientesDePiezas().size() == 0) {
            return;
        }
        
        Salida.mostrar("Seleccione el id del pedido con piezas a reponer");
        final Pedido p =  RegistroPedido.getPedidoPendientePiezas(Entrada.getInt());
        
        if (p==null) {
            Salida.mostrar("No existe el pedido con el id introducido");
            return;
        }
        
        j.reponerPiezas(p);
        Salida.mostrar("Se han repuesto las piezas:");
        RegistroPieza.listarPiezas(p);
    }

    /**
     * Actualiza el estado de un pedido a Estado.PARADO mostrando submenus de selección
     */
    public static void pararPedido() {
        if (!tiene("ArtesanoHora") && !tiene("ArtesanoPlantilla")) {
            Salida.mostrar("No tiene artesanos en su plantilla");
            return;
        }
        if (!RegistroPedido.tienePedidos(Estado.FABRICACION)) {
            Salida.mostrar("No tiene ningun pedido en fabricación por un artesano");
            return;
        }

        Artesano a;        
        int op;
        do {
            listarArtesanos();
            Salida.mostrar("Introduzca el ID del artesano o 0 para salir");
            op = Entrada.getInt();
            if (op==0) {
                return;
            }
            a = getArtesano(op);
        } while(a==null);

        Pedido p;
        do {
            RegistroPedido.listarPedidos(Estado.FABRICACION, a);
            Salida.mostrar("Introduzca el ID del artesano o 0 para salir");
            op = Entrada.getInt();
            if (op==0) {
                return;
            }
            p = RegistroPedido.getPedido(op, Estado.FABRICACION, a);
        } while(p==null);

        RegistroPieza.mostrarMenu();
        final String salir = Entrada.getString();
        if (salir.length() == 1 && salir.charAt(0) == '1'){
            a.detenerTrabajo(p, RegistroPieza.recogerPiezas());
            return;
        }

        a.detenerTrabajo(p);
    }

    /**
     * Selecciona a un comercial y asigna un presupuesto a un pedido gestionado por este. 
     * Aparecen submenus para interactuar con la opción seleccionada.
     */
    public static void asignarPresupuesto(){
        if (!tiene("Comercial")) {
            Salida.mostrar("Necesita tener un comercial en su plantilla");
            return;
        }

        if (!RegistroPedido.tienePedidos(Estado.NUEVO)) {
            Salida.mostrar("No tiene ningun pedido pendiente de presupuestos");
            return;
        }

        int op;
        Comercial c;
        do {
            listarEmpleados("Comercial");
            Salida.mostrar("Introduzca el ID del comercial o 0 para salir");
            op = Entrada.getInt();
            if (op==0) {
                return;
            }
            c = (Comercial)getEmpleado(op,"Comercial");
        } while(c==null);
        Pedido p;
        do {
            RegistroPedido.listarPedidos(Estado.NUEVO);
            Salida.mostrar("Introduzca el ID del pedido o 0 para salir");
            op = Entrada.getInt();
            if (op==0) {
                return;
            }
            p = RegistroPedido.getPedido(op, Estado.NUEVO);
        } while(p==null);

        c.establecerPrecio(p);
        Salida.mostrar("Presupuesto asignado correctamente");
    }

    /**
     * Muestra un submenú para seleccionar un jefe y que este le asigne trabajo a un artesano
     */
    public static void asignarTrabajo(){
        if (!tiene("Jefe")) {
            Salida.mostrar("Necesita tener un jefe en su plantilla");
            return;
        }

        if (!tiene("ArtesanoHora") && !tiene("ArtesanoPlantilla")) {
            Salida.mostrar("No tiene artesanos en su plantilla");
            return;
        }

        if (!RegistroPedido.tienePedidos(Estado.ACEPTADO)) {
            Salida.mostrar("No tiene ningun pedido por asignar a un artesano");
            return;
        }

        Jefe j;

        int op;
        do {
            listarEmpleados("Jefe");
            Salida.mostrar("Introduzca el ID del jefe o 0 para salir");
            op = Entrada.getInt();
            if (op==0) {
                return;
            }
            j = (Jefe) getEmpleado(op,"Jefe");
        } while(j==null);
        Artesano a;
        do {
            listarArtesanos();
            Salida.mostrar("Introduzca el ID del artesano o 0 para salir");
            op = Entrada.getInt();
            if (op==0) {
                return;
            }
            a = getArtesano(op);
        } while(a==null);
        Pedido p;
        do {
            RegistroPedido.listarPedidos(Estado.ACEPTADO);
            Salida.mostrar("Introduzca el ID del pedido o 0 para salir");
            op = Entrada.getInt();
            if (op==0) {
                return;
            }
            p = RegistroPedido.getPedido(op, Estado.ACEPTADO);
        } while(p==null);

        j.asignarPedido(p,a);
        Salida.mostrar("Pedido asignado correctamente");
    }

    /**
     * Actualiza el pedido de un artesano a seleccionar en un submenú de Estado.FABRICACION a Estado.FABRICADO
     */
    public static void terminarPedidoArtesano(){
        
        if (!tiene("ArtesanoHora") && !tiene("ArtesanoPlantilla")) {
            Salida.mostrar("No tiene artesanos en su plantilla");
            return;
        }

        int op;
        Artesano a;
        do {
            listarArtesanos();
            Salida.mostrar("Introduzca el ID del artesano o 0 para salir");
            op = Entrada.getInt();
            if (op==0) {
                return;
            }
            a = getArtesano(op);
        } while(a==null);

        Pedido p;
        do {
            RegistroPedido.listarPedidos(Estado.FABRICACION,a);
            Salida.mostrar("Introduzca el ID del pedido o 0 para salir");
            op = Entrada.getInt();
            if (op==0) {
                return;
            }
            p = RegistroPedido.getPedido(op, a);
        } while(p==null);

        a.finalizarTrabajo(p);
        Salida.mostrar("Pedido finalizado por parte del artesano. Se comenzará con la siguiente tarea.");
    }

    /**
     * Muestra un submenú para actualizar el estado de un pedido a Estado.RECOGER o Estado.ENTREGAR
     */
    public static void notificarClienteEstado() {
        
        if (!tiene("Comercial")) {
            Salida.mostrar("No tiene ningún comercial en su plantilla");
            return;
        }

        if (RegistroPedido.getPedidos(Estado.FABRICADO).size() == 0) {
            Salida.mostrar("No tiene ningún nuevo pedido cuya fabricación haya sido completada");
            return;
        }

        RegistroPedido.listarPedidos(Estado.FABRICADO);
        int id;
        Pedido p;
        do {
            Salida.mostrar("Introduzca el id del pedido o 0 para salir");
            id = Entrada.getInt();
            if (id == 0) return;
            p = RegistroPedido.getPedido(id, Estado.FABRICADO);
            if (p == null) {
                Salida.mostrar("ID erroneo");
            }
        } while(p==null);

        Comercial c;
        listarEmpleados("Comercial");
        do {
            Salida.mostrar("Introduzca el id del comercial o 0 para salir");
            id = Entrada.getInt();
            if (id == 0) return;
            c = (Comercial) getEmpleado(id, "Comercial");
            if (c == null) {
                Salida.mostrar("ID erroneo");
            }
        } while(c==null);

        do {
            Salida.mostrar("Seleccione una opción:");
            Salida.mostrar("[1] Notificar de entrega");
            Salida.mostrar("[2] Notificar de recogida");
            Salida.mostrar("[0] Cancelar y salir");
            id = Entrada.getInt();
        } while (id > 2 || id < 0);

        switch (id) {
            case 0:
            return;
            case 1:
            c.notificarClienteEntregar(p);
            break;
            case 2:
            c.notificarClienteRecoger(p);
            break;
        }
        Salida.mostrar("Se ha actualizado el estado del pedido");
    }

    /**
     * Muestra un submenú y lee entradas del usuario para dar de alta a un nuevo empleado en el sistema
     */
    public static void altaEmpleado() {
        int opcion;
        do {
            Salida.mostrarMensajeAltaEmpleado();
            opcion = Entrada.getInt();
        } while (opcion > 4 || opcion < 0);

        switch (opcion) {
            case 0:
            return;
            case 1:
            addJefe();
            break;
            case 2:
            addComercial();
            break;
            case 3:
            addArtesano();
            break;
        }
    }

    /**
     * Da de alta a un nuevo empleado y muestra un mensaje de éxito en la operación
     */
    public static void addEmpleado(final Empleado e) {
        empleados.add(e);
        Salida.mostrar("El empleado: "+e.toString());
        Salida.mostrar("Ha sido añadido al sistema");
    }

    /**
     * Comprueba si el sistema tiene empleados y pide un id al usuario para eliminar al empleado indicado
     */
    public static void eliminarEmpleado() {
        listarEmpleados();
        if (empleados.size()==0) return;
        Salida.mostrar("Introduzca el id del empleado que quiere eliminar");
        deleteEmpleado(Entrada.getInt());
    } 

    /**
     * Comprueba si el sistema tiene empleados y pide un id al usuario para editar al empleado indicado
     */
    public static void editarEmpleado() {
        listarEmpleados();
        if (empleados.size()==0) return;
        Salida.mostrar("Introduzca el id del empleado que quiere editar");
        final int id = Entrada.getInt();
        final Empleado empleado = getEmpleado(id);

        if (empleado==null) {
            Salida.mostrar("No existe el empleado con id: "+id);
            return;
        }

        Salida.mostrar("Inserte el nuevo nombre del empleado");
        Entrada.getString();
        empleado.setNombre(Entrada.getString());
    }

    /**
     * Elimina a un empleado del sistema
     * @param id El ID del empleado
     */
    private static void deleteEmpleado(final int id) {
        final Empleado empleado = getEmpleado(id);
        if (empleado==null) {
            Salida.mostrar("No existe el empleado con id: "+id);
            return;
        }
        empleados.remove(getEmpleado(id));
    }

    /**
     * Muestra un submenú y lee entradas del usuario para dar de alta a un nuevo
     * artesano en el sistema
     */
    private static void addArtesano() {
        int opcion;
        do {
            Salida.mostrarMensajeAltaArtesano();
            opcion = Entrada.getInt();
        } while (opcion > 3 || opcion < 0);

        switch (opcion) {
            case 0:
            return;
            case 1:
            addArtesanoHora();
            break;
            case 2:
            addArtesanoPlantilla();
            break;
        }
    }

    /**
     * Da de alta a un nuevo jefe en el sistema con el nombre introducido por el
     * usuario
     */
    private static void addJefe() {
        Salida.mostrar("Introduzca el nombre del jefe");
        Entrada.getString();
        final Jefe e = new Jefe(Entrada.getString());
        addEmpleado(e);
    }

    /**
     * Da de alta a un nuevo comercial en el sistema con el nombre introducido por
     * el usuario
     */
    private static void addComercial() {
        Salida.mostrar("Introduzca el nombre del comercial");
        Entrada.getString();
        final Comercial e = new Comercial(Entrada.getString());
        addEmpleado(e);
    }

    /**
     * Da de alta a un nuevo artesano por hora en el sistema con el nombre
     * introducido por el usuario
     */
    private static void addArtesanoHora() {
        Salida.mostrar("Introduzca el nombre del artesano por hora");
        Entrada.getString();
        final ArtesanoHora e = new ArtesanoHora(Entrada.getString());
        addEmpleado(e);
    }

    /**
     * Da de alta a un nuevo artesano en plantilla en el sistema con el nombre
     * introducido por el usuario
     */
    private static void addArtesanoPlantilla() {
        Salida.mostrar("Introduzca el nombre del artesano en plantilla");
        Entrada.getString();
        final ArtesanoPlantilla e = new ArtesanoPlantilla(Entrada.getString());
        addEmpleado(e);
    }
}
