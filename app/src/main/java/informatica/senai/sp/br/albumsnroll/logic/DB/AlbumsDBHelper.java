package informatica.senai.sp.br.albumsnroll.logic.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class AlbumsDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "album.db";
    private static final int VERSION = 1;
    public static final String TABLE = "albums";

    public static final String ID = "_id";
    public static final String NAME = "name";
    public static final String GENRE = "genre";
    public static final String RELEASE_DATE= "releasedate";


    public AlbumsDBHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String criarTabela = "CREATE TABLE " + TABLE + " (" + ID + " integer primary key autoincrement, " + NAME +
                " text, " + GENRE + " text, " + RELEASE_DATE + " integer)";

        db.execSQL(criarTabela);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}