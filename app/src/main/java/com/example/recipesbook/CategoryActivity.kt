package com.example.recipesbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import androidx.appcompat.widget.Toolbar
import com.example.recipesbook.databinding.ActivityCategoryBinding
import com.example.recipesbook.databinding.ActivityRecipesBinding

class CategoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCategoryBinding
    private lateinit var arrowBackToolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        arrowBackToolbar = binding.toolbar
        setSupportActionBar(arrowBackToolbar)

        backToMainActivity() // обрабатывает нажатие для возврата в главное меню
    }

    private fun backToMainActivity(){
        arrowBackToolbar.setNavigationOnClickListener{
            finish()
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Раздуваем меню из ресурса
        menuInflater.inflate(R.menu.action_save, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_save -> {
                val name = findViewById<EditText>(R.id.name_of_the_dish).text.toString()
                val imageResId = R.drawable.error_image// Замените на ваш ресурс изображения

                val intent = Intent(this, MainActivity::class.java).apply {
                    putExtra("name", name)
                    putExtra("imageResId", imageResId)
                }
                startActivity(intent)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}