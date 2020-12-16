package com.example.recyclerdi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_coche.view.*


//el adapter se encarga de coger la informacion
class cocheAdapter(var coches: ArrayList<Coche>):RecyclerView.Adapter<cocheAdapter.cocheHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cocheHolder {

        val layoutInflater = LayoutInflater.from(parent.context)

        return cocheHolder(layoutInflater.inflate(R.layout.item_coche, parent, false))

    }

    override fun onBindViewHolder(holder: cocheHolder, position: Int) {
        holder.render(coches[position])

    }

    override fun getItemCount(): Int {
        return coches.size
    }


    class cocheHolder(val view: View):RecyclerView.ViewHolder(view){

        fun render(coche: Coche){

            view.tvModelo.text = coche.modelo
            view.tvMarca.text = coche.marca
            view.tvPrecio.text = ""+coche.precio
            view.tvCV.text = ""+coche.cv
            //Picasso.get().load(coche.imagen).placeholder(R.drawable.ic_launcher_background).into(view.image)


        }

    }
}