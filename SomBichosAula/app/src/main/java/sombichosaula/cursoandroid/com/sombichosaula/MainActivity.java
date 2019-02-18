package sombichosaula.cursoandroid.com.sombichosaula;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity implements View.OnClickListener {

    private ImageView cao;
    private ImageView gato;
    private ImageView leao;
    private ImageView macaco;
    private ImageView ovelha;
    private ImageView vaca;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cao     = (ImageView) findViewById(R.id.caoId);
        gato    = (ImageView) findViewById(R.id.gatoId);
        leao    = (ImageView) findViewById(R.id.leaoId);
        macaco  = (ImageView) findViewById(R.id.macacoId);
        ovelha  = (ImageView) findViewById(R.id.ovelhaId);
        vaca    = (ImageView) findViewById(R.id.vacaId);

        cao.setOnClickListener(this);
        gato.setOnClickListener(this);
        leao.setOnClickListener(this);
        macaco.setOnClickListener(this);
        ovelha.setOnClickListener(this);
        vaca.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch ( v.getId() ){
            case R.id.caoId:
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.cao);
                tocarMusica();
                break;
            case R.id.gatoId:
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.gato);
                tocarMusica();
                break;
            case R.id.leaoId:
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.leao);
                tocarMusica();
                break;
            case R.id.macacoId:
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.macaco);
                tocarMusica();
                break;
            case R.id.ovelhaId:
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.ovelha);
                tocarMusica();
                break;
            case R.id.vacaId:
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.vaca);
                tocarMusica();
                break;

        }

    }

    public void tocarMusica(){
        if( mediaPlayer != null ){
            mediaPlayer.start();
        }
    }

    @Override
    protected void onDestroy() {
        if( mediaPlayer != null ){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }

}
