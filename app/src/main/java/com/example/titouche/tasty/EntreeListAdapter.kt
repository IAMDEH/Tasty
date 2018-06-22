package com.example.titouche.tasty

import android.content.Context
import android.content.DialogInterface
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import org.jetbrains.anko.toast


class EntreeListAdapter(private var myDataset: ArrayList<Entree>, var mCtx: Context): RecyclerView.Adapter<EntreeListAdapter.ViewHolder>(){
    class ViewHolder (holder : View): RecyclerView.ViewHolder(holder){
        val nom = holder.findViewById<TextView>(R.id.nome)
        var image = holder.findViewById<ImageView>(R.id.image)
        var description = holder.findViewById<TextView>(R.id.description)
        val order = holder.findViewById<ImageButton>(R.id.order)
        val dialog = android.support.v7.app.AlertDialog.Builder(holder.getContext())
        val dialogView = LayoutInflater.from(holder.getContext()).inflate(R.layout.order_entree_dialog, null,false)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.entree_list_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nom.text = myDataset[position].nom
        holder.image.setImageResource(myDataset[position].image)
        holder.description.text = myDataset[position].description


        holder.order.setOnClickListener({view->


            holder.dialog.setView(holder.dialogView)
//           holder.dialog.setCancelable(true)
            holder.dialog.setPositiveButton("Commander",{ dialogInterface: DialogInterface, i: Int -> })
            holder.dialog.setNegativeButton("Annuler",{ dialogInterface: DialogInterface, i: Int -> })

            val customDialog = holder.dialog.create()
            customDialog.setCanceledOnTouchOutside(true)
            customDialog.show()
            customDialog.getButton(android.support.v7.app.AlertDialog.BUTTON_POSITIVE).setOnClickListener({
                view.getContext().toast("Commandé")
                customDialog.dismiss()
            })
            customDialog.getButton(android.support.v7.app.AlertDialog.BUTTON_NEGATIVE).setOnClickListener({
                view.getContext().toast("Annulé")
                customDialog.dismiss()
            })
        })
//        holder.itemView.setOnClickListener({view->
//            val intent = Intent(view.getContext(),Commande::class.java )
//            view.getContext().startActivity(intent)
//        })

    }

    override fun getItemCount() = myDataset.size




}