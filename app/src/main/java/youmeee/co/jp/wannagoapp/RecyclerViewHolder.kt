package youmeee.co.jp.wannagoapp

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import kotterknife.bindView

/**
 * Created by yumitsuhori on 2018/04/16.
 */
class RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val textView: TextView by bindView(R.id.info_text)

    interface onClickCardListener {
        fun onClickCard(view: View, position: Int)
    }
}