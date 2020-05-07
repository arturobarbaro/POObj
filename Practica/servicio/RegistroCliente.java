package servicio;


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
import servicio.Entrada;
import servicio.Salida;

/**
 * Clase encargada de almacenar, insertar, editar y eliminar los clientes que figuran en el sistema.
 * 
 * @author Arturo Barba
 */
public class RegistroCliente
{
    /**
     * Variable estática con el listado de todos los clientes
     */
    private static List<Cliente> clientes = new ArrayList<Cliente>();

    /**
     * Getter cliente. Devuelve in cliente del sistema en función de su ID
     * @param id El ID el cliente
     * @return Cliente El cliente
     */
    public static Cliente getCliente(int id) {
        Iterator<Cliente> iter = clientes.iterator();
        boolean encontrado = false;
        Cliente cliente;
        while (iter.hasNext() && !encontrado) { 
            cliente = iter.next();
            if (id == cliente.getClienteId()) {
                encontrado = !encontrado;
                return cliente;
            }
        }
        return null;
    }
    
    /**
     * Muestra el listado de todos los clientes que figuran en el sistema
     */
    public static void listarClientes() {
        Salida.separadorGordo();
        Salida.mostrar("LISTADO DE CLIENTES");
        Salida.separadorFino();
        if (clientes.size()<=0) {
            Salida.mostrar("No dispone de ningun cliente en la base de datos");
            Salida.separadorGordo();
            return;
        }
        Iterator<Cliente> iter  = clientes.iterator();
        Cliente cliente;
        
        while (iter.hasNext()) { 
            cliente = iter.next();
            Salida.mostrar(cliente.toString());
        }
        Salida.separadorGordo();
    }
    
    /**
     * Indica si hay clientes en el sistema
     * @return boolean Si existen clientes o no
     */
    public static boolean tieneClientes() {
        return clientes.size() > 0;
    }
    
    /**
     * Muestra un submenú de selección y permite ver, aceptar o rechazar los presupuestos generados por un comercial a un pedido realizado por
     * el cliente seleccionado
     */
    public static void verPresupuesto(){
        if (!tieneClientes()){
            Salida.mostrar("No existen clientes en el sistema");
            return;
        }
        
        if (!RegistroPedido.tienePedidos(Estado.PENDIENTE)){
            Salida.mostrar("No existen pedidos en este estado");
            return;
        }
        
        int id;
        Cliente cliente;
        do {
            RegistroCliente.listarClientes();
            Salida.mostrar("Introduzca el id del cliente o 0 para salir");
            id = Entrada.getInt();
            if (id == 0) return;
            cliente = getCliente(id);
        } while(cliente==null);
        
        if(RegistroPedido.getPedidos(Estado.PENDIENTE, cliente).size() == 0){
            Salida.mostrar("El cliente no pendiente ningún presupuesto por aprobar");
            return;
        }
        
        Pedido p;
        do {
            RegistroPedido.listarPedidos(Estado.PENDIENTE, cliente);
            Salida.mostrar("Introduzca el id del pedido o 0 para salir");
            id = Entrada.getInt();
            if (id == 0) return;
            p = RegistroPedido.getPedido(id, Estado.PENDIENTE, cliente);
        } while(p==null);
        
        Salida.mostrar("Seleccionado el pedido: "+p.toString());
        
        int opcion;
        do {
            Salida.mostrar("Seleccione una opcion:");
            Salida.mostrar("[1] Aceptar presupuesto");
            Salida.mostrar("[2] Rechazar presupuesto");
            Salida.mostrar("[0] Salir");
            opcion = Entrada.getInt();
        } while (opcion > 2 || opcion < 0);

        switch (opcion) {
            case 0:
            return;
            case 1:
            cliente.aceptarPresupuesto(p);
            Salida.mostrar("Presupuesto aceptado. Pendiente de fabricacción");
            break;
            case 2:
            cliente.rechazarPresupuesto(p);
            Salida.mostrar("Presupuesto rechazado. El pedido ha sido cancelado");
            break;
        }
    }
    
    /**
     * Muestra un submenú y lee entradas del sistema para dar de alta a un nuevo cliente
     */
    public static void altaCliente() {
        int opcion;
        do {
            Salida.mostrarMensajeAltaCliente();
            opcion = Entrada.getInt();
        } while (opcion > 2 || opcion < 0);

        switch (opcion) {
            case 0:
            return;
            case 1:
            addParticular();
            break;
            case 2:
            addEmpresa();
            break;
        }
    }

    /**
     * Añade un cliente al sistema y muestra un mensaje de éxito
     * @param c El cliente
     */
    public static void addCliente(Cliente c) {
        clientes.add(c);
        Salida.mostrar("El cliente: "+c.toString());
        Salida.mostrar("Ha sido añadido al sistema");
    }

    /**
     * Muestra un listado de todos los clientes y pide la seleccion de un usuario por id para eliminarlo del sistema
     */
    public static void eliminarCliente() {
        listarClientes();
        if (!tieneClientes()) {
            return;
        }
        Salida.mostrar("Introduzca el id del cliente que quiere eliminar");
        deleteCliente(Entrada.getInt());
    }

    /**
     * Muestra un listado de todos los clientes y pide la selección de un cliente por id para editar sus datos en el sistema
     */
    public static void editarCliente() {
        listarClientes();
        if (!tieneClientes()) {
            return;
        }
        Salida.mostrar("Introduzca el id del cliente que quiere editar");
        int id = Entrada.getInt();
        Cliente cliente = getCliente(id);

        if (cliente==null) {
            Salida.mostrar("No existe el cliente con ID: "+id);
            return;
        }

        Salida.mostrar("Inserte el nuevo nombre del cliente");
        Entrada.getString();
        cliente.setNombre(Entrada.getString());
    }

    /**
     * Elimina a un cliente del sistema. Muestra un mensaje de éxito o de error.
     * @param id El id del cliente
     */
    private static void deleteCliente(int id) {
        Cliente cliente = getCliente(id);
        if (cliente == null) {
            Salida.mostrar("No existe el cliente con ID: "+id);
            return;
        }
        clientes.remove(cliente);
    }

    /**
     * Crea un cliente Particular con el nombre introducido por el usuario y realiza
     * una llamada al método auxiliar encargado de guardar el cliente en el sistema
     */
    private static void addParticular() {
        Salida.mostrar("Introduzca el nombre del cliente particular");
        Entrada.getString();
        Particular e = new Particular(Entrada.getString());
        addCliente(e);
    }

    /**
     * Crea un cliente Empresa con el nombre introducido por el usuario y realiza
     * una llamada al método auxiliar encargado de guardar el cliente en el sistema
     */
    private static void addEmpresa() {
        Salida.mostrar("Introduzca el nombre de la empresa");
        Entrada.getString();
        Empresa e = new Empresa(Entrada.getString());
        addCliente(e);
    }

}
