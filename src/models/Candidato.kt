package models

data class Candidato(
    val nombre: String,
    var votosInternet: Int = 0,
    var votosRadio: Int = 0,
    var votosTelevision: Int = 0
) {
    // Función que calcula el costo total de la campaña basado en los votos
    //// y el medio de publicidad

    //la Funcion calcularCostoCampaña nos permite que dependiendo del valor que tenga los votos
    //basados en los diferentes medios este hara una multiplicacion con respecto al valor de cada uno
    //usando un enum en el archivo Publicidad.kt
    fun calcularCostoCampaña(): Int {
        return (votosInternet * Publicidad.INTERNET.costo) +
                (votosRadio * Publicidad.RADIO.costo) +
                (votosTelevision * Publicidad.TELEVISION.costo)
    }
    // Función para obtener el total de votos de los diferentes apartados del candidatos
    fun totalVotos(): Int {
        return votosInternet + votosRadio + votosTelevision
    }
}
