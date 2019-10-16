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

class FragmentTutorial3 : Fragment(), AnkoLogger {
    private lateinit var listener: OnTutorialClickListener
    private lateinit var mPrevious: Button
    private lateinit var mFinish: Button

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
        val view = inflater.inflate(R.layout.fragment_tutorial_3, container, false)
        mPrevious = view.find(R.id.fragment_tutorial_3_btn_previous)
        mFinish = view.find(R.id.fragment_tutorial_3_btn_finish)
        mPrevious.setOnClickListener { listener.onPrevious(2) }
        mFinish.setOnClickListener { listener.onFinish() }
        return view
    }
}