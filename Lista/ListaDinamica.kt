package Lista

class ListaDinamica (val tamaho: Int) : Listavel {
    private var qnt = 0
    private var fim: NoDuplo?
    private  var inicio: NoDuplo?

    override fun inserir(dado: Any?, posicao: Int) {
        if (!estaCheia()) {
            if (posicao >= 0 && posicao <= qnt) {
                var aux = inicio
                for (i in 0 until posicao) {
                    aux = aux?.proximo
                }
                var novoNo = NoDuplo (dado)
                var pro = aux
                var ant = aux?.anterior
                if (ant!= null)//inserção no meio ou fim
                    ant?.proximo = novoNo
                else//incerção no inicio
                    inicio = novoNo
                pro?.anterior = novoNo
                novoNo?.anterior = ant
                novoNo?.proximo = pro
                qnt++
            } else
                throw IndexOutOfBoundsException("Posição invalida")
        }else{
            throw NoSuchElementException ("Lista Vazia")}
    }

    override fun apagar(posicao: Int): Any? {
        var dadoAux : Any? = null
        var aux = inicio
        if (!estaVazia()) {
            if (posicao <= 0 && posicao < qnt) {
                for (i in 0 until posicao){
                    aux = aux?.proximo
                    dadoAux = aux?.dado
                }
                val ant = aux?.anterior
                val pro = aux?.proximo
                if (ant != null)
                    ant?.proximo = pro
                else
                    inicio = inicio?.proximo
                if (pro != null)
                    pro?.anterior = ant
                else
                    fim = fim?.anterior
                qnt--
            }else{
                throw IndexOutOfBoundsException ("Posição invalida")
            }
        }else{
            throw NoSuchElementException ("Lista Vazia")
        }
        return dadoAux
    }


    override fun selecionarTodos(): Array<Any?> {
        var arrayDados: Array<Any?> = ArrayofNulls(qnt)
        var aux = inicio
        if (!estaVazia()){
            for (i in 0 until qnt){
                arrayDados[i] = aux?.dado
                aux = aux?.proximo
            }
        }else {
            throw NoSuchElementException ("Lista Vazia")
        }
        return arrayDados
    }

    override fun anexar(dado: Any?) {
        if (!estaCheia()){
            var noAux = NoDuplo (dado)
            noAux.anterior = fim
            if (!estaVazia())
                fim?.proximo = noAux
            else
                inicio = noAux
            fim = noAux
            qnt ++
        }
    }

    override fun limpar() {
        var qnt = 0
        fim = inicio = null
    }

    override fun atualizar(dado: Any?, posicao: Int) {
        if(!estaVazia()){
            if (posicao >= 0 && posicao < qnt){
                //laço para ir até o nó que tem o dado a ser retornado
                var aux = inicio
                for (i in 0 until posicao){
                    aux = aux?.proximo
                }
                aux?.dado = dado
            }else {
                throw IndexOutOfBoundsException ("Posição invalida")
            }
        }else {
            throw NoSuchElementException("Lista vazia")
        }
    }

    override fun selecionar(posicao: Int): Any {
        var datoTemp : Any? = null
        if(!estaVazia()){
            if (posicao >= 0 && posicao < qnt){
                //laço para ir até o nó que tem o dado a ser retornado
                var aux = inicio
                for (i in 0 until posicao){
                    aux = aux?.proximo
                }
                datoTemp = aux?.dado
            }else {
                throw IndexOutOfBoundsException ("Posição invalida")
            }
        }else {
            throw NoSuchElementException("Lista vazia")
        }
        return "$datoTemp"
    }
    override fun estaVazia(): Boolean {
        return qnt == 0
    }

    override fun estaCheia(): Boolean {
        return qnt == tamaho
    }

    override fun imprimir(): String {
        var resultado = "["
        var aux = inicio
        for (i in 0 until qnt) {
            resultado += aux?.dado
            if (i != qnt - 1)
                resultado += ","
            aux = aux?.proximo
        }
        return  "$resultado]"
    }
}