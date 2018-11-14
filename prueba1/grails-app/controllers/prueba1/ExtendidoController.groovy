package prueba1

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ExtendidoController {

    ExtendidoService extendidoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond extendidoService.list(params), model:[extendidoCount: extendidoService.count()]
    }

    def show(Long id) {
        respond extendidoService.get(id)
    }

    def create() {
        respond new Extendido(params)
    }

    def save(Extendido extendido) {
        if (extendido == null) {
            notFound()
            return
        }

        try {
            extendidoService.save(extendido)
        } catch (ValidationException e) {
            respond extendido.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'extendido.label', default: 'Extendido'), extendido.id])
                redirect extendido
            }
            '*' { respond extendido, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond extendidoService.get(id)
    }

    def update(Extendido extendido) {
        if (extendido == null) {
            notFound()
            return
        }

        try {
            extendidoService.save(extendido)
        } catch (ValidationException e) {
            respond extendido.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'extendido.label', default: 'Extendido'), extendido.id])
                redirect extendido
            }
            '*'{ respond extendido, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        extendidoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'extendido.label', default: 'Extendido'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'extendido.label', default: 'Extendido'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
