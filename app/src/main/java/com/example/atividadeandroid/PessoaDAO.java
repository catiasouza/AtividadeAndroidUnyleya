package com.example.atividadeandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {

    private Conexao conexao;
    private SQLiteDatabase db;

    public PessoaDAO(Context context){
        conexao = new Conexao(context);
        db = conexao.getWritableDatabase();
    }
    public long insert(Pessoa pessoa){
        ContentValues contentvalue = new ContentValues();
        contentvalue.put("nome", pessoa.getNome());
        contentvalue.put("idade", pessoa.getIdade());

        return db.insert("pessoa", null, contentvalue);

    }
    public List<Pessoa>listar(){
        List<Pessoa> lista = new ArrayList<Pessoa>();
       Cursor cursor = db.rawQuery("SELECT * FROM pessoa", null);
       while(cursor.moveToNext()){
           lista.add(new Pessoa(cursor.getString(1), cursor.getInt(2)));
       }
       return lista;
    }

}
