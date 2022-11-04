package app.iggy.messagereactions.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import app.iggy.messagereactions.Interfaces.AdapterCallback
import app.iggy.messagereactions.R
import java.util.*

class MyAdapter(var myList: ArrayList<String>,
                private val adapterCallback: AdapterCallback): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle = itemView.findViewById<TextView>(R.id.tv_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.my_item,
            parent, false
        )
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        if (myList.isNotEmpty()){
            holder.tvTitle.text = myList[position]

            holder.itemView.setOnLongClickListener{ view ->
                adapterCallback.callback(view)
                true
            }
        }
    }

    override fun getItemCount(): Int {
        return myList.size
    }
}