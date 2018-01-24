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
import informatica.senai.sp.br.albumsnroll.logic.model.Album;

public class EditActivity extends AppCompatActivity {
    AlbumDao dao = new AlbumDao();

    EditText etName;
    EditText etGenre;
    EditText etReDate;

    FloatingActionButton fabAddNew;
    Album toSaveAlbum = new Album();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        etName = findViewById(R.id.etName);
        etGenre = findViewById(R.id.etGenre);
        etReDate = findViewById(R.id.etReDate);

        if (getIntent().getExtras() != null) {

            Long id = (Long) getIntent().getExtras().get("id");

            Album album = dao.find(id);

            toSaveAlbum.setId(id);
            etName.setText(album.getName());
            etGenre.setText(album.getGenre());
            etReDate.setText(album.getReleaseDateString());
        }


        fabAddNew = findViewById(R.id.fabSalvar);
        fabAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                toSaveAlbum.setName(etName.getText().toString());
                toSaveAlbum.setGenre(etGenre.getText().toString());
                //toSaveAlbum.setReleaseDate(etReDate);
                dao.update(toSaveAlbum);
                setResult(RESULT_OK);
                finish();
            }
        });
    }

    public void takeDate(View view) {

        DateDialog.makeDialog(calendar,R.id.edLancamento)
                .show(getFragmentManager(), "Data de Lançamento");
    }
}
