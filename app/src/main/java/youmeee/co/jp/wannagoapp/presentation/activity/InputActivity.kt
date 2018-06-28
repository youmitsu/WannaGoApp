package youmeee.co.jp.wannagoapp.presentation.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import youmeee.co.jp.wannagoapp.R

/**
 * Created by yumitsuhori on 2018/04/30.
 */
class InputActivity() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.input_menu, menu)
        return true
    }

}