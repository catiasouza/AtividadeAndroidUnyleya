package com.example.atividadeandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void inserir(View view) {
        EditText etName = findViewById(R.id.idtName);
        EditText etIdade = findViewById(R.id.edtIdade);

    Pessoa pessoa = new Pessoa(etName.getText().toString(), Integer.parseInt(etIdade.getText().toString()));
    PessoaDAO pessoaDAO = new PessoaDAO(this);
    long id = pessoaDAO.insert(pessoa);

        Toast.makeText(this, "pessoa salva, id: " + id, Toast.LENGTH_LONG).show();
 
    }

    public void listar(View view){
        Intent intPessoas = new Intent(this, ListaPessoas.class);
        startActivity(intPessoas);
    }
}