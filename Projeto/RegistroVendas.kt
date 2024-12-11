package Projeto
import java.time.LocalDateTime
class RegistroVendas (private val tamanho: Int = 10) {

    private var vendas: Array<Vendas?> = arrayOfNulls(tamanho)
    private var quantidade = 0
    private var ponteiroInicio = 0
    private var ponteiroFim = -1

    fun registrarVenda (venda: Vendas, produtos : Produto){
        val dataVenda = LocalDateTime.now()
        if (produtos.qntdEstoque != 0 && !estaCheia()) {
            ponteiroInicio = retroceder(ponteiroInicio)
            vendas[ponteiroInicio] = venda
            quantidade++
            produtos.qntdEstoque--
            if (ponteiroFim == -1)
                ponteiroFim = ponteiroInicio
        }
    }
    fun cancelamentoDeVendas(id : Int, posicao: Int){
        var auxProduto : Produto? = null
        var aux : Vendas? = null
        if (id == aux?.idVendas)
            if (aux != null) {
                val tempoDesdeVenda = Duration.between(aux.dataVenda, LocalDateTime.now())
                if (tempoDesdeVenda.toHours() <= 24) {
                    val posicaoFisica = logicaPraFisica(posicao)
                    aux = vendas[posicaoFisica]
                    var atual = posicaoFisica
                    var proximo = atual
                    proximo = avancar(proximo)
                    for (i in posicao until (quantidade-1)) {
                        vendas[atual] = vendas[proximo]
                        atual = avancar(atual)
                        proximo = avancar(proximo)
                    }
                    ponteiroFim = retroceder(ponteiroFim)
                    quantidade--
                    auxProduto?.qntdEstoque?.inc()
                }
            }
    }
    fun relatorioDeVendas(): String{
        var resultado = "["
        var ponteiroAux = ponteiroInicio
        for (i in 0 until quantidade) {
            resultado += if (i == ponteiroFim)
                "${vendas[(ponteiroAux+i) % vendas.size]}"
            else
                "${vendas[(ponteiroAux+i) % vendas.size]}, "
        }
        return "$resultado]"
    }

    private fun retroceder(ponteiro: Int): Int {
        var aux = ponteiro
        aux = aux--
        return if (aux == -1) vendas.size-1
        else
            aux
    }

    fun estaCheia(): Boolean {
        return quantidade == vendas.size
    }
    fun estaVazia(): Boolean {
        return quantidade == 0
    }
    private fun logicaPraFisica(posicao: Int): Int {
        return (ponteiroInicio + posicao) % vendas.size
    }
    private fun avancar(ponteiro: Int): Int {
        var aux = ponteiro
        aux++
        return if (aux == vendas.size) 0
        else
            aux
    }

}


