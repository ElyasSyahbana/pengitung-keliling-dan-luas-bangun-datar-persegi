package org.d3if4030.pengitungkelilingdanluasbangundatarpersegi

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import org.d3if4030.pengitungkelilingdanluasbangundatarpersegi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?  {
        binding = ActivityMainBinding.inflate(layoutInflater,container,false)
        binding.button.setOnClickListener{
            hitung()
        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun hitung (){
        val sisi = binding.sisi.text.toString()
        if (TextUtils.isEmpty(sisi)){
            Toast.makeText(this, "Sisi Harus Diisi", Toast.LENGTH_LONG).show()
            return
        }
        val hasilKeliling = sisi.toDouble()*4
        val hasilLuas = sisi.toDouble()*sisi.toDouble()
        binding.textKeliling.visibility = View.VISIBLE
        binding.keliling.text = hasilKeliling.toString()
        binding.textLuas.visibility = View.VISIBLE
        binding.luas.text = hasilLuas.toString()

    }

}