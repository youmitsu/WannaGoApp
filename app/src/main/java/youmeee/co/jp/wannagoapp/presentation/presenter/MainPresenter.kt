package youmeee.co.jp.wannagoapp.presentation.presenter

import youmeee.co.jp.wannagoapp.presentation.view.MainView

/**
 * Created by yumitsuhori on 2018/04/11.
 */
class MainPresenter() {
    private lateinit var view: MainView

    fun setView(view: MainView) {
        this.view = view
    }
}