package informatica.senai.sp.br.albumsnroll.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.List;

import informatica.senai.sp.br.albumsnroll.R;
import informatica.senai.sp.br.albumsnroll.logic.dao.AlbumDao;
import informatica.senai.sp.br.albumsnroll.logic.model.Album;

public class MenuActivity extends AppCompatActivity {

    /*//Start-instances//*/

        //FragmentRecyclerView
        private RecyclerView recyclerView;
        private AlbumDao dao;

    /*//End-instances//*/



    /*//Start-methods of AppCompactActivity//*/
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_menu);

            //FragmentRecyclerView
            recyclerView = findViewById(R.id.rvList);
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
            List<Album> albums= dao.getList();


        }
    /*//End - methods of FragmentRecyclerView//*/

}
