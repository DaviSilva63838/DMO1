//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val pessoa = Pessoa("Davilau", "000.111.222-33", "davilau@gmail.com");

    pessoa.nome = "davilau";
    pessoa.cpf = "00000000000";
    pessoa.email = "davilau@gmail.com";

    println("Nome: ${pessoa.nome}");
    println("Cpf: ${pessoa.cpf}");
    println("Email: ${pessoa.email}");
    pessoa.andar();

    val crianca = Crianca();

    crianca.nome = "Oswaldo";
    crianca.cpf = "56489023421"
    crianca.reuPrimario = false;
    crianca.andar();

    crianca.som();
    crianca.mover();
    crianca.respirar();

    val crianca2 = Adolescente();

    crianca2.idioma = "Mandarim";
    crianca2.praticarHobby();
}