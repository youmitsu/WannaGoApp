package youmeee.co.jp.wannagoapp.di.module

import android.app.Activity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap
import youmeee.co.jp.wannagoapp.di.component.MainActivitySubcomponent
import youmeee.co.jp.wannagoapp.presentation.activity.MainActivity

/**
 * Created by yumitsuhori on 2018/05/14.
 */
@Module(subcomponents = arrayOf(
        MainActivitySubcomponent::class))
abstract class MainActivityModule {
    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
    abstract fun bindMainActivityInjectorFactory(builder: MainActivitySubcomponent.Builder): AndroidInjector.Factory<out Activity>
}