package PilhaDinamica

class PilhaDinamica {
    private var quantidade = 0
    private var ponteiroTopo : NoDuplo ? = null

    fun empilhar (dado: Any){
        if (!estaCheia()){
            var noTemp : NoDuplo(dado)

        }
    }
    fun desempilhar (): Any?
    fun estaCheia (): Boolean{
        return quantidade == tamanho
    }
    fun estaVazia (): Boolean {
        return quantidade == 0
    }
    fun imprimir (): String

    fun olhar (): Any?
    fun atualizar (dado: Any)
}