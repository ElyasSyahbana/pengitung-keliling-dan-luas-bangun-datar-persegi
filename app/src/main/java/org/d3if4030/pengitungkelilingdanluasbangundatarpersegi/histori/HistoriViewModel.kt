package org.d3if4030.pengitungkelilingdanluasbangundatarpersegi.histori

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if4030.pengitungkelilingdanluasbangundatarpersegi.db.PersegiDao
import org.d3if4030.pengitungkelilingdanluasbangundatarpersegi.db.PersegiEntity

class HistoriViewModel(private val db: PersegiDao): ViewModel() {
    val data = db.getLastPersegi()

    fun deleteData(persegi: PersegiEntity) = viewModelScope.launch {
        withContext(Dispatchers.IO){
            db.delete(persegi)
        }
    }

    fun deleteAll() = viewModelScope.launch {
        withContext(Dispatchers.IO){
            db.clearData()
        }
    }
}