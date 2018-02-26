package gears.com.lab_app_7;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Context mContext;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = findViewById(R.id.main_btn);
        mContext = this;
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.  this,SettingsActivity.class));
            }
        });
        Button c = findViewById(R.id.popupbtn);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupMenu(view);
            }
        });
        Log.d("Hello","wassup");
        textView = findViewById(R.id.main_textView);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        Log.d("Hello",String.valueOf(resultCode));
        if (resultCode == RESULT_OK){
            ArrayList<String> cryptos = data.getStringArrayListExtra("Cryptos");
            StringBuilder sb = new StringBuilder();
            for (String crypto : cryptos){
                sb.append(crypto).append("\n");
            }
            textView.setText(sb.toString());
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_first:
                startActivityForResult(new Intent(MainActivity.this,AddCryptoActivity.class),RESULT_OK);

                return true;
            case R.id.menu_second:
                Toast.makeText(this,"Hello",Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    public void popupMenu(View v){
        PopupMenu popupMenu = new PopupMenu(this,v);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Toast.makeText(mContext,menuItem.getTitle(),Toast.LENGTH_LONG).show();
                return true;
            }
        });

        popupMenu.show();
    }
}
