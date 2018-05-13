package youmeee.co.jp.wannagoapp.presentation.activity

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.FragmentTransaction
import dagger.android.AndroidInjection
import youmeee.co.jp.wannagoapp.R
import youmeee.co.jp.wannagoapp.presentation.fragment.ListFragment
import youmeee.co.jp.wannagoapp.presentation.presenter.MainPresenter
import youmeee.co.jp.wannagoapp.presentation.view.MainView

class MainActivity : BaseActivity(), MainView {
    private var fragment: android.support.v4.app.Fragment? = null
    private val requestCode = 1

    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)

        setContentView(R.layout.activity_main)

        //       presenter.setView(this)
        fragment = ListFragment()
        val fragmentManager: android.support.v4.app.FragmentManager = supportFragmentManager
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { v ->
            onClickFAB()
        }
    }

    fun onClickFAB() {
        val intent = Intent(this, InputActivity::class.java)
        startActivity(intent)
    }
}
