package Heap

class HeapMaxima (private val tamanho: Int =10): Amontoavel{

    private var dados = LongArray(tamanho)
    private var ponteiroFim = -1

    private fun indiceFilhoDireito (indicePai : Int) : Int{
        return 2 * indicePai + 2
    }
    private fun indiceFilhoEsquerdo (indicePai: Int) : Int{
        return 2 * indicePai + 1
    }
    private fun indicePai (indiceFilho : Int) : Int{
        return (indiceFilho -1)/2
    }

    private fun ajustarAcima(Indice : Int){

    }
    private fun trocar (i : Int, j : Int){
        val temp = dados[i]
        dados[i] = dados[j]
        dados[j] = temp
    }

    override fun obter(): Long? {
        var dadoRaiz : Long? = null
        if (!estaVazia())
            dadoRaiz = dados[0]
        else
            println("Pilha vazia")
        return dadoRaiz
    }

    override fun estaCheia(): Boolean {
        return ponteiroFim == dados.size -1
    }

    override fun estaVazia(): Boolean {
        return ponteiroFim == -1
    }

    override fun imprimir(): String {
        var aux = "["
        for (i in 0 .. ponteiroFim){
            aux += "${dados[i]}"
            if (i != ponteiroFim)
                aux += ","
        }
        return "$aux]"
    }
}