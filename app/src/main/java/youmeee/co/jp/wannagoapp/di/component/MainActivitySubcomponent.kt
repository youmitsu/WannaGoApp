package youmeee.co.jp.wannagoapp.di.component

import dagger.Subcomponent
import dagger.android.AndroidInjector
import youmeee.co.jp.wannagoapp.di.module.ActivityModule
import youmeee.co.jp.wannagoapp.di.module.MainActivityModule
import youmeee.co.jp.wannagoapp.presentation.activity.MainActivity

/**
 * Created by yumitsuhori on 2018/05/14.
 */
@Subcomponent(modules = arrayOf(
        ActivityModule::class,
        MainActivityModule::class
))
interface MainActivitySubcomponent : AndroidInjector<MainActivity> {
    abstract class Builder : AndroidInjector.Builder<MainActivity>() {
        abstract fun activityModule(module: ActivityModule)

        override fun seedInstance(instance: MainActivity) {
            activityModule(ActivityModule(instance))
        }
    }
}