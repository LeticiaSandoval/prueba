package prueba1.Prueba1

class PrimerDominio {
    
    String frutas;
    String sabores;

    static constraints = {
        frutas nullable: true;
        sabores unique: true;        
    }
}
