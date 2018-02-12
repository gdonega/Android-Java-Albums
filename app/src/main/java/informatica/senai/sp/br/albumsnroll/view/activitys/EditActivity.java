package informatica.senai.sp.br.albumsnroll.view.activitys;

import android.app.Activity;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.text.DateFormat;
import java.util.Calendar;

import informatica.senai.sp.br.albumsnroll.R;
import informatica.senai.sp.br.albumsnroll.logic.dao.AlbumDao;
import informatica.senai.sp.br.albumsnroll.logic.model.Album;
import informatica.senai.sp.br.albumsnroll.view.fragments.DatePickerFragment;
import informatica.senai.sp.br.albumsnroll.view.fragments.recyclerView.RVManager;

public class EditActivity extends AppCompatActivity {
    //instance of "dao"
    private AlbumDao dao;

    //views (instances)
    private EditText etName;
    private EditText etGenre;
    private EditText etReDate;
    private FloatingActionButton fabAddNew;

    //helpers
    private DateFormat fmt;
    private Boolean bIDTest;
    private Calendar calendar;
    private Album toSaveAlbum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        //instance of "dao"
        dao = new AlbumDao();

        //views (instances) ----- setting (instance <- view_id)
        etName = findViewById(R.id.etName);
        etGenre = findViewById(R.id.etGenre);
        etReDate = findViewById(R.id.etReDate);

        /*helpers  -- start*/
            //standard instance of calendar
            calendar = Calendar.getInstance();

            //test of id (extra from intent)
            bIDTest = getIntent().getExtras() != null;

            //format calendar (for the Edit Text)
            fmt = DateFormat.getDateInstance(DateFormat.LONG);

            //album to save
            toSaveAlbum = new Album();
        /*helpers  -- end*/


        /*if 'id' isn't null*/
        if (bIDTest) {
            //take the extra from intent
            Long id = (Long) getIntent().getExtras().get("id");

            //searching id in the DB
            Album album = dao.find(id);

            //putting the name/genre in EditText
            etName.setText(album.getName());
            etGenre.setText(album.getGenre());

            //setting id in the album to save
            toSaveAlbum.setId(id);

            //DATE
            if (album.getReleaseDate() == null) {
                //put a standard date on EditText
                etReDate.setText(fmt.format(calendar.getTime()));
            } else {
                //put the formatted date (from album) in the EditText
                etReDate.setText(album.getReleaseDateString());
                //put the date (from album) in local the local instance of calendar
                calendar.setTime(album.getReleaseDate());
            }

        /*if 'id' is null*/
        } else {
            //put a standard date on EditText
            etReDate.setText(fmt.format(calendar.getTime()));
        }


        fabAddNew = findViewById(R.id.fabSalvar);
        fabAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                toSaveAlbum.setName(etName.getText().toString());
                toSaveAlbum.setGenre(etGenre.getText().toString());
                toSaveAlbum.setReleaseDate(calendar.getTime());

                /*if 'id' isn't null*/
                if (bIDTest) {
                    dao.update(toSaveAlbum);

                /*if 'id' is null*/
                } else {
                    dao.save(toSaveAlbum);
                }



                setResult(Activity.RESULT_OK);
                finish();
            }
        });
    }

    public void takeDate(View view) {
        DatePickerFragment.dateSetDialog(calendar, R.id.etReDate)
                .show(getFragmentManager(), "data");
    }
}
