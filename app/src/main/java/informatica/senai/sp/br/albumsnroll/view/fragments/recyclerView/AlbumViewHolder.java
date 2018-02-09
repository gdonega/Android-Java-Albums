package informatica.senai.sp.br.albumsnroll.view.fragments.recyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import informatica.senai.sp.br.albumsnroll.R;
import informatica.senai.sp.br.albumsnroll.logic.dao.AlbumDao;
import informatica.senai.sp.br.albumsnroll.logic.model.Album;
import informatica.senai.sp.br.albumsnroll.view.activitys.EditActivity;
import informatica.senai.sp.br.albumsnroll.view.activitys.Main;


public class AlbumViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

    //Instances of views from intem_album_rv.xml
    private final CheckBox cbItem;
    private final TextView tvName;
    private final TextView tvGenre;
    private final TextView tvReleaseDate;
    private final CheckBox cbPrepareToDell;

    //Others instances
    private AlbumDao dao;
    private Context context;
    private Long albumId;
    private boolean checkBoxStatus;
    private ShareInformation shareInformation = ShareInformation.instance;




    public void setCheckBoxEnable(boolean checkBoxEnable) {
        this.checkBoxStatus = checkBoxEnable;
    }

    public AlbumViewHolder(View itemView) {
        super(itemView);

        //setting clicks
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);

        //views from intem_album_rv.xml
        cbItem = itemView.findViewById(R.id.cbItem);
        tvName = itemView.findViewById(R.id.tvName);
        tvGenre = itemView.findViewById(R.id.tvGenre);
        tvReleaseDate = itemView.findViewById(R.id.tvReleaseDate);
        cbPrepareToDell = itemView.findViewById(R.id.cbItem);

        //get Context
        context = Main.getContext();

        //Dao
        dao = new AlbumDao();


    }

    public void setAlbumOnHolder(final Album album) {
        albumId = album.getId();
        tvName.setText(album.getName());
        tvGenre.setText(album.getGenre());
        tvReleaseDate.setText(album.getReleaseDateString());

        if (checkBoxStatus) {
            cbPrepareToDell.setVisibility(View.VISIBLE);
        } else {
            cbPrepareToDell.setVisibility(View.INVISIBLE);
        }

        cbPrepareToDell.setTag(albumId);
        cbPrepareToDell.setChecked(album.getWillBeDelete());
        cbPrepareToDell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Album albumToDelete = dao.find(albumId);
                albumToDelete.setWillBeDelete(!albumToDelete.getWillBeDelete());

                dao.update(albumToDelete);

                if (albumToDelete.getWillBeDelete()) {
                    shareInformation.getListPositions().add(getAdapterPosition());
                }else {
                    shareInformation.getListPositions().remove(getAdapterPosition());
                }

            }
        });
    }


    @Override
    public void onClick(View view) {

        Activity activity = (Activity) view.getContext();
        Intent intent = new Intent(activity, EditActivity.class);
        intent.putExtra("id", albumId);

        activity.startActivityForResult(intent, 55);

    }

    @Override
    public boolean onLongClick(View v) {
        Toast.makeText(Main.getContext(), "long", Toast.LENGTH_SHORT).show();
        return false;
    }
}

