package youmeee.co.jp.wannagoapp.presentation.customview

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import kotterknife.bindView
import youmeee.co.jp.wannagoapp.R

/**
 * Created by yumitsuhori on 2018/04/16.
 */
class RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val textView: TextView by bindView(R.id.info_text)

    interface onClickCardListener {
        fun onClickCard(view: View, position: Int)
    }
}