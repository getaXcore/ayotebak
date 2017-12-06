package taufan.ayotebak;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {
    Button btnLanjut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        startService(new Intent(MainActivity.this,serv.class));

        super.onCreate(savedInstanceState);

        requestWindowFeature( Window.FEATURE_NO_TITLE );
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.activity_main);

        kenalan();
        ketikaButtonDipencet();

    }

    private void ketikaButtonDipencet() {
        btnLanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(getApplicationContext(),soal1.class);
                startActivity(a);
            }
        });
    }

    private void kenalan() {
        btnLanjut = (Button)findViewById(R.id.btnLanjut);
    }
    public void onDestroy() {
        stopService(new Intent(MainActivity.this, serv.class));
        super.onDestroy();
    }
}
