package prueba1.campista

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class MochilaServiceSpec extends Specification {

    MochilaService mochilaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Mochila(...).save(flush: true, failOnError: true)
        //new Mochila(...).save(flush: true, failOnError: true)
        //Mochila mochila = new Mochila(...).save(flush: true, failOnError: true)
        //new Mochila(...).save(flush: true, failOnError: true)
        //new Mochila(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //mochila.id
    }

    void "test get"() {
        setupData()

        expect:
        mochilaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Mochila> mochilaList = mochilaService.list(max: 2, offset: 2)

        then:
        mochilaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        mochilaService.count() == 5
    }

    void "test delete"() {
        Long mochilaId = setupData()

        expect:
        mochilaService.count() == 5

        when:
        mochilaService.delete(mochilaId)
        sessionFactory.currentSession.flush()

        then:
        mochilaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Mochila mochila = new Mochila()
        mochilaService.save(mochila)

        then:
        mochila.id != null
    }
}
