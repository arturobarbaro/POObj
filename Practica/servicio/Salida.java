package servicio;

import modelo.enumerable.Operacion;

/**
 * Clase encargada de mostrar información al usuario por consola
 * 
 * @author Arturo Barba
 */
public class Salida
{
    /**
     * Muestra un separador fino
     */
    public static void separadorFino() {
        mostrar("----------------------------------------------------------");
    }
    
    /**
     * Muestra un separador gordo
     */
    public static void separadorGordo() {
        mostrar("==========================================================");
    }

    /**
     * Muestra un mensaje
     * @param mensaje El mensaje
     */
    public static void mostrar(String mensaje) {
        System.out.println(mensaje);
    }
    
    /**
     * Realiza un salto de línea
     */
    public static void salto() {
        System.out.println();
    }
    
    /**
     * Muestra un submenú de opciones con las Sublclases de Silla
     */
    public static void mostrarMensajeSillas() {
        Salida.mostrar("[1] Sillas de oficina");
        Salida.mostrar("[2] Sillas de cocina");
        Salida.mostrar("[3] Sillas plegable");
        Salida.mostrar("[0] Salir");
    }
    
    /**
     * Muestra un submenú de opciones con las Sublclases de Mesa
     */
    public static void mostrarMensajeMesas() {
        Salida.mostrar("[1] Mesa de café");
        Salida.mostrar("[2] Mesa de dormitorio");
        Salida.mostrar("[3] Mesa de comedor");
        Salida.mostrar("[0] Salir");
    }
    
    /**
     * Muestra un submenú de opciones con las Sublclases de SillaDeOficina
     */
    public static void mostrarMensajeSillaOficina() {
        Salida.mostrar("[1] Silla de oficina con ruedas");
        Salida.mostrar("[2] Silla de oficina sin ruedas");
        Salida.mostrar("[0] Salir");
    }
    
    /**
     * Muestra un submenú de opciones con las Sublclases de MesaDeCafé
     */
    public static void mostrarMensajeMesaCafe() {
        Salida.mostrar("[1] Mesa de cristal");
        Salida.mostrar("[2] Mesa de madera");
        Salida.mostrar("[0] Salir");
    }
    
    /**
     * Muestra un submenú de opciones con las Sublclases de Mueble
     */
    public static void mostrarMensajeMuebles() {
        Salida.mostrar("[1] Ver sillas");
        Salida.mostrar("[2] Ver mesas");
        Salida.mostrar("[0] Salir");
    }
    
    /**
     * Muestra un submenú de opciones con las Sublclases de Cliente
     */
    public static void mostrarMensajeAltaCliente() {
        mostrar("[1] Cliente particular");
        mostrar("[2] Empresa");
        mostrar("[0] Salir");
    }
    
    /**
     * Muestra un submenú de opciones con las Sublclases de Empleado
     */
    public static void mostrarMensajeAltaEmpleado() {
        mostrar("[1] Jefe");
        mostrar("[2] Comercial");
        mostrar("[3] Artesano");
        mostrar("[0] Salir");
    }
    
    /**
     * Muestra un submenú de opciones con las Sublclases de Artesano
     */
    public static void mostrarMensajeAltaArtesano() {
        mostrar("[1] Artesano por hora");
        mostrar("[2] Artesano en plantilla");
        mostrar("[0] Salir");
    }
    
    /**
     * Muestra un submenú para añadir un pedido
     */
    public static void mostrarOpcionesPedido() {
        Salida.mostrar("Introduzca uno de los siguientes valores");
        Salida.mostrar("[1]. Para añadir muebles a su pedido");
        Salida.mostrar("[2]. Para finalizar la compra");
        Salida.mostrar("[0]. Para salir y cancelar el pedido");
    }
}
