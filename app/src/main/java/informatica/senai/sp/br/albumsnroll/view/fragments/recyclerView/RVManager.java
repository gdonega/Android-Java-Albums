package informatica.senai.sp.br.albumsnroll.view.fragments.recyclerView;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import informatica.senai.sp.br.albumsnroll.logic.dao.AlbumDao;
import informatica.senai.sp.br.albumsnroll.logic.model.Album;
import informatica.senai.sp.br.albumsnroll.view.activitys.Main;

/**
 * Created by gustavo on 12/02/2018.
 */

public class RVManager {
    /**Instances**/
    public static final RVManager INSTANCE = new RVManager();
    private AlbumAdaper albumAdaper = new AlbumAdaper();
    private RecyclerView recyclerView;

    /**
     * Return the Instance of this class
     * @return
     */
    public RVManager getInstance() {
        return INSTANCE;
    }

    public void setRecyclerView(RecyclerView rv) {
        this.recyclerView = rv;
        this.recyclerView.setAdapter(this.albumAdaper);
        this.listForm();
    }

    public void listForm() {
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(Main.getContext(), 3);
        recyclerView.setLayoutManager(layoutManager);
    }

    private Boolean canCheck = false;

    public void setStatusOfCheckBox(Boolean statusOfCheckBox) {
        this.canCheck = statusOfCheckBox;
        this.notifyToRemoveItems();
    }
    public Boolean getStatusOfCheckBox() {
        return canCheck;
    }


    /**
     * USE THIS METHOD WHEN YOU JUST WANT TO UPDATE
     * YOUR LIST VIEW
     *
     * BE CAREFUL: YOU DON'T NEED TO USE THIS METHOD WHEN
     * YOU USE ANOTHER METHOD TO DELETE FROM THIS CLASS
     */
    public void notifySomeChangeInTheList(){
        albumAdaper.notifyDataSetChanged();
    }


    /**
     * DELETE ITEMS AND UPDATE THE LIST
     *
     * USER WHEN: YOU DON'T NEED TO UPDATE ALL THE LIST
     *
     * BE CAREFUL: IT DOESN'T HELP WHEN YOU NEED TO UPDATE THE
     * CHECKBOX
     *
     *
     * WHAT YOU NEED TO CONFIGURE:
     * 1) DO A LOGIC TO ADD AND REMOVE THEITEM POSITION IN
     * THE LIST WHEN USER CLICK IN CHECKBOX
     * 2) USE THE "notifySomeItemsWereRemoved()" WHEN
     * USER CLICK IN DELETE
     *
     */
    public void notifySomeItemsWereRemoved() {
        new AlbumDao().deleteAll();

        for (int integer : getlistOfPositionsToDel()) {
            albumAdaper.notifyItemRemoved(integer);
        }

    }
    private List<Integer> listOfPositionsToDel = new ArrayList<>();
    public List<Integer> getlistOfPositionsToDel(){
        return listOfPositionsToDel;
    }
    public void addPositionToDel(int positionToDel){
        this.listOfPositionsToDel.add(positionToDel);
    }
    public void removePositionToDel(int positionToDel){
        this.listOfPositionsToDel.remove(positionToDel);
    }


    /**
     * UPDATE THE ENTIRE LIST
     *
     * USER WHEN: YOU NEED TO UPDATE ALL THE ITEMS OF THE
     * LIST
     *
     */
    public void notifyToRemoveItems(){
        new AlbumDao().deleteAll();

        notifySomeChangeInTheList();
    }


    /**
     * DELETE A ITEM AND UPDATE THE LIST
     * @param positionOfTheItemOnList = Position of the Item in the list
     */
    public void notifyOneItemRemove(Integer positionOfTheItemOnList){
        albumAdaper.notifyItemRemoved(positionOfTheItemOnList);
    }



}
