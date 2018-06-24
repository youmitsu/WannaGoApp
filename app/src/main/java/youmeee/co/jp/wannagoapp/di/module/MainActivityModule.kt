package youmeee.co.jp.wannagoapp.di.module

import android.app.Activity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap
import youmeee.co.jp.wannagoapp.di.component.MainActivitySubComponent
import youmeee.co.jp.wannagoapp.presentation.activity.MainActivity

/**
 * Created by yumitsuhori on 2018/05/13.
 */
@Module(subcomponents = arrayOf(
        MainActivitySubComponent::class))
abstract class MainActivityModule {
    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
    abstract fun bindHogeActivityInjectorFactory(builder: MainActivitySubComponent.Builder): AndroidInjector.Factory<in Activity>
}