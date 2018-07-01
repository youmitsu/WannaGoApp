package youmeee.co.jp.wannagoapp.presentation.customview

import android.content.Context
import android.text.InputFilter
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.input_item_view.view.*
import youmeee.co.jp.wannagoapp.R

/**
 * Created by yumitsuhori on 2018/04/30.
 */
class InputItemView : LinearLayout {

    private var itemName: String? = null

    @JvmOverloads
    constructor(
            context: Context,
            attrs: AttributeSet? = null,
            defStyle: Int = 0
    ) : super(context, attrs, defStyle) {
        LayoutInflater.from(context).inflate(R.layout.input_item_view, this)
        val a = context.theme.obtainStyledAttributes(attrs, R.styleable.inputItemView, 0, 0)
        try {
            itemName = a.getString(R.styleable.inputItemView_itemName)
        } finally {
            a.recycle()
        }
        buildView()
    }

    private fun buildView() {
        item_title.text = itemName
        item_edit.filters = arrayOf(InputFilter.LengthFilter(20), inputFilter)
    }

    private val inputFilter: InputFilter = InputFilter { src, start, end, dest, dstart, dend ->
        src
    }
}