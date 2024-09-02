package com.example.recipesbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import com.example.recipesbook.databinding.ActivityRecipesBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class RecipesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecipesBinding
    private lateinit var arrowBackToolbar:Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipesBinding.inflate(layoutInflater)
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
                // Обработка клика по элементу меню "Сохранить"
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}