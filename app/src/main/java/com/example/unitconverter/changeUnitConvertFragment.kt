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

        binding.backFirstButton.setOnClickListener { view ->
            view.findNavController()
                .navigate(R.id.action_changeUnitConvert_to_firstPageFragment)
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
                } else if (args.unitFrom == "ฟุต") {
                    if (args.unitTo == "นิ้ว") {
                        result = num * 12.0
                    } else if (args.unitTo == "ฟุต") {
                        result = num.toDouble()
                    } else if (args.unitTo == "เมตร") {
                        result = num * 0.3048
                    } else if (args.unitTo == "กิโลเมตร") {
                        result = num * 0.0003048
                    } else if (args.unitTo == "เซนติเมตร") {
                        result = num * 30.48
                    } else if (args.unitTo == "มิลลิเมตร") {
                        result = num * 304.8
                    } else if (args.unitTo == "หลา") {
                        result = num / 3.0
                    } else if (args.unitTo == "ไมล์") {
                        result = num / 5280.0
                    }
                } else if (args.unitFrom == "หลา") {
                    if (args.unitTo == "นิ้ว") {
                        result = num * 36.0
                    } else if (args.unitTo == "ฟุต") {
                        result = num * 3.0
                    } else if (args.unitTo == "เมตร") {
                        result = num * 0.9144
                    } else if (args.unitTo == "กิโลเมตร") {
                        result = num / 1093.61
                    } else if (args.unitTo == "เซนติเมตร") {
                        result = num * 91.44
                    } else if (args.unitTo == "มิลลิเมตร") {
                        result = num * 914.4
                    } else if (args.unitTo == "หลา") {
                        result = num.toDouble()
                    } else if (args.unitTo == "ไมล์") {
                        result = num / 1760.0
                    }
                } else if (args.unitFrom == "ไมล์") {
                    if (args.unitTo == "นิ้ว") {
                        result = num * 6330.0
                    } else if (args.unitTo == "ฟุต") {
                        result = num * 5280.0
                    } else if (args.unitTo == "เมตร") {
                        result = num * 1609.34
                    } else if (args.unitTo == "กิโลเมตร") {
                        result = num * 1.60934
                    } else if (args.unitTo == "เซนติเมตร") {
                        result = num * 160934.0
                    } else if (args.unitTo == "มิลลิเมตร") {
                        result = num * 1609340.0
                    } else if (args.unitTo == "หลา") {
                        result = num * 1760.0
                    } else if (args.unitTo == "ไมล์") {
                        result = num.toDouble()
                    }
                } else if (args.unitFrom == "มิลลิเมตร") {
                    if (args.unitTo == "นิ้ว") {
                        result = num / 25.4
                    } else if (args.unitTo == "ฟุต") {
                        result = num / 304.8
                    } else if (args.unitTo == "เมตร") {
                        result = num / 1000.00
                    } else if (args.unitTo == "กิโลเมตร") {
                        result = num / 1000000.0
                    } else if (args.unitTo == "เซนติเมตร") {
                        result = num / 10.00
                    } else if (args.unitTo == "มิลลิเมตร") {
                        result = num.toDouble()
                    } else if (args.unitTo == "หลา") {
                        result = num / 914.4
                    } else if (args.unitTo == "ไมล์") {
                        result = num / 1609000.0
                    }
                } else if (args.unitFrom == "เซนติเมตร") {
                    if (args.unitTo == "นิ้ว") {
                        result = num / 2.54
                    } else if (args.unitTo == "ฟุต") {
                        result = num / 30.48
                    } else if (args.unitTo == "เมตร") {
                        result = num / 100.00
                    } else if (args.unitTo == "กิโลเมตร") {
                        result = num / 100000.0
                    } else if (args.unitTo == "เซนติเมตร") {
                        result = num.toDouble()
                    } else if (args.unitTo == "มิลลิเมตร") {
                        result = num * 10.0
                    } else if (args.unitTo == "หลา") {
                        result = num / 91.44
                    } else if (args.unitTo == "ไมล์") {
                        result = num / 160934.0
                    }
                } else if (args.unitFrom == "เมตร") {
                    if (args.unitTo == "นิ้ว") {
                        result = num * 39.3701
                    } else if (args.unitTo == "ฟุต") {
                        result = num * 3.28084
                    } else if (args.unitTo == "เมตร") {
                        result = num.toDouble()
                    } else if (args.unitTo == "กิโลเมตร") {
                        result = num / 1000.0
                    } else if (args.unitTo == "เซนติเมตร") {
                        result = num * 100.0
                    } else if (args.unitTo == "มิลลิเมตร") {
                        result = num * 1000.0
                    } else if (args.unitTo == "หลา") {
                        result = num * 1.09361
                    } else if (args.unitTo == "ไมล์") {
                        result = num / 1609.34
                    }
                } else if (args.unitFrom == "กิโลเมตร") {
                    if (args.unitTo == "นิ้ว") {
                        result = num * 39370.1
                    } else if (args.unitTo == "ฟุต") {
                        result = num * 3280.84
                    } else if (args.unitTo == "เมตร") {
                        result = num * 1000.0
                    } else if (args.unitTo == "กิโลเมตร") {
                        result = num.toDouble()
                    } else if (args.unitTo == "เซนติเมตร") {
                        result = num * 100000.0
                    } else if (args.unitTo == "มิลลิเมตร") {
                        result = num * 1000000.0
                    } else if (args.unitTo == "หลา") {
                        result = num * 1093.61
                    } else if (args.unitTo == "ไมล์") {
                        result = num / 1.60934
                    }
                }
            }
        binding.toTextView.text = "%.2f".format(result).toDouble().toString()
    }
}

