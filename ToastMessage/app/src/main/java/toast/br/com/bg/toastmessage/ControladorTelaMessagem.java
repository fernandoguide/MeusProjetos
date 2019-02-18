package toast.br.com.bg.toastmessage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ControladorTelaMessagem extends AppCompatActivity {

    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_messagem);
        btn = findViewById(R.id.btnToastMessage);
        
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ControladorTelaMessagem.this, "Teste Toast", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
