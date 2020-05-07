import java.util.*;

import modelo.persona.empleado.*;
import modelo.persona.cliente.*;
import modelo.pedido.Pedido;
import modelo.mueble.Mueble;
import modelo.mueble.mesa.*;
import modelo.mueble.silla.*;
import modelo.enumerable.*;
import servicio.RegistroEmpleado;
import servicio.RegistroMueble;
import servicio.RegistroPedido;
import servicio.RegistroCliente;
import servicio.Entrada;
import servicio.Salida;

/**
 * Clase encargada de proporcionar el conjunto de menus y submenus principales
 * 
 * @author Arturo Barba
 */
public class Menu
{
    /**
     * Menú principal. Inicia el menú.
     */
    public static void iniciar() {
        boolean firstTime = true;
        do {
            if (!firstTime) {
                Salida.salto();
                Salida.salto();
                Salida.salto();
                Salida.mostrar(".");
                Salida.mostrar(".");
                Salida.mostrar(".");
                Entrada.getString();
                Salida.mostrar("Pulse 0 para salir y cualquier otra letra para continuar");
                Salida.salto();
                Salida.salto();
                Salida.salto();
                String salir = Entrada.getString();
                if (salir.length() == 1 && salir.charAt(0) == '0'){
                    Salida.mostrar("Cerrando aplicación");
                    return;
                }
            } else {
                firstTime = false;
            }

            mostrarPrincipal();
            int op = Entrada.getInt(0,14);
            switch (op) {
                case 0:
                Salida.mostrar("Vuelva pronto");
                return;
                case 1:
                gestionArtesanos();
                break;
                case 2:
                RegistroEmpleado.reponerPiezas();
                break;
                case 3:
                RegistroPedido.anotarPedido();
                break;
                case 4:
                RegistroCliente.verPresupuesto();
                break;
                case 5:
                RegistroPedido.finalizarPedido();
                break;
                case 6:
                RegistroEmpleado.asignarPresupuesto();
                break;
                case 7:
                RegistroEmpleado.notificarClienteEstado();
                break;
                case 8:
                RegistroEmpleado.verPedidosArtesano();
                break;
                case 9:
                RegistroEmpleado.terminarPedidoArtesano();
                break;
                case 10:
                RegistroEmpleado.pararPedido();
                break;
                case 11:
                gestionClientes();
                break;
                case 12:
                gestionEmpleados();
                break;
                case 13:
                gestionMuebles();
                break;
                case 14:
                gestionPedidos();
                break;
            }
        } while (true);
    }
    
    /**
     * Submenú de gestión de pedidos, que llama a la clase encargada de 
     * obtener, modificar, insertar o eliminar datos y ofrece diferentes 
     * opciones a realizar.
     */
    private static void gestionPedidos() {
        Salida.mostrar("[1] Ver el listado completo de pedidos");
        Salida.mostrar("[2] Ver los pedidos en un estado determinado");
        Salida.mostrar("[3] Buscar un pedido");
        Salida.mostrar("[4] Buscar un pedido en un estado determinado");
        Salida.mostrar("[0] Menu principal");
        int op = Entrada.getInt(0, 4);
        switch (op) {
            case 0:
            return;
            case 1:
            RegistroPedido.listarPedidos();
            break;
            case 2:
            RegistroPedido.listarPedidosEstado();
            break;
            case 3:
            RegistroPedido.buscarPedido();
            break;
            case 4:
            RegistroPedido.menuBuscarPedido();
            break;
        }
    }

    
    /**
     * Submenú de gestión de artesanos por parte de un jefe. 
     * Ofrece diferentes opciones a realizar, entre ellas ver el progreso
     * del trabajo de un artesano o asignar trabajo a este.
     */
    private static void gestionArtesanos() {
        Salida.mostrar("[1] Asignar trabajo a un artesano");
        Salida.mostrar("[2] Ver el progreso de un artesano");
        Salida.mostrar("[0] Menu principal");
        int op = Entrada.getInt(0, 2);
        switch (op) {
            case 0:
            return;
            case 1:
            RegistroEmpleado.asignarTrabajo();
            break;
            case 2:
            RegistroEmpleado.verPedidosArtesano();
            break;
        }
    }

