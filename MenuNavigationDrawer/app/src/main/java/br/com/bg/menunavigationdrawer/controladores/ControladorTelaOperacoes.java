package br.com.bg.menunavigationdrawer.controladores;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.com.bg.menunavigationdrawer.R;


public class ControladorTelaOperacoes extends AppCompatActivity {

    //Declaraçoes de Variaveis
    EditText edtValor1,edtValor2;
    TextView txvResult;
    Button btnSomar, btnSubtrair;

    //Variaveis pra calculo

    double valor1,valor2,result;

    protected  void abrirTela(Context tela, Class<?> novaTela){
        Intent intent = new Intent(tela,novaTela);
        this.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_operacoes);

        //Associaçao dos componentes e variaveis

        edtValor1 = findViewById(R.id.edtValor1);
        edtValor2 = findViewById(R.id.edtValor2);
        txvResult =  findViewById(R.id.txvResult);
        //Associaçao dos botoes
        btnSomar = findViewById(R.id.btnSomar);
        btnSubtrair = findViewById(R.id.btnSubtrair);


        //Adicionando a programaçao dos botoes no evento de clique
        btnSomar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valor1 = Double.parseDouble(edtValor1.getText().toString());
                valor2 = Double.parseDouble(edtValor2.getText().toString());
                result = (valor1 + valor2);
                txvResult.setText("Resultado: " + result);

            }
        });

        btnSubtrair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valor1 = Double.parseDouble(edtValor1.getText().toString());
                valor2 = Double.parseDouble(edtValor2.getText().toString());
                result = (valor1 - valor2);
                txvResult.setText("Resultado: " + result);
            }
        });

    }


}