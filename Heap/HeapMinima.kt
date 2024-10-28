package Heap

class HeapMinima (private val tamanho : Int = 10) : Amontoavel {
    private var ponteiroFim = -1
    private var dados = LongArray (tamanho) {0}

    override fun inserir (dado : Long){
        if (!estaCheia()){
            ponteiroFim = ponteiroFim.inc()
            dados[ponteiroFim] = dado
            ajustarAcima(ponteiroFim)
        }
        else{
            println("The heap is full!")
        }
    }
    private fun ajustarAcima (indice : Int){
        var indiceFilho = indice
        while (indiceFilho != 0){
            val indicePai = indicePai(indiceFilho)
            if (dados[indicePai]>dados[indiceFilho]){
                trocar(indicePai, indiceFilho)
                indiceFilho = indicePai
            }
            else   {
                break
            }
        }
    }
    private fun ajustarAbaixo (indice: Int){
        var pai = indice
        while (pai <= ponteiroFim){
            val filhoEsquerdo = indiceFilhoEsquerdo(pai)
            val filhoDireito = indiceFilhoDireito(pai)
            var menor = pai
            if (filhoEsquerdo <= ponteiroFim)
                if (dados[filhoEsquerdo] < dados[menor])
                    menor = filhoEsquerdo
            if (filhoDireito <= ponteiroFim)
                if (dados[filhoDireito] < dados[menor])
                    menor = filhoDireito
            if (menor != pai){
                trocar(pai, menor)
                pai = menor
            } else{
                break
            }
        }
    }
    private fun indicePai (indiceFilho : Int): Int{
        return (indiceFilho -1)/2
    }
    private fun indiceFilhoDireito (indicePai : Int) : Int {
        return (2 * indicePai + 2)
    }
    private fun indiceFilhoEsquerdo (indicePai : Int) : Int {
        return (2 * indicePai + 1)
    }
    fun trocar (a : Int, b: Int){
        val temporaria = dados[a]
        dados [a] = dados [b]
        dados [b] = temporaria
    }
    override fun remover () : Long? {
        var dadoRaiz : Long ? = null
        if (!estaVazia()){
            dadoRaiz = dados[0]
            dados [0] = dados[ponteiroFim]
            ponteiroFim--
            ajustarAbaixo(0)
        }
        return dadoRaiz
    }
    override fun obter () : Long? {
        var dadoRaiz : Long? = null
        if (!estaVazia()){
            dadoRaiz = dados[0]
        }else {
            println("The heap is empty")
        }
        return dadoRaiz
    }

    override fun atualizar (dado: Long) {
        if (!estaVazia()) {
            dados[0] = dado
            ajustarAbaixo (0)
        }
        else{
            println("The heap is empty!")
        }
    }

    override fun imprimir () : String {
        var mostrar = "["
        if (!estaVazia()) {
            for (i in 0..ponteiroFim) {
                mostrar += "${dados[i]}"
                if (i != ponteiroFim) {
                    mostrar += ","
                }
            }
        }else{
            var mostrar = "The heap is empty!"
        }
        return "$mostrar]"
    }
    override fun estaCheia () : Boolean{
        return ponteiroFim == dados.size -1
    }

    override fun estaVazia () : Boolean {
        return ponteiroFim == -1
    }
}