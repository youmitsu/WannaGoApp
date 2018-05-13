package youmeee.co.jp.wannagoapp.di.component

import android.app.Application
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import youmeee.co.jp.wannagoapp.di.module.AppModule

/**
 * Created by yumitsuhori on 2018/04/30.
 */
@Component(modules = arrayOf(
        AndroidSupportInjectionModule::class,
        AppModule::class)
)
interface AppComponent {
    fun inject(app: Application)
}