package taufan.ayotebak;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class soal5 extends AppCompatActivity {
    Integer nilai;
    Button btnLanjut5;
    RadioButton rbStevejobs,rbObama,rbBillgates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        requestWindowFeature( Window.FEATURE_NO_TITLE );
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.activity_soal5);

        kenalan();
        ketikaButonDipencet();
        tangkapnilai();
    }

    private void ketikaButonDipencet() {
        btnLanjut5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rbObama.isChecked()){
                    Toast.makeText(soal5.this, "Maaf, jawaban kamu salah", Toast.LENGTH_LONG).show();
                    Log.i("salah",String.valueOf(nilai));
                }else if (rbBillgates.isChecked()){
                    Toast.makeText(soal5.this, "Maaf, jawaban kamu salah", Toast.LENGTH_LONG).show();
                    Log.i("salah",String.valueOf(nilai));
                }else if (rbStevejobs.isChecked()){
                    nilai++;
                    Toast.makeText(soal5.this, "Hore, jawaban kamu benar", Toast.LENGTH_LONG).show();
                    Log.i("benar",String.valueOf(nilai));
                }else{
                    Toast.makeText(soal5.this, "Kamu tidak menjawab apapun", Toast.LENGTH_LONG).show();
                    Log.i("salah",String.valueOf(nilai));
                }

                Intent a = new Intent(getApplicationContext(),hasil.class);
                a.putExtra("nilai",nilai);
                startActivity(a);
            }
        });
    }
    private void tangkapnilai() {
        nilai = getIntent().getIntExtra("nilai",0);
    }

    private void kenalan() {
        btnLanjut5 = (Button)findViewById(R.id.btnLanjut5);
        rbStevejobs = (RadioButton)findViewById(R.id.rbStevejobs);
        rbBillgates = (RadioButton)findViewById(R.id.rbBillgates);
        rbObama = (RadioButton)findViewById(R.id.rbObama);
    }

    private void munculdialog() {
        new AlertDialog.Builder(this)
                .setMessage("Hai Kak, kenapa? Ayo lanjut lagi")
                .setCancelable(false)
                .setNegativeButton("Lanjutkan", null)
                .show();
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            munculdialog();

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
