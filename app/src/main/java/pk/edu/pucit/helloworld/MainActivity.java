package pk.edu.pucit.helloworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int counter = 0;
    TextView cv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cv = findViewById(R.id.counter_txt_view);
        cv.setText(counter + "");  //Addition of "" to convert the counter into a string.

        View.OnClickListener inc_listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                cv.setText(counter + "");
            }
        };
        View.OnClickListener dec_listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter--;
                cv.setText(counter + "");
            }
        };
        Button btn_inc = findViewById(R.id.inc_btn);
        btn_inc.setOnClickListener(inc_listener);
        Button btn_dec = findViewById(R.id.dec_btn);
        btn_dec.setOnClickListener(dec_listener);

        String message = getString(android.R.string.dialog_alert_title);

//        AlertDialog ad = new AlertDialog.Builder(this)
//                .setMessage(R.string.message)
//                .setTitle(getString(android.R.string.dialog_alert_title))
//                .create();
//        ad.show();
        Toast.makeText(this,"this is a string",Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.mainmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.menu_reset){
            counter=0;
            cv.setText(counter + "");
            return true;
        }
        else
            return super.onOptionsItemSelected(item);
    }
}