package prueba1

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ExtendidoServiceSpec extends Specification {

    ExtendidoService extendidoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Extendido(...).save(flush: true, failOnError: true)
        //new Extendido(...).save(flush: true, failOnError: true)
        //Extendido extendido = new Extendido(...).save(flush: true, failOnError: true)
        //new Extendido(...).save(flush: true, failOnError: true)
        //new Extendido(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //extendido.id
    }

    void "test get"() {
        setupData()

        expect:
        extendidoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Extendido> extendidoList = extendidoService.list(max: 2, offset: 2)

        then:
        extendidoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        extendidoService.count() == 5
    }

    void "test delete"() {
        Long extendidoId = setupData()

        expect:
        extendidoService.count() == 5

        when:
        extendidoService.delete(extendidoId)
        sessionFactory.currentSession.flush()

        then:
        extendidoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Extendido extendido = new Extendido()
        extendidoService.save(extendido)

        then:
        extendido.id != null
    }
}
