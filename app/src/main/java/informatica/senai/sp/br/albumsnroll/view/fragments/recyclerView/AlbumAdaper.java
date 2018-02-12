package informatica.senai.sp.br.albumsnroll.view.fragments.recyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import informatica.senai.sp.br.albumsnroll.R;
import informatica.senai.sp.br.albumsnroll.logic.dao.AlbumDao;
import informatica.senai.sp.br.albumsnroll.logic.model.Album;

public class AlbumAdaper extends RecyclerView.Adapter {
    AlbumDao dao= new AlbumDao();

    //constructor
    public AlbumAdaper() {
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_album_rv, parent, false);
        AlbumViewHolder holder = new AlbumViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        AlbumViewHolder albumViewHolder = (AlbumViewHolder) holder;
        Album album = dao.getList().get(position);
        albumViewHolder.setAlbumOnHolder(album);
    }

    @Override
    public int getItemCount() {
        return dao.getList().size();
    }
}