    /**
     * Submenú de gestión de empleados, que llama a la clase encargada de 
     * obtener, modificar, insertar o eliminar datos y ofrece diferentes 
     * opciones a realizar.
     */
    private static void gestionEmpleados() {
        Salida.mostrar("[1] Alta empleado");
        Salida.mostrar("[2] Eliminar empleado");
        Salida.mostrar("[3] Editar empleado");
        Salida.mostrar("[0] Menu principal");
        int op = Entrada.getInt(0, 3);
        switch (op) {
            case 0:
            return;
            case 1:
            RegistroEmpleado.altaEmpleado();
            break;
            case 2:
            RegistroEmpleado.eliminarEmpleado();
            break;
            case 3:
            RegistroEmpleado.editarEmpleado();
            break;
        }
    }

    /**
     * Submenú de gestión de clientes, que llama a la clase encargada de 
     * obtener, modificar, insertar o eliminar datos y ofrece diferentes 
     * opciones a realizar.
     */
    private static void gestionClientes() {
        Salida.mostrar("[1] Alta cliente");
        Salida.mostrar("[2] Eliminar cliente");
        Salida.mostrar("[3] Editar cliente");
        Salida.mostrar("[0] Menu principal");
        int op = Entrada.getInt(0, 3);
        switch (op) {
            case 0:
            return;
            case 1:
            RegistroCliente.altaCliente();
            break;
            case 2:
            RegistroCliente.eliminarCliente();
            break;
            case 3:
            RegistroCliente.editarCliente();
            break;
        }
    }

    /**
     * Submenú de gestión de muebles, que llama a la clase encargada de 
     * obtener, modificar, insertar o eliminar datos y ofrece diferentes 
     * opciones a realizar.
     */
    private static void gestionMuebles() {
        Salida.mostrar("[1] Añadir un mueble al sistema");
        Salida.mostrar("[2] Eliminar un mueble del sistema");
        Salida.mostrar("[3] Listar muebles");
        Salida.mostrar("[0] Menu principal");
        int op = Entrada.getInt(0, 3);
        switch (op) {
            case 0:
            return;
            case 1:
            RegistroMueble.addMuebles();
            break;
            case 2:
            RegistroMueble.eliminarMueble();
            break;
            case 3:
            RegistroMueble.listaMuebles();
            break;
        }
    }

    /**
     * Muestra las opciones del menú principal.
     */
    private static void mostrarPrincipal() {
        Salida.mostrar("MENU PRINCIPAL");
        Salida.separadorGordo();
        Salida.salto();
        Salida.mostrar("ACCIONES DE JEFE");
        Salida.salto();
        Salida.separadorFino();
        Salida.mostrar("[1] Gestionar trabajo de artesanos");
        Salida.mostrar("[2] Reponer stock de piezas");
        Salida.separadorFino();
        Salida.salto();
        Salida.mostrar("ACCIONES DE CLIENTE");
        Salida.separadorFino();
        Salida.mostrar("[3] Realizar nuevo pedido");
        Salida.mostrar("[4] Aceptar/Rechazar presupuestos");
        Salida.mostrar("[5] Recoger o confirmar recepción de pedidos");
        Salida.separadorFino();
        Salida.salto();
        Salida.mostrar("ACCIONES DE COMERCIAL");
        Salida.mostrar("[6] Asignar presupuesto a un pedido");
        Salida.mostrar("[7] Notificar a cliente pendiente recogida");
        Salida.separadorFino();
        Salida.salto();
        Salida.mostrar("ACCIONES DE ARTESANO");
        Salida.separadorFino();
        Salida.mostrar("[8] Ver pedidos asignados");
        Salida.mostrar("[9] Notificar terminación de fabricación");
        Salida.mostrar("[10] Notificar incidencia");
        Salida.separadorFino();
        Salida.salto();
        Salida.mostrar("GESTIÓN GENERAL");
        Salida.separadorFino();
        Salida.mostrar("[11] Gestión de clientes");
        Salida.mostrar("[12] Gestión de empleados");
        Salida.mostrar("[13] Gestión de muebles");
        Salida.mostrar("[14] Gestión de pedidos");
        Salida.separadorFino();
        Salida.mostrar("[0] Salir");
        Salida.mostrar("Por favor seleccione una opción:");
    }
}
