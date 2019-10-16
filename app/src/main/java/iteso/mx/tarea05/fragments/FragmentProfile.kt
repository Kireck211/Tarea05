package iteso.mx.tarea05.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import iteso.mx.tarea05.R
import iteso.mx.tarea05.activities.ActivityStart
import org.jetbrains.anko.find
import org.jetbrains.anko.support.v4.startActivity

class FragmentProfile : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        view.find<TextView>(R.id.fragment_profile_tv_logout).setOnClickListener {
            startActivity<ActivityStart>()
        }
        return view
    }
}