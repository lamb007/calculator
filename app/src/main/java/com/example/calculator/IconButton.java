package com.example.calculator;


import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

public class IconButton extends Button {


    public IconButton(Context context) {
        super(context);
        init(context);
    }

    public IconButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public IconButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public IconButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        //设置字体图标
        Typeface font = Typeface.createFromAsset(context.getAssets(), "iconfont.ttf");
        this.setTypeface(font);
    }

}
