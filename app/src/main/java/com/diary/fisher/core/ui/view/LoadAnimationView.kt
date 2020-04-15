package com.diary.fisher.core.ui.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.widget.AppCompatImageView
import com.diary.fisher.R

class LoadAnimationView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {

    private var loadAnimation: Animation? = null

    init {
        setImageResource(R.drawable.ic_launcher_foreground)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        startLoadAnimation()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        stopLoadAnimation()
    }

    override fun setVisibility(visibility: Int) {
        if (visibility == View.VISIBLE) {
            startLoadAnimation()
        } else {
            stopLoadAnimation()
        }
        super.setVisibility(visibility)
    }

    private fun startLoadAnimation() {
        if (loadAnimation == null) {
            loadAnimation = AnimationUtils.loadAnimation(context, R.anim.anim_load)
            startAnimation(loadAnimation)
        }
    }

    private fun stopLoadAnimation() {
        loadAnimation?.cancel()
        loadAnimation = null
        clearAnimation()
    }
}