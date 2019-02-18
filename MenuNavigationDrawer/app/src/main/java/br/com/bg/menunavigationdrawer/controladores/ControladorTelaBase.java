package br.com.bg.menunavigationdrawer.controladores;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import br.com.bg.menunavigationdrawer.repositorios.RepositorioCliente;


public abstract class  ControladorTelaBase extends AppCompatActivity {
    protected RepositorioCliente repositorioCliente;

    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //repositorioCliente = new RepositorioCliente(this);
    }

    protected  void abrirTela(Context tela, Class<?> novaTela){
        Intent intent = new Intent(tela,novaTela);
        this.startActivity(intent);
    }

    public  void finalizacaoApp() {this.finish();}
    protected  String obterTexto(EditText editText){
        String texto = editText.getText().toString();

        return  texto != null && !texto.isEmpty() ? texto : "";
    }

}
