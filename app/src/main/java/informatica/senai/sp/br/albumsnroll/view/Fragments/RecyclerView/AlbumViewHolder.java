package informatica.senai.sp.br.albumsnroll.view.Fragments.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import informatica.senai.sp.br.albumsnroll.R;
import informatica.senai.sp.br.albumsnroll.logic.dao.AlbumDao;
import informatica.senai.sp.br.albumsnroll.logic.model.Album;
import informatica.senai.sp.br.albumsnroll.view.Activitys.EditActivity;
import informatica.senai.sp.br.albumsnroll.view.Activitys.Main;


public class AlbumViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

    //Instances of views from intem_album_rv.xml
    private final CheckBox cbItem;
    private final TextView tvName;
    private final TextView tvGenre;
    private final TextView tvReleaseDate;

    //Others instances
    private AlbumDao dao;
    private Context context;
    private Long albumId;


    public AlbumViewHolder(View itemView) {
        super(itemView);

        //setting clicks
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);

        //views from intem_album_rv.xml
        cbItem = itemView.findViewById(R.id.cvItem);
        tvName = itemView.findViewById(R.id.tvName);
        tvGenre = itemView.findViewById(R.id.tvGenre);
        tvReleaseDate = itemView.findViewById(R.id.tvReleaseDate);

        //get Context
        context = Main.getContext();

        //Dao
        dao = new AlbumDao();


    }

    public void setAlbumOnHolder(Album album) {
        albumId = album.getId();
        tvName.setText(album.getName());
        tvGenre.setText(album.getGenre());
        tvReleaseDate.setText(album.getReleaseDateString());
    }


    @Override
    public void onClick(View view) {

        Activity activity = (Activity) view.getContext();
        Intent intent = new Intent(activity, EditActivity.class);
        intent.putExtra("id", albumId);

        activity.startActivityForResult(intent,55);

    }

    @Override
    public boolean onLongClick(View v) {
        Toast.makeText(Main.getContext(), "long", Toast.LENGTH_SHORT).show();
        return false;
    }
}

