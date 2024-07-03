package com.example.carrace

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.carrace.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private var controller: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        makeCurrentFragment(HomeFragment())

        val navView: BottomNavigationView = findViewById(R.id.bottomNavigation)
        navView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.bottom_home -> {
                    makeCurrentFragment(HomeFragment())
                    true
                }

                R.id.bottom_mms -> {
                    makeCurrentFragment(MMSFragment())
                    true
                }

                R.id.bottom_sport -> {
                    makeCurrentFragment(SportFragment())
                    true
                }

                R.id.bottom_self_imp -> {
                    makeCurrentFragment(SelfImpFragment())
                    true
                }

                R.id.bottom_emotion -> {
                    makeCurrentFragment(MoodFragment())
                    true
                }

                else -> false
            }
        }
    }
//
//        binding = ActivityMainBinding.inflate(layoutInflater).also {
//            setContentView(it.root)
//        }
//        controller = (supportFragmentManager.findFragmentById(R.id.fragmentView) as NavHostFragment)
//            .navController
//        controller?.let { navController ->
//            binding?.bottomNavigation?.setupWithNavController(navController)
//        }
//    }
//
//    override fun onBackPressed() {
//        super.onBackPressed()
//
//        controller?.navigateUp()
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        binding = null
//    }
//

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, fragment)
            commit()
        }
}