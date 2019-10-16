package iteso.mx.tarea05.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import iteso.mx.tarea05.R
import org.jetbrains.anko.*

class ActivityLogin : AppCompatActivity() {
    /* TODO Declare EditText and Button variables */
    private lateinit var mLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mLogin = find(R.id.activity_login_btn_login)
        mLogin.setOnClickListener { startActivity(intentFor<ActivityTutorial>().newTask().clearTask()) }

    }
}
