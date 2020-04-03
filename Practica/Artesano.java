import java.util.*;

/**
 * Abstract class Artesano - write a description of the class here
 * 
 * @author: 
 * Date: 
 */
public abstract class Artesano extends Empleado
{
    // instance variables - replace the example below with your own
    private int pedido_id = -1;
    private HashMap <Integer,Pedido> pedidos;
    private HashMap <Integer,Pedido> pedidosCompletados;
    public Artesano() {
       super();
       this.pedidos = new HashMap <Integer,Pedido>();
    }
    
    public Artesano(String nombre) {
       super(nombre);
       this.pedidos = new HashMap <Integer,Pedido>();
    }

    public boolean tieneTrabajo() {
        return (getPedidoId()>=0)?true:false;
    }
    
    public int getPedidoId() {
        return this.pedido_id;
    }
    
    public void asignarTrabajo(int pedido_id)
    {
        int anterior = this.pedido_id;
        setPedidoId(pedido_id);
        if (anterior!=pedido_id) {
            System.out.println("El trabajo ha sido asignado correctamente");
        } else {
            System.out.println("El artesano tiene otro trabajo asignado.");
        }
    }
    
    public void finalizarTrabajo()
    {
        setPedidoId(-1);
    }
    
    private void setPedidoId(int id) {
        if (!tieneTrabajo()) {
          this.pedido_id = id;
        }
    }
    
}
