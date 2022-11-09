package com.example.nguyenthidiemkhang_bt056;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvNotes;
    ArrayList<Note> notes;
    NoteAdapter noteAdapter;
    ImageView addNote;
    int position;

    ActivityResultLauncher<Intent> mLauncher =registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode()==RESULT_OK) {
                        if (result.getData().getIntExtra("flag", 0) == 1) {
                            Note note = (Note) result.getData().getSerializableExtra("Note");
                            NoteAdapter.addNote(note);
                        } else if(result.getData().getIntExtra("flag", 0) == 2){
                            Note note = (Note) result.getData().getSerializableExtra("Note");
                            NoteAdapter.editNote(note,position);
                        }
                    }
                }
            }
    );
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvNotes = findViewById(R.id.rvNotes);

        //Notes = App.initDataFornote();
        noteAdapter = new NoteAdapter(notes, MainActivity.this);
        rvNotes.setAdapter(noteAdapter);

        rvNotes.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));

        addNote = findViewById(R.id.faAdd);
        addNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Note.class);
                intent.putExtra("flag",1);
                mLauncher.launch(intent);
            }
        });
    }
}