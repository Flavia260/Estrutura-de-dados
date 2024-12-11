package Projeto
import java.time.LocalDateTime
data class Vendas(
    var idCliente: Cliente
    var idVendedor: Vendedor
    val dataVenda: LocalDateTime
    var idVendas : Int
    var produto: Produto
)