package youmeee.co.jp.wannagoapp.di.component

import android.app.Activity
import dagger.Component
import youmeee.co.jp.wannagoapp.di.module.ActivityModule
import youmeee.co.jp.wannagoapp.di.scope.PerActivity

/**
 * Created by yumitsuhori on 2018/05/13.
 */
@PerActivity
@Component(
        dependencies = arrayOf(AppComponent::class),
        modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun activity(): Activity
}