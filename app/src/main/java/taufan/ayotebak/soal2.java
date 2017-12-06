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
import android.widget.EditText;
import android.widget.Toast;

public class soal2 extends AppCompatActivity {
    Integer nilai;
    EditText editSukarno;
    Button btnLanjut2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature( Window.FEATURE_NO_TITLE );
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.activity_soal2);

        kenalan();
        ketikaButtonDipencet();
        tangkapnilai();
    }

    private void ketikaButtonDipencet() {
        btnLanjut2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editSukarno.getText().toString().equalsIgnoreCase("soekarno")){
                    nilai++;
                    Toast.makeText(soal2.this, "Hore, jawaban kamu benar", Toast.LENGTH_LONG).show();
                    Log.i("benar",String.valueOf(nilai));
                }else{
                    Toast.makeText(soal2.this, "Maaf, jawaban kamu salah", Toast.LENGTH_LONG).show();
                    Log.i( "salah",String.valueOf(nilai));
                }

                Intent a = new Intent(getApplicationContext(),soal3.class);
                a.putExtra("nilai",nilai);
                startActivity(a);
            }
        });
    }

    private void tangkapnilai() {
        nilai = getIntent().getIntExtra("nilai",0);
    }

    private void kenalan() {
        btnLanjut2 = (Button)findViewById(R.id.btnLanjut2);
        editSukarno = (EditText)findViewById(R.id.editSukarno);
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
