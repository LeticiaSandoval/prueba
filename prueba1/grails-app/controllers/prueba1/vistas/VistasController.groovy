package prueba1.vistas

import prueba1.interaccion.InteraccionService

class VistasController {
    
    def interaccionService

    def index() {
        render(view:'index', model:[lista:interaccionService.listarDatos()])
    }
    
    def otraVentana(){}
}
