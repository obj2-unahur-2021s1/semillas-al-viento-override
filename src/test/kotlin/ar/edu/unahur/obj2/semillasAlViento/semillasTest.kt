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
})