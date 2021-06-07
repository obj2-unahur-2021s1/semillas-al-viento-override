package ar.edu.unahur.obj2.semillasAlViento

class Agricultora(val parcelas: MutableList<Parcela>) {

    fun parcelasSemilleras() =
        parcelas.filter {
                parcela -> parcela.plantas.all { planta -> planta.daSemillas() }
        }

    fun parcelaConMasLugar(): Parcela {
        return parcelas.maxBy { it.cantidadMaximaPlantas() - it.plantas.size }!!
    }

    fun plantarEstrategicamente(planta: Planta) {
        val laElegida = parcelaConMasLugar()

        laElegida.plantar(planta)
        }
}