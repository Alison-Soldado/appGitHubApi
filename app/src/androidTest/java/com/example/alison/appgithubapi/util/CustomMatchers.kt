package com.example.alison.appgithubapi.util

import android.content.Context
import android.graphics.drawable.*
import android.os.Build
import android.support.design.widget.TextInputLayout
import android.support.test.espresso.matcher.BoundedMatcher
import android.support.test.internal.util.Checks
import android.support.v4.content.ContextCompat
import android.text.Html
import android.text.Spanned
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.alison.appgithubapi.R
import org.hamcrest.*
import java.util.regex.Pattern

/**
 * Created by alissonsoldado on 21/05/18.
 */
object CustomMatchers {

    val isHiding: Matcher<View>
        get() = object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("is displayed on the screen to the user")
            }

            public override fun matchesSafely(view: View): Boolean {
                return view.alpha < 1
            }
        }

    fun withCompoundDrawable(resourceId: Int): Matcher<View> {
        checkNotNull(resourceId)
        return object : BoundedMatcher<View, TextView>(TextView::class.java) {
            override fun describeTo(description: Description) {
                description.appendText("has compound drawable resource $resourceId")
            }

            public override fun matchesSafely(textView: TextView): Boolean {
                for (drawable in textView.compoundDrawables) {
                    if (sameBitmap(textView.context, drawable, resourceId)) {
                        return true
                    }
                }
                return false
            }
        }
    }

    fun withDrawable(resourceId: Int): Matcher<View> {
        checkNotNull(resourceId)
        return object : BoundedMatcher<View, ImageView>(ImageView::class.java) {
            override fun describeTo(description: Description) {
                description.appendText("has compound drawable resource $resourceId")
            }

            public override fun matchesSafely(imageView: ImageView): Boolean {
                return sameBitmap(imageView.context, imageView.drawable, resourceId)
            }
        }
    }

    fun withBackground(resourceId: Int): Matcher<View> {
        checkNotNull(resourceId)
        return object : BoundedMatcher<View, View>(View::class.java) {
            override fun describeTo(description: Description) {
                description.appendText("has background resource $resourceId")
            }

            public override fun matchesSafely(view: View): Boolean {
                return sameBitmap(view.context, view.background, resourceId)
            }
        }
    }

    fun withBackgroundColor(color: Int): Matcher<View> {
        Checks.checkNotNull(color)
        return object : BoundedMatcher<View, View>(View::class.java) {
            public override fun matchesSafely(view: View): Boolean {
                return color == (view.background as ColorDrawable).color
            }

            override fun describeTo(description: Description) {
                description.appendText("with background color from id: $color")
            }
        }
    }

    fun withTextColor(color: Int): Matcher<View> {
        Checks.checkNotNull(color)
        return object : BoundedMatcher<View, TextView>(TextView::class.java) {
            public override fun matchesSafely(warning: TextView): Boolean {
                return ContextCompat.getColor(warning.context, color) == warning.currentTextColor
            }

            override fun describeTo(description: Description) {
                description.appendText("with text color: $color")
            }
        }
    }

    fun withTextHtml(resource: Int): Matcher<View> {
        Checks.checkNotNull(resource)
        return object : BoundedMatcher<View, TextView>(TextView::class.java) {
            public override fun matchesSafely(textView: TextView): Boolean {
                val text = textView.context.getString(resource)
                val htmlText: Spanned
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    htmlText = Html.fromHtml(text, Html.FROM_HTML_MODE_COMPACT)
                } else {
                    htmlText = Html.fromHtml(text)
                }

                return textView.text.toString() == htmlText.toString()
            }

            override fun describeTo(description: Description) {
                description.appendText("with text : $resource")
            }
        }
    }

//    fun withTextHtmlColor(resource: Int): Matcher<View> {
//        Checks.checkNotNull(resource)
//        return object : BoundedMatcher<View, TextView>(TextView::class.java) {
//            public override fun matchesSafely(textView: TextView): Boolean {
////                return textView.currentTextColor == ContextCompat.getColor(textView.context, R.color.csf_colorAccent)
//            }
//
//            override fun describeTo(description: Description) {
//                description.appendText("with text : $resource")
//            }
//        }
//    }


    fun withTextIsBold(): Matcher<View> {
        val textIsBold = booleanArrayOf(false)
        return object : BoundedMatcher<View, TextView>(TextView::class.java) {
            public override fun matchesSafely(textView: TextView): Boolean {
                textIsBold[0] = textView.typeface.isBold
                return textIsBold[0]
            }

            override fun describeTo(description: Description) {
                description.appendText("with text is bold: " + textIsBold[0])
            }
        }
    }

