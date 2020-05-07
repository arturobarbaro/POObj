package modelo.enumerable;


/**
 * Enumeration class Estado - Listado de todos los estados disponibles
 * en los que se puede encontrar un pedido
 * 
 * @author Arturo Barba
 */
public enum Estado
{
    /**
     * Estado por defecto al crear un pedido y pendiente de asignar presupuesto
     */
    NUEVO {
        public String toString() {
            return "nuevo";
        }
    }, 
    /**
     * Pendiente de aprobar el presupuesto
     */
    PENDIENTE {
        public String toString() {
            return "pendiente de estudio del presupuesto";
        }
    },
    /**
     * Pedido cancelado (por rechazo de presupuesto por ejemplo)
     */
    CANCELADO {
        public String toString() {
            return "cancelado";
        }
    },
    /**
     * Presupuesto aceptado, pendiente de asignacion de un jefe a un artesano
     */
    ACEPTADO {
        public String toString() {
            return "presupuesto aceptado";
        }
    }, 
    /**
     * En fabricacion por un artesano
     */
    COLA_FABRICACION {
        public String toString() {
            return "pendiente de fabricación por el artesano";
        }
    },
    /**
     * En fabricacion por un artesano
     */
    FABRICACION {
        public String toString() {
            return "en fabricación";
        }
    },
    /**
     * Fabricado por un artesano, pendiente de que un comercial notifique al 
     * cliente
     */
    FABRICADO {
        public String toString() {
            return "fabricado";
        }
    },
    /**
     * Pendiente de recogida por parte de un cliente
     */
    RECOGER {
        public String toString() {
            return "pendiente de recoger por el cliente";
        }
    },
    /**
     * Pendiente de entrega y confirmación de recepcion por un cliente
     */
    ENTREGAR {
        public String toString() {
            return "pendiente de entrega";
        }
    },
    /**
     * Pedido completado y en manos del cliente
     */
    FINALIZADO {
        public String toString() {
            return "finalizado";
        }
    },
    /**
     * Parado por falta de piezas u otros. Pendiente de reanudación
     */
    PARADO {
        public String toString() {
            return "parado";
        }
    }
}
