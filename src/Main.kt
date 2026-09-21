//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var num1 = 12;
    val num2: Int = num1;
    num1 = 55;

    println("Hello World");
    println(num1);
    println(num2);

    //====================
    //Leitura de dados
    println("Digite a sua idade: ");
    var idade = readln()?.toIntOrNull() ?: 0;

    //Condicionais (se?senão = if/else)
    if (idade != null){
        println("No ano que vem sua idade será: ${idade+1}");
    } else {
        println("Idade digitada de forma incorreta: ${idade}");
    }

    //Exercícios

    //Exercício 01
    println("Digite uma palavra:");
    var palavra = readln();

    println("Maiúscula: ${palavra.uppercase()}");
    println("Minúscula: ${palavra.lowercase()}");

    //Exercício 02
    println("Digite o primeiro número:")
    var numero1 = readln().toInt();

    println("Digite o segundo número:")
    var numero2 = readln().toInt();

    val soma = numero1 + numero2;

    println("A soma dos números é: $soma");

    //Exercício 03
    println("Digite um número:");
    var num = readln()?.toIntOrNull()

    if (num != null) {
        if (num % 2 == 0) {
            println("O número $num é par.")
        } else {
            println("O número $num é ímpar.")
        }
    } else {
        println("Entrada inválida! Digite apenas um número inteiro.")
    }

    //Exercício 04
    println("Digite a primeira nota:")
    val n1 = readLine()?.toDoubleOrNull() ?: 0.0

    println("Digite a segunda nota:")
    val n2 = readLine()?.toDoubleOrNull() ?: 0.0

    println("Digite a terceira nota:")
    val n3 = readLine()?.toDoubleOrNull() ?: 0.0

    val media = (n1 + n2 + n3) / 3

    println("Média final: %.2f".format(media))

    if (media >= 6.0) {
        println("Situação: Aprovado")
    } else if (media >= 4.0) {
        println("Situação: Recuperação")
    } else {
        println("Situação: Reprovado")
    }

    //Exercicio 05
}