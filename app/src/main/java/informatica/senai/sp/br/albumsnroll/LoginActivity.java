package informatica.senai.sp.br.albumsnroll;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.facebook.stetho.Stetho;

import informatica.senai.sp.br.albumsnroll.view.Activitys.MenuActivity;

public class LoginActivity extends AppCompatActivity {

    EditText user;
    EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = findViewById(R.id.userInput);
        pass = findViewById(R.id.passInput);

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

    public void createNewUser(View view) {
    }

    public void login(View view) {

        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);

    }

}
