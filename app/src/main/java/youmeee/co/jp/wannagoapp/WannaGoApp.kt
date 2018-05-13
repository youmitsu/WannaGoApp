package youmeee.co.jp.wannagoapp

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import youmeee.co.jp.wannagoapp.di.component.AppComponent
import youmeee.co.jp.wannagoapp.di.component.DaggerAppComponent
import youmeee.co.jp.wannagoapp.di.module.AppModule

/**
 * Created by yumitsuhori on 2018/04/26.
 */
class WannaGoApp() : Application(), HasActivityInjector {
    private lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        this.initializeInjector()
    }

    fun initializeInjector() {
        DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
                .inject(this)
    }

    fun getApplicationComponent(): AppComponent = appComponent

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingActivityInjector
}