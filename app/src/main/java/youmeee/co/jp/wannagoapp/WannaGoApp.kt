package youmeee.co.jp.wannagoapp

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.HasActivityInjector
import youmeee.co.jp.wannagoapp.di.component.DaggerAppComponent
import youmeee.co.jp.wannagoapp.di.module.AppModule

/**
 * Created by yumitsuhori on 2018/04/26.
 */
class WannaGoApp() : Application(), HasActivityInjector {
    override fun activityInjector(): AndroidInjector<Activity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate() {
        super.onCreate()

        val appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }
}