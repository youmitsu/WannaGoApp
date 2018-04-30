package youmeee.co.jp.wannagoapp.presentation.customview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import youmeee.co.jp.wannagoapp.R

/**
 * Created by yumitsuhori on 2018/04/16.
 */
class RecyclerAdapter(
        private val context: Context,
        private val itemClickListener: RecyclerViewHolder.onClickCardListener,
        private val itemList: List<String>) : RecyclerView.Adapter<RecyclerViewHolder>() {

    private var mRecyclerView: RecyclerView? = null

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView?) {
        super.onAttachedToRecyclerView(recyclerView)
        mRecyclerView = recyclerView
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView?) {
        super.onDetachedFromRecyclerView(recyclerView)
        mRecyclerView = null

    }

    override fun onBindViewHolder(holder: RecyclerViewHolder?, position: Int) {
        holder?.let {
            it.textView.text = itemList.get(position)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.list_item, parent, false)
        view.setOnClickListener { view ->
            mRecyclerView?.let {
                itemClickListener.onClickCard(view, it.getChildAdapterPosition(view))
            }
        }
        return RecyclerViewHolder(view)
    }

    override fun getItemCount(): Int = itemList.size

}