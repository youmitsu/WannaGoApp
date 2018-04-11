package youmeee.co.jp.wannagoapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotterknife.bindView

class MainActivity : AppCompatActivity() {

    val recyclerView: RecyclerView by bindView(R.id.recyclerView)
    val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = layoutManager

    }
}
