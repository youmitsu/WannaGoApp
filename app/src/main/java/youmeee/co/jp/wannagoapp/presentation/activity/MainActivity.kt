package youmeee.co.jp.wannagoapp.presentation.activity

import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import youmeee.co.jp.wannagoapp.R
import youmeee.co.jp.wannagoapp.presentation.fragment.ListFragment

class MainActivity : AppCompatActivity() {

    private var fragment: android.support.v4.app.Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragment = ListFragment()
        val fragmentManager: android.support.v4.app.FragmentManager = supportFragmentManager
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
