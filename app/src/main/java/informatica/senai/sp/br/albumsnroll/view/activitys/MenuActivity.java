package informatica.senai.sp.br.albumsnroll.view.activitys;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import informatica.senai.sp.br.albumsnroll.R;
import informatica.senai.sp.br.albumsnroll.logic.dao.AlbumDao;
import informatica.senai.sp.br.albumsnroll.view.fragments.recyclerView.AlbumAdaper;

public class MenuActivity extends AppCompatActivity {

    /*//Start-instances//*/

        //Toolbar
        private Toolbar toolbar;
        private MenuItem startDell;
        private MenuItem finalDell;

        //FragmentRecyclerView
        private RecyclerView recyclerView;
        private AlbumAdaper adapter;
        private AlbumDao dao;


        //FloatingActionButton
        private FloatingActionButton fabNewAlbum;



    /*//End-instances//*/



    /*//Start-methods of AppCompactActivity//*/
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_menu);

            //Toolbar
            toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            //DAO
            dao = new AlbumDao();

            //FragmentRecyclerView
            recyclerView = findViewById(R.id.rvList);

            //Floating Button
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
            adapter = new AlbumAdaper(dao.getList());
            recyclerView.setAdapter(adapter);


            RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 3);
            recyclerView.setLayoutManager(layoutManager);
        }
    /*//End - methods of FragmentRecyclerView//*/


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_items, menu);

        startDell= menu.findItem(R.id.start_dell_option);
        finalDell= menu.findItem(R.id.final_dell_option);
        return true;
    }

    @Override
        public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.start_dell_option:
                finalDell.setVisible(true);
                startDell.setVisible(false);
                adapter.setDellBox(true);
                break;
            case R.id.final_dell_option:

                finalDell.setVisible(false);
                startDell.setVisible(true);
                adapter.setDellBox(false);
                adapter.dellSet();
                break;
        }
        return true;
    }
}
