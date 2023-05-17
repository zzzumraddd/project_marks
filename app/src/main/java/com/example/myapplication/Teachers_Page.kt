package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.myapplication.Adapter.Baholat_Adapter_For_Teachers
import com.example.myapplication.Adapter.Bakholar_Adapter
import com.example.myapplication.Adapter.Marks_List
import com.example.myapplication.databinding.FragmentTeachersPageBinding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Teachers_Page : Fragment() {
    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val binding = FragmentTeachersPageBinding.inflate(layoutInflater, container, false)
        var mutableList = mutableListOf<Marks_List>()
        mutableList.add(Marks_List("", 3,5, 7,9))
        var adapter = Baholat_Adapter_For_Teachers(mutableList, object : Baholat_Adapter_For_Teachers.ContactInterface {
            override fun onClick() {
                val teacher_id = arguments?.getInt("teacher")
                Log.d("AAA", teacher_id.toString())
                findNavController().navigate(R.id.action_teachers_Page_to_putMark)
            }

        })
        binding.rv.setAdapter(adapter)
        return binding.root
    }

    companion object {


        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Teachers_Page().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}

