class Crianca: Pessoa(), SerVivo {
    var dentesDeLeite: String = "";
    var reuPrimario: Boolean = true;
    override var temCoracao: String = "Sim";
    override var categoria: String = "Onivoro";
    override var habitat: String = "Em vários lugares!";

    override fun andar() {
        //super.andar();
        println("Criança engatinhando...");
    }

    override fun som() {
        println("Unhe, unhe, unhe... (criança chorando)");
    }

    override fun mover() {
        println("Andando (depois que se aprende)");
    }

    override fun respirar() {
        println("");
    }

}