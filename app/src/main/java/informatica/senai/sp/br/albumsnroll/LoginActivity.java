package informatica.senai.sp.br.albumsnroll;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.stetho.Stetho;

import informatica.senai.sp.br.albumsnroll.view.activitys.EditActivity;
import informatica.senai.sp.br.albumsnroll.view.activitys.Main;
import informatica.senai.sp.br.albumsnroll.view.activitys.MenuActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        // Create an InitializerBuilder
        Stetho.InitializerBuilder initializerBuilder =
                Stetho.newInitializerBuilder(this);

        // Enable Chrome DevTools
        initializerBuilder.enableWebKitInspector(
                Stetho.defaultInspectorModulesProvider(this)
        );

        // Enable command line interface
        initializerBuilder.enableDumpapp(
                Stetho.defaultDumperPluginsProvider(this)
        );

        // Use the InitializerBuilder to generate an Initializer
        Stetho.Initializer initializer = initializerBuilder.build();

        // Initialize Stetho with the Initializer
        Stetho.initialize(initializer);

    }

    public void newAlbum(View view) {
        startActivityForResult((new Intent(Main.getContext(), EditActivity.class)), MenuActivity.EDIT);
    }

    public void login(View view) {

        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case MenuActivity.EDIT:
                switch (resultCode) {
                    case RESULT_OK:
                        Toast.makeText(this, data.getStringExtra(MenuActivity.EDIT_RESULT), Toast.LENGTH_SHORT).show();
                        break;
                    case RESULT_CANCELED:

                        if (data != null) {
                            Toast.makeText(this, data.getStringExtra(MenuActivity.EDIT_RESULT), Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(this, "Canceled", Toast.LENGTH_SHORT).show();
                        }
                        break;
                }
                break;
        }


    }
}
