package edu.duke.compsci290.albumviewer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Mercy Fang on 1/29/18.
 */

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout mLinearLayout;
        private TextView mSong;

        private ViewHolder(View itemView) {
            super(itemView);

            // Connect the instance variables in the ViewHolder class to the inflated instances.
            this.mLinearLayout = itemView.findViewById(R.id.song_holder_linear_layout);
            this.mSong = itemView.findViewById(R.id.song_name_text_view);
        }
    }

    private Context mContext;
    private String[] mSongs;

    public SongAdapter(final Context context, String[] songs) {
        mContext = context;
        mSongs = songs;
    }

    @Override
    public int getItemCount() {
        return mSongs.length;
    }

    @Override
    public SongAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater mInflater =
                (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = mInflater.inflate(R.layout.song_holder, parent, false);
        final SongAdapter.ViewHolder songHolder = new SongAdapter.ViewHolder(row);
        return songHolder;
    }

    @Override
    public void onBindViewHolder(SongAdapter.ViewHolder holder, int position) {
        holder.mSong.setText(mSongs[position]);
    }
}
