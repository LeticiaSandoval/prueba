package prueba1.articulos

import grails.gorm.services.Service

@Service(Articulos)
interface ArticulosService {

    Articulos get(Serializable id)

    List<Articulos> list(Map args)

    Long count()

    void delete(Serializable id)

    Articulos save(Articulos articulos)

}