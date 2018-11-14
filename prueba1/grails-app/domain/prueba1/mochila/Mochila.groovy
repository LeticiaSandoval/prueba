package prueba1.mochila
import prueba1.articulos.Articulos
import prueba1.campista.Campista
import prueba1.color.Color

class Mochila {
    String tamanio
    int num_bolsas        
    static belongsTo = [Articulos]    
    
    Color color
    Campista campista
    
    static constraints = {
        tamanio nullable:false, blank:false
        num_bolsas nullable:false, min:0
    }    
}
