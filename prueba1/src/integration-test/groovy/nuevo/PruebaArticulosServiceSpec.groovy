package nuevo

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PruebaArticulosServiceSpec extends Specification {

    PruebaArticulosService pruebaArticulosService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new PruebaArticulos(...).save(flush: true, failOnError: true)
        //new PruebaArticulos(...).save(flush: true, failOnError: true)
        //PruebaArticulos pruebaArticulos = new PruebaArticulos(...).save(flush: true, failOnError: true)
        //new PruebaArticulos(...).save(flush: true, failOnError: true)
        //new PruebaArticulos(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //pruebaArticulos.id
    }

    void "test get"() {
        setupData()

        expect:
        pruebaArticulosService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<PruebaArticulos> pruebaArticulosList = pruebaArticulosService.list(max: 2, offset: 2)

        then:
        pruebaArticulosList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        pruebaArticulosService.count() == 5
    }

    void "test delete"() {
        Long pruebaArticulosId = setupData()

        expect:
        pruebaArticulosService.count() == 5

        when:
        pruebaArticulosService.delete(pruebaArticulosId)
        sessionFactory.currentSession.flush()

        then:
        pruebaArticulosService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        PruebaArticulos pruebaArticulos = new PruebaArticulos()
        pruebaArticulosService.save(pruebaArticulos)

        then:
        pruebaArticulos.id != null
    }
}
