package Heap

interface Amontoavel {
    fun inserir (dado : Long)
    fun remover () : Long?
    fun obter () : Long?
    fun atualizar (dado: Long)

    fun imprimir () : String
    fun estaCheia () : Boolean
    fun estaVazia () : Boolean
}
