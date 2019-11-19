package com.example.unitconverter


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.unitconverter.databinding.FragmentChangeUnitConvertBinding
import kotlinx.android.synthetic.main.fragment_change_unit_convert.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class changeUnitConvert : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding = DataBindingUtil.inflate<FragmentChangeUnitConvertBinding>(inflater,R.layout.fragment_change_unit_convert,container,false)

        val args = changeUnitConvertArgs.fromBundle(arguments!!)

        binding.apply {
            fromUnit.text = args.unitFrom
            toUnit.text = args.unitTo
        }

        binding.cancelButton.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_changeUnitConvert_to_unitConverter)
        }

        Log.i("changeUnitConvert", "onCreateView Called")

        return binding.root

//        return inflater.inflate(R.layout.fragment_change_unit_convert, container, false)
    }


}
