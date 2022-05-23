package org.d3if4030.pengitungkelilingdanluasbangundatarpersegi.data

import org.d3if4030.pengitungkelilingdanluasbangundatarpersegi.HasilPersegi
import org.d3if4030.pengitungkelilingdanluasbangundatarpersegi.db.PersegiEntity

object HitungPersegi {

    fun hitung(data: PersegiEntity): HasilPersegi{
        val sisi = data.sisi
        val hasilKeliling = sisi.toDouble()*4
        val hasilLuas = sisi.toDouble()*sisi.toDouble()

        return HasilPersegi(sisi,hasilKeliling.toFloat(),hasilLuas.toFloat())
    }
}