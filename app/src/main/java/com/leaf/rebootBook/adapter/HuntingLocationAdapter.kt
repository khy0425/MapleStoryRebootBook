package com.leaf.rebootBook.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.leaf.rebootBook.R
import com.leaf.rebootBook.dataClass.HuntingLocation

class HuntingLocationAdapter : RecyclerView.Adapter<HuntingLocationAdapter.HuntingLocationViewHolder>() {
    private var huntingLocations: List<HuntingLocation> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HuntingLocationViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.hunting_item, parent, false)
        return HuntingLocationViewHolder(view)
    }

    override fun onBindViewHolder(holder: HuntingLocationViewHolder, position: Int) {
        holder.bind(huntingLocations[position])
    }

    override fun getItemCount() = huntingLocations.size

    fun submitList(newHuntingLocations: List<HuntingLocation>) {
        huntingLocations = newHuntingLocations
        notifyDataSetChanged()
    }

    inner class HuntingLocationViewHolder(private val view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        private val huntingLocationName: TextView = view.findViewById(R.id.hunting_location_name)
        private val huntingLocationDescription: TextView = view.findViewById(R.id.hunting_location_description)

        init {
            view.setOnClickListener(this)
        }

        fun bind(huntingLocation: HuntingLocation) {
            huntingLocationName.text = huntingLocation.name
            huntingLocationDescription.text = huntingLocation.description

            itemView.setOnClickListener {
                huntingLocationDescription.isVisible = !huntingLocationDescription.isVisible

                itemView.setBackgroundColor(
                    if(huntingLocationDescription.isVisible)
                        ContextCompat.getColor(itemView.context, R.color.light_gray)
                    else
                        Color.TRANSPARENT
                )
            }

            huntingLocationName.text = huntingLocation.name
            huntingLocationDescription.text = huntingLocation.description
        }

        override fun onClick(v: View) {
            if (huntingLocationDescription.visibility == View.GONE) {
                huntingLocationDescription.visibility = View.VISIBLE
            } else {
                huntingLocationDescription.visibility = View.GONE
            }
        }
    }
}
