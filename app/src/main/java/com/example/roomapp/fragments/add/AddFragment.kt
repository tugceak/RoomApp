package com.example.roomapp.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.roomapp.R
import com.example.roomapp.data.User
import com.example.roomapp.data.UserViewModal
import com.example.roomapp.databinding.FragmentAddBinding
import com.example.roomapp.databinding.FragmentListBinding
import kotlinx.coroutines.InternalCoroutinesApi






@InternalCoroutinesApi
class AddFragment : Fragment() {
    private lateinit var binding: FragmentAddBinding
    private lateinit var mUserViewModel : UserViewModal


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(inflater,container,false)
        mUserViewModel = ViewModelProvider(this).get(UserViewModal::class.java)
        binding.addButton.setOnClickListener {
            insertDataToDatabase()
        }




        return binding.root

    }

    private fun insertDataToDatabase() {
        val firstName =binding.addFirstEt.text.toString()
        val lastName = binding.addLastEt.text.toString()
        val age =binding.addAgeEt.text
        if (inputCheck(firstName,lastName,age)){
            val user=User(0,firstName,lastName,Integer.parseInt(age.toString()))
            mUserViewModel.addUser(user)
            Toast.makeText(requireContext(),"SUCCESFULLY ADDED",Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(requireContext(),"PLEASE FILL OUT ALL FIELDS",Toast.LENGTH_LONG).show()
        }



    }
    private fun inputCheck(firstName:String ,lastName:String,age:Editable):Boolean{
        return !(TextUtils.isEmpty(firstName)&&TextUtils.isEmpty(lastName)&& age.isEmpty())

    }


}