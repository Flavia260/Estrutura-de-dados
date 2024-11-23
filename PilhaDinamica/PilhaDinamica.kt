package PilhaDinamica

class PilhaDinamica (var tamanho: Int) : EmpilhavelDinamica {
    private var ponteiroTopo: NoDuplo? = null
    private var quantidade = 0
    // Metodos principais
    override fun empilhar(dado: Any?) {
        if (!estaCheia()){
            val novoNo = NoDuplo (dado)
            if (!estaVazia())
                ponteiroTopo?.proximo = novoNo
            novoNo.anterior = ponteiroTopo
            ponteiroTopo = novoNo
            quantidade++
        }
    }
    override fun desempilhar(): Any? {
        var dadoAux : Any? = null
        if (!estaVazia()){
            dadoAux = ponteiroTopo?.dado
            ponteiroTopo = ponteiroTopo?.anterior
            ponteiroTopo?.proximo = null
            quantidade--
        }else{
            println("Pilha vazia")
        }
        return dadoAux
    }
    override fun espiar(): Any?{
        var dadoAux : Any? = null
        if (!estaVazia()){
            dadoAux = ponteiroTopo?.dado
        }else{
            println("Pilha Vazia")
        }
        return dadoAux
    }
    override fun atualizar(dado: Any?){
        if (!estaVazia()){
            ponteiroTopo?.dado = dado
        }else{
            println("Esta vazia")
        }
    }
    // Metodos auxiliares
    override fun estaCheia(): Boolean {
        return quantidade == tamanho
    }
    override fun estaVazia(): Boolean {
        return quantidade == 0
    }
    override fun imprimir(): String {
        var aux = ponteiroTopo
        var retorno = "["
        while (aux?.anterior != null) {
            retorno += aux?.dado
            aux = aux?.anterior
        }
        // partir topo
        // descendo
        return "$retorno]"
    }


}
