package turing.com.simplenote;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class NotesList extends AppCompatActivity {

    private List<Mfiles> mfiles;
    private RecyclerView rv;



String path;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_list);
                path= Environment.getExternalStorageDirectory().toString()+"/Notes";
        Log.d("Files", "Path: " + path);
        File f = new File(path);
        File file[] = f.listFiles();
        Log.d("Files", "Size: " + file.length);
        mfiles=new ArrayList<>();
        for (int i=0; i < file.length; i++)
        {
            Log.d("Files", "FileName:" + file[i].getName());
           // Toast.makeText(this,"FileName:" + file[i].getName(),Toast.LENGTH_LONG).show();
            mfiles.add(new Mfiles(file[i].getName().toString()));

        }

        rv=(RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        FilesListAdapter adapter = new FilesListAdapter(mfiles);
        rv.setAdapter(adapter);

    }




}
