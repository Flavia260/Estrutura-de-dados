package Projeto

fun main () {
    val sistema = GerenciamentoProduto()
    val produto1 = Produto("Camisa", "camiseta", 50.0, "P", 10)
    sistema.cadastrar(produto1)
}