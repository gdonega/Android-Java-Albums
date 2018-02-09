package informatica.senai.sp.br.albumsnroll.view.fragments.recyclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import informatica.senai.sp.br.albumsnroll.R;
import informatica.senai.sp.br.albumsnroll.logic.dao.AlbumDao;
import informatica.senai.sp.br.albumsnroll.logic.model.Album;
import informatica.senai.sp.br.albumsnroll.view.activitys.Main;

public class AlbumAdaper extends RecyclerView.Adapter {
    ShareInformation shareInformation = ShareInformation.instance;




    //constructor
    public AlbumAdaper() {
    }


    public void dellSet() {
        new AlbumDao().deleteAll();

        for (int integer : shareInformation.getListPositions()) {
            notifyItemRemoved(integer);
            Log.d("vamola", String.valueOf(integer));
        }


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
        Album album = shareInformation.getListOfAlbums().get(position);
        albumViewHolder.setCheckBoxEnable(checkBoxStatus);
        albumViewHolder.setAlbumOnHolder(album);
    }

    @Override
    public int getItemCount() {
        return shareInformation.getListOfAlbums().size();
    }
}
