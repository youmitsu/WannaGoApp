package youmeee.co.jp.wannagoapp.di.component

import dagger.Subcomponent
import dagger.android.AndroidInjector
import youmeee.co.jp.wannagoapp.di.module.ActivityModule
import youmeee.co.jp.wannagoapp.presentation.activity.MainActivity

/**
 * Created by yumitsuhori on 2018/05/13.
 */
@Subcomponent(modules = arrayOf(
        ActivityModule::class
))
interface MainActivitySubComponent : AndroidInjector<MainActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>() {
        abstract fun activityModule(activityModule: ActivityModule): Builder

        override fun seedInstance(instance: MainActivity) {
            activityModule(ActivityModule(instance))
        }
    }
}