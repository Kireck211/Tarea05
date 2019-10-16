package iteso.mx.tarea05.fragments.home

import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.util.*

class Presenter(private val view: HomeView) : HomePresenter {
    override fun fetchInfo() {
        doAsync {
            uiThread {
                view.showProgress()
            }
            Thread.sleep(10000)
            val randomInt = Random().nextInt(20)
            if (randomInt < 10) {
                uiThread {
                    view.showFavorite()
                }
            } else {
                uiThread {
                    view.showNoInfo()
                }
            }
        }
    }
}