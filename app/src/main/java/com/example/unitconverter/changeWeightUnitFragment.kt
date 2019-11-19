package com.example.unitconverter


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.unitconverter.databinding.FragmentChangeUnitConvertBinding
import com.example.unitconverter.databinding.FragmentChangeWeightUnitBinding

/**
 * A simple [Fragment] subclass.
 */
class changeWeightUnitFragment : Fragment() {

    private lateinit var binding: FragmentChangeUnitConvertBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        val binding = DataBindingUtil.inflate<FragmentChangeWeightUnitBinding>(inflater,R.layout.fragment_change_weight_unit,container,false)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_change_unit_convert,container,false)

        val args = changeUnitConvertArgs.fromBundle(arguments!!)

        binding.fromUnit.text = args.unitFrom
        binding.toUnit.text = args.unitTo

        binding.confirmButton.setOnClickListener { view ->
            weightUnitConvert(view)
        }

        binding.cancelButton.setOnClickListener { view ->
            view.findNavController()
                .navigate(R.id.action_changeWeightUnitFragment2_to_weightUnitFragment)
        }

        binding.backFirstButton.setOnClickListener { view ->
            view.findNavController()
                .navigate(R.id.action_changeWeightUnitFragment2_to_firstPageFragment)
        }

        Log.i("temperatureUnitFragment", "onCreateView Called")

        return binding.root
//        return inflater.inflate(R.layout.fragment_change_weight_unit, container, false)
    }

    fun weightUnitConvert(view: View) {
        val args = changeUnitConvertArgs.fromBundle(arguments!!)

        var result = 1.0

        if (binding.formEditText.text.isEmpty()) {
            val alert: Int = Toast.LENGTH_SHORT
            val toast = Toast.makeText(context, "กรูณาใส่ตัวเลข", alert)
            toast.show()
        } else {
            var num = binding.formEditText.text.toString().toInt()

            if (args.unitFrom == "กิโลกรัม") {
                if (args.unitTo == "กิโลกรัม") {
                    result = num.toDouble()
                } else if (args.unitTo == "กรัม") {
                    result = num * 1000.00
                } else if (args.unitTo == "ตัน") {
                    result = num / 1000.00
                } else if (args.unitTo == "ปอนด์") {
                    result = num * 2.2046
                } else if (args.unitTo == "ออนซ์") {
                    result = num * 35.274
                }
            } else if (args.unitFrom == "กรัม") {
                if (args.unitTo == "กิโลกรัม") {
                    result = num / 1000.00
                } else if (args.unitTo == "กรัม") {
                    result = num.toDouble()
                } else if (args.unitTo == "ตัน") {
                    result = num / 1000000.00
                } else if (args.unitTo == "ปอนด์") {
                    result = num * 0.0022046
                } else if (args.unitTo == "ออนซ์") {
                    result = num * 0.03527396195
                }
            } else if (args.unitFrom == "ตัน") {
                if (args.unitTo == "กิโลกรัม") {
                    result = num * 1000.0
                } else if (args.unitTo == "กรัม") {
                    result = num * 1000000.00
                } else if (args.unitTo == "ตัน") {
                    result = num.toDouble()
                } else if (args.unitTo == "ปอนด์") {
                    result = num * 2204.62262
                } else if (args.unitTo == "ออนซ์") {
                    result = (num * 2204.62262) * 16.00
                }
            } else if (args.unitFrom == "ปอนด์") {
                if (args.unitTo == "กิโลกรัม") {
                    result = num / 2.2046
                } else if (args.unitTo == "กรัม") {
                    result = num / 0.0022046
                } else if (args.unitTo == "ตัน") {
                    result = num / 2204.62262
                } else if (args.unitTo == "ปอนด์") {
                    result = num.toDouble()
                } else if (args.unitTo == "ออนซ์") {
                    result = num * 16.0
                }
            } else if (args.unitFrom == "ออนซ์") {
                if (args.unitTo == "กิโลกรัม") {
                    result = num / 35.274
                } else if (args.unitTo == "กรัม") {
                    result = num / 0.03527396195
                } else if (args.unitTo == "ตัน") {
                    result = (num * 0.0625) / 2204.62262
                } else if (args.unitTo == "ปอนด์") {
                    result = num * 0.0625
                } else if (args.unitTo == "ออนซ์") {
                    result = num.toDouble()
                }
            }
        }
        binding.toTextView.text = "%.2f".format(result).toDouble().toString()
    }

}
