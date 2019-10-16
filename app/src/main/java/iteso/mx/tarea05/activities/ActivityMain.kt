package iteso.mx.tarea05.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import iteso.mx.tarea05.R
import iteso.mx.tarea05.fragments.home.FragmentHome
import iteso.mx.tarea05.fragments.FragmentProfile
import iteso.mx.tarea05.fragments.FragmentRecipes
import org.jetbrains.anko.find

class ActivityMain : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    private val profileFragment: Fragment = FragmentProfile()
    private val homeFragment: Fragment = FragmentHome()
    private val recipeFragment: Fragment = FragmentRecipes()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigation = find<BottomNavigationView>(R.id.activity_main_bnv_navigation)
        navigation.selectedItemId = R.id.action_home
        navigation.setOnNavigationItemSelectedListener(this)

        changeFragment(homeFragment)

        /* TODO Add BottomNavigationView with three options
        1.- List of recipes
        Use FragmentRecipes
        2.- Actual recipe
        Create FragmentRecipe
        Use MVP Pattern
        FragmentRecipe (View)
        Recipe (Model)
        PresenterRecipe (Presenter)
        Use ViewAnimator
            FIRST_VIEW
            Button with Refresh text
            SECOND_VIEW
            MaterialCard
            THIRD_VIEW
            Image with text
        3.- Profile
        Create FragmentProfile
         */
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val newFragmentReference = when (item.itemId) {
            R.id.action_home -> {
                homeFragment
            }
            R.id.action_profile -> {
                profileFragment
            }
            R.id.action_recipes -> {
                recipeFragment
            }
            else -> homeFragment
        }
        changeFragment(newFragmentReference)
        return true
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.activity_main_fl_main_content, fragment)
            .commit()
    }
}
