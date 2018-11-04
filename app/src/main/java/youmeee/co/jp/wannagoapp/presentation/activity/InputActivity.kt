package youmeee.co.jp.wannagoapp.presentation.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_input.*
import youmeee.co.jp.wannagoapp.R

/**
 * Created by yumitsuhori on 2018/04/30.
 */
class InputActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

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
                val place = mapOf<String, Any>(Pair("name", "hoge"), Pair("expected", "hoge"))
                val db = FirebaseFirestore.getInstance()
                db.collection("place")
                        .add(place)
                        .addOnSuccessListener { documentReference ->
                            Toast.makeText(this, documentReference.id, Toast.LENGTH_SHORT).show()
                        }
                        .addOnFailureListener { e ->
                            Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
                        }
            }
        }
        return super.onOptionsItemSelected(item)
    }

}