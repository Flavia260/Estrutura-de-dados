package PilhaDinamica

interface EmpilhavelDinamica {
    fun empilhar (dado: Any)
    fun desempilhar (): Any?
    fun estaCheia (): Boolean
    fun estaVazia (): Boolean
    fun imprimir (): String
    fun olhar (): Any?
    fun atualizar (dado: Any)

}