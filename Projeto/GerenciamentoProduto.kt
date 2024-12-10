package Projeto

class GerenciamentoProduto (private val tamanho: Int = 10) {
    private var ponteiroInicio: NoDuplo? = null
    private var ponteiroFim: NoDuplo? = null
    private var qnt = 0

    fun excluir (posicao: Int): Produto?{
        var aux: Produto? = null
        if (!estaVazia()){
            if (posicao >0 && posicao < qnt){
                var ponteiroAux = ponteiroInicio
                for (i in 0 until qnt)
                    ponteiroAux = ponteiroAux?.proximo
                aux = ponteiroAux?.produto
                val ponteiroAnterior = ponteiroAux?.anterior
                val ponteiroProximo = ponteiroAux?.proximo
                if (ponteiroAnterior != null)
                    ponteiroAnterior.proximo = ponteiroProximo
                else
                    ponteiroInicio = ponteiroInicio?.proximo
                if (ponteiroProximo != null)
                    ponteiroProximo?.anterior = ponteiroAnterior
                else
                    ponteiroFim = ponteiroFim?.anterior
                qnt--
            }else
                throw IndexOutOfBoundsException ("Posição invalida")
        }else{
            throw NoSuchElementException ("Não há produtos para ser apagado")
        }
        return aux
    }

    fun alterar (posicao: Int, produto: Produto){
        if(!estaVazia()){
            if (posicao >= 0 && posicao < qnt){
                var ponteiroAux = ponteiroInicio
                for (i in 0 until posicao)
                    ponteiroAux= ponteiroAux?.proximo
                ponteiroAux?.produto = produto
            }else
                throw IndexOutOfBoundsException ("Posição invalida")
        }else
            throw NoSuchElementException ("Não há produtos para ser alterado")
    }

    fun cadastrar (produto: Produto){
        if (!estaCheia()){
            val temp = NoDuplo(produto)
            temp.anterior = ponteiroFim
            if (!estaVazia())
                ponteiroFim?.proximo = temp
            else
                ponteiroInicio = temp
            ponteiroFim = temp
            qnt++
        }else
            throw NoSuchElementException ("Sem espaço para novos produtos")
    }

    fun estaCheia() : Boolean {
        return qnt == tamanho
    }
    fun estaVazia() : Boolean{
        return qnt == 0
    }
}