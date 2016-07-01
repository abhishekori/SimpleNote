package turing.com.simplenote;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class NotesList extends AppCompatActivity {

   // private List<Mfiles> mfiles=new ArrayList<>();
    List<String> fileNames=new ArrayList<>();
    private RecyclerView rv;
    FilesListAdapter adapter;


String path;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_list);

        //mfiles=new ArrayList<>();


        rv=(RecyclerView)findViewById(R.id.rv);
        adapter = new FilesListAdapter(fileNames);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
       // rv.setHasFixedSize(true);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(adapter);

        prepareData();


    }

    void prepareData(){
        path= Environment.getExternalStorageDirectory().toString()+"/Notes";
        Log.d("Files", "Path: " + path);
        File f = new File(path);
        File file[] = f.listFiles();
        Log.d("Files", "Size: " + file.length);

        for (int i=0; i < file.length; i++)
        {
            Log.d("Files", "FileName:" + file[i].getName());
            Toast.makeText(this,"FileName:" + file[i].getName(),Toast.LENGTH_LONG).show();
            //mfiles.add(new Mfiles(file[i].getName().toString()));
            fileNames.add(file[i].getName().toString());

        }
        //Mfiles test=mfiles.get(2);
        //Log.d("class",test.getName().toString());
        adapter.notifyDataSetChanged();
    }



}
