package iteso.mx.tarea05.fragments.home

interface HomeView {
    fun showRefreshView()
    fun showProgress()
    fun showNoInfo()
    fun showFavorite()
}

interface HomePresenter {
    fun fetchInfo()
}