
/**
 * Write a description of class Salida here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Salida
{
    public void mostrarMensaje(Operacion operacion) {
        System.out.println("Introduzca uno de los siguientes valores");
        System.out.println("0. Para salir");
        System.out.println("1. Para "+operacion.toString().toLowerCase()
            +" un empleado");
        System.out.println("2. Para "+operacion.toString().toLowerCase()
            +" un cliente");
    }

    public void mostrarMensajeAltaCliente() {
        System.out.println("Introduzca uno de los siguientes valores");
        System.out.println("0. Para salir");
        System.out.println("1. Para añadir un cliente como particular");
        System.out.println("2. Para añadir un cliente como empresa");
    }

    public void mostrarMensajeAltaEmpleado() {
        System.out.println("Introduzca uno de los siguientes valores");
        System.out.println("0. Para salir");
        System.out.println("1. Para añadir un jefe");
        System.out.println("2. Para añadir un comercial");
        System.out.println("3. Para añadir un artesano");
    }

    public void mostrarMensajeAltaArtesano() {
        System.out.println("Introduzca uno de los siguientes valores");
        System.out.println("0. Para salir");
        System.out.println("1. Para añadir un artesano por hora");
        System.out.println("2. Para añadir un artesano en plantilla");
    }

    public void mostrarMensajeSillas() {
        System.out.println("Introduzca uno de los siguientes valores");
        System.out.println("0. Para salir y cancelar el pedido");
        System.out.println("1. Para sillas de oficina");
        System.out.println("2. Para sillas de cocina");
        System.out.println("3. Para sillas plegables");
    }

    public void mostrarMensajeMesaCafe() {
        System.out.println("Introduzca uno de los siguientes valores");
        System.out.println("0. Para salir y cancelar el pedido");
        System.out.println("1. Para añadir mesa cristal");
        System.out.println("2. Para añadir mesa de madera");
    }

    public void mostrarMensajeMesas() {
        System.out.println("Introduzca uno de los siguientes valores");
        System.out.println("0. Para salir y cancelar el pedido");
        System.out.println("1. Para añadir mesa de cafe");
        System.out.println("2. Para añadir mesa de dormitorio");
        System.out.println("2. Para añadir mesa de comedor");
    }

    public void mostrarMensajeMuebles() {
        System.out.println("Introduzca uno de los siguientes valores");
        System.out.println("0. Para salir y cancelar el pedido");
        System.out.println("1. Para añadir mesas");
        System.out.println("2. Para añadir sillas");
    }

    public void mostrarOpcionesPedido() {
        System.out.println("Introduzca uno de los siguientes valores");
        System.out.println("0. Para salir y cancelar el pedido");
        System.out.println("1. Para añadir muebles a su pedido");
        System.out.println("2. Para finalizar la compra");
    }

    public void mostrar(String mensaje) {
        System.out.println(mensaje);
    }
}
