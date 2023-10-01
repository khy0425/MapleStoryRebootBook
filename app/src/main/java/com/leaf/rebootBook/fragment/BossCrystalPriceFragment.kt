package com.leaf.rebootBook.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.leaf.rebootBook.adapter.BossMonsterAdapter
import com.leaf.rebootBook.dataClass.BossMonster
import com.leaf.rebootBook.databinding.FragmentBossCrystalPriceBinding
import com.leaf.rebootBook.interfaces.BossCrystalPriceFilter

class BossCrystalPriceFragment : Fragment(), BossCrystalPriceFilter {

    private var _binding: FragmentBossCrystalPriceBinding? = null
    private val binding get() = _binding!!

    private var selectedItem: BossMonster? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBossCrystalPriceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvBossList.layoutManager = LinearLayoutManager(context)
        val dividerItemDecoration = DividerItemDecoration(context, LinearLayoutManager.VERTICAL)
        binding.rvBossList.addItemDecoration(dividerItemDecoration)

        val bossType = arguments?.getSerializable(ARG_BOSS_TYPE) as? BossMonster.BossType ?: BossMonster.BossType.DAILY
        setupRecyclerView(bossType)
    }

    private fun setupRecyclerView(bossType: BossMonster.BossType) {
        val bossMonsters = arguments?.getParcelableArrayList<BossMonster>(ARG_BOSS_MONSTERS) ?: emptyList()

        val bossMonsterAdapter = BossMonsterAdapter(bossMonsters) { bossMonster ->
            if (selectedItem == bossMonster) {
                selectedItem = null
                binding.dropItemDesc.text = ""
                binding.dropItemDesc.visibility = View.GONE
            } else {
                updateDropItemDesc(bossMonster)
                selectedItem = bossMonster
            }
            binding.dropItemDesc.visibility = if (selectedItem == null) View.GONE else View.VISIBLE
        }
        binding.rvBossList.adapter = bossMonsterAdapter
        bossMonsterAdapter.filterByBossType(bossType)
    }


    private fun updateDropItemDesc(bossMonster: BossMonster) {
        val bossInfo = """
            Name: ${bossMonster.name}
            Difficulty: ${bossMonster.diff}
            Price: ${bossMonster.price}
            Boss Type: ${bossMonster.bossType}
            Drop Items: ${bossMonster.dropItems.joinToString()}
            Description: ${bossMonster.bossDesc}
        """.trimIndent()
        binding.dropItemDesc.text = bossInfo
        binding.dropItemDesc.visibility = View.VISIBLE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun applyFilter(query: String) {
        (_binding?.rvBossList?.adapter as? BossMonsterAdapter)?.filter(query)
    }

    companion object {
        private const val ARG_BOSS_MONSTERS = "boss_monsters"
        private const val ARG_BOSS_TYPE = "boss_type"

        fun newInstance(bossMonsters: List<BossMonster>, bossType: BossMonster.BossType): BossCrystalPriceFragment {
            val fragment = BossCrystalPriceFragment()
            val args = Bundle()
            args.putParcelableArrayList(ARG_BOSS_MONSTERS, ArrayList(bossMonsters))
            args.putSerializable(ARG_BOSS_TYPE, bossType)
            fragment.arguments = args
            return fragment
        }
    }
}
