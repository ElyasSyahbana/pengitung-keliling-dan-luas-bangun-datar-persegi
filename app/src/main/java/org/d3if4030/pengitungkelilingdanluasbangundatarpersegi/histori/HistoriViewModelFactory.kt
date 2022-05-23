package org.d3if4030.pengitungkelilingdanluasbangundatarpersegi.histori

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if4030.pengitungkelilingdanluasbangundatarpersegi.db.PersegiDao
import java.lang.IllegalArgumentException

class HistoriViewModelFactory(
    private val db: PersegiDao
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(HistoriViewModel::class.java)){
            return HistoriViewModel(db) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}