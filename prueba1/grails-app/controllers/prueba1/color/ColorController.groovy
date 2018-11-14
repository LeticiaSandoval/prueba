package prueba1.color

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ColorController {

    ColorService colorService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond colorService.list(params), model:[colorCount: colorService.count()]
    }

    def show(Long id) {
        respond colorService.get(id)
    }

    def create() {
        respond new Color(params)
    }

    def save(Color color) {
        if (color == null) {
            notFound()
            return
        }

        try {
            colorService.save(color)
        } catch (ValidationException e) {
            respond color.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'color.label', default: 'Color'), color.id])
                redirect color
            }
            '*' { respond color, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond colorService.get(id)
    }

    def update(Color color) {
        if (color == null) {
            notFound()
            return
        }

        try {
            colorService.save(color)
        } catch (ValidationException e) {
            respond color.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'color.label', default: 'Color'), color.id])
                redirect color
            }
            '*'{ respond color, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        colorService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'color.label', default: 'Color'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'color.label', default: 'Color'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
