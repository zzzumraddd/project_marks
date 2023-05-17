package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.myapplication.Database.AppDataBase
import com.example.myapplication.Entity.User
import com.example.myapplication.databinding.FragmentLoginBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class Login : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    val appDataBase: AppDataBase by lazy{
        AppDataBase.getInstance(requireContext())
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding = FragmentLoginBinding.inflate(layoutInflater, container, false)

        binding.textView2.setOnClickListener {
            findNavController().navigate(R.id.action_login2_to_registration)
        }


        binding.login.setOnClickListener {
            var login = binding.name.text.toString()
            var password = binding.pass.text.toString()
            var user: User
          if(login != "" && password != ""){
               user = appDataBase.getUsersDao().getUser(login,password)
               Log.d("AAA", user.login)
              if(user.role.toLowerCase().equals("student")){
                  val bundle = bundleOf()
                  bundle.putInt("student", user.user_id)
                  findNavController().navigate(R.id.action_login2_to_students_Page, bundle)
              }

              if(user.role.toLowerCase().equals("teacher")){
                  val bundle = bundleOf()
                  bundle.putInt("teacher", user.user_id)

                  findNavController().navigate(R.id.action_login2_to_teachers_Page, bundle)
              }
           }

        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Login().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}