package informatica.senai.sp.br.albumsnroll.view.activitys;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.net.URISyntaxException;

import informatica.senai.sp.br.albumsnroll.R;
import informatica.senai.sp.br.albumsnroll.view.fragments.recyclerView.RVManager;

public class MenuActivity extends AppCompatActivity {

    /*//Start-instances//*/

    //Requests
    public static final int EDIT = 0;
    public static final String EDIT_RESULT = "EDIT_RESULT";

    //Toolbar
    private Toolbar toolbar;
    private MenuItem startDell;
    private MenuItem finalDell;

    //FragmentRecyclerView
    private RecyclerView recyclerView;
    private RVManager rvManager;


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


        //Floating Button
        fabNewAlbum = findViewById(R.id.fabAdd);
        fabNewAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult((new Intent(Main.getContext(), EditActivity.class)), EDIT);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        loadList();
    }
    /*//End-methods of AppCompactActivity//*/

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case EDIT:
                switch (resultCode) {
                    case RESULT_OK:
                        Toast.makeText(this, data.getStringExtra(EDIT_RESULT), Toast.LENGTH_SHORT).show();
                        break;
                    case RESULT_CANCELED:

                        if(data != null) {
                            Toast.makeText(this, data.getStringExtra(EDIT_RESULT), Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(this, "Canceled", Toast.LENGTH_SHORT).show();
                        }
                        break;
                }
                break;
        }

    }

    /*//Start - methods of FragmentRecyclerView//*/
    private void loadList() {
        recyclerView = findViewById(R.id.rvL);
        rvManager = RVManager.INSTANCE;
        rvManager.setRecyclerView(recyclerView);
    }
    /*//End - methods of FragmentRecyclerView//*/

    /*//Start - methods of Buttons//*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_items, menu);

        startDell = menu.findItem(R.id.start_dell_option);
        finalDell = menu.findItem(R.id.final_dell_option);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.start_dell_option:
                finalDell.setVisible(true);
                startDell.setVisible(false);
                rvManager.setStatusOfCheckBox(true);
                break;
            case R.id.final_dell_option:
                finalDell.setVisible(false);
                startDell.setVisible(true);
                rvManager.setStatusOfCheckBox(false);

                break;
        }
        return true;
    }
    /*//End - methods of Buttons//*/
}
