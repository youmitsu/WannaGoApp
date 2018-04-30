package youmeee.co.jp.wannagoapp.presentation.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.transition.ChangeBounds
import android.transition.TransitionSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import youmeee.co.jp.wannagoapp.R
import youmeee.co.jp.wannagoapp.presentation.customview.RecyclerAdapter
import youmeee.co.jp.wannagoapp.presentation.customview.RecyclerViewHolder

/**
 * Created by yumitsuhori on 2018/04/23.
 */
class ListFragment : Fragment(), RecyclerViewHolder.onClickCardListener {

    val arr: List<String> = listOf("hoge", "hoge", "hoge", "hoge", "hoge", "hoge", "hoge", "hoge", "hoge")
    private val sharedElementkey = "card_iamge"

    var recyclerView: RecyclerView? = null
    var ts: TransitionSet = TransitionSet()
    var targetImage: ImageView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view: View = View.inflate(context, R.layout.fragment_list, null)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView?.let {
            it.setHasFixedSize(true)
            it.adapter = RecyclerAdapter(context, this, arr)
            it.layoutManager = LinearLayoutManager(context)
        }
        return view
    }

    override fun onStart() {
        super.onStart()
        ts.ordering = TransitionSet.ORDERING_TOGETHER
        ts.addTransition(ChangeBounds())
    }

    override fun onClickCard(view: View, position: Int) {
        Toast.makeText(context, "position $position was tapped", Toast.LENGTH_SHORT).show()
        val detailFragment = DetailFragment.newInstance(position.toString())
        detailFragment.sharedElementEnterTransition = ts
        detailFragment.sharedElementReturnTransition = ts
        targetImage = view.findViewById(R.id.card_image)
        targetImage?.transitionName = sharedElementkey
        targetImage?.let {
            val transaction: FragmentTransaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, detailFragment)
                    .addSharedElement(it, sharedElementkey)
                    .addToBackStack(null)
                    .commit()
        }

    }

    override fun onDestroy() {
        recyclerView = null
        super.onDestroy()
    }
}