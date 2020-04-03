import java.util.*;

/**
 * Write a description of class Pedido here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pedido
{
    // instance variables - replace the example below with your own
    private static int idActual = 1;
    private int id;
    private Cliente cliente;
    private Comercial comercial;
    private ArrayList <Mueble> muebles;
    private Estado estado;

    /**
     * Constructor for objects of class Pedido
     */
    public Pedido(ArrayList <Mueble> muebles, Cliente cliente)
    {
        muebles = new ArrayList <Mueble>(muebles);
        this.id = this.idActual;
        this.idActual++;
        this.estado = Estado.PENDIENTE;
        this.cliente = cliente;
    }

    public double getPrecio() {
        double total = 0;
        Iterator<Mueble> iter  = muebles.iterator();
        Mueble mueble;
        while (iter.hasNext()) { 
            total += iter.next().getPrecio();
        }
        return total;
    }
}
