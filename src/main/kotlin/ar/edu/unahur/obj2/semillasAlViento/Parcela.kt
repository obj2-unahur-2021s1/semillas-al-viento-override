package ar.edu.unahur.obj2.semillasAlViento

class Parcela(val ancho: Int, val largo: Int, val horasSolPorDia: Int) {
  val plantas = mutableListOf<Planta>()


  fun superficie() = ancho * largo

  fun cantidadMaximaPlantas() =
    if (ancho > largo) this.superficie() / 5 else this.superficie() / 3 + largo

  fun sePuedePlantar(planta: Planta): Boolean {
    return plantas.size < this.cantidadMaximaPlantas() && horasSolPorDia < planta.horasDeSolQueTolera() + 2
  }

  fun plantar(planta: Planta) {
    if (sePuedePlantar(planta)) {
      plantas.add(planta)
    }
    else{ error("No se puede plantar aqui")}
  }

  fun tieneComplicaciones(): Boolean {
    return plantas.any { it.horasDeSolQueTolera() < this.horasSolPorDia }
  }

}



