package sn.esmt.scolarite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HomeActivity extends AppCompatActivity {
    private Button visualisationtxt;
    private Button inscritiontext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        inscritiontext=(Button) findViewById(R.id.inscritiontext);
        visualisationtxt=(Button) findViewById(R.id.visualisationtxt);
        inscritiontext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(HomeActivity.this,InscriptionActivity.class);
                startActivity(i);
            }
        });
    }
}