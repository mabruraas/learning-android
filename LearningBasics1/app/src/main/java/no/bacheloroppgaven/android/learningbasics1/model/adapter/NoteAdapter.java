package no.bacheloroppgaven.android.learningbasics1.model.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import no.bacheloroppgaven.android.learningbasics1.R;
import no.bacheloroppgaven.android.learningbasics1.model.Note;

public class NoteAdapter extends ArrayAdapter<Note> {
    List<Note> notes;

    public NoteAdapter(Context context, int resource, List<Note> list) {
        super(context, resource, list);
        notes = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) super.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.item_note, parent, false);
        TextView textName = (TextView) rowView.findViewById(R.id.item_note_name);
        TextView textCount = (TextView) rowView.findViewById(R.id.item_note_count);
        TextView textPrice = (TextView) rowView.findViewById(R.id.item_note_price);

        textName.setText(notes.get(position).getName());
        textCount.setText(String.valueOf(notes.get(position).getCount()));
        textPrice.setText(String.valueOf(notes.get(position).getPrice()));

        return rowView;
    }
}
