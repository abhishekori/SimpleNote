package turing.com.simplenote;

        import android.app.Activity;
        import android.content.Context;
        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.os.Bundle;
        import android.os.Environment;
        import android.support.v4.view.MenuItemCompat;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.SearchView;
        import android.view.KeyEvent;
        import android.view.Menu;
        import android.view.MenuInflater;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.TextView.OnEditorActionListener;
        import android.widget.Toast;
        import android.widget.Toolbar;

        import java.io.File;
        import java.io.FileWriter;
        import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText note,subject;
    SharedPreferences sharedPreferences;
    String Ssubject,Snotes;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        note = (EditText) findViewById(R.id.note);
        subject = (EditText) findViewById(R.id.subject);
        Ssubject="default";
        Snotes="default";


    }

    public void generateNoteOnSD(Context context, String sFileName, String sBody) {
        Toast.makeText(context, "Saved hghg", Toast.LENGTH_SHORT).show();
        try {
            File root = new File(Environment.getExternalStorageDirectory(), "Notes");
            if (!root.exists()) {
                root.mkdirs();
            }
            File gpxfile = new File(root, sFileName);
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(sBody);
            writer.flush();
            writer.close();
            Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

void saveContents(String note)
{

}
    @Override
    protected void onPause() {
        super.onPause();
        Snotes=note.getText().toString();
        Ssubject=subject.getText().toString();
        generateNoteOnSD(this,Ssubject,Snotes);

    }

    @Override
    protected void onStop() {
        super.onStop();
        Snotes=note.getText().toString();
        Ssubject=subject.getText().toString();
        generateNoteOnSD(this,Ssubject,Snotes);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_actions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.list:
                //Toast.makeText(this,"list",Toast.LENGTH_LONG).show();
                startActivity(new Intent(this,NotesList.class));
                break;


        }
        return super.onOptionsItemSelected(item);
    }
}