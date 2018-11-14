package prueba1.articulos

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ArticulosController {

    ArticulosService articulosService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond articulosService.list(params), model:[articulosCount: articulosService.count()]
    }

    def show(Long id) {
        respond articulosService.get(id)
    }

    def create() {
        respond new Articulos(params)
    }

    def save(Articulos articulos) {
        if (articulos == null) {
            notFound()
            return
        }

        try {
            articulosService.save(articulos)
        } catch (ValidationException e) {
            respond articulos.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'articulos.label', default: 'Articulos'), articulos.id])
                redirect articulos
            }
            '*' { respond articulos, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond articulosService.get(id)
    }

    def update(Articulos articulos) {
        if (articulos == null) {
            notFound()
            return
        }

        try {
            articulosService.save(articulos)
        } catch (ValidationException e) {
            respond articulos.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'articulos.label', default: 'Articulos'), articulos.id])
                redirect articulos
            }
            '*'{ respond articulos, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        articulosService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'articulos.label', default: 'Articulos'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'articulos.label', default: 'Articulos'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
