package informatica.senai.sp.br.albumsnroll.view.fragments.recyclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import informatica.senai.sp.br.albumsnroll.R;
import informatica.senai.sp.br.albumsnroll.logic.model.Album;
import informatica.senai.sp.br.albumsnroll.view.activitys.Main;

public class AlbumAdaper extends RecyclerView.Adapter{
    //instances
    private List<Album> albums;
    private Context context = Main.getContext();

    //SetDellBox - Boolean
    private boolean checkBoxStatus;

    //constructor
    public AlbumAdaper(List<Album> albums) {
        this.albums = albums;
    }

    public void setDellBox(boolean newStatus){
        this.checkBoxStatus = newStatus;
        notifyDataSetChanged();
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

        Album album = albums.get(position);

        albumViewHolder.setCheckBoxEnable(checkBoxStatus);

        albumViewHolder.setAlbumOnHolder(album);
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }
}
