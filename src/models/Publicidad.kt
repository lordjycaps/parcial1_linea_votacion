package models
//class enum donde podemos parametrizar las opciones de publicidad y adicionarle un valor a la clase

enum class Publicidad(val costo: Int) {
    INTERNET(700000),
    RADIO(200000),
    TELEVISION(600000)
}
