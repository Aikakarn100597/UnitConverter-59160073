package com.example.unitconverter


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.unitconverter.databinding.FragmentChangeWeightUnitBinding

/**
 * A simple [Fragment] subclass.
 */
class changeWeightUnitFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentChangeWeightUnitBinding>(inflater,R.layout.fragment_change_weight_unit,container,false)

//        binding.confirmButton.setOnClickListener { view ->
//            view.findNavController().navigate(R.id.action_weightUnitFragment_to_changeWeightUnitFragment)
//        }

        binding.cancelButton.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_changeWeightUnitFragment2_to_weightUnitFragment)
        }

        Log.i("temperatureUnitFragment", "onCreateView Called")

        return binding.root
//        return inflater.inflate(R.layout.fragment_change_weight_unit, container, false)
    }


}
