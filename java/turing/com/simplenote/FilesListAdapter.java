package turing.com.simplenote;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by abhishek on 13/5/16.
 */
public class FilesListAdapter extends RecyclerView.Adapter<FilesListAdapter.FileViewHolder> {

    public class FileViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView filename;
        public FileViewHolder(View itemView) {
            super(itemView);
            cv= (CardView) itemView.findViewById(R.id.card_view);
            filename = (TextView) itemView.findViewById(R.id.tv);
        }
    }

    List<String> mfiles;

    public FilesListAdapter(List<String> mfiles)
    {

        this.mfiles=mfiles;
    }

    @Override
    public FilesListAdapter.FileViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card,parent,false);
        FileViewHolder fvh=new FileViewHolder(v);
        return fvh;
    }

    @Override
    public void onBindViewHolder(FilesListAdapter.FileViewHolder holder, final int position) {
       // Mfiles file = mfiles.get(position);
        holder.filename.setText(mfiles.get(position));
        holder.filename.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("pos"," "+position);
            }
        });


    }

    @Override
    public int getItemCount() {

        return mfiles.size();
    }


}
