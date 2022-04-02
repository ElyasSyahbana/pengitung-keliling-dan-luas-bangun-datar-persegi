package org.d3if4030.pengitungkelilingdanluasbangundatarpersegi

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import org.d3if4030.pengitungkelilingdanluasbangundatarpersegi.databinding.FragmentUtamaBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentUtama.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentUtama : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentUtamaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?  {
        binding = FragmentUtamaBinding.inflate(layoutInflater,container,false)
        binding.button.setOnClickListener{
            hitung()
        }
        binding.textKeliling.visibility = View.GONE
        binding.keliling.visibility = View.GONE
        binding.textLuas.visibility = View.GONE
        binding.luas.visibility = View.GONE
        return binding.root
    }

    private fun hitung (){
        val sisi = binding.sisi.text.toString()
        if (TextUtils.isEmpty(sisi)){
            Toast.makeText(context, "Panjang sisi Harus Diisi", Toast.LENGTH_LONG).show()
            return
        }
        val hasilKeliling = sisi.toDouble()*4
        val hasilLuas = sisi.toDouble()*sisi.toDouble()
        binding.textKeliling.visibility = View.VISIBLE
        binding.keliling.visibility = View.VISIBLE
        binding.keliling.text = hasilKeliling.toString()
        binding.textLuas.visibility = View.VISIBLE
        binding.luas.visibility = View.VISIBLE
        binding.luas.text = hasilLuas.toString()

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentUtama.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentUtama().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}