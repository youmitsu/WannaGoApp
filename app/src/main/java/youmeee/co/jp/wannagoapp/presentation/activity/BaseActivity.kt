package youmeee.co.jp.wannagoapp.presentation.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import youmeee.co.jp.wannagoapp.WannaGoApp

/**
 * Created by yumitsuhori on 2018/05/13.
 */
open class BaseActivity() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun getApplicationComponent() = (application as WannaGoApp).getApplicationComponent()

}