package com.leaf.rebootBook

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.leaf.rebootBook.adapter.WeaponAdapter
import com.leaf.rebootBook.adapter.WeaponRepository
import com.leaf.rebootBook.dataClass.Brand
import com.leaf.rebootBook.dataClass.Category
import com.leaf.rebootBook.databinding.ActivityWeaponOptionBinding

class WeaponOptionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWeaponOptionBinding
    private val weaponAdapter = WeaponAdapter(emptyList())

    private var activeBrand: Brand? = null
    private var activeCategory: Category? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWeaponOptionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews(binding)

        binding.weaponOptionRecyclerView.adapter = weaponAdapter
        binding.weaponOptionRecyclerView.layoutManager = LinearLayoutManager(this)


        // 1. 첫 화면에 모든 무기 옵션을 보이도록 설정
        weaponAdapter.submitList(WeaponRepository.getWeapons())

        binding.searchEditText.addTextChangedListener { text ->
            val query = text.toString()

            val filteredWeapons = WeaponRepository.getWeapons().filter { weapon ->
                weapon.name.contains(query, ignoreCase = true) ||
                        weapon.type.getDisPlay().contains(query, ignoreCase = true)
            }

            weaponAdapter.submitList(filteredWeapons)
        }

        setupWeaponBrandButtons()
        setupJobTypeButtons()
    }

    private fun setActiveBrandButton(selectedButton: Button) {
        binding.papButton.isSelected = false
        binding.absolButton.isSelected = false
        binding.arcaneButton.isSelected = false
        binding.genesisButton.isSelected = false

        selectedButton.isSelected = true
    }

    private fun setActiveCategoryButton(selectedButton: Button) {
        binding.warriorButton.isSelected = false
        binding.magicianButton.isSelected = false
        binding.archerButton.isSelected = false
        binding.thiefButton.isSelected = false
        binding.pirateButton.isSelected = false

        selectedButton.isSelected = true
    }


    private fun setupWeaponBrandButtons() {
        binding.papButton.setOnClickListener {
            setActiveBrandButton(it as Button)
            activeBrand = Brand.PAPRIFIR
            filterWeapons()
        }
        binding.absolButton.setOnClickListener {
            setActiveBrandButton(it as Button)
            activeBrand = Brand.EBSOLABS
            filterWeapons()
        }
        binding.arcaneButton.setOnClickListener {
            setActiveBrandButton(it as Button)
            activeBrand = Brand.ARCANESHADE
            filterWeapons()
        }
        binding.genesisButton.setOnClickListener {
            setActiveBrandButton(it as Button)
            activeBrand = Brand.GENESIS
            filterWeapons()
        }
    }

    private fun setupJobTypeButtons() {
        binding.warriorButton.setOnClickListener {
            setActiveCategoryButton(it as Button)
            activeCategory = Category.WARRIOR
            filterWeapons()
        }
        binding.magicianButton.setOnClickListener {
            setActiveCategoryButton(it as Button)
            activeCategory = Category.MAGICIAN
            filterWeapons()
        }
        binding.archerButton.setOnClickListener {
            setActiveCategoryButton(it as Button)
            activeCategory = Category.ARCHER
            filterWeapons()
        }
        binding.thiefButton.setOnClickListener {
            setActiveCategoryButton(it as Button)
            activeCategory = Category.THIEF
            filterWeapons()
        }
        binding.pirateButton.setOnClickListener {
            setActiveCategoryButton(it as Button)
            activeCategory = Category.PIRATE
            filterWeapons()
        }
    }

    private fun filterWeapons() {
        val filteredWeapons = WeaponRepository.getWeapons().filter { weapon ->
            (activeBrand == null || weapon.brand == activeBrand) &&
                    (activeCategory == null || weapon.category == activeCategory)
        }
        weaponAdapter.submitList(filteredWeapons)
    }

    private fun initViews(binding: ActivityWeaponOptionBinding) {
        // Set up toolbar with back button
        setSupportActionBar(binding.toolbarWithBackButton.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        binding.toolbarWithBackButton.toolbar.setNavigationOnClickListener {
            // Navigate back to MainActivity
            onBackPressed()
        }
    }
}