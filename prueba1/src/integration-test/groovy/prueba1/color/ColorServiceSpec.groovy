package prueba1.color

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ColorServiceSpec extends Specification {

    ColorService colorService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Color(...).save(flush: true, failOnError: true)
        //new Color(...).save(flush: true, failOnError: true)
        //Color color = new Color(...).save(flush: true, failOnError: true)
        //new Color(...).save(flush: true, failOnError: true)
        //new Color(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //color.id
    }

    void "test get"() {
        setupData()

        expect:
        colorService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Color> colorList = colorService.list(max: 2, offset: 2)

        then:
        colorList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        colorService.count() == 5
    }

    void "test delete"() {
        Long colorId = setupData()

        expect:
        colorService.count() == 5

        when:
        colorService.delete(colorId)
        sessionFactory.currentSession.flush()

        then:
        colorService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Color color = new Color()
        colorService.save(color)

        then:
        color.id != null
    }
}
