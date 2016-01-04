package no.bacheloroppgaven.android.learningbasics1.model.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

import no.bacheloroppgaven.android.learningbasics1.model.Note;

public class NoteAdapter extends ArrayAdapter<Note> {

    public NoteAdapter(Context context, int resource, List<Note> list) {
        super(context, resource, list);
    }
}
