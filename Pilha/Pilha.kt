package Pilha

class Pilha (Private val tamanho : Int = 10) : Empilhavel {

    private var ponteiroTopo : Int = -1 // ponteiro topo vai ser ponteiroTopo++ a cada novo elemento (começa em -1 para quando o primeiro dado ser add ir para 0)
    private var dados : Array<Any?> = ArrayOfNulls(tamanho) // declara que a variável dados é um array e o tamanho dela

    override fun estaCheia(): Boolean {
        return ponteiroTopo == dados.size -1 //verifica se está cheia (observando se o ponteiroTopo tem a mesma quantidade que o tamanho do array)
    }

    override fun estaVazia(): Boolean {
        return ponteiroTopo == -1 // se estiver vazio o ponteiro topo ainda não vai está em nenhum dado logo já que o array conta a partir do 0
    }

    override fun topo(): Any? {
        var dadoTopo : Any? = null // cria uma variável para armazenar um dado se houver
        if (!estaVazia()) // Verifica se está vazia
            dadoTopo = dados[ponteiroTopo] // coloca o dado na variável criada
        else
            println("Pilha vazia") // mostra a mensagem que a pilha está vazia
        return dadoTopo // retorna o dado que tá no topo
    }

    override fun atualizar(dado : Any?){
        if (!estaVazia()) // verifica se esta vazia
            dados[ponteiroTopo] = dado // armazena o dado no topo da pilha
        else
            println("Pilha Vazia") // Fala que a pilha está vazia
    }

    override fun imprimir(): String {
        var aux = "[" // cria uma string com "[" para o array ficar entre "[]" quando for impresso
            for (i in ponteiroTopo downTo 0 ){ // for para percorrer a pilha onde o i está no ponteiroTopo e vai ate o 0
                if (i == 0) //Verifica se o i é igual o 0
                    aux += "${dados[i]}" // armazena em aux os dados que estão em i com o "+=" para manter os antigos
                else
                    aux += "${dados[i]}"
            }
        return "$aux]"
    }

    override fun inserir(dado: Any?) {
        if (!estaCheia()) { // verifica se a pilha está cheia
            ponteiroTopo++ //soma um número a ponteiro topo
            dados[ponteiroTopo] = dado //armazena o dado na posição de ponteiroTopo +1
        }else
            println("Pilha cheia")
    }

    override fun remover(): Any? {
        var dadoTopo : Any? = null
        if (!estaVazia()){
            dadoTopo = dados[ponteiroTopo]
            ponteiroTopo--
        }else
            println("Pilha vazia")
        return dadoTopo
    }

}