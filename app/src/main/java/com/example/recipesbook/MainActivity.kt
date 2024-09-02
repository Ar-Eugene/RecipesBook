package com.example.recipesbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipesbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView
    private val categoryItems = mutableListOf<CategoryItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CategoryAdapter(categoryItems)
        val bottomNavigationView = binding.bottomNavigation
        // Проверяем наличие данных из CategoryActivity
        val imageResId = intent.getIntExtra("imageResId", R.drawable.error_image) // Замените default_image на ваш ресурс по умолчанию
        val name = intent.getStringExtra("name") ?: ""

        if (imageResId != R.drawable.error_image && name.isNotEmpty()) {
            categoryItems.add(CategoryItem(imageResId, name))
            recyclerView.adapter?.notifyDataSetChanged()
        }

        bottomNavigationView.setOnItemSelectedListener{item ->
            when(item.itemId){
                R.id.add_dish->{
                    startActivity(Intent(this,RecipesActivity::class.java))
                    true
                }
                R.id.add_category->{
                    startActivity(Intent(this,CategoryActivity::class.java))
                    true
                }
                else->false
            }
        }
    }
}