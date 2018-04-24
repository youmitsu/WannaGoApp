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

    companion object {
        private val EXTRA_TRANSITION_NAME = "transition_name"

        fun newInstance(transitionName: String): DetailFragment {
            val fragment = DetailFragment()
            val bundle = Bundle()
            bundle.putString(EXTRA_TRANSITION_NAME, transitionName)
            fragment.arguments = (bundle)
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view: View = View.inflate(context, R.layout.fragment_detail, null)
        thumbnail = view.findViewById(R.id.card_image)
        title = view.findViewById(R.id.info_text)
        val transitionName = arguments.getString(EXTRA_TRANSITION_NAME)
        thumbnail?.transitionName = transitionName

        return view
    }

}