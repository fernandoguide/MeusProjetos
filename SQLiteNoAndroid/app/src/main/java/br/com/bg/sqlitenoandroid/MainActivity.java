package br.com.bg.sqlitenoandroid;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try{
             //Criando o banco de Dados
            SQLiteDatabase bdAppBanco = openOrCreateDatabase("app",MODE_PRIVATE,null);
            //Criando a Tabela do banco se ela nao existir
            bdAppBanco.execSQL("Create table if not exists pessoas (nome VARCHAR , endereco VARCHAR ,dataNascimento VARCHAR,sexo CHAR, email VARCHAR)");
            //Inserindo dados na tabela
            bdAppBanco.execSQL("Insert into pessoas (nome,endereco,dataNascimento,sexo,email) " +
                    "VALUES ('Fernando','Rua do Meio','05/10/1989','M','fernando@fernando.com')");
            bdAppBanco.execSQL("Insert into pessoas (nome,endereco,dataNascimento,sexo,email)" +
                    " VALUES ('Jennifer','Rua do Fundo','03/07/2000','F','Jennifer@jhenny.com')");
            bdAppBanco.execSQL("Insert into pessoas (nome,endereco,dataNascimento,sexo,email) " +
                    "VALUES ('ZeRuela','Rua da Frente','04/11/1999','M','Zeruela@ruela.com')");
            bdAppBanco.execSQL("Insert into pessoas (nome,endereco,dataNascimento,sexo,email) " +
                    "VALUES ('JucaBaleiro','Rua do Judas','01/01/2018','M','juca@baleiro.com')");
            bdAppBanco.execSQL("Insert into pessoas (nome,endereco,dataNascimento,sexo,email)" +
                    " VALUES ('Ze Droguinha','Rua das Dorgas','22/05/1994','M','Zedrouinha@gmail.com')");
            //Percorendo os itens com o Cursor
            Cursor  cursor = bdAppBanco.rawQuery("Select * from pessoas",null);
            //recuperar o indice  da coluna
            int indiceColNome = cursor.getColumnIndex("nome");
            int indiceColEndereco = cursor.getColumnIndex("endereco");
            int indiceColDataNasc = cursor.getColumnIndex("dataNascimento");
            int indiceColSexo = cursor.getColumnIndex("sexo");
            int indiceColEmail = cursor.getColumnIndex("email");
            //Movendo o cursor para o primeiro item da tabela
            cursor.moveToFirst();
            //testar o cursor enquanto ele for diferente de nulo
            while (cursor!=null){
                //Exibir info do Log
                Log.i("Retorno = Nome",cursor.getString(indiceColNome));
                Log.i("Retorno = Endereco",cursor.getString(indiceColEndereco));
                Log.i("Retorno = DataNasc",cursor.getString(indiceColDataNasc));
                Log.i("Retorno = Sexo",cursor.getString(indiceColSexo));
                Log.i("Retorno = Email",cursor.getString(indiceColEmail));
                cursor.moveToNext();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
