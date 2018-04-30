package youmeee.co.jp.wannagoapp.di.component

import dagger.Component
import youmeee.co.jp.wannagoapp.di.module.AppModule
import youmeee.co.jp.wannagoapp.presentation.activity.MainActivity

/**
 * Created by yumitsuhori on 2018/04/30.
 */
@Component(modules = arrayOf(
        AppModule::class)
)
interface AppComponent {
    fun inject(activity: MainActivity)
}