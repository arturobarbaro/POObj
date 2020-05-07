package servicio;

import java.util.*;

/**
 * Clase encargada de la lectura de datos del sistema
 * 
 * @author Arturo Barba
 */
public class Entrada
{
    /**
     * Variable estática scanner encargada de leer datos de entrada
     */
    private static Scanner lector = new Scanner(System.in);

    /**
     * Lee y devuelve un número entero introducido al sistema
     * @return int El número
     */
    public static int getInt() {
        lector.reset();
        return lector.nextInt();
    }
    
    /**
     * Lee y devuelve un número entero introducido al sistema comprendido en 
     * un intervalo
     * @param min La cota inferior del intervalo
     * @param max La cota superior del intervalo
     * @return int El número
     */
     public static int getInt(int min, int max) {
        lector.reset();
        int op;
        do {
            op = lector.nextInt();
        } while(op > max || min > op);
        return op;
    }
    
    /**
     * Lee y devuelve una cadena introducida en el sistema
     * @return String La cadena
     */
    public static String getString() {
        lector.reset();
        return lector.nextLine().trim();
    }
    
    /**
     * Limpia el scanner
     */
    public static void limpiar() {
        lector.next();
    }
}
