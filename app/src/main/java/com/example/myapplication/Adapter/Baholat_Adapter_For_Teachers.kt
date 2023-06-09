package com.example.myapplication.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Entity.Marks
import com.example.myapplication.R
import com.example.myapplication.databinding.MarksItemBinding

class Baholat_Adapter_For_Teachers (var list: MutableList<Marks_List>,  var contInterface: ContactInterface) : RecyclerView.Adapter<Baholat_Adapter_For_Teachers.ViewHolder>(){
    class ViewHolder(binding: MarksItemBinding): RecyclerView.ViewHolder(binding.root){
        var name = binding.subjectName
        var bsb1 = binding.bsb1
        var bsb2 = binding.bsb2
        var fb = binding.fb
        var chsb = binding.chsb
        var jami  = binding.jami

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(MarksItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = list.get(position).name
        holder.bsb1.text = list.get(position).bsb1.toString()
        holder.bsb2.text = list.get(position).bsb2.toString()
        holder.fb.text = list.get(position).fb.toString()
        holder.chsb.text = list.get(position).chsb.toString()
        var total = list.get(position).bsb1+list.get(position).bsb2+list.get(position).fb+list.get(position).chsb
        holder.jami.text = total.toString()

        holder.bsb1.setOnClickListener {
           contInterface.onClick()
        }
        holder.bsb2.setOnClickListener {
            //bsb2
        }
        holder.fb.setOnClickListener {
            //bsbfb
        }
        holder.chsb.setOnClickListener {
            //chsb
        }
    }


    override fun getItemCount(): Int {
        return list.size
    }
    interface ContactInterface{
        fun onClick()
    }

}