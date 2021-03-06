package com.example.carlease

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList
import kotlin.time.ExperimentalTime

@ExperimentalTime
class CarRecyclerViewAdapter(
    val clickListener: (Car) -> Unit,
    val carlist: ArrayList<Car>
) :
    RecyclerView.Adapter<CarRecyclerViewAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.car_row, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return carlist.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val car: Car = carlist[position]
        holder.rating.setText(car.rating)
        holder.carColor.setText(car.carColor)
        holder.chargePerDay.setText("From $" + car.chargePerDay.toString() + "/day")
        holder.carImage.setImageResource(car.carImage)
        holder.deals.setText(car.deals.size.toString() + " Deals")

        holder.nextScreen.setOnClickListener {
            clickListener(car)
        }


    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rating: TextView = itemView.findViewById(R.id.ratingText)
        val carColor: TextView = itemView.findViewById(R.id.carColor)
        val chargePerDay: TextView = itemView.findViewById(R.id.chargePerDay)
        val carImage: ImageView = itemView.findViewById(R.id.carImage)
        val deals: TextView = itemView.findViewById(R.id.numberOfDeals)

        val nextScreen: ImageView = itemView.findViewById(R.id.nextIcon)
    }


}