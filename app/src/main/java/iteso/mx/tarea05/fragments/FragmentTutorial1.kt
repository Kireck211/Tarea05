package iteso.mx.tarea05.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import iteso.mx.tarea05.R
import iteso.mx.tarea05.activities.ActivityTutorial
import iteso.mx.tarea05.activities.OnTutorialClickListener
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.error
import org.jetbrains.anko.find
import java.lang.ClassCastException

class FragmentTutorial1 : Fragment(), AnkoLogger {
    private lateinit var listener: OnTutorialClickListener
    private lateinit var mNext: Button

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as ActivityTutorial
        } catch (e : ClassCastException) {
            error { e }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tutorial_1, container, false)
        mNext = view.find(R.id.fragment_tutorial_1_btn_next)
        mNext.setOnClickListener { listener.onNext(0) }
        return view
    }
}