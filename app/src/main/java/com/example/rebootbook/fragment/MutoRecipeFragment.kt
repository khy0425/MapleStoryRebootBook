package com.example.rebootBook.fragment

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.example.rebootBook.R
import com.example.rebootBook.adapter.RecipeAdapter
import com.example.rebootBook.databinding.FragmentMutoRecipeBinding
import com.example.rebootBook.viewModel.RecipeViewModel

class MutoRecipeFragment : Fragment() {

    private lateinit var binding: FragmentMutoRecipeBinding
    private lateinit var viewModel: RecipeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMutoRecipeBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this)[RecipeViewModel::class.java]

        val adapter = RecipeAdapter(viewModel.recipes.toMutableList())
        binding.recipeRecyclerView.layoutManager = LinearLayoutManager(context)

        // 각 요리 레시피를 구별할 수 있도록 짧은 회색 선을 추가
        val dividerItemDecoration = DividerItemDecoration(
            binding.recipeRecyclerView.context,
            (binding.recipeRecyclerView.layoutManager as LinearLayoutManager).orientation
        )
        dividerItemDecoration.setDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.divider
            )!!
        )
        binding.recipeRecyclerView.addItemDecoration(dividerItemDecoration)

        binding.recipeRecyclerView.adapter = adapter

        // 아이콘 대신 전체 SearchView를 클릭하면 활성화되고 키보드를 띄우도록 설정
        binding.recipeSearchView.setOnClickListener {
            it.isFocusable = true
            it.requestFocusFromTouch()
            val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(it, InputMethodManager.SHOW_IMPLICIT)
            binding.recipeSearchView.isIconified = false
        }

        // 한 글자마다 데이터 검색
        binding.recipeSearchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.setRecipes(viewModel.searchRecipe(newText ?: ""))
                return true
            }
        })

        return binding.root
    }
}
