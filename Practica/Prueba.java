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
 * Clase encargada de generar datos de pruebas. Añade empleados, clientes, 
 * muebles y pedidos al sistema.
 * 
 * @author Arturo Barba
 */
public class Prueba
{
    /**
     * Variable con el listado de nombres de pruebas.
     */
    private static List<String> nombresPropios;
    /**
     * Variable con el listado de apellidos de pruebas.
     */
    private static List<String> apellidos;

    static {
        nombresPropios = Arrays.asList(
            "Ángel", "María", "Carmen", "Arturo", "Lourdes", "Carlos", 
            "Antonio", "Germán", "Soledad", "Marcos", "Adrián", "Mercedes",
            "Rocío", "Adán", "Luis", "Almudena"
        );

        apellidos = Arrays.asList(
            "García", "Barba", "López", "Olmedo", "Pérez", "Rodríguez",
            "Román", "Mellado", "Escobar", "Banderas", "Delgado", "Ramos",
            "González", "Fernández", "Gómez", "Martín", "Ruiz",
            "Hernández", "Díaz", "Torres", "Muñoz", "Jiménez",
            "Vázquez", "Serrano", "Molina"
        );
    }
    
    /**
     * Método encargado de cargar datos iniciales en el sistema.
     * Llama a métodos auxiliares para obtener e insertar la información.
     */
    public static void cargarDatos() {
        Salida.mostrar("Generando datos de pruebas...");
        datosEmpleados();
        datosClientes();
        datosMuebles();
        datosPedidos();
        actualizarUnPedido();
        Salida.mostrar("Se han añadido datos al sistema para pruebas");
    }
    
    /**
     * Método que genera un número entero aleatorio comprendido en un rango.
     * @param min Cota inferior del intervalo
     * @param max Cota superior del intervalo
     * @return Un entero comprendido en el intervalo
     */
    public static int enteroAleatorioEntreRango(int min, int max) {
        return (int) decimalAleatorioEntreRango(min, max);
    }
    
    /**
     * Método que genera un número float aleatorio comprendido en un rango.
     * @param min Cota inferior del intervalo
     * @param max Cota superior del intervalo
     * @return Un número float comprendido en el intervalo
     */
    public static float decimalAleatorioEntreRango(float min, float max) {
        return (float) (Math.random() * ((max + 1) - min)) + min;
    }
    
    /**
     * Método que genera nombre aleatorio, obteniendolo de la variable 
     * List<String> nombresPropios.
     * @return El nombre
     */
    public static String generarNombrePropio() {
        return nombresPropios.get(enteroAleatorioEntreRango(0, nombresPropios.size() - 1));
    }

    /**
     * Método que genera un apellido aleatorio, obteniendolo de la variable 
     * List<String> apellidos.
     * @return El apellido
     */
    public static String generarApellido() {
        return apellidos.get(enteroAleatorioEntreRango(0, nombresPropios.size() - 1));
    }

    /**
     * Método que genera nombre aleatorio seguido de un primer y un 
     * segundo apellido.
     * @return El nombre completo seguido de dos apellidos
     */
    public static String generarNombrePropioCompleto() {
        String nombre = generarNombrePropio();
        String primerApellido = generarApellido();
        String segundoApellido = generarApellido();

        return String.format("%s %s %s", nombre, primerApellido, segundoApellido);
    }
    
    /**
     * Método que inserta empleados de prueba en el sistema
     */
    private static void datosEmpleados() {
        RegistroEmpleado.addEmpleado(new Jefe(generarNombrePropioCompleto()));
        RegistroEmpleado.addEmpleado(new Comercial(generarNombrePropioCompleto()));
        RegistroEmpleado.addEmpleado(new ArtesanoHora(generarNombrePropioCompleto()));
        RegistroEmpleado.addEmpleado(new ArtesanoPlantilla(generarNombrePropioCompleto()));
    }
    
    /**
     * Método que inserta clientes de prueba en el sistema
     */
    private static void datosClientes() {
        RegistroCliente.addCliente(new Empresa(generarNombrePropioCompleto()));
        RegistroCliente.addCliente(new Particular(generarNombrePropioCompleto()));
        RegistroCliente.addCliente(new Particular(generarNombrePropioCompleto()));
    }
    
    /**
     * Método que inserta muebles de prueba en el sistema
     */
    private static void datosMuebles() {
        RegistroMueble.addMueble(new MesaDeComedor());
        RegistroMueble.addMueble(new MesaCafeMadera());
        RegistroMueble.addMueble(new MesaCafeCristal());
        RegistroMueble.addMueble(new SillaPlegable());
        RegistroMueble.addMueble(new SillaConRuedas());
        RegistroMueble.addMueble(new SillaSinRuedas());
    }
    
    /**
     * Método que inserta pedidos de prueba en el sistema
     */
    private static void datosPedidos() {
        ArrayList<Mueble> muebles = new ArrayList<Mueble>();
        muebles.add(new MesaDeComedor());
        RegistroPedido.addPedido(new Pedido(muebles, RegistroCliente.getCliente(1)));
        muebles.add(new SillaCocina());
        RegistroPedido.addPedido(new Pedido(muebles, RegistroCliente.getCliente(2)));
        muebles.add(new SillaConRuedas());
        RegistroPedido.addPedido(new Pedido(muebles, RegistroCliente.getCliente(2)));
    }
    
    /**
     * Método que actualiza el estado de un pedido de prueba en el sistema
     */
    private static void actualizarUnPedido() {
        Comercial c = (Comercial)RegistroEmpleado.getEmpleado(2, "Comercial");
        Pedido p = RegistroPedido.getPedido(1);
        Cliente cli = p.getCliente();
        c.establecerPrecio(p);
        cli.aceptarPresupuesto(p);
        
    }
}
