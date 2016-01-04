package no.bacheloroppgaven.android.learningbasics1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import no.bacheloroppgaven.android.learningbasics1.model.Note;
import no.bacheloroppgaven.android.learningbasics1.model.adapter.NoteAdapter;

public class NotesActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    TextView heading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        initHeader();
        initNoteList();
    }

    private void initHeader() {
        heading = (TextView) findViewById(R.id.header_notes);
        heading.setText(R.string.header_notes);
    }

    private void initNoteList() {
        final ListView noteList = (ListView) findViewById(R.id.list_notes);

        Note[] notes = {
                new Note("Finca Tamana", 74.9, 2),
                new Note("Burger", 186.0, 1),
                new Note("Hipster Øl", 25.0, 1),
                new Note("Kruttønne", 1500.0, 1),
                new Note("Luft", 250.0, 1),
                new Note("Kjærlighet", 332.0, 1),
                new Note("Bestemors favoritter", 55.0, 163),
                new Note("Sølvgutt", 77325.0, 1)
        };

        final List<Note> list = Arrays.asList(notes);
        final NoteAdapter adapter = new NoteAdapter(this, android.R.layout.simple_list_item_1, list);
        noteList.setAdapter(adapter);
        noteList.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Note selectedNote = (Note) parent.getItemAtPosition(position);

        Toast.makeText(NotesActivity.this, selectedNote.getName(), Toast.LENGTH_SHORT).show();
    }
}
