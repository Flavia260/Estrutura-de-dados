package FilaDupla

class FilaDupla (private val tamanho : Int = 10) : EnfileiravelDupla {
    private var ponteiroInicio = 0
    private var ponteiroFim = -1
    private var qnt = 0
    private var dados : Array<Any>? = ArrayOfNulls(tamanho)

    override fun imprimirFrentePraTras() : String{
        var aux = "["
        var inicio = ponteiroInicio
        for (i in 0 .. qnt -1){
            if (qnt == -1){
                aux += "${dados?.get(inicio)}"
            }else{
                aux += "${dados?.get(inicio)}"
            }
            inicio++
            if (inicio == dados?.size){
                inicio = 0
            }
        }
        return "$aux]"
    }

    override fun frente(): Any? {
        var aux : Any? = null
        if (!estaVazia()){
            aux = dados[ponteiroInicio]
        } else{
            throw NoSuchElementException ("Lista Vazia")
        }
        return aux
    }

    override fun estaCheia(): Boolean {
        return qnt == dados?.size
    }

    override fun estaVazia(): Boolean {
        return qnt == 0
    }
}