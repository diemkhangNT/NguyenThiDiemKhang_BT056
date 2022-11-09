package com.example.nguyenthidiemkhang_bt056;

import android.location.GnssAntennaInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteVH> {
    ArrayList<Note> notes;
    ArrayList<Note> notesFilter;
    Listener listener;

    public NoteAdapter(ArrayList<Note> notes, Listener listener) {
        this.notes = notes;
        this.notes = notesFilter;
        this.listener = listener;
    }

    @NonNull
    @Override
    public NoteVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_row, parent, false);
        return new NoteVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteVH holder, int position) {
        Note note = notesFilter.get(position);
        holder.txTitle.setText(note.getTitle());
        holder.txDate.setText(note.getDate());
        holder.txContent.setText(note.getContent());
    }

    @Override
    public int getItemCount() {
        return notesFilter.size();
    }
    class NoteVH extends RecyclerView.ViewHolder{

        TextView txTitle,txDate,txContent;

        public NoteVH(@NonNull View itemView) {
            super(itemView);
            txTitle = itemView.findViewById(R.id.tv_title);
            txDate = itemView.findViewById(R.id.tv_date);
            txContent = itemView.findViewById(R.id.tv_content);
        }
    }

    public void addNote(Note note){
        notesFilter.add(note);
        notifyDataSetChanged();
    }

    public void editNote(Note note, int pos){
        notesFilter.set(pos, note);
        notifyDataSetChanged();
    }
    interface Listener {
        default void onItemListener(int pos, Note note) {
        }
    }
}
