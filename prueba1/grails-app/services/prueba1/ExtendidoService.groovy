package prueba1

import grails.gorm.services.Service

@Service(Extendido)
interface ExtendidoService {

    Extendido get(Serializable id)

    List<Extendido> list(Map args)

    Long count()

    void delete(Serializable id)

    Extendido save(Extendido extendido)

}