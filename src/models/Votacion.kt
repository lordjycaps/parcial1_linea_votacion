package models

class Votacion(
    private val candidatos: List<Candidato>
) {
    private var totalVotos: Int = 0

    // Función para registrar un voto
    fun votar(candidato: Candidato, publicidad: Publicidad) {
        when (publicidad) {
            Publicidad.INTERNET -> candidato.votosInternet++
            Publicidad.RADIO -> candidato.votosRadio++
            Publicidad.TELEVISION -> candidato.votosTelevision++
        }
        totalVotos++
    }

    // Función para calcular el costo promedio de campaña
    fun costoPromedioCampaña(): Int {
        val costoTotal = candidatos.sumOf { it.calcularCostoCampaña() }
        return if (totalVotos > 0) costoTotal / totalVotos else 0
    }

    // Función para vaciar las urnas
    fun vaciarUrnas() {
        candidatos.forEach {
            it.votosInternet = 0
            it.votosRadio = 0
            it.votosTelevision = 0
        }
        totalVotos = 0
    }

    // Obtener el porcentaje de votos por candidato
    fun porcentajeVotos(candidato: Candidato): Double {
        return if (totalVotos > 0) (candidato.totalVotos().toDouble() / totalVotos) * 100 else 0.0
    }

    // Obtener el total de votos
    fun totalVotos(): Int {
        return totalVotos
    }

    // Función para obtener el candidato con más votos
    fun candidatoConMasVotos(): Candidato? {
        if (totalVotos == 0) {
            println("No se han registrado votos.")
            return null
        }

        // Encuentra el número máximo de votos
        val maxVotos = candidatos.maxOfOrNull { it.totalVotos() }

        // Verifica si hay más de un candidato con el mismo número de votos máximos
        val candidatosConMaxVotos = candidatos.filter { it.totalVotos() == maxVotos }

        return if (candidatosConMaxVotos.size > 1) {
            println("No existe un ganador claro, hay un empate entre los candidatos.")
            null
        } else {
            val ganador = candidatosConMaxVotos.first()
            println("El candidato con más votos es: ${ganador.nombre} con ${ganador.totalVotos()} votos.")
            ganador
        }
    }


}
