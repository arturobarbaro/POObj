/**
 * Abstract class Muebles - write a description of the class here
 * 
 * @author: 
 * Date: 
 */
public abstract class Mueble
{
    private double precio;
    
    public Mueble() {
    }
    
    public Mueble(double precio) {
        setPrecio(precio);
    }
    
    public double getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(double precio) {
        if (precio > 0)
            this.precio = precio;
    }
    
    public String toString() {
        return "Precio: "+getPrecio()+" euros.";
    }
}
