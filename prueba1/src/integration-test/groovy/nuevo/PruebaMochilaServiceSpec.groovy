package nuevo

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PruebaMochilaServiceSpec extends Specification {

    PruebaMochilaService pruebaMochilaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new PruebaMochila(...).save(flush: true, failOnError: true)
        //new PruebaMochila(...).save(flush: true, failOnError: true)
        //PruebaMochila pruebaMochila = new PruebaMochila(...).save(flush: true, failOnError: true)
        //new PruebaMochila(...).save(flush: true, failOnError: true)
        //new PruebaMochila(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //pruebaMochila.id
    }

    void "test get"() {
        setupData()

        expect:
        pruebaMochilaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<PruebaMochila> pruebaMochilaList = pruebaMochilaService.list(max: 2, offset: 2)

        then:
        pruebaMochilaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        pruebaMochilaService.count() == 5
    }

    void "test delete"() {
        Long pruebaMochilaId = setupData()

        expect:
        pruebaMochilaService.count() == 5

        when:
        pruebaMochilaService.delete(pruebaMochilaId)
        sessionFactory.currentSession.flush()

        then:
        pruebaMochilaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        PruebaMochila pruebaMochila = new PruebaMochila()
        pruebaMochilaService.save(pruebaMochila)

        then:
        pruebaMochila.id != null
    }
}