//    fun currencyValueViewWithText(text: String): Matcher<View> {
//        Checks.checkNotNull(text)
//        return object : BoundedMatcher<View, CurrencyValueView>(CurrencyValueView::class.java!!) {
//            override fun describeTo(description: Description) {
//                description.appendText("with text size: $text")
//            }
//
//            override fun matchesSafely(item: CurrencyValueView): Boolean {
//                return item.getCurrencyTextView().getText().toString().equals(text)
//            }
//        }
//    }

//    fun currencyValueViewWithValue(value: String): Matcher<View> {
//        Checks.checkNotNull(value)
//        return object : BoundedMatcher<View, CurrencyValueView>(CurrencyValueView::class.java!!) {
//            override fun describeTo(description: Description) {
//                description.appendText("with text size: $value")
//            }
//
//            override fun matchesSafely(item: CurrencyValueView): Boolean {
//                return item.getValueTextView().getText().toString().equals(value)
//            }
//        }
//    }

    private fun sameBitmap(context: Context, drawable: Drawable?, resourceId: Int): Boolean {
        var drawable = drawable
        var otherDrawable: Drawable? = ContextCompat.getDrawable(context, resourceId)
        if (drawable == null || otherDrawable == null) {
            return false
        }

        if (drawable is StateListDrawable && otherDrawable is StateListDrawable) {
            drawable = drawable.current
            otherDrawable = otherDrawable.current
        }

        if (drawable is BitmapDrawable) {
            val bitmap = drawable.bitmap
            val otherBitmap = (otherDrawable as BitmapDrawable).bitmap
            return bitmap.sameAs(otherBitmap)
        }

        return (null != otherDrawable!!.constantState && null != drawable!!.constantState
                && drawable is GradientDrawable && drawable.constantState == otherDrawable.constantState)

    }

    fun withPattern(pattern: String, offsetString: Int): Matcher<View> {
        Checks.checkNotNull(pattern)
        return object : BoundedMatcher<View, TextView>(TextView::class.java) {
            public override fun matchesSafely(textView: TextView): Boolean {
                val patternCompile = Pattern.compile(pattern)
                val string = textView.text.toString()
                val matcher = patternCompile.matcher(string.substring(offsetString, string.length))
                return matcher.matches()
            }

            override fun describeTo(description: Description) {
                description.appendText("with pattern color: $pattern")
            }
        }
    }

    fun withError(errorMessage: String?): Matcher<View> {
        return object : BoundedMatcher<View, TextInputLayout>(TextInputLayout::class.java) {
            public override fun matchesSafely(textInputLayout: TextInputLayout): Boolean {
                return errorMessage == null || textInputLayout.error == errorMessage
            }

            override fun describeTo(description: Description) {
                description.appendText("with error layout: " + errorMessage!!)
            }
        }
    }

    fun withImageDrawable(resourceId: Int): Matcher<View> {
        return object : BoundedMatcher<View, ImageView>(ImageView::class.java) {
            override fun describeTo(description: Description) {
                description.appendText("has image drawable resource $resourceId")
            }

            public override fun matchesSafely(imageView: ImageView): Boolean {
                return sameBitmap(imageView.context, imageView.drawable, resourceId)
            }
        }
    }

    fun <T> withString(name: String): Matcher<T> {
        return object : BaseMatcher<T>() {
            override fun matches(item: Any): Boolean {
                return item.toString() == name
            }

            override fun describeTo(description: Description) {

            }
        }
    }

    fun containsText(context: Context, text: String): Matcher<String> {
        return object : BaseMatcher<String>() {
            override fun matches(item: Any): Boolean {
                return (item as String).contains(text)
            }

            override fun describeTo(description: Description) {
                description.appendText("Request contains text")
            }
        }
    }

//    fun billMonthWithString(text: String): Matcher<BillMonthVO> {
//        return billMonthWithString(Matchers.`is`(text))
//    }
//
//    fun billMonthWithString(name: Matcher<String>): Matcher<BillMonthVO> {
//        return object : TypeSafeMatcher<BillMonthVO>() {
//            override fun matchesSafely(item: BillMonthVO): Boolean {
//                return name.matches(item.getDescription())
//            }
//
//            override fun describeTo(description: Description) {
//                description.appendText("is displayed on Spinner")
//            }
//        }
//    }
}