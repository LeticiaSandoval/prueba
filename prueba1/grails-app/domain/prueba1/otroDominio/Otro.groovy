package prueba1.otroDominio

class Otro {
    Integer cantidad;
    String descripcion;

    static constraints = {
        cantidad min: 1, max:10;
        
    }
}
