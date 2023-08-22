package com.example.noteappllication.Controller;

import com.example.noteappllication.Entity.Note;
import com.example.noteappllication.Exception.ResourceNotFoundException;
import com.example.noteappllication.Repository.NoteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
@CrossOrigin(origins = "http://localhost:4200")
public class NoteController {

    @Autowired
    NoteRepository noteRepository;

    @GetMapping
    public List<Note> getAllNote() {
        System.out.println("Retrieving all notes from DB.");
        return noteRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<String> createNote(@RequestBody Note note) {
        System.out.println("Added system out println");
        System.out.println("Added by Shankhar");
        this.noteRepository.save(note);
        return ResponseEntity.ok("Note Created");
    }

//    @PostMapping("/notes")
//    public Note createNote(@Valid @RequestBody Note note){
//        return noteRepository.save(note);
//    }

    @GetMapping("/{id}")
    public Note getNoteById(@PathVariable(value = "id") Long noteId) {
        return noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
    }


    @PutMapping("/{id}")
    public Note updateNote(@PathVariable(value = "id") Long noteId, @Valid @RequestBody Note noteDetails) {
        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

        note.setTitle(noteDetails.getTitle());
        note.setContent(noteDetails.getContent());

        Note updatedNote = noteRepository.save(note);

        return updatedNote;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
        noteRepository.delete(note);
        return ResponseEntity.ok().build();
    }


}

