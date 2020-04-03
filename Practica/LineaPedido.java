import java.util.*;

/**
 * Write a description of class Pedido here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LineaPedido
{
    private int unidades;
    private Mueble mueble;
    private Artesano artesanoAsignado;
    private EstadoFabricacion estado;

    /**
     * Constructor for objects of class Pedido
     */
    public LineaPedido(int unidades, Mueble muebñe, Artesano artesanoAsignado)
    {
        this.unidades = unidades;
        this.mueble = mueble;
        this.artesanoAsignado = artesanoAsignado;
        //this.estado;
    }
    
    public double getImporte() {
        return mueble.getPrecio() * this.unidades;
    }
}
