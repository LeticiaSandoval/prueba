package prueba1.articulos

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ArticulosServiceSpec extends Specification {

    ArticulosService articulosService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Articulos(...).save(flush: true, failOnError: true)
        //new Articulos(...).save(flush: true, failOnError: true)
        //Articulos articulos = new Articulos(...).save(flush: true, failOnError: true)
        //new Articulos(...).save(flush: true, failOnError: true)
        //new Articulos(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //articulos.id
    }

    void "test get"() {
        setupData()

        expect:
        articulosService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Articulos> articulosList = articulosService.list(max: 2, offset: 2)

        then:
        articulosList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        articulosService.count() == 5
    }

    void "test delete"() {
        Long articulosId = setupData()

        expect:
        articulosService.count() == 5

        when:
        articulosService.delete(articulosId)
        sessionFactory.currentSession.flush()

        then:
        articulosService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Articulos articulos = new Articulos()
        articulosService.save(articulos)

        then:
        articulos.id != null
    }
}
