package ar.edu.unahur.obj2.semillasAlViento

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class SemillasTest: DescribeSpec({
    describe("Test Planta"){
        val plantaMenta = Menta(2000, 0.6F)
        val plantaSojaMediana = Soja(2009, 0.7F)
        val plantaSojaTrans = SojaTransgenica(2010, 2F)

    describe("Menta"){
        plantaMenta.horasDeSolQueTolera().shouldBe(6)
        plantaMenta.daSemillas().shouldBe(true)
        plantaMenta.esFuerte().shouldBe(false)
        plantaMenta.altura.shouldBe(0.6F)
    }

    describe("Soja"){
        plantaSojaMediana.horasDeSolQueTolera().shouldBe(7)
        plantaSojaMediana.daSemillas().shouldBe(false)
        plantaSojaMediana.esFuerte().shouldBe(false)
        plantaSojaMediana.altura.shouldBe(0.7F)
        plantaSojaMediana.anioObtencionSemilla.shouldBe(2009)
    }

    describe("Soja Transgenica"){
        plantaSojaTrans.horasDeSolQueTolera().shouldBe(18)
        plantaSojaTrans.daSemillas().shouldBe(false)
        plantaSojaTrans.esFuerte().shouldBe(true)
        plantaSojaTrans.altura.shouldBe(2F)
        plantaSojaTrans.anioObtencionSemilla.shouldBe(2010)
    }
    }

    describe("Test Parcela"){
        var unaParcelita = Parcela(5, 5, 7)

        val plantaMenta = Menta(2000, 0.6F)
        val plantaSojaMediana = Soja(2009, 0.7F)
        val plantaSojaTrans = SojaTransgenica(2010, 2F)

        describe("superficie"){
            unaParcelita.superficie().shouldBe(25)
        }
        describe("cantidad maxima de plantas"){
            unaParcelita.cantidadMaximaPlantas().shouldBe(13)
        }
        describe("plantar"){
          unaParcelita.plantar(plantaMenta)
          unaParcelita.plantar(plantaSojaMediana)
          unaParcelita.plantar(plantaSojaTrans)

          unaParcelita.plantas.size.shouldBe(3)
        }
        describe("tiene complicaciones"){
            unaParcelita.plantar(plantaMenta)
            unaParcelita.plantar(plantaSojaMediana)
            unaParcelita.plantar(plantaSojaTrans)

            unaParcelita.tieneComplicaciones().shouldBe(true)
        }

    }

    describe("Test Agricultora"){
        var unaParcelita = Parcela(5, 5, 7)
        var parcelaDos = Parcela(5, 5, 7)
        var parcelaTres = Parcela(5, 5, 7)

        val plantaMenta = Menta(2000, 0.6F)
        val plantaSojaMediana = Soja(2009, 1.7F)
        val plantaSojaTrans = SojaTransgenica(2010, 2F)

        unaParcelita.plantar(plantaMenta)
        unaParcelita.plantar(plantaSojaMediana)
        unaParcelita.plantar(plantaSojaMediana)

        parcelaTres.plantar(plantaMenta)
        parcelaTres.plantar(plantaSojaMediana)
        parcelaTres.plantar(plantaSojaMediana)

        parcelaDos.plantar(plantaSojaTrans)

        var listaParcelas = mutableListOf<Parcela>()
        listaParcelas.add(unaParcelita)
        listaParcelas.add(parcelaDos)
        listaParcelas.add(parcelaTres)

        var agricultora = Agricultora(listaParcelas)

        describe("plantar estrategicamente"){
            parcelaDos.plantas.size.shouldBe(1)

            agricultora.plantarEstrategicamente(plantaSojaTrans)

            parcelaDos.plantas.size.shouldBe(2)
        }

        describe("parcelas semilletas"){

            agricultora.parcelasSemilleras().size.shouldBe(2)
        }
    }
})