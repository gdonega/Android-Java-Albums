package informatica.senai.sp.br.albumsnroll.logic.dao;



import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import informatica.senai.sp.br.albumsnroll.logic.db.AlbumsDBHelper;
import informatica.senai.sp.br.albumsnroll.logic.model.Album;
import informatica.senai.sp.br.albumsnroll.view.activitys.Main;

/**
 * Created by gustavo on 18/01/2018.
 */

public class AlbumDao {

    //instances of SQLite and of Album Data Base Helper
    private SQLiteDatabase db;
    private AlbumsDBHelper dbo;


    /**
     * Constructor
     */
    public AlbumDao() {
        //get the context of MainActivity
        dbo = new AlbumsDBHelper(Main.getContext());
    }

    /**
     * List of Albums (FROM SQLITE DB)
     *
     * @return List
     */
    public List<Album> getList() {
        db = dbo.getReadableDatabase();
        List<Album> albums = new LinkedList<>();

        String list = "select _id, name, genre, releasedate FROM " + AlbumsDBHelper.TABLE;

        Cursor cursor = db.rawQuery(list, null);
        Album album = null;

        if (cursor.moveToFirst()) {
            do {
                album = new Album();
                album.setId(cursor.getLong(0));
                album.setName(cursor.getString(1));
                album.setGenre(cursor.getString(2));
                album.setReleaseDate(new Date(cursor.getLong(3)));

                albums.add(album);
            } while (cursor.moveToNext());
        }

        return albums;
    }

    /**
     * Get one Album (FROM SQLITE DB)
     *
     * @param id of an Album
     * @return
     */
    public Album find(Long id) {
        db = dbo.getReadableDatabase();
        String find = "select * FROM " + AlbumsDBHelper.TABLE + " where _id = ?";


        Cursor cursor = db.rawQuery(find, new String[]{String.valueOf(id)});

        Album album = new Album();

        cursor.moveToFirst();

        album.setId(cursor.getLong(0));
        album.setName(cursor.getString(1));
        album.setGenre(cursor.getString(2));
        album.setReleaseDate(new Date(cursor.getLong(3)));

        cursor.close();
        db.close();
        return album;
    }

    /**
     * DELETE one album of SQLITE DB
     *
     * @param album (which you want to delete)
     */
    public void delete(Album album) {
        db = dbo.getWritableDatabase();
        String del = "delete from " + AlbumsDBHelper.TABLE + " where _id = ?";
        db.execSQL(del, new Object[]{album.getId()});
        db.close();
    }

    /**
     * SAVE one album in SQLITE DB
     *
     * @param album (which you want to save)
     */
    public void save(Album album) {
        db = dbo.getWritableDatabase();


        String insert = "insert into " + AlbumsDBHelper.TABLE + " (name, genre, releasedate) values (?, ?, ?)";



        db.execSQL(insert, new Object[]{album.getName(), album.getGenre(), album.getReleaseDateLong()});



        db.close();
    }

    /**
     * UPDATE one album
     *
     * @param album (which you want to update)
     */
    public void update(Album album) {
        db = dbo.getWritableDatabase();
        String update = "update " + AlbumsDBHelper.TABLE + " set name = ?, genre = ?, releasedate = ? where _id = ?";


        db.execSQL(update, new Object[]{album.getName(), album.getGenre(), album.getReleaseDateLong(), album.getId()});
        db.close();
    }
}
