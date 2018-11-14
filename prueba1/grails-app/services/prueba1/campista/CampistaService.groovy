package prueba1.campista

import grails.gorm.services.Service

@Service(Campista)
interface CampistaService {

    Campista get(Serializable id)

    List<Campista> list(Map args)

    Long count()

    void delete(Serializable id)

    Campista save(Campista campista)

}