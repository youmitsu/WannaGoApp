package youmeee.co.jp.wannagoapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import kotterknife.bindView

class MainActivity : AppCompatActivity(), RecyclerViewHolder.onClickCardListener {

    val recyclerView: RecyclerView by bindView(R.id.recyclerView)
    val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val arr: List<String> = listOf("hoge", "hoge", "hoge", "hoge", "hoge", "hoge", "hoge", "hoge", "hoge")
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = RecyclerAdapter(this, this, arr)
        recyclerView.layoutManager = layoutManager
    }

    override fun onClickCard(view: View, position: Int) {
        Toast.makeText(applicationContext, "position $position was tapped", Toast.LENGTH_SHORT).show()
    }
}
