package iteso.mx.tarea05.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ViewAnimator
import androidx.fragment.app.Fragment
import iteso.mx.tarea05.R
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find

class FragmentHome : Fragment() , HomeView {
    private lateinit var mRefresh: Button
    private lateinit var mSwitcher: ViewAnimator
    private val mPresenter: HomePresenter by lazy {
        Presenter(this)
    }

    companion object {
        const val REFRESH_VIEW = 0
        const val PROGRESS_VIEW = 1
        const val NO_INFO_VIEW = 2
        const val INFO_VIEW = 3
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        mRefresh = view.find(R.id.fragment_home_btn_refresh)
        mSwitcher = view.find(R.id.fragment_home_va_switcher)

        showRefreshView()

        mRefresh.setOnClickListener {
            mPresenter.fetchInfo()
        }

        return view
    }

    override fun showRefreshView() {
        mSwitcher.displayedChild = REFRESH_VIEW
    }

    override fun showProgress() {
        mSwitcher.displayedChild = PROGRESS_VIEW
    }

    override fun showNoInfo() {
        mSwitcher.displayedChild = NO_INFO_VIEW
    }

    override fun showFavorite() {
        mSwitcher.displayedChild = INFO_VIEW
    }
}