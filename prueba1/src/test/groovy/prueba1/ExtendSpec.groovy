package prueba1

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class ExtendSpec extends Specification implements DomainUnitTest<Extend> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
