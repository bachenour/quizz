package fr.ensitech.tpnour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnCommencer;

    private EditText editTextNom;

    private ImageView imageViewCrossRouge, imageViewCrossGris;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewCrossRouge = findViewById(R.id.imageViewCrossRouge);
        imageViewCrossRouge.setVisibility(View.INVISIBLE);
        imageViewCrossGris = findViewById(R.id.imageViewCrossGris);
        imageViewCrossGris.setVisibility(View.VISIBLE);

        btnCommencer = findViewById(R.id.btnCommencer);
        btnCommencer.setEnabled(false);

        editTextNom = findViewById(R.id.editTextTextNom);


        editTextNom.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() > 0){
                    imageViewCrossRouge.setVisibility(View.VISIBLE);
                    imageViewCrossGris.setVisibility(View.INVISIBLE);
                }else{
                    imageViewCrossRouge.setVisibility(View.INVISIBLE);
                    imageViewCrossGris.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length() > 0){
                    btnCommencer.setEnabled(true);
                }else{
                    btnCommencer.setEnabled(false);
                }
            }
        });
    }

    public void btnCommencer(View view) {
        if(editTextNom.getText().toString().trim().isEmpty()){
            Toast.makeText(this, R.string.error_nom, Toast.LENGTH_LONG).show();
        } else{
            Toast.makeText(this, R.string.success_commencer, Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity.this, Quiz.class);
            startActivity(intent);
        }
    }

}