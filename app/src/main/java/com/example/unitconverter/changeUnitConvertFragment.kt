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

    private lateinit var binding: FragmentChangeUnitConvertBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        val binding = DataBindingUtil.inflate<FragmentChangeUnitConvertBinding>(inflater,R.layout.fragment_change_unit_convert,container,false)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_change_unit_convert,container,false)

        val args = changeUnitConvertArgs.fromBundle(arguments!!)

        binding.fromUnit.text = args.unitFrom
        binding.toUnit.text = args.unitTo

        binding.confirmButton.setOnClickListener { view ->
            unitConvert(view)
        }

        binding.cancelButton.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_changeUnitConvert_to_unitConverter)
        }

        Log.i("changeUnitConvert", "onCreateView Called")

        return binding.root

//        return inflater.inflate(R.layout.fragment_change_unit_convert, container, false)
    }

    fun unitConvert(view: View?) {
//        val binding = DataBindingUtil.inflate<FragmentChangeUnitConvertBinding>(inflater,R.layout.fragment_change_unit_convert,container,false)

        val args = changeUnitConvertArgs.fromBundle(arguments!!)

        var result = 1.0

            if (binding.formEditText.text.isEmpty()) {
                val alert: Int = Toast.LENGTH_SHORT
                val toast = Toast.makeText(context, "กรูณาใส่ตัวเลข", alert)
                toast.show()
            } else {
                var num = binding.formEditText.text.toString().toInt()

                if (args.unitFrom == "นิ้ว") {
                    if (args.unitTo == "นิ้ว") {
                        result = num.toDouble()
                    } else if (args.unitTo == "ฟุต") {
                        result = num / 12.00
                    } else if (args.unitTo == "เมตร") {
                        result = num * 0.0254
                    } else if (args.unitTo == "กิโลเมตร") {
                        result = num * 0.0000254
                    } else if (args.unitTo == "เซนติเมตร") {
                        result = num * 2.54
                    } else if (args.unitTo == "มิลลิเมตร") {
                        result = num * 25.4
                    } else if (args.unitTo == "หลา") {
                        result = num / 36.0
                    } else if (args.unitTo == "ไมล์") {
                        result = num / 63360.00
                    }
                }

//            case "feet":
//            {
//                switch(newU)
//                {
//                    case "inches":
//
//                    num2 = num1*12.0d;
//                    break;
//                    case "feet":
//                    num2 = num1;
//                    break;
//                    case "yards":
//
//                    num2 = num1/3.0d;
//                    break;
//                    case "miles":
//
//                    num2 = num1/5280.0d;
//                    break;
//                    case "millimeters":
//
//                    num2 = num1*304.8d;
//                    break;
//                    case "centimeters":
//
//                    num2 = num1*30.48d;
//                    break;
//                    case "meters":
//
//                    num2 = num1*0.3048d;
//                    break;
//                    case "kilometers":
//
//                    num2 = num1*0.0003048d;
//                    break;
//                }
//                break;
//            }
//            case "yards":
//            {
//                switch(newU) {
//                    case "inches":
//
//                    num2 = num1 * 36.0d;
//                    break;
//                    case "feet":
//
//                    num2 = num1 * 3.0d;
//                    break;
//                    case "yards":
//                    num2 = num1;
//                    break;
//                    case "miles":
//
//                    num2 = num1 / 1760.0d;
//                    break;
//                    case "millimeters":
//
//                    num2 = num1 * 914.4d;
//                    break;
//                    case "centimeters":
//
//                    num2 = num1*91.44d;
//                    break;
//                    case "meters":
//                    num2 = num1*0.9144d;
//                    break;
//                    case "kilometers":
//
//                    num2 = num1/1093.61d;
//                    break;
//                }
//                break;
//            }
//            case "miles":
//            {
//                switch(newU)
//                {
//                    case "inches":
//
//                    num2 = num1*6330.0d;
//                    break;
//                    case "feet":
//
//                    num2 = num1*5280.0d;
//                    break;
//                    case "yards":
//
//                    num2 = num1*1760.0d;
//                    break;
//                    case "miles":
//                    num2 = num1;
//                    break;
//                    case "millimeters":
//
//                    num2 = num1*1609340.0d;
//                    break;
//                    case "centimeters":
//
//                    num2 = num1*160934.0d;
//                    break;
//                    case "meters":
//
//                    num2 = num1*1609.34d;
//                    break;
//                    case "kilometers":
//
//                    num2 = num1*1.60934d;
//                    break;
//                }
//                break;
//            }
//            case "millimeters":
//            {
//                switch(newU)
//                {
//                    case "inches":
//                    num2 = num1*25.4d;
//                    break;
//                    case "feet":
//                    num2 = num1/304.8d;
//                    break;
//                    case "yards":
//                    num2 = num1/914.4d;
//                    break;
//                    case "miles":
//                    num2 = num1/1609000.0d;
//                    break;
//                    case "millimeters":
//                    num2 = num1;
//                    break;
//                    case "centimeters":
//                    num2 = metricConverter.metricConvert(num1, "milli", "centi");
//                    break;
//                    case "meters":
//                    num2 = metricConverter.metricConvert(num1, "milli", "unit");
//                    break;
//                    case "kilometers":
//                    num2 = metricConverter.metricConvert(num1, "milli", "kilo");
//                    break;
//                }
//                break;
//            }
//
//            case "centimeters":
//            {
//                switch(newU)
//                {
//                    case "inches":
//                    num2 = num1 / 2.54d;
//                    break;
//                    case "feet":
//                    num2 = num1 / 30.48d;
//                    break;
//                    case "yards":
//                    num2 = num1 / 91.44d;
//                    break;
//                    case "miles":
//                    num2 = num1/160934.0d;
//                    break;
//                    case "millimeters":
//                    num2 = metricConverter.metricConvert(num1, "centi", "milli");
//                    break;
//                    case "centimeters":
//                    num2 = num1;
//                    break;
//                    case "meters":
//                    num2 = metricConverter.metricConvert(num1, "centi", "unit");
//                    break;
//                    case "kilometers":
//                    num2 = metricConverter.metricConvert(num1, "centi", "kilo");
//                    break;
//                }
//                break;
//            }
//            case "meters":
//            {
//                switch(newU) {
//                    case "inches":
//                    num2 = num1 * 39.3701d;
//                    break;
//                    case "feet":
//                    num2 = num1 * 3.28084d;
//                    break;
//                    case "yards":
//                    num2 = num1*1.09361d;
//                    break;
//                    case "miles":
//                    num2 = num1/1609.34d;
//                    break;
//                    case "millimeters":
//                    num2 = metricConverter.metricConvert(num1, "unit", "milli");
//                    break;
//                    case "centimeters":
//                    num2 = metricConverter.metricConvert(num1, "unit", "centi");
//                    break;
//                    case "meters":
//                    num2 = num1;
//                    break;
//                    case "kilometers":
//                    num2 = metricConverter.metricConvert(num1, "unit", "kilo");
//                    break;
//                }
//                break;
//            }
//            case "kilometers":
//            {
//                switch(newU)
//                {
//                    case "inches":
//                    num2 = num1*39370.1d;
//                    break;
//                    case "feet":
//                    num2 = num1*3280.84d;
//                    break;
//                    case "yards":
//                    num2 = num1*1093.61d;
//                    break;
//                    case "miles":
//                    num2 = num1/1.60934d;
//                    break;
//                    case "millimeters":
//                    num2 = metricConverter.metricConvert(num1, "kilo", "milli");
//                    break;
//                    case "centimeters":
//                    num2 = metricConverter.metricConvert(num1, "kilo", "centi");
//                    break;
//                    case "meters":
//                    num2 = metricConverter.metricConvert(num1, "kilo", "unit");
//                    break;
//                    case "kilometers":
//                    num2 = num1;
//                    break;
//                }
//                break;
//            }
            }
        binding.toTextView.text = "%.2f".format(result).toDouble().toString()
    }
}

