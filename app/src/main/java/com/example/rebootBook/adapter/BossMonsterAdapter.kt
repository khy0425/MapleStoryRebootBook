package com.example.rebootBook.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rebootBook.dataClass.BossMonster
import com.example.rebootBook.databinding.BossMonsterItemBinding
import java.util.*

class BossMonsterAdapter(
    private val bossMonsters: List<BossMonster>,
    private val listener: (BossMonster) -> Unit
) : RecyclerView.Adapter<BossMonsterAdapter.ViewHolder>(), Filterable {

    private var filteredBossList = bossMonsters.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = BossMonsterItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(filteredBossList[position])
    }

    override fun getItemCount() = filteredBossList.size

    fun filter(query: String) {
        filter.filter(query)
    }

    fun filterByBossType(bossType: BossMonster.BossType) {
        filteredBossList = bossMonsters.filter { it.bossType == bossType }.toMutableList()
        notifyDataSetChanged()
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val queryString = constraint?.toString()?.toLowerCase(Locale.ROOT)
                val filterResults = FilterResults()

                filterResults.values = if (queryString == null || queryString.isEmpty()) {
                    bossMonsters
                } else {
                    bossMonsters.filter { bossMonster ->
                        bossMonster.name.toLowerCase(Locale.ROOT).contains(queryString) ||
                                bossMonster.diff.toLowerCase(Locale.ROOT).contains(queryString) ||
                                bossMonster.dropItems.any { dropItem ->
                                    dropItem.name.toLowerCase(Locale.ROOT).contains(queryString)
                                }
                    }
                }
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredBossList = results?.values as MutableList<BossMonster>
                notifyDataSetChanged()
            }
        }
    }

    inner class ViewHolder(private val binding: BossMonsterItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                if (binding.dripItemsLinearLayout.visibility == View.GONE) {
                    binding.dripItemsLinearLayout.visibility = View.VISIBLE
                    binding.bossDesc.visibility = View.VISIBLE
                } else {
                    binding.dripItemsLinearLayout.visibility = View.GONE
                    binding.bossDesc.visibility = View.GONE
                }
            }
        }

        fun bind(bossMonster: BossMonster) {
            binding.ivBossImage.setImageResource(bossMonster.imageResId)
            binding.tvBossName.text = bossMonster.name
            binding.tvBossDifficulty.text = bossMonster.diff
            binding.tvBossPrice.text = bossMonster.price
            binding.bossDesc.text = bossMonster.bossDesc

            if (bossMonster.dropItems.isNotEmpty()) {
                binding.dropItemsRecyclerView.layoutManager = GridLayoutManager(itemView.context, 2)
                binding.dropItemsRecyclerView.adapter = DropItemAdapter(bossMonster.dropItems)

            } else {
                binding.dripItemsLinearLayout.visibility = View.GONE
                binding.bossDesc.visibility = View.GONE
            }
        }
    }
}
