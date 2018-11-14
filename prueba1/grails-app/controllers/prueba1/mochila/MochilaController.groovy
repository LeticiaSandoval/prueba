package prueba1.mochila

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class MochilaController {

    MochilaService mochilaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond mochilaService.list(params), model:[mochilaCount: mochilaService.count()]
    }

    def show(Long id) {
        respond mochilaService.get(id)
    }

    def create() {
        respond new Mochila(params)
    }

    def save(Mochila mochila) {
        if (mochila == null) {
            notFound()
            return
        }

        try {
            mochilaService.save(mochila)
        } catch (ValidationException e) {
            respond mochila.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'mochila.label', default: 'Mochila'), mochila.id])
                redirect mochila
            }
            '*' { respond mochila, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond mochilaService.get(id)
    }

    def update(Mochila mochila) {
        if (mochila == null) {
            notFound()
            return
        }

        try {
            mochilaService.save(mochila)
        } catch (ValidationException e) {
            respond mochila.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'mochila.label', default: 'Mochila'), mochila.id])
                redirect mochila
            }
            '*'{ respond mochila, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        mochilaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'mochila.label', default: 'Mochila'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'mochila.label', default: 'Mochila'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
