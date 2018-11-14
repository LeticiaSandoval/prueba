package prueba1.color

import grails.gorm.services.Service

@Service(Color)
interface ColorService {

    Color get(Serializable id)

    List<Color> list(Map args)

    Long count()

    void delete(Serializable id)

    Color save(Color color)

}