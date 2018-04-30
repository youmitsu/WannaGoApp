package youmeee.co.jp.wannagoapp.presentation.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import youmeee.co.jp.wannagoapp.R

/**
 * Created by yumitsuhori on 2018/04/30.
 */
class InputItemView : LinearLayout {
    @JvmOverloads
    constructor(
            context: Context,
            attrs: AttributeSet? = null,
            defStyle: Int = 0
    ) : super(context, attrs, defStyle)

    init {
        LayoutInflater.from(context).inflate(R.layout.input_item_view, this)
    }
}