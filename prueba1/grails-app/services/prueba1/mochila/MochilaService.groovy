package prueba1.mochila

import grails.gorm.services.Service

@Service(Mochila)
interface MochilaService {

    Mochila get(Serializable id)

    List<Mochila> list(Map args)

    Long count()

    void delete(Serializable id)

    Mochila save(Mochila mochila)

}