package ar.edu.unahur.obj2.semillasAlViento

class Parcela(val ancho: Int, val largo: Int, val horasSolPorDia: Int) {
  val plantas = mutableListOf<Planta>()
  var cantidadPlantas = 0 //Innecesario, no se pide por ningunlado en los requerimientos (YAGNI)
                          // en caso de nesecitar saber la cantidad de plantas se deberia hacer una funcion cuyo return seria "plantas.size"
  fun superficie() = ancho * largo
  fun cantidadMaximaPlantas() =
    if (ancho > largo) ancho * largo / 5 else ancho * largo / 3 + largo // Abstraccion -> si ya se calculo la superficie no es necesario hacer la cuenta otra vez. va en contra de la reutilizacion de codigo. reusabilidad.

  fun plantar(planta: Planta) {
    if (cantidadPlantas == this.cantidadMaximaPlantas()) {
      println("Ya no hay lugar en esta parcela")
    } else if (horasSolPorDia > planta.horasDeSolQueTolera() + 2) {
      println("No se puede plantar esto acá, se va a quemar")
    } else {
      plantas.add(planta)
      cantidadPlantas += 1// innecesario
    }
  }
}
//cohesion todo el if de plantar puede ir en otra funcion que devuelva un booleano. sePuedePalntar(planta)
class Agricultora(val parcelas: MutableList<Parcela>) {
  var ahorrosEnPesos = 20000

  // Suponemos que una parcela vale 5000 pesos
  fun comprarParcela(parcela: Parcela) { //Simplicidad - KISS - Es una complejidad no pedida
    if (ahorrosEnPesos >= 5000) {
      parcelas.add(parcela)
      ahorrosEnPesos -= 5000
    }
  }

  fun parcelasSemilleras() =
    parcelas.filter {
      parcela -> parcela.plantas.all {
        planta -> planta.daSemillas()
      }
    }

  fun plantarEstrategicamente(planta: Planta) {
    val laElegida = parcelas.maxBy { it.cantidadMaximaPlantas() - it.cantidadPlantas }!!
    laElegida.plantas.add(planta)// redundancia, falta de robustez. Generacion de errores. si no se utiliza el metodo plantar de parcela, no sabes si se puede o no plantar la planta.
//Podria ser mas simple con un minBy, que devuelve el menor valor. parcelas.minBy(it.cantidadMaximaPlantas())

  }
}

//FALTA este requerimiento: saber si tiene complicaciones,

//FALTA: faltan todos los test. Asique eso seria facilidad de prueba, que no la hay