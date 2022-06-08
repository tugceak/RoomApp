package com.example.roomapp.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomapp.R
import com.example.roomapp.data.User
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapter:RecyclerView.Adapter<ListAdapter.MyViewHolder> (){
    private var userList= emptyList<User>()
    class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val currentItem =userList[position]
        holder.itemView.idTw.text=currentItem.id.toString()
        holder.itemView.firstTw.text=currentItem.firstName.toString()
        holder.itemView.lastTw.text=currentItem.lastName.toString()
        holder.itemView.ageTw.text=currentItem.age.toString()

    }
    fun setData(user : List<User>){
        this.userList=user
        notifyDataSetChanged()

    }

    override fun getItemCount(): Int {
      return userList.size
    }
}