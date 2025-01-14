package com.example.planeto

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(var planet: List<PlanetData>): RecyclerView.Adapter<Adapter.myViewHolder>(){
    class myViewHolder(view:View): RecyclerView.ViewHolder(view){
        var title = view.findViewById<TextView>(R.id.title)
        var planetImg = view.findViewById<ImageView>(R.id.planet_img)
        var galaxy = view.findViewById<TextView>(R.id.galaxy)
        var distance = view.findViewById<TextView>(R.id.distance)
        var gravity = view.findViewById<TextView>(R.id.gravity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        var itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.view,parent,false)
        return myViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return planet.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        var dummyImage:Int? = null
        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context,PlanetDetail::class.java)
            intent.putExtra("planet",planet[position])
            intent.putExtra("planetImage",dummyImage)
            holder.itemView.context.startActivity(intent)
        }
        holder.title.text = planet[position].title
        holder.galaxy.text = planet[position].galaxy
        holder.distance.text = planet[position].distance + "m km"
        holder.gravity.text = planet[position].gravity+ "m/ss"

        when(planet[position].title!!.toLowerCase())
        {
            "mars"->{
                dummyImage = R.drawable.mars
            }
            "neptune"->{
                dummyImage = R.drawable.neptune
            }
            "jupiter"->{
                dummyImage = R.drawable.jupiter
            }
            "moon"->{
                dummyImage = R.drawable.moon
            }
            "sun"->{
                dummyImage = R.drawable.sun
            }
            "uranus"->{
                dummyImage = R.drawable.uranus
            }
            "mercury"->{
                dummyImage = R.drawable.mercury
            }
            "saturn"->{
                dummyImage = R.drawable.saturn
            }
            "earth" -> {
                dummyImage = R.drawable.earth
            }
            "venus"->{
                dummyImage = R.drawable.venus
            }

        }
        holder.planetImg.setImageResource(dummyImage!!)
    }
}

