package youmeee.co.jp.wannagoapp.di.module

import android.content.Context
import android.support.v7.app.AppCompatActivity
import dagger.Module
import dagger.Provides
import youmeee.co.jp.wannagoapp.di.scope.PerActivity

/**
 * Created by yumitsuhori on 2018/05/14.
 */
@Module
class ActivityModule(val activity: AppCompatActivity) {

    @Provides
    @PerActivity
    fun provideContext(): Context = activity
}