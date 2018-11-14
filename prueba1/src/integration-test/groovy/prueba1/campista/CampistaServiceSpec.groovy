package prueba1.campista

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CampistaServiceSpec extends Specification {

    CampistaService campistaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Campista(...).save(flush: true, failOnError: true)
        //new Campista(...).save(flush: true, failOnError: true)
        //Campista campista = new Campista(...).save(flush: true, failOnError: true)
        //new Campista(...).save(flush: true, failOnError: true)
        //new Campista(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //campista.id
    }

    void "test get"() {
        setupData()

        expect:
        campistaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Campista> campistaList = campistaService.list(max: 2, offset: 2)

        then:
        campistaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        campistaService.count() == 5
    }

    void "test delete"() {
        Long campistaId = setupData()

        expect:
        campistaService.count() == 5

        when:
        campistaService.delete(campistaId)
        sessionFactory.currentSession.flush()

        then:
        campistaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Campista campista = new Campista()
        campistaService.save(campista)

        then:
        campista.id != null
    }
}
