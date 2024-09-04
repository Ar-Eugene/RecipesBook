package com.example.recipesbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipesbook.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView
    private val categoryItems = mutableListOf<CategoryItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar=binding.toolbar
        setSupportActionBar(toolbar)

        val navigationView: NavigationView = findViewById(R.id.naw_view)
        // Получаем headerView из NavigationView
        val headerView: View = navigationView.getHeaderView(0)
        // Находим ImageView в headerView
        val imageView: ImageView = headerView.findViewById(R.id.image_year)

        // Получаем текущий месяц
        val calendar = Calendar.getInstance()
        val month = calendar.get(Calendar.MONTH)
        // Выбираем изображение в зависимости от месяца
        val imageResource = when (month) {
            Calendar.DECEMBER,Calendar.JANUARY,Calendar.FEBRUARY, -> R.drawable.tangerines
            Calendar.MARCH,Calendar.APRIL,Calendar.MAY -> R.drawable.error_image
            Calendar.JUNE,Calendar.JULY,Calendar.AUGUST -> R.drawable.error_image
            Calendar.SEPTEMBER,Calendar.OCTOBER,Calendar.NOVEMBER -> R.drawable.autumn_apples

            else -> R.drawable.error_image
        }

        // Устанавливаем изображение в ImageView
        imageView.setImageDrawable(ContextCompat.getDrawable(this, imageResource))

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val bottomNavigationView = binding.bottomNavigation
        val drawer=binding.drawerLayout
        val builder=AppBarConfiguration.Builder(navController.graph)
        builder.setOpenableLayout(drawer)
        //recyclerView = findViewById(R.id.recycler_view)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.adapter = CategoryAdapter(categoryItems)

        bottomNavigationView.setupWithNavController(navController)
    }
    fun onCreatedOptionsMenu(menu: Menu):Boolean{
        menuInflater.inflate(R.menu.action_save,menu)
        return super.onCreateOptionsMenu(menu)
    }
    private fun imageCalendar(){

    }
}