package prueba1.articulos
import prueba1.mochila.Mochila

class Articulos {
     String nombre
     String descripcion
     
    static hasMany=[mochila:Mochila]
    
    static constraints = {
        nombre size:1..100, nullable:false, blank:false
        descripcion size: 1..200, nullable:true 
    }
}
