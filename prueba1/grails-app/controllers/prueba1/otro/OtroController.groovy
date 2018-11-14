package prueba1.otro


class OtroController {

    def index() {
        render(view:'/primerDominio/index')
    
    }
    
    def otroMetodo() {
        render(view:'nada', model:[palabra:'esto es una palabra'])
    }
}
