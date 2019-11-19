package com.example.unitconverter


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.unitconverter.databinding.FragmentWeightUnitBinding
import kotlinx.android.synthetic.main.fragment_weight_unit.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class weightUnitFragment : Fragment() {

    lateinit var unitFrom: String
    lateinit var unitTo: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentWeightUnitBinding>(
            inflater,R.layout.fragment_weight_unit,container,false)

        binding.confirmButton.setOnClickListener { view ->
//            view.findNavController().navigate(R.id.action_weightUnitFragment_to_changeWeightUnitFragment2)

            view.findNavController().navigate(weightUnitFragmentDirections.actionWeightUnitFragmentToChangeWeightUnitFragment2(unitFrom, unitTo))

            val alert: Int = Toast.LENGTH_SHORT
            val toast = Toast.makeText(context, "${unitFrom} + ${unitTo}", alert)
            toast.show()
        }

        binding.cancelButton.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_weightUnitFragment_to_firstPageFragment)
        }

        Log.i("temperatureUnitFragment", "onCreateView Called")

        return binding.root
//        return inflater.inflate(R.layout.fragment_weight_unit, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*Find the id of spinner*/
        val spinnerf = spinnerWF
        val spinnert = spinnerWT

        /*set an adapter with strings array*/
        spinnerf.adapter = activity?.let {
            ArrayAdapter(
                it,
                R.layout.support_simple_spinner_dropdown_item,
                resources.getStringArray(R.array.weightUnit)
            )
        }
        /*set click listener*/
        spinnerf.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                unitFrom =  spinnerf.selectedItem.toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                /*Do something if nothing selected*/
            }
        }

        /*set an adapter with strings array*/
        spinnert.adapter = activity?.let {
            ArrayAdapter(
                it,
                R.layout.support_simple_spinner_dropdown_item,
                resources.getStringArray(R.array.weightUnit)
            )
        }
        /*set click listener*/
        spinnert.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                unitTo =  spinnert.selectedItem.toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                /*Do something if nothing selected*/
            }
        }

    }

}
