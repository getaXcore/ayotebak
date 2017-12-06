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

public class soal1 extends AppCompatActivity {
    Integer nilai;
    RadioButton rbRonaldo,rbMark,rbWilliam;
    Button btnLanjut1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature( Window.FEATURE_NO_TITLE );
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.activity_soal1);

        kenalan();
        ketikaButonDipencet();

    }

    private void ketikaButonDipencet() {
        btnLanjut1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rbRonaldo.isChecked()){
                    Toast.makeText(soal1.this, "Maaf, jawaban kamu salah", Toast.LENGTH_LONG).show();
                    Log.i("salah",String.valueOf(nilai));
                }else if (rbWilliam.isChecked()){
                    Toast.makeText(soal1.this, "Maaf, jawaban kamu salah", Toast.LENGTH_LONG).show();
                    Log.i("salah",String.valueOf(nilai));
                }else if (rbMark.isChecked()){
                    nilai = 1;
                    Toast.makeText(soal1.this, "Hore, jawaban kamu benar", Toast.LENGTH_SHORT).show();
                    Log.i("benar",String.valueOf(nilai));
                }else{
                    Toast.makeText(soal1.this, "Kakak tidak kamu apapun", Toast.LENGTH_SHORT).show();
                    Log.i("salah",String.valueOf(nilai));
                }

                Intent a = new Intent(getApplicationContext(),soal2.class);
                a.putExtra("nilai",nilai);
                startActivity(a);
            }
        });
    }

    private void kenalan() {
        btnLanjut1 = (Button)findViewById(R.id.btnLanjut1);
        rbMark = (RadioButton)findViewById(R.id.rbMark);
        rbRonaldo = (RadioButton)findViewById(R.id.rbRonaldo);
        rbWilliam = (RadioButton)findViewById(R.id.rbWilliam);
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
