package informatica.senai.sp.br.albumsnroll.view.fragments.recyclerView;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import informatica.senai.sp.br.albumsnroll.logic.dao.AlbumDao;
import informatica.senai.sp.br.albumsnroll.logic.model.Album;
import informatica.senai.sp.br.albumsnroll.view.activitys.Main;

/**
 * Created by gustavo on 11/02/2018.
 */

public class RVManager {
    private static final RVManager RV_MANAGER = new RVManager();
    private static AlbumAdaper albumAdaper = new AlbumAdaper();
    private static RecyclerView recyclerView;
    private AlbumDao dao = new AlbumDao();

    public static RVManager getInstance() {
        return RV_MANAGER;
    }

    public static void setRecyclerView(RecyclerView rv) {
        recyclerView = rv;
        recyclerView.setAdapter(albumAdaper);
        listForm();
    }


    public static void listForm() {
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(Main.getContext(), 3);
        recyclerView.setLayoutManager(layoutManager);
    }










    /**
     * List of the position of items on the scream
     */
    private List<Integer> listPositions = new ArrayList<>();
    public List<Integer> getListPositions(){
        return listPositions;
    }
    public void setListPositions (List<Integer> listPositionsToInsert){
        this.listPositions = listPositionsToInsert;
    }


    private List<Album> albums = dao.getList();
    public List<Album> getListOfAlbums(){
        return albums;
    }
}
