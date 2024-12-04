package Pilha

interface Empilhavel {
    fun inserir (dado : Any?)
    fun remover (): Any?
    fun topo (): Any?
    fun atualizar (dado: Any?)

    fun estaVazia () : Boolean
    fun estaCheia (): Boolean
    fun imprimir (): String
}