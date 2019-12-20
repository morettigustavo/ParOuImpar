package br.senai.sp.parouimpar;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class JogoActivity extends AppCompatActivity {

    int [] iImagens = {R.drawable.maogrande1,R.drawable.maogrande2,R.drawable.maogrande3,R.drawable.maogrande4,R.drawable.maogrande5};
    RadioGroup rgGrupoA, rgGrupoB;
    RadioButton rbPar, rbImpar;
    ImageView ivImagemEu, ivImagemRobo;
    TextView tvPlacarEu, tvPlacarRobo;
    int iPlacarRobo, iPlacarEu;
    LinearLayout llPrincipal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);

        rgGrupoA = findViewById(R.id.rgGrupoA);
        rgGrupoB = findViewById(R.id.rgGrupoB);

        rbPar = findViewById(R.id.rbPar);
        rbImpar = findViewById(R.id.rbImpar);

        ivImagemEu = findViewById(R.id.ivImagemEu);
        ivImagemRobo = findViewById(R.id.ivImagemRobo);

        tvPlacarEu = findViewById(R.id.tvPlacarEu);
        tvPlacarRobo = findViewById(R.id.tvPlacarRobo);

        llPrincipal = findViewById(R.id.llPrincipal);

        iPlacarEu=0;
        iPlacarRobo=0;

        tvPlacarEu.setText(String.valueOf(0));
        tvPlacarRobo.setText(String.valueOf(0));
    }

    public void um(View v){contar(1);}
    public void dois(View v){contar(2);}
    public void tres(View v){contar(3);}
    public void quatro(View v){contar(4);}
    public void cinco(View v){contar(5);}

    public void reiniciar(View v){
        llPrincipal.setBackgroundColor(Color.parseColor("#FFFFFF"));
        rgGrupoB.clearCheck();
        rgGrupoA.clearCheck();
        tvPlacarRobo.setText(null);
        tvPlacarEu.setText(null);
        iPlacarRobo = 0;
        iPlacarEu = 0;
        ivImagemRobo.setImageResource(0);
        ivImagemEu.setImageResource(0);
    }

    public void contar(int iValor){
        if (rbImpar.isChecked() || rbPar.isChecked()){
            int iAleatorio = (int) ((Math.random()*5)+1);

            if ((iAleatorio+iValor)%2==0 && rbPar.isChecked()){
                iPlacarEu++;
                llPrincipal.setBackgroundColor(Color.parseColor("#0000CD"));
            }else if ((iAleatorio+iValor)%2!=0 && rbImpar.isChecked()){
                iPlacarEu++;
                llPrincipal.setBackgroundColor(Color.parseColor("#0000CD"));
            }else{
                iPlacarRobo++;
                llPrincipal.setBackgroundColor(Color.parseColor("#FF0000"));
            }
            ivImagemEu.setImageResource(iImagens[iValor-1]);
            ivImagemRobo.setImageResource(iImagens[iAleatorio-1]);

            tvPlacarRobo.setText(String.valueOf(iPlacarRobo));
            tvPlacarEu.setText(String.valueOf(iPlacarEu));
        }else{
            Toast.makeText(this,"Você deve selecionar IMPAR ou PAR", Toast.LENGTH_LONG).show();
        }
    }

    public void limpar(View v){
        rgGrupoB.clearCheck();
    }
}
