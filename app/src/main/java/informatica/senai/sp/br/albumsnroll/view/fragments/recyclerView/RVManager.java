package informatica.senai.sp.br.albumsnroll.view.fragments.recyclerView;

import android.content.res.Configuration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import informatica.senai.sp.br.albumsnroll.logic.dao.AlbumDao;
import informatica.senai.sp.br.albumsnroll.view.activitys.Main;
import informatica.senai.sp.br.albumsnroll.view.activitys.MenuActivity;

/**
 * Created by gustavo on 12/02/2018.
 */

public class RVManager {
    /**
     * Variables
     **/
    public static final RVManager INSTANCE = new RVManager();
    private AlbumAdaper albumAdaper = new AlbumAdaper();
    private RecyclerView recyclerView;
    private AlbumDao dao = new AlbumDao();

    /**
     * RETURN THE INSTANCE OF THIS CLASS
     *
     * @return RVManager
     */
    public RVManager getInstance() {
        return INSTANCE;
    }


    /**
     * SET A RecyclerView TO MANAGER
     *
     * @param rv = RecyclerView instance
     */
    public void setRecyclerView(RecyclerView rv) {
        this.recyclerView = rv;
        this.recyclerView.setAdapter(this.albumAdaper);
        this.listForm("grid");
    }

    /**
     * LayoutManager OF THE LIST
     */
    public void listForm(String listForm) {

        switch (listForm) {
            case "grid":
            case "Grid":
                int orientacao = Main.getContext().getResources().getConfiguration().orientation;
                if (orientacao == Configuration.ORIENTATION_PORTRAIT) {
                    recyclerView.setLayoutManager(new GridLayoutManager(Main.getContext(), 3));
                } else {
                    recyclerView.setLayoutManager(new GridLayoutManager(Main.getContext(), 5));
                }
        }

    }


    /**
     * METHODS TO SEND INFORMATION FOR CHECKBOX IN ViewHolder
     */
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
     * <p>
     * BE CAREFUL: YOU DON'T NEED TO USE THIS METHOD WHEN
     * YOU USE ANOTHER METHOD TO DELETE FROM THIS CLASS
     */
    public void notifySomeChangeInTheList() {
        albumAdaper.notifyDataSetChanged();
    }


    /**
     * DELETE ITEMS AND UPDATE THE LIST
     * <p>
     * USER WHEN: YOU DON'T NEED TO UPDATE ALL THE LIST
     * <p>
     * BE CAREFUL: IT DOESN'T HELP WHEN YOU NEED TO UPDATE THE
     * CHECKBOX
     * <p>
     * <p>
     * WHAT YOU NEED TO CONFIGURE:
     * 1) DO A LOGIC TO ADD AND REMOVE THEITEM POSITION IN
     * THE LIST WHEN USER CLICK IN CHECKBOX
     * 2) USE THE "notifySomeItemsWereRemoved()" WHEN
     * USER CLICK IN DELETE
     */
    public void notifySomeItemsWereRemoved() {
        dao.deleteAll();

        for (int integer : getlistOfPositionsToDel()) {
            albumAdaper.notifyItemRemoved(integer);
        }

    }

    private List<Integer> listOfPositionsToDel = new ArrayList<>();

    public List<Integer> getlistOfPositionsToDel() {
        return listOfPositionsToDel;
    }

    public void addPositionToDel(int positionToDel) {
        this.listOfPositionsToDel.add(positionToDel);
    }

    public void removePositionToDel(int positionToDel) {
        this.listOfPositionsToDel.remove(positionToDel);
    }


    /**
     * UPDATE THE ENTIRE LIST
     * <p>
     * USER WHEN: YOU NEED TO UPDATE ALL THE ITEMS OF THE
     * LIST
     */
    public void notifyToRemoveItems() {
        dao.deleteAll();
        notifySomeChangeInTheList();
    }


    /**
     * DELETE A ITEM AND UPDATE THE LIST
     *
     * @param positionOfTheItemOnList = Position of the Item in the list
     * @param idOfTheItemOnList       = Id of Item
     */
    public void notifyOneItemRemove(Integer positionOfTheItemOnList, Long idOfTheItemOnList) {
        dao.delete(idOfTheItemOnList);
        albumAdaper.notifyItemRemoved(positionOfTheItemOnList);
    }

}
