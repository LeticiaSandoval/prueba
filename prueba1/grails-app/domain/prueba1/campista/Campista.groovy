package prueba1.campista
import prueba1.mochila.Mochila

class Campista {
    String nombre
    String apellido
    String telefono
    Integer edad
    
    static constraints = {        
        nombre nullable:false, size:2..70, blank:false
        apellido nullable:false, maxSize:50, blank:false        
    }  
}
