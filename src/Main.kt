package models

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
//lista candidatos

    val candidato1 = Candidato("Candidato 1")
    val candidato2 = Candidato("Candidato 2")
    val candidato3 = Candidato("Candidato 3")


    val votacion = Votacion(listOf(candidato1, candidato2, candidato3))

    while (true) {
        println("\n")
        println("--------------------------------------")
        println("---- Elecciones Municipio Premier ----")
        println("--------------------------------------")
        println("\n")
        println("1. Votar por un candidato")
        println("2. Calcular el costo de campaña")
        println("3. Vaciar urnas")
        println("4. Ver número total de votos")
        println("5. Ver porcentaje de votos por candidato")
        println("6. Ver costo promedio de campaña")
        println("7. Ver candidato con más votos")
        println("8. Salir")
        println("\n")
        print("Seleccione una opción: ")
        println("\n")

        when (scanner.nextLine()) {
            "1" -> {
                println("Seleccione un candidato: (1, 2, 3)")
                val candidato = when (scanner.nextLine()) {
                    "1" -> candidato1
                    "2" -> candidato2
                    "3" -> candidato3
                    else -> {
                        println("Candidato inválido")
                        continue
                    }
                }

                println("Seleccione el medio de influencia publicitaria (Internet, Radio, Television):")
                val publicidad = when (scanner.nextLine().lowercase()) {
                    "internet" -> Publicidad.INTERNET
                    "radio" -> Publicidad.RADIO
                    "television" -> Publicidad.TELEVISION
                    else -> {
                        println("Medio inválido")
                        continue
                    }
                }

                votacion.votar(candidato, publicidad)
                println("Voto registrado.")
            }

            "2" -> {
                println("Seleccione un candidato para calcular el costo de campaña: (1, 2, 3)")
                val candidato = when (scanner.nextLine()) {
                    "1" -> candidato1
                    "2" -> candidato2
                    "3" -> candidato3
                    else -> {
                        println("Candidato inválido")
                        continue
                    }
                }
                println("El costo total de la campaña de ${candidato.nombre} es: ${candidato.calcularCostoCampaña()}")
            }

            "3" -> {
                votacion.vaciarUrnas()
                println("Urnas vaciadas.")
            }

            "4" -> {
                println("El total de votos es: ${votacion.totalVotos()}")
            }

            "5" -> {
                listOf(candidato1, candidato2, candidato3).forEach {
                    println("${it.nombre}: ${votacion.porcentajeVotos(it)}% de los votos.")
                }
            }

            "6" -> {
                println("El costo promedio de campaña es: ${votacion.costoPromedioCampaña()}")
            }

            "7" -> {
                val candidatoConMasVotos = votacion.candidatoConMasVotos()

            }

            "8" -> {
                println("Saliendo...")
                break
            }

            else -> println("Opción inválida. Intente nuevamente.")
        }
    }
}