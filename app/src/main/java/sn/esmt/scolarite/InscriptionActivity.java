package sn.esmt.scolarite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import sn.esmt.scolarite.http.Api;
import sn.esmt.scolarite.http.EtudiantResponse;


public class InscriptionActivity extends AppCompatActivity {
    private EditText mattext;

    private EditText nomtext;
    private EditText prenomtext;
    private EditText addrtexte;
    private EditText teltext;
    private EditText fraistext;
    private Button  retourIbt;
    private Button validerIbt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        retourIbt=(Button) findViewById(R.id.retourIbt);
        nomtext=(EditText) findViewById(R.id.nomtext);
        mattext=(EditText) findViewById(R.id.mattext);
        prenomtext=(EditText) findViewById(R.id.prenomtext);
        addrtexte=(EditText) findViewById(R.id.addrtexte);
        teltext=(EditText)findViewById(R.id.teltext);
        fraistext=(EditText)findViewById(R.id.fraistext);
        validerIbt=(Button) findViewById(R.id.validerIbt);

        validerIbt.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Retrofit retrofit =new Retrofit.Builder()
                        .baseUrl("http://10.0.2.2:8081./")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Api api=retrofit.create(Api.class);
                EtudiantResponse e=new EtudiantResponse();
                e.setMat(mattext.getText().toString());
                e.setNom(nomtext.getText().toString());
                e.setPrenom(prenomtext.getText().toString());
                e.setAddr(addrtexte.getText().toString());
                e.setTel(Integer.parseInt(teltext.getText().toString()));
                e.setFrais(Double.parseDouble(fraistext.getText().toString()));
                Call <EtudiantResponse> callSave=api.saveEtudiant(e);

                callSave.enqueue(new Callback<EtudiantResponse>() {
                    @Override
                    public void onResponse(Call<EtudiantResponse> call, Response<EtudiantResponse> response) {
                        Toast.makeText(InscriptionActivity.this,"Etudiant inscrit avec succès!",
                                Toast.LENGTH_LONG).show();

                    }
                    @Override
                    public void onFailure(Call <EtudiantResponse> call, Throwable t)
                {
                    Toast.makeText(InscriptionActivity.this,"Impossible d'acceder au serveur iu verifier votre connexion",
                            Toast.LENGTH_LONG).show();

                }

           });


        }


            });

        }
    }