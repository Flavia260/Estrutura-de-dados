package Projeto

class GerenciamentoProduto (private val tamanho: Int = 10) {

    private var produtos: Array<Produto?> = arrayOfNulls(tamanho)
    private var qntd = 0
    private var pInicio = 0
    private var pFim = -1


    fun atualizarProduto (posicao: Int, produto: Produto) {
        if (!estaVazia()) {
            if (posicao >= 0 && posicao < qntd) {
                var posicaoFisica =
                    (pInicio + posicao) % produtos.size
                produtos[posicaoFisica] = produto
            } else
                throw IndexOutOfBoundsException("Posição Inválida!")
        } else
            throw NoSuchElementException("Não ha produtos para ser atualizado")
    }

    fun inserirProduto (posicao: Int, produto: Produto) {
        if (!estaCheia()) {
            //índice/posição é válido?
            if (posicao >= 0 && posicao <= qntd) {
                var pFisica = (pInicio + posicao) % produtos.size
                var ponteiroAux = pFim+1
                for (i in posicao until qntd) {
                    var anterior = ponteiroAux-1
                    if(ponteiroAux == produtos.size)
                        ponteiroAux = 0
                    var atual = ponteiroAux
                    produtos[atual] = produtos[anterior]
                    ponteiroAux--
                }
                produtos[pFisica] = produto
                pFim++
                if (pFim == produtos.size) {
                    pFim= 0
                }
                qntd++
            } else
                throw IndexOutOfBoundsException ("Posição inválida")
        } else
            throw NoSuchElementException ("Não ha espaço para a inserção de novos produtos")
    }

    fun apagar(posicao: Int) : Produto? {
        var aux: Produto? = null
        if (!estaVazia()) {
            if (posicao >= 0 && posicao < qntd) {
                var pFisica = (pInicio+ posicao) % produtos.size
                aux = produtos[pFisica]
                var ponteiroAux = pFisica
                for (i in posicao until (qntd-1)) {
                    var auxAtual = ponteiroAux
                    var auxProximo = (ponteiroAux+1)%produtos.size
                    produtos[auxAtual] = produtos[auxProximo]
                    ponteiroAux++
                }
                pFim--
                if (pFim == -1)
                    pFim = produtos.size - 1
                qntd--
            } else
                throw IndexOutOfBoundsException ("Posição inválida")
        } else {
            throw NoSuchElementException ("Não ha produtos para serem apagados")
        }
        return aux
    }



    fun estaCheia (): Boolean {
        return qntd == produtos.size
    }
    fun estaVazia () : Boolean {
        return qntd == 0
    }
}