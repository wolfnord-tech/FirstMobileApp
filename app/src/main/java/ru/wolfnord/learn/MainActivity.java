package ru.wolfnord.learn;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ru.wolfnord.learn.databinding.ActivityMainBinding;

//import android.net.Uri;
//import android.widget.Toast;
//import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMainBinding activityMainBinding;

    public static final String KEY = "key"; // Ключ для Экстра

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Запуск разметки
        Log.d("RRR", "onCreate()"); // Лог состояния

        Button button = findViewById(R.id.button); // Находим идентификатор кнопки
        button.setOnClickListener(this); // Случшаем клики (Можно реализовать через анонимный класс, если их немного)
    }

    // Элементы жизненного цикла активити
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("RRR", "OnStart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("RRR", "onDestroy()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("RRR", "onResume()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("RRR", "onRestart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("RRR", "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("RRR", "onStop()");
    }

    public void onClick(View view) { // Слушает все клики, а во View передается элемент, который услышали
        if (view.getId() == R.id.button) { // Ищем первую кнопку
            EditText editText = findViewById(R.id.editText); // Ищем текстовое поле
            String message = editText.getText().toString(); // Получаем сообщение и переводим в String

            // Явное намерение
            Intent intent = new Intent(this, DisplayMessageActivity.class); // Создаем явное намерение
            intent.putExtra(KEY, message); // Ключ-значение (Сохраняем информацию, которую можно передать на другой активити)
            startActivity(intent); // Запускаем второй активити

            // Неявное намерение (Мы явно не указываем куда идем - вызов сторонних сервисов ОС - sharing так работает практически)
//            Intent intent2 = new Intent(Intent.ACTION_VIEW);
//            String str = "https://developer.android.com/";
//            intent2.setData(Uri.parse(str)); // Запустит приложение, которое умеет подтягивает определенный ресурс (в нашем случае - ссылка, которую можно открыть в браузере)
//            startActivity(intent2); // Будут вызваны ресурсы ОС

//            Toast.makeText(this, "Message", Toast.LENGTH_LONG).show(); // Откуда, строка, длина (Небольшая разнутая горизонтально капелька)

//            Snackbar.make(findViewById(R.id.textView), "Message", Snackbar.LENGTH_SHORT).show(); // Откуда, строка, длина (Панель)
        }
    }
}