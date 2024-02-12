package ru.wolfnord.learn;

import static ru.wolfnord.learn.MainActivity.KEY;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) { // Если есть информация
            String str = bundle.getString(KEY); // То достаем по ключу строку
            TextView textView = new TextView(this); // Создаем textView
            textView.setGravity(Gravity.CENTER); // Устанавливаем по центру
            textView.setTextSize(40); // Устанавливаем размер на 40
            textView.setText(str); // Фиксируем
            setContentView(textView); // Передаем в разметку активити
        }
    }

}
