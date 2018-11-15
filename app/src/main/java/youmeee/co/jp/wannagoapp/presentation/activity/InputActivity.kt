package youmeee.co.jp.wannagoapp.presentation.activity

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_input.*
import youmeee.co.jp.wannagoapp.R
import youmeee.co.jp.wannagoapp.viewModel.TopViewModel

/**
 * Created by yumitsuhori on 2018/04/30.
 */
class InputActivity : AppCompatActivity() {

    lateinit var model: TopViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        model = ViewModelProviders.of(this).get(TopViewModel::class.java)

        expected_date_area.setOnClickListener {
            Toast.makeText(this, "Tapped", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.input_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.register_btn -> {
                model.insert()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}