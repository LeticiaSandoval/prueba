package prueba1.campista

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class CampistaController {

    CampistaService campistaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond campistaService.list(params), model:[campistaCount: campistaService.count()]
    }

    def show(Long id) {
        respond campistaService.get(id)
    }

    def create() {
        respond new Campista(params)
    }

    def save(Campista campista) {
        if (campista == null) {
            notFound()
            return
        }

        try {
            campistaService.save(campista)
        } catch (ValidationException e) {
            respond campista.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'campista.label', default: 'Campista'), campista.id])
                redirect campista
            }
            '*' { respond campista, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond campistaService.get(id)
    }

    def update(Campista campista) {
        if (campista == null) {
            notFound()
            return
        }

        try {
            campistaService.save(campista)
        } catch (ValidationException e) {
            respond campista.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'campista.label', default: 'Campista'), campista.id])
                redirect campista
            }
            '*'{ respond campista, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        campistaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'campista.label', default: 'Campista'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'campista.label', default: 'Campista'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
