import java.util.*;

/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fabrica
{
    // instance variables - replace the example below with your own
    public List<Empleado> empleados;
    public List<Cliente> clientes;
    public List<Pedido> pedidos;
    public List<Mueble> muebles;
    private Entrada entrada;
    private Salida salida;

    /**
     * Constructor for objects of class Main
     */
    public Fabrica() {
        empleados = new ArrayList<Empleado>();
        clientes = new ArrayList<Cliente>();
        pedidos = new ArrayList<Pedido>();
        muebles = new ArrayList<Mueble>();
        entrada = new Entrada();
        salida = new Salida();
    }

    public void crearUsuario() {
        setUsuario(Operacion.CREAR);
    }

    public void eliminarUsuario() {
        setUsuario(Operacion.ELIMINAR);
    }

    public void editarUsuario() {
        setUsuario(Operacion.EDITAR);
    }

    private Cliente getCliente(int id) {
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

    private Empleado getEmpleado(int id) {
        Iterator<Empleado> iter  = empleados.iterator();
        boolean encontrado = false;
        Empleado empleado;
        while (iter.hasNext() && !encontrado) { 
            empleado = iter.next();
            if (id == empleado.getEmpleadoId()) {
                encontrado = !encontrado;
                return empleado;
            }
        }
        return null;
    }
    
    private int leerCantidad(int min, int max) {
        int cantidad;
        do {
            salida.mostrar("Entre "+min+" y "+max+".");
            cantidad = entrada.getInt();
        } while ( cantidad > max || cantidad < min);
        return cantidad;
    }

    public void verListaMuebles() {
        Iterator<Mueble> iter  = muebles.iterator();
        Mueble mueble;
        while (iter.hasNext()) { 
            salida.mostrar(iter.next().toString());
        }
    }

    public boolean tieneArtesanos() {
        Iterator<Empleado> iter  = empleados.iterator();
        boolean encontrado = false;
        String puesto;
        while (iter.hasNext()) { 
            puesto = iter.next().getClass().getSimpleName();
            if (puesto == "ArtesanoHora" || puesto == "ArtesanoPlantilla") {
                return true;
            }
        }
        return false;
    }
    
    public Artesano getArtesano(int id) {
        Iterator<Empleado> iter  = empleados.iterator();
        boolean encontrado = false;
        List<Artesano> artesanos = new ArrayList<Artesano>();
        String puesto;
        while (iter.hasNext()) { 
            puesto = iter.next().getClass().getSimpleName();
            if ((puesto == "ArtesanoHora" || puesto == "ArtesanoPlantilla")) {
                iter.remove();
            }
        }
        
        while (iter.hasNext()) { 
            puesto = iter.next().getClass().getSimpleName();
            if ((puesto != "ArtesanoHora" || puesto != "ArtesanoPlantilla")) {
                iter.remove();
            }
        }
        return null;
    }

    public boolean tieneClientes() {
        return clientes.size() > 0;
    }

    public void anotarPedido() {
        ArrayList <Mueble> productos = new ArrayList <Mueble>();

        Artesano artesano;
        if (!tieneArtesanos()) {
            salida.mostrar("Debe tener almenos un artesano contratado para poder realizar un pedido");
            addArtesano();
        }  else {
            int id;
            do {
                salida.mostrar("Introduzca el id del artesano");
                id = entrada.getInt();
            } while(getEmpleado(id).getClass().getSimpleName());
            
            
            artesano = getEmpleado(id);
        }
        
        Cliente cliente;

        if (!tieneClientes()) {
            salida.mostrar("Debe tener almenos un artesano contratado para poder realizar un pedido");
            altaCliente();
            cliente = clientes.get(0);
        } else {
            salida.mostrar("Introduzca el id del cliente");
            cliente = getCliente(entrada.getInt());
        }

        salida.mostrar("Introduzca el id del artesano que debe fabricar los muebles");
        int artesanoId = entrada.getInt();
        int opcion;
        
        do {

            do {
                salida.mostrarOpcionesPedido();
                opcion = entrada.getInt();
            } while ( (opcion == 2 && productos.size() == 0) ||opcion > 1 || opcion < 0);

            if (opcion == 0) return;

            switch (opcion) {
                case 1:
                addMuebles(productos);
                break;
                case 2:
                new Pedido(productos,cliente);
                return;
                default:
                return;
            }

        } while (opcion == 1 && productos.size() == 0);
    }

    private void addMuebles(ArrayList <Mueble> productos) {
        int opcion;
        do {
            salida.mostrarMensajeMuebles();
            opcion = entrada.getInt();
        } while ( opcion > 2 || opcion < 0);

        if (opcion == 0) return;

        switch (opcion) {
            case 1:
            addMesas(productos);
            break;
            case 2:
            addSillas(productos);
            break;
            default:
            return;
        }
    }

    private void addMesas(ArrayList <Mueble> productos) {
        int opcion;
        do {
            salida.mostrarMensajeMesas();
            opcion = entrada.getInt();
        } while ( opcion > 3 || opcion < 0);

        if (opcion == 0) return;
        int cantidad;
        cantidad = leerCantidad(0,99);

        switch (opcion) {
            case 1:
            int tipo;
            do {
                salida.mostrarMensajeMesaCafe();
                tipo = entrada.getInt();
            } while ( tipo > 2 || opcion < 0);

            if (tipo == 1){
                for (int i = 0; i < cantidad; i++) {
                    MesaCafeCristal mesa = new MesaCafeCristal();
                    muebles.add(mesa);
                    productos.add(mesa);
                }
            } else if (tipo == 2){
                for (int i = 0; i < cantidad; i++) {
                    MesaCafeMadera mesa = new MesaCafeMadera();
                    muebles.add(mesa);
                    productos.add(mesa);
                }
            }
            break;
            case 2:
            for (int i = 0; i < cantidad; i++) {
                MesaDeDormitorio mesa = new MesaDeDormitorio();
                muebles.add(mesa);
                productos.add(mesa);
            }
            break;
            case 3:
            for (int i = 0; i < cantidad; i++) {
                MesaDeComedor mesa = new MesaDeComedor();
                muebles.add(mesa);
                productos.add(mesa);
            }
            break;
            default:
            return;
        }
    }

    private void addSillas(ArrayList <Mueble> productos) {
        int opcion;
        do {
            salida.mostrarMensajeSillas();
            opcion = entrada.getInt();
        } while ( opcion > 3 || opcion < 0);

        if (opcion == 0) return;

        switch (opcion) {
            case 1:
            break;
            case 2:
            break;
            default:
            return;
        }
    }

    private void setUsuario(Operacion operacion) {
        int opcion;

        do {
            salida.mostrarMensaje(operacion);
            opcion = entrada.getInt();
        } while (opcion > 2 || opcion < 0);

        switch (opcion) {
            case 0:
            return;
            case 1:
            if (operacion == Operacion.CREAR) {
                altaEmpleado();
            } else if(operacion == Operacion.ELIMINAR) {
                eliminarEmpleado();
            } else {
                editarEmpleado();
            }
            break;
            case 2:
            if (operacion == Operacion.CREAR) {
                altaCliente();
            } else if(operacion == Operacion.ELIMINAR) {
                eliminarCliente();
            } else {
                editarCliente();
            }
            break;
        }
    }

    public void altaCliente() {
        int opcion;
        do {
            salida.mostrarMensajeAltaCliente();
            opcion = entrada.getInt();
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

    private void altaEmpleado() {
        int opcion;
        do {
            salida.mostrarMensajeAltaEmpleado();
            opcion = entrada.getInt();
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

    private void addArtesano() {
        int opcion;
        do {
            salida.mostrarMensajeAltaArtesano();
            opcion = entrada.getInt();
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

    private void addParticular() {
        salida.mostrar("Introduzca el nombre del cliente particular");
        entrada.getString();
        Particular e = new Particular(entrada.getString());
        addCliente(e);
    }

    private void addEmpresa() {
        salida.mostrar("Introduzca el nombre de la empresa");
        entrada.getString();
        Empresa e = new Empresa(entrada.getString());
        addCliente(e);
    }

    private void addJefe() {
        salida.mostrar("Introduzca el nombre del jefe");
        entrada.getString();
        Jefe e = new Jefe(entrada.getString());
        addEmpleado(e);
    }

    private void addComercial() {
        salida.mostrar("Introduzca el nombre del comercial");
        entrada.getString();
        Comercial e = new Comercial(entrada.getString());
        addEmpleado(e);
    }

    private void addArtesanoHora() {
        salida.mostrar("Introduzca el nombre del artesano por hora");
        entrada.getString();
        ArtesanoHora e = new ArtesanoHora(entrada.getString());
        addEmpleado(e);
    }

    private void addArtesanoPlantilla() {
        salida.mostrar("Introduzca el nombre del artesano en plantilla");
        entrada.getString();
        ArtesanoPlantilla e = new ArtesanoPlantilla(entrada.getString());
        addEmpleado(e);
    }

    private void addEmpleado(Empleado e) {
        empleados.add(e);
        salida.mostrar("El empleado: "+e.toString());
        salida.mostrar("Ha sido añadido al sistema");
    }

    private void addCliente(Cliente c) {
        clientes.add(c);
        salida.mostrar("El cliente: "+c.toString());
        salida.mostrar("Ha sido añadido al sistema");
    }

    private void eliminarEmpleado() {
        salida.mostrar("Introduzca el id del empleado que quiere eliminar");
        deleteEmpleado(entrada.getInt());
    }

    private void eliminarCliente() {
        salida.mostrar("Introduzca el id del cliente que quiere eliminar");
        deleteCliente(entrada.getInt());
    }

    private void editarEmpleado() {
        salida.mostrar("Introduzca el id del empleado que quiere editar");
        int id = entrada.getInt();
        Empleado empleado = getEmpleado(id);

        if (empleado==null) {
            salida.mostrar("No existe el empleado con id: "+id);
            return;
        }

        salida.mostrar("Inserte el nuevo nombre del empleado");
        entrada.getString();
        empleado.setNombre(entrada.getString());
    }

    private void editarCliente() {
        salida.mostrar("Introduzca el id del clienteleado que quiere editar");
        int id = entrada.getInt();
        Cliente cliente = getCliente(id);

        if (cliente==null) {
            salida.mostrar("No existe el cliente con id: "+id);
            return;
        }

        salida.mostrar("Inserte el nuevo nombre del cliente");
        entrada.getString();
        cliente.setNombre(entrada.getString());
    }

    private void deleteEmpleado(int id) {
        Iterator<Empleado> iter  = empleados.iterator();
        boolean encontrado = false;
        empleados.remove(getEmpleado(id));
    }

    private void deleteCliente(int id) {
        Iterator<Cliente> iter  = clientes.iterator();
        boolean encontrado = false;
        clientes.remove(getCliente(id));
    }

}
