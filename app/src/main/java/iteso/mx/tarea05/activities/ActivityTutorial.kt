package iteso.mx.tarea05.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import iteso.mx.tarea05.R
import iteso.mx.tarea05.fragments.FragmentTutorial1
import iteso.mx.tarea05.fragments.FragmentTutorial2
import iteso.mx.tarea05.fragments.FragmentTutorial3
import org.jetbrains.anko.startActivity

class ActivityTutorial : AppCompatActivity(), OnTutorialClickListener {
    private val fragment1 : Fragment = FragmentTutorial1()
    private val fragment2 : Fragment = FragmentTutorial2()
    private val fragment3 : Fragment = FragmentTutorial3()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial)

        /* TODO Create three fragments for the tutorial and place them in activity_tutorial_fl_content
        *   First Fragment has a background image and a next button
        *   Second Fragment has a background image a next and previous button
        *   Third Fragment has a background image a finish and a previous button
        *  */
        changeFragment(0)
    }

    override fun onNext(fragmentClicked: Int) {
        changeFragment(fragmentClicked + 1)
    }

    override fun onPrevious(fragmentClicked: Int) {
        changeFragment(fragmentClicked - 1)
    }

    override fun onFinish() {
        startActivity<ActivityMain>()
    }

    private fun changeFragment(newIndexFragment: Int) {
        val fragmentReference = when(newIndexFragment) {
            0 -> fragment1
            1 -> fragment2
            2 -> fragment3
            else -> fragment1
        }
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.activity_tutorial_fl_content, fragmentReference)
            .commit()
    }
}

interface OnTutorialClickListener {
    fun onNext(fragmentClicked: Int)
    fun onPrevious(fragmentClicked: Int)
    fun onFinish()
}
