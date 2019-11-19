package com.example.unitconverter

import android.os.Bundle
import android.util.Log
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

        binding.weightButton.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_firstPageFragment_to_weightUnitFragment)
        }

        setHasOptionsMenu(true)

        Log.i("firstPageFragment", "onCreateView Called")

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

    override fun onStart() {
        super.onStart()
        Log.i("firstPageFragment", "onStart Called")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("firstPageFragment", "onCreate called")
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.i("firstPageFragment", "onActivityCreated called")
    }
    override fun onResume() {
        super.onResume()
        Log.i("firstPageFragment", "onResume called")
    }
    override fun onPause() {
        super.onPause()
        Log.i("firstPageFragment", "onPause called")
    }
    override fun onStop() {
        super.onStop()
        Log.i("firstPageFragment", "onStop called")
    }
    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("firstPageFragment", "onDestroyView called")
    }
    override fun onDetach() {
        super.onDetach()
        Log.i("firstPageFragment", "onDetach called")
    }
}
