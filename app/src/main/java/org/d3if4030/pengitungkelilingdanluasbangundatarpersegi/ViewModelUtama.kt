package org.d3if4030.pengitungkelilingdanluasbangundatarpersegi

import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if4030.pengitungkelilingdanluasbangundatarpersegi.data.HitungPersegi
import org.d3if4030.pengitungkelilingdanluasbangundatarpersegi.db.PersegiDao
import org.d3if4030.pengitungkelilingdanluasbangundatarpersegi.db.PersegiDb
import org.d3if4030.pengitungkelilingdanluasbangundatarpersegi.db.PersegiEntity

class ViewModelUtama(private val db: PersegiDao) : ViewModel() {
    private val hasilPersegi = MutableLiveData<HasilPersegi?>()
    //val data = db.getLastPersegi()

    fun hitung (sisiString: String){

//        if (TextUtils.isEmpty(sisi)){
//            Toast.makeText(context, "Panjang sisi Harus Diisi", Toast.LENGTH_LONG).show()
//            return
//        }
//        val sisi = sisiString.toFloat()
//        val hasilKeliling = sisi.toDouble()*4
//        val hasilLuas = sisi.toDouble()*sisi.toDouble()
//        hasilPersegi.value = HasilPersegi(sisi,hasilKeliling.toFloat(),hasilLuas.toFloat())

        val dataPersegi = PersegiEntity(
            sisi = sisiString.toFloat(),

        )
        hasilPersegi.value = HitungPersegi.hitung(dataPersegi)

        viewModelScope.launch {
            withContext(Dispatchers.IO){
//                val dataPersegi = PersegiEntity(
//                    sisi = sisi,
//                    keliling = hasilKeliling.toFloat(),
//                    luas = hasilLuas.toFloat()
//                )
                db.insert(dataPersegi)
            }
        }

//        binding.textKeliling.visibility = View.VISIBLE
//        binding.keliling.visibility = View.VISIBLE
//        binding.keliling.text = hasilKeliling.toString()
//        binding.textLuas.visibility = View.VISIBLE
//        binding.luas.visibility = View.VISIBLE
//        binding.luas.text = hasilLuas.toString()

    }
    fun getHasilPersegi() : LiveData<HasilPersegi?> = hasilPersegi
}