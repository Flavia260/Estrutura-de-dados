package Projeto

data class NoDuplo (var produto: Produto? = null) {
    var anterior: NoDuplo? = null
    var proximo : NoDuplo? = null
}