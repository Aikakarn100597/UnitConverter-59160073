package com.example.unitconverter

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.unitconverter.databinding.FragmentFirstPageBinding
import kotlinx.android.synthetic.main.fragment_first_page.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class firstPageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentFirstPageBinding>(inflater,R.layout.fragment_first_page,container,false)

        binding.lengthButton.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_firstPageFragment_to_unitConverter)
        }

        binding.temperatureButton.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_firstPageFragment_to_unitConverter)
        }

        binding.weightButton.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_firstPageFragment_to_unitConverter)
        }

        setHasOptionsMenu(true)

        return binding.root
//        return inflater.inflate(R.layout.fragment_first_page, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.option_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,
            view!!.findNavController()) || super.onOptionsItemSelected(item)
    }

}
