package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.calculator.utils.Calculator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // 加减乘除百分号
    private String add;
    private String sub;
    private String mul;
    private String div;
    private String percent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        // 获取EditText
        EditText et = findViewById(R.id.number_edit_text);
        // 设置EditText被点击时不弹出软键盘
        et.setShowSoftInputOnFocus(false);
        // 设置EditText字体从屏幕右边开始
        et.setTextAlignment(EditText.TEXT_ALIGNMENT_VIEW_END);
        // 获取按钮
        findViewById(R.id.button_0).setOnClickListener(this);
        findViewById(R.id.button_1).setOnClickListener(this);
        findViewById(R.id.button_2).setOnClickListener(this);
        findViewById(R.id.button_3).setOnClickListener(this);
        findViewById(R.id.button_4).setOnClickListener(this);
        findViewById(R.id.button_5).setOnClickListener(this);
        findViewById(R.id.button_6).setOnClickListener(this);
        findViewById(R.id.button_7).setOnClickListener(this);
        findViewById(R.id.button_8).setOnClickListener(this);
        findViewById(R.id.button_9).setOnClickListener(this);
        findViewById(R.id.button_point).setOnClickListener(this);
        findViewById(R.id.button_add).setOnClickListener(this);
        findViewById(R.id.button_sub).setOnClickListener(this);
        findViewById(R.id.button_mul).setOnClickListener(this);
        findViewById(R.id.button_div).setOnClickListener(this);
        findViewById(R.id.button_percent).setOnClickListener(this);
        findViewById(R.id.button_clear).setOnClickListener(this);
        findViewById(R.id.button_del).setOnClickListener(this);
        findViewById(R.id.button_equal).setOnClickListener(this);

        // 添加assets/iconfont.ttf中的字体
        Typeface typeface = Typeface.createFromAsset(getAssets(), "iconfont.ttf");
        et.setTypeface(typeface);
        // 获取除号
        div = getResources().getString(R.string.dev);
        // 获取加号
        add = getResources().getString(R.string.add);
        // 获取乘号
        mul = getResources().getString(R.string.mul);
        // 获取减号
        sub = getResources().getString(R.string.sub);
        // 百分号
        percent = getResources().getString(R.string.percent);
    }


    @Override
    public void onClick(View view) {
        // 获取EditText
        EditText et = findViewById(R.id.number_edit_text);
        // 获取EditText中的内容
        String str = et.getText().toString();
        // 获取点击的按钮
        switch (view.getId()) {
            case R.id.button_0:
                et.setText(str + "0");
                break;
            case R.id.button_1:
                et.setText(str + "1");
                break;
            case R.id.button_2:
                et.setText(str + "2");
                break;
            case R.id.button_3:
                et.setText(str + "3");
                break;
            case R.id.button_4:
                et.setText(str + "4");
                break;
            case R.id.button_5:
                et.setText(str + "5");
                break;
            case R.id.button_6:
                et.setText(str + "6");
                break;
            case R.id.button_7:
                et.setText(str + "7");
                break;
            case R.id.button_8:
                et.setText(str + "8");
                break;
            case R.id.button_9:
                et.setText(str + "9");
                break;
            case R.id.button_point:
                // 只有最后一个字符是数字，才拼接小数点
                if (str != null && !str.equals("")) {
                    char last = str.charAt(str.length() - 1);
                    if (last >= '0' && last <= '9') {
                        et.setText(str + ".");
                    }
                }
                break;
            case R.id.button_add:
                et.setText(checkCharacter(str, add));
                break;
            case R.id.button_sub:
                et.setText(checkCharacter(str, sub));
                break;
            case R.id.button_mul:
                et.setText(checkCharacter(str, mul));
                break;
            case R.id.button_div:
                et.setText(checkCharacter(str, div));
                break;
            case R.id.button_percent:
                et.setText(checkCharacter(str, percent));
                break;
            case R.id.button_clear:
                et.setText("");
                break;
            case R.id.button_del:
                if (str != null && !str.equals("")) {
                    et.setText(str.substring(0, str.length() - 1));
                }
                break;
            case R.id.button_equal:
                // 复制一份str，防止str被修改
                String copyStr = str;
                // 将str中的加减乘除替换为对应的运算符
                copyStr = copyStr.replace(add, "+");
                copyStr = copyStr.replace(sub, "-");
                copyStr = copyStr.replace(mul, "*");
                copyStr = copyStr.replace(div, "/");
                copyStr = copyStr.replace(percent, "/100");
                double ans = 0;
                Calculator calculator = new Calculator();
                try {
                    ans = calculator.executeExpression(copyStr);
                } catch (Exception e) {
                    // 如果出现异常，在ExitText表达式的下一行显示错误
                    et.setText(str + "\n" + "错误");
                }
                // 在EditText中显示结果
                et.setText(ans + "");
                break;
        }
        // 将光标移动到最后
        et.setSelection(et.getText().length());

    }


    private String checkCharacter(String str, String target) {
        // 如果不为空，获取最后一个字符的字符串
        if (str != null && !str.equals("")) {
            String last = str.substring(str.length() - 1);
            // 如果最后一个字符是加减乘除中的一个，就替换为当前点击的按钮
            if (last.equals(add) || last.equals(sub) || last.equals(mul) || last.equals(div)) {
                str = str.substring(0, str.length() - 1) + target;
            } else {
                str = str + target;
            }
        } else {
            // 如果如果第一个字符不是乘法或者除法或百分号，就直接拼接
            if (!target.equals(mul) && !target.equals(div) && !target.equals(percent)) {
                str = target;
            }
        }
        return str;
    }
}