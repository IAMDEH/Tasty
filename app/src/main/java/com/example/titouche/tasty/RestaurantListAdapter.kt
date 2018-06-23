package com.example.titouche.tasty

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide


class RestaurantListAdapter(private var myDataset: ArrayList<Restaurant>, var mCtx:Context):RecyclerView.Adapter<RestaurantListAdapter.ViewHolder>(){
    class ViewHolder (holder : View):RecyclerView.ViewHolder(holder){
        val nom = holder.findViewById<TextView>(R.id.nomr)
        var image = holder.findViewById<ImageView>(R.id.image)
        val phone = holder.findViewById<TextView>(R.id.phone)
        val email = holder.findViewById<TextView>(R.id.email)
        val info = holder.findViewById<ImageButton>(R.id.info)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.restaurant_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nom.text = myDataset[position].nom
        //holder.image.setImageResource(myDataset[position].image)
        Glide.with(mCtx).load(RetrofitService.baseUrl+myDataset[position].image).into(holder.image)

        holder.phone.text = myDataset[position].phone
        holder.email.text = myDataset[position].email
        holder.info.setOnClickListener({view->
            val intent = Intent(view.getContext(),resto::class.java )
            intent.putExtra("resto", myDataset[position])
            view.getContext().startActivity(intent)
        })
        holder.itemView.setOnClickListener({view->
            val intent = Intent(view.getContext(),resto::class.java )
            //Passer l'objet restaurant à l'activité suivante pour pouvoir utiliser son id
            intent.putExtra("resto", myDataset[position])
            view.getContext().startActivity(intent)
        })

    }

    override fun getItemCount() = myDataset.size

}