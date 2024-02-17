package sixth.hometask.SemSixthHomeTask.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sixth.hometask.SemSixthHomeTask.domains.Note;
import sixth.hometask.SemSixthHomeTask.services.NoteService;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RestController
@RequestMapping("/notes")
public class NoteController {
    NoteService noteService;

    /**
     * 1. Добавление заметки. (Подсказка @PostMapping )
     * @param note
     * @return note
     */
    @PostMapping
    public Note saveNote(@RequestBody Note note){
        noteService.saveNote(note);
        return note;
    }

    /**
     * 2. Просмотр всех заметок.(Подсказка @GetMapping )
     * @return list of all available notes
     */
    @GetMapping
    public ResponseEntity<List<Note>>findAll(){
        return new ResponseEntity<>(noteService.findAll(), HttpStatus.OK);
    }

    /**
     * 3. Получение заметки по id. (Подсказка @GetMapping("/{id}") )
     * @param id
     * @return ResponseEntity
     */
    @GetMapping("/{id}")
    public ResponseEntity <Optional<Note>> findNoteById(@PathVariable Long id){
        Optional <Note> note;
        try {
            note = noteService.findById(id);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Optional.of(new Note()));
        }
        return new ResponseEntity(note, HttpStatus.OK);
    }

    /**
     * 4. Редактирование заметки.(Подсказка @PutMapping("/{id}") )
     * @param note
     * @param id
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@RequestBody Note note, @PathVariable Long id){
        note.setId(id);
        return new ResponseEntity<>(noteService.saveNote(note), HttpStatus.OK);
    }

    /**
     * 5. Удаление заметки.(Подсказка @DeleteMapping("/{id}") )
     * @param id
     * @return
     */
    @DeleteMapping ("/{id}")
    public ResponseEntity<Note>deleteNote(@PathVariable Long id){
        noteService.deleteNoteById(id);
        return ResponseEntity.ok().build();
    }


}
