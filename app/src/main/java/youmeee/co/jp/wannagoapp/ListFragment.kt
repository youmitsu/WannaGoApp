package youmeee.co.jp.wannagoapp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

/**
 * Created by yumitsuhori on 2018/04/23.
 */
class ListFragment() : Fragment(), RecyclerViewHolder.onClickCardListener {

    val arr: List<String> = listOf("hoge", "hoge", "hoge", "hoge", "hoge", "hoge", "hoge", "hoge", "hoge")

    var recyclerView: RecyclerView? = null
    val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view: View = View.inflate(context, R.layout.fragment_list, null)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView?.let {
            it.setHasFixedSize(true)
            it.adapter = RecyclerAdapter(context, this, arr)
            it.layoutManager = layoutManager
        }
        return view
    }

    override fun onClickCard(view: View, position: Int) {
        Toast.makeText(context, "position $position was tapped", Toast.LENGTH_SHORT).show()
    }
}