package gears.com.lab_app_7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class AddCryptoActivity extends AppCompatActivity {

    EditText editText;
    Button addButton,submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_crypto);
        editText = findViewById(R.id.add_edittext);
        addButton = findViewById(R.id.add_crypto_btn);
        submitButton = findViewById(R.id.add_submit);
        final Intent t  =getIntent();
        final ArrayList<String> cryptos = new ArrayList<>();
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String k = editText.getText().toString();
                cryptos.add(k);
                Toast.makeText(getApplicationContext(),"Added",Toast.LENGTH_SHORT).show();
                editText.setText("");
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t.putExtra("Cryptos",cryptos);

                setResult(RESULT_OK);

//                finishActivity(RESULT_OK);
            }
        });


    }
}
