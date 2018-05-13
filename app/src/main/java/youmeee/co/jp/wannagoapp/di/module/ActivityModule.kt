package youmeee.co.jp.wannagoapp.di.module

import android.app.Activity
import dagger.Module
import dagger.Provides
import youmeee.co.jp.wannagoapp.di.scope.PerActivity
import youmeee.co.jp.wannagoapp.presentation.activity.MainActivity

/**
 * Created by yumitsuhori on 2018/05/13.
 */
@Module
class ActivityModule(private val activity: MainActivity) {
    @Provides
    @PerActivity
    fun activity(): Activity = this.activity
}