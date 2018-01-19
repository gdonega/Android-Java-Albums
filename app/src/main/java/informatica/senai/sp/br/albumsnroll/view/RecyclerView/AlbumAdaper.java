package informatica.senai.sp.br.albumsnroll.view.RecyclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

import informatica.senai.sp.br.albumsnroll.logic.model.Album;
import informatica.senai.sp.br.albumsnroll.view.Main;

public class AlbumAdaper extends RecyclerView.Adapter{
    //instances
    private List<Album> albums;
    private Context context = Main.getContext();

    //constructor
    public AlbumAdaper(List<Album> albums) {
        this.albums = albums;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
