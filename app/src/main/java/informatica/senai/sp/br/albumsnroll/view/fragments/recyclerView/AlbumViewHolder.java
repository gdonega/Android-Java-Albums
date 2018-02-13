package informatica.senai.sp.br.albumsnroll.view.fragments.recyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;


import informatica.senai.sp.br.albumsnroll.R;
import informatica.senai.sp.br.albumsnroll.logic.dao.AlbumDao;
import informatica.senai.sp.br.albumsnroll.logic.model.Album;
import informatica.senai.sp.br.albumsnroll.view.activitys.EditActivity;
import informatica.senai.sp.br.albumsnroll.view.activitys.Main;
import informatica.senai.sp.br.albumsnroll.view.activitys.MenuActivity;


public class AlbumViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

    //Instances of views from intem_album_rv.xml

    private final TextView tvName;
    private final TextView tvGenre;
    private final TextView tvReleaseDate;
    private final CheckBox cbPrepareToDell;

    //Others instances
    private AlbumDao dao;
    private Context context;
    private Long albumId;
    private RVManager rvManager = RVManager.INSTANCE;



    public AlbumViewHolder(View itemView) {
        super(itemView);

        //setting clicks
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);

        //views from intem_album_rv.xml

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

        if (rvManager.getStatusOfCheckBox()) {
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
                    rvManager.addPositionToDel(getAdapterPosition());
                }else {
                    rvManager.removePositionToDel(getAdapterPosition());
                }

            }
        });
    }


    @Override
    public void onClick(View view) {

        Activity activity = (Activity) view.getContext();
        Intent intent = new Intent(activity, EditActivity.class);
        intent.putExtra("id", albumId);

        activity.startActivityForResult(intent, MenuActivity.EDIT);

    }

    @Override
    public boolean onLongClick(final View view) {

        PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
        popupMenu.getMenuInflater().inflate(R.menu.album_options, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()){

                    case R.id.menuAlbumEdit:
                        Intent intent = new Intent(view.getContext(), EditActivity.class);
                        intent.putExtra("id", albumId);

                        ((Activity) view.getContext()).startActivityForResult(intent, MenuActivity.EDIT);
                        break;
                    case R.id.menuAlbumDel:

                        rvManager.notifyOneItemRemove(getAdapterPosition(), albumId);
                        break;
                }

                return true;
            }
        });

        popupMenu.show();

        return false;
    }
}

