package informatica.senai.sp.br.albumsnroll.view;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.Date;
import java.util.List;

import informatica.senai.sp.br.albumsnroll.R;
import informatica.senai.sp.br.albumsnroll.logic.dao.AlbumDao;
import informatica.senai.sp.br.albumsnroll.logic.model.Album;
import informatica.senai.sp.br.albumsnroll.view.RecyclerView.AlbumAdaper;

public class MenuActivity extends AppCompatActivity {

    /*//Start-instances//*/

        //FragmentRecyclerView
        private RecyclerView recyclerView;
        private AlbumDao dao;


        //FloatingActionButton
        private FloatingActionButton fabNewAlbum;

    /*//End-instances//*/



    /*//Start-methods of AppCompactActivity//*/
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_menu);

            //DAO
            dao = new AlbumDao();


            //FragmentRecyclerView
            recyclerView = findViewById(R.id.rvList);

            fabNewAlbum = findViewById(R.id.fabAdd);
            fabNewAlbum.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivityForResult(new Intent(Main.getContext(), EditActivity.class), 00);
                }
            });
        }

        @Override
        protected void onStart() {
            super.onStart();

            //FragmentRecyclerView
            loadList();
        }
    /*//End-methods of AppCompactActivity//*/



    /*//Start - methods of FragmentRecyclerView//*/
        private void loadList() {
            //dao.save(new Album("lala","HAHAHAHAH",new Date()));
            //dao.update(new Album(3L, "BATATA","N sei",new Date()));
            // Log.d("ELP",dao.find(1L).getName());
            //dao.delete(new Album(3L));
            recyclerView.setAdapter(new AlbumAdaper(dao.getList()));


            RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 3);
            recyclerView.setLayoutManager(layoutManager);
        }
    /*//End - methods of FragmentRecyclerView//*/

}
