package taufan.ayotebak;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

public class hasil extends AppCompatActivity {
    Integer nilai,totalNilai;
    TextView txtHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        startService(new Intent(hasil.this,serv2.class));

        super.onCreate(savedInstanceState);

        requestWindowFeature( Window.FEATURE_NO_TITLE );
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.activity_hasil);

        tangkapnilai();
        kenalan();
        totalNilai = 100*nilai/5;
        txtHasil.setText("Jawaban yang berhasil dijawab adalah "+nilai+" dari 5" + "\n Nilai " + totalNilai);
    }

    private void tangkapnilai() {
        nilai = getIntent().getIntExtra("nilai",0);
    }

    private void kenalan() {
        txtHasil = (TextView)findViewById(R.id.txtHasil);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Toast.makeText(this, "Tidak dapat kembali", Toast.LENGTH_SHORT).show();

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    public void onDestroy() {
        stopService(new Intent(hasil.this, serv2.class));
        super.onDestroy();
    }
}
