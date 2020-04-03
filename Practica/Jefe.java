
/**
 * Write a description of class Jefe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jefe extends Empleado
{
    public Jefe() {
       super();
    }
    
    public Jefe(String nombre) {
       super(nombre);
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void asignarPedido(int pedido_id, Artesano artesano)
    {
        artesano.asignarTrabajo(pedido_id);
    }
    
    public String toString() {
        return super.toString() + ". Puesto: jefe";
    }
}
