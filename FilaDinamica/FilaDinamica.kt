package FilaDinamica

class FilaDinamica (private val tamanho : Int): Enfileravel {
    private var ponteiroInicio: NoDuplo? = null
    private var ponteiroFim: NoDuplo? = null
    private var quantidade = 0

    override fun enfileirar(dado: Any?) {
        if (!estaCheia()){
            val novoNo = NoDuplo(dado)
            if (ponteiroFim != null)
                ponteiroFim?.proximo = novoNo
            else// ponteiro fim nulo
                ponteiroInicio = novoNo
            novoNo.anterior = ponteiroFim
            ponteiroFim = novoNo
            quantidade++
        }else{
            throw NoSuchElementException ("Lista cheia")
        }
    }
    override fun desenfileirar(): Any? {
        var aux : Any? = null
        if (!estaVazia()){
            aux = ponteiroInicio?.dado
            ponteiroInicio = ponteiroInicio?.proximo
            if (ponteiroInicio != null)
                ponteiroInicio?.anterior = null
            else
                ponteiroFim = null
            quantidade--
        }else {
            throw NoSuchElementException ("Lista Vazia")
        }
        return aux
    }
    override fun atualizar(dado: Any?){
        if (!estaVazia())
            ponteiroInicio?.dado = dado
        else
            throw NoSuchElementException ("Lista Vazia")
    }
    override fun frente(): Any?{
        var aux : Any? = null
        if (!estaVazia())
            aux = ponteiroInicio?.dado
        else
            throw NoSuchElementException ("Lista Vazia")
        return aux
    }
    // Metodos auxiliares
    override fun estaCheia(): Boolean{
        return tamanho== quantidade
    }
    override fun estaVazia(): Boolean {
        return quantidade==0
    }
    override fun imprimir(): String{
        var retorno = "["
        var aux = ponteiroInicio
        for (i in 0 until quantidade){
             retorno += "${aux?.dado}"
            if (i != quantidade-1)
                retorno += ","

             aux = aux?.proximo
        }
        return "$retorno]"
        }

    }
