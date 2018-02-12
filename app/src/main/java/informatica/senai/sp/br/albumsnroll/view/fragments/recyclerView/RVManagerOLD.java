package informatica.senai.sp.br.albumsnroll.view.fragments.recyclerView;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import informatica.senai.sp.br.albumsnroll.logic.dao.AlbumDao;
import informatica.senai.sp.br.albumsnroll.logic.model.Album;
import informatica.senai.sp.br.albumsnroll.view.activitys.Main;

/**
 * Created by gustavo on 11/02/2018.
 */

public class RVManagerOLD {
    private static final RVManagerOLD RV_MANAGER = new RVManagerOLD();
    private AlbumAdaper albumAdaper = new AlbumAdaper();
    private RecyclerView recyclerView;
    private AlbumDao dao = new AlbumDao();

    public static RVManagerOLD getInstance() {
        return RV_MANAGER;
    }

    public void setRecyclerView(RecyclerView rv) {
        recyclerView = rv;
        recyclerView.setAdapter(albumAdaper);
        listForm();
        notifyDataSetChangedAdapter();
    }


    public  void listForm() {
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(Main.getContext(), 3);
        recyclerView.setLayoutManager(layoutManager);
    }


    /**
     * List of the position of items on the scream
     */
    private List<Integer> listPositions = new ArrayList<>();

    public List<Integer> getListPositions() {
        return listPositions;
    }

    public void setListPositions(List<Integer> listPositionsToInsert) {
        this.listPositions = listPositionsToInsert;
    }

    /**
     * List of albums from DataBase
     */

    public List<Album> getListOfAlbums() {


        return new AlbumDao().getList();


    }


    /**
     * NotifyDataSetChanged of the Adapter
     */
    public void notifyDataSetChangedAdapter() {
        albumAdaper.notifyDataSetChanged();
    }

    /**
     * NotifyItemRemoved of the Adapter and Del from DB
     */
    public void notifyItemRemovedAdapter() {
        new AlbumDao().deleteAll();

        for (int integer : getListPositions()) {
            albumAdaper.notifyItemRemoved(integer);
        }


    }




    private Boolean canCheck = false;

    public void setStatusOfCheckBox(Boolean status) {
        this.canCheck = status;
        notifyDataSetChangedAdapter();
    }

    public Boolean getStatusOfCheckBox() {
        return canCheck;
    }





}
