package prueba1.interaccion

import grails.gorm.transactions.Transactional

import prueba1.Prueba1.PrimerDominio
import prueba1.otroDominio.Otro

@Transactional
class InteraccionService {

    def listarDatos() {        
        def lista = PrimerDominio.list()
        lista
    }
}
