package com.leaf.rebootBook.activity


import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.leaf.rebootBook.adapter.DropItemRecipeAdapter
import com.leaf.rebootBook.adapter.DropItemRecipeRepository
import com.leaf.rebootBook.dataClass.ItemType
import com.leaf.rebootBook.dataClass.Job
import com.leaf.rebootBook.dataClass.Stat
import com.leaf.rebootBook.databinding.ActivityDropRecipeBinding

class ItemRecipeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDropRecipeBinding
    private val recipeAdapter = DropItemRecipeAdapter()

    private var activeJob: Job? = null
    private var activeStat: Stat? = null
    private var activeType: ItemType? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDropRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews(binding)

        binding.recyclerViewItems.adapter = recipeAdapter
        binding.recyclerViewItems.layoutManager = LinearLayoutManager(this)

        //1. 첫 화면에 모든 레시피가 보이도록 설정
        recipeAdapter.submitList(DropItemRecipeRepository.getRecipes())

        binding.searchView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterRecipes(newText)
                return true
            }
        })

        setupJobItemButtons()
        setupItemTypeButtons()
        setupStatTypeButtons()
        binding.btnReset.setOnClickListener {
            resetFilters()
        }
    }
    private fun setActiveJobButton(selectedButton: Button){
        binding.btnWarrior.isSelected = false
        binding.btnArcher.isSelected = false
        binding.btnMage.isSelected = false
        binding.btnRogue.isSelected = false
        binding.btnPirate.isSelected = false

        selectedButton.isSelected = true
    }

    private fun setActiveStatButton(selectedButton: Button){
        binding.btnSTR.isSelected = false
        binding.btnDEX.isSelected = false
        binding.btnINT.isSelected = false
        binding.btnLUK.isSelected = false

        selectedButton.isSelected = true
    }

    private fun setActiveTypeButton(selectedButton: Button){
        binding.btnAccessory.isSelected = false
        binding.btnPotion.isSelected = false
        binding.btnDart.isSelected = false

        selectedButton.isSelected = true
    }

    private fun setupJobItemButtons() {
        binding.btnWarrior.setOnClickListener {
            setActiveJobButton(it as Button)
            activeJob = Job.WARRIOR
            filterRecipes()
        }
        binding.btnArcher.setOnClickListener {
            setActiveJobButton(it as Button)
            activeJob = Job.ARCHER
            filterRecipes()
        }
        binding.btnMage.setOnClickListener {
            setActiveJobButton(it as Button)
            activeJob = Job.MAGICIAN
            filterRecipes()
        }
        binding.btnRogue.setOnClickListener {
            setActiveJobButton(it as Button)
            activeJob = Job.THIEF
            filterRecipes()
        }
        binding.btnPirate.setOnClickListener {
            setActiveJobButton(it as Button)
            activeJob = Job.PIRATE
            filterRecipes()
        }
    }

    private fun setupStatTypeButtons() {
        binding.btnSTR.setOnClickListener {
            setActiveStatButton(it as Button)
            activeStat = Stat.STR
            filterRecipes()
        }
        binding.btnDEX.setOnClickListener {
            setActiveStatButton(it as Button)
            activeStat = Stat.DEX
            filterRecipes()
        }
        binding.btnINT.setOnClickListener {
            setActiveStatButton(it as Button)
            activeStat = Stat.INT
            filterRecipes()
        }
        binding.btnLUK.setOnClickListener {
            setActiveStatButton(it as Button)
            activeStat = Stat.LUK
            filterRecipes()
        }
    }

    private fun setupItemTypeButtons(){
        binding.btnPotion.setOnClickListener {
            setActiveTypeButton(it as Button)
            activeType = ItemType.POTION
            filterRecipes()
        }
        binding.btnAccessory.setOnClickListener {
            setActiveTypeButton(it as Button)
            activeType = ItemType.ACCESSORY
            filterRecipes()
        }
        binding.btnDart.setOnClickListener {
            setActiveTypeButton(it as Button)
            activeType = ItemType.ThrowingStar
            filterRecipes()
        }
    }

    private fun resetFilters() {
        activeJob = null
        activeStat = null
        activeType = null

        // 모든 Job 버튼을 비활성화
        binding.btnWarrior.isSelected = false
        binding.btnArcher.isSelected = false
        binding.btnMage.isSelected = false
        binding.btnRogue.isSelected = false
        binding.btnPirate.isSelected = false

        // 모든 Stat 버튼을 비활성화
        binding.btnSTR.isSelected = false
        binding.btnDEX.isSelected = false
        binding.btnINT.isSelected = false
        binding.btnLUK.isSelected = false

        // 모든 ItemType 버튼을 비활성화
        binding.btnPotion.isSelected = false
        binding.btnAccessory.isSelected = false
        binding.btnDart.isSelected = false

        // 모든 레시피 다시 표시
        recipeAdapter.submitList(DropItemRecipeRepository.getRecipes())
    }

    private fun filterRecipes(query: String? = null) {
        val filteredRecipes = DropItemRecipeRepository.getRecipes().filter { recipe ->
            (query == null || recipe.name.contains(query, ignoreCase = true)) &&
                    (activeStat == null || recipe.category.stats.contains(activeStat)) &&
                    (activeJob == null || recipe.category.jobs.contains(activeJob)) &&
                    (activeType == null || recipe.category.type == activeType)
        }
        recipeAdapter.submitList(filteredRecipes)
    }



    private fun initViews(binding: ActivityDropRecipeBinding) {
        setSupportActionBar(binding.toolbarWithBackButton.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        binding.toolbarWithBackButton.toolbar.setNavigationOnClickListener{
            onBackPressed()
        }
    }
}