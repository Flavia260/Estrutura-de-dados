package Heap

class Main {
    fun main() {
        var heap: Amontoavel = HeapMinima(10)
        heap.inserir(2)
        heap.inserir(6)
        heap.inserir(0)
        heap.inserir(9)
        heap.atualizar(6)
        heap.inserir(1)
        println(heap.imprimir())//[1,4,6,8,7]
        println(heap.remover())	//1
        println(heap.obter())	//4
        println(heap.obter())	//4
        println(heap.imprimir())//[4,7,6,8]
    }
}