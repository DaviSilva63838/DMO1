open class Pessoa {
    var nome: String = "";
    var cpf: String = "";
    var email: String = "";

    constructor(nome: String, cpf: String, email: String) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    constructor() {

    }

    open fun andar() {
        println("Pessoa andando...");
    }

}