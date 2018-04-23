package youmeee.co.jp.wannagoapp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

/**
 * Created by yumitsuhori on 2018/04/23.
 */
class DetailFragment : Fragment() {

    var thumbnail: ImageView? = null
    var title: TextView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view: View = View.inflate(context, R.layout.fragment_detail, null)
        thumbnail = view.findViewById(R.id.card_image)
        title = view.findViewById(R.id.info_text)
        thumbnail?.transitionName = "card_image"

        return view
    }


}