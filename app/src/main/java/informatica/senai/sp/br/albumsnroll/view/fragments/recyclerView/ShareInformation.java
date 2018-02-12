//package informatica.senai.sp.br.albumsnroll.view.fragments.recyclerView;
//
//import android.support.v7.widget.RecyclerView;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import informatica.senai.sp.br.albumsnroll.logic.dao.AlbumDao;
//import informatica.senai.sp.br.albumsnroll.logic.model.Album;
//
///**
// * Created by gustavo on 04/02/2018.
// */
//
//public class ShareInformation {
//
//    /**
//     * Static Instance
//     */
//    private static RecyclerView rv;
//    private static ShareInformation instance;
//    private AlbumDao dao = new AlbumDao();
//
//    private static RecyclerView getRv() {
//        return rv;
//    }
//
//    private static void setRv(RecyclerView rv) {
//        ShareInformation.rv = rv;
//    }
//
//    public ShareInformation getInstance(RecyclerView recyclerView) {
//        return instance;
//     //   this.setRv(recyclerView);
//    }
//
//    /**
//     * List of the position of items (to delete)
//     */
//    private List<Integer> listPositions = new ArrayList<>();
//    public List<Integer> getListPositions() {
//        return listPositions;
//    }
//    public void setListPositions(List<Integer> listPositions) {
//        this.listPositions = listPositions;
//    }
//
//
//    /**
//     * List of albums from DataBase
//     */
//    private List<Album> albums = dao.getList();
//    public List<Album> getListOfAlbums() {
//        return albums;
//    }
//  /*  public void setListOfAlbums(List<Album> albums) {
//        this.albums = albums;
//    }*/
//
//
//    /**
//     * NotifyDataSetChanged of the Adapter
//     */
//    public void notifyDataSetChangedAdapter(){
//        //notifyDataSetChanged();
//    }
//
//    /**
//     * CheckBox of the one item of ViewHolder
//     */
//    //SetDellBox - Boolean
//    private boolean checkBoxStatus;
//
//    public void setDellBox(boolean newStatus) {
//        this.checkBoxStatus = newStatus;
//        notifyDataSetChangedAdapter();
//    }
//}
