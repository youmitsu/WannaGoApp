package youmeee.co.jp.wannagoapp.presentation.activity

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import youmeee.co.jp.wannagoapp.R
import youmeee.co.jp.wannagoapp.presentation.fragment.ListFragment

class MainActivity : AppCompatActivity() {

    private var fragment: android.support.v4.app.Fragment? = null
    private val requestCode = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
