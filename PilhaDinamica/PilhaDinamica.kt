package PilhaDinamica

class PilhaDinamica (private val tamanho : Int = 10) {
    private var qnt = 0
    private var ponteiroTopo : NoDuplo ? = null

    fun empilhar (dado: Any){
        if (!estaCheia()){
            var noTemp : NoDuplo(dado)
            noTemp.anterior = ponteiroTopo
            if (!estaVazia())
                ponteiroTopo?.proximo = noTemp
            ponteiroTopo = noTemp
            qnt = qnt++
        }else{
            println("A pilha está cheia")
        }
    }
    fun desempilhar (): Any? {
        var dadotopo: Any? = null
        if (!estaVazia()) {
            var dadoTopo = ponteiroTopo?.dado
            ponteiroTopo = ponteiroTopo?.anterior
            qnt = qnt--
            if (!estaCheia())
                ponteiroTopo?.proximo = null
        } else {
            println("A pilha esta vazia")
        }
        return dadotopo
    }
    fun estaCheia (): Boolean{
        return qnt == tamanho
    }
    fun estaVazia (): Boolean {
        return qnt == 0
    }
    fun imprimir (): String{
        var aux = ponteiroTopo
        var resultado = "["
        for (i in 0 until qnt){
            resultado += "${aux?.dado}"
            if (i != qnt - 1)
                resultado += ","
            aux = aux?.anterior
        }
        return "$resultado"
    }

    fun olhar (): Any?{
        var topo : Any? = null
        if (!estaVazia())
            topo = ponteiroTopo?.dado
        else
            println("A pilha está vazia")
        return topo
    }
    fun atualizar (dado: Any){
        if (!estaVazia())
            ponteiroTopo?.dado = dado
        else
            println("A pilha está vazia")
    }
}