package com.example.atividadeandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class ListaPessoas extends AppCompatActivity {
     List<Pessoa> iPessoa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pessoas);

        ListView listViewpessoas = findViewById(R.id.listViewPessoas);

        PessoaDAO pessoaDAO = new PessoaDAO(this);
        iPessoa = pessoaDAO.listar();

        ArrayAdapter<Pessoa> adapter = new ArrayAdapter<Pessoa>(this, android.R.layout.simple_list_item_1, iPessoa);
        listViewpessoas.setAdapter(adapter);
    }
}