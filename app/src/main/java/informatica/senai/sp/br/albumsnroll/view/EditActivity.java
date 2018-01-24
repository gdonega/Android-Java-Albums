package informatica.senai.sp.br.albumsnroll.view;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import informatica.senai.sp.br.albumsnroll.R;
import informatica.senai.sp.br.albumsnroll.logic.dao.AlbumDao;

public class EditActivity extends AppCompatActivity {
    AlbumDao dao = new AlbumDao();

    EditText etName;
    EditText etGenre;
    EditText etReDate;
    FloatingActionButton fabAddNew;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        if (getIntent().getExtras() != null) {

            getIntent().getExtras().get()

            /// /etName.setText();
        }


        fabAddNew = findViewById(R.id.fabSalvar);
        fabAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                finish();
            }
        });
    }
}
