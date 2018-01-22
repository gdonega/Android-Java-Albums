package informatica.senai.sp.br.albumsnroll.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import informatica.senai.sp.br.albumsnroll.R;

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

      //  Long id = (Long) getIntent().getExtras().get("id");
       // Toast.makeText(this, id.toString(), Toast.LENGTH_SHORT).show();
    }
}
