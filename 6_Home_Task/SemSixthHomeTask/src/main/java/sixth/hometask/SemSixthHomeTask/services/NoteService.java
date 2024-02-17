package sixth.hometask.SemSixthHomeTask.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sixth.hometask.SemSixthHomeTask.domains.Note;
import sixth.hometask.SemSixthHomeTask.repositories.INoteRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NoteService {
    private INoteRepository iNoteRepository;

    /**
     * Просмотр всех заметок;
     * @return all available notes in Repository;
     */
    public List<Note> findAll(){
        return iNoteRepository.findAll();
    }

    /**
     * Получение заметки по id
     * @param id
     * @return Optional <Note>
     */
    public Optional<Note> findById(Long id){
        return iNoteRepository.findById(id);
    }

    /**
     * Добавление заметки
     * @param note
     */
    public Note saveNote(Note note){
        return iNoteRepository.save(note);
    }

    /**
     * Удаление заметки
     * @param id
     */
    public void deleteNoteById(Long id){
        iNoteRepository.deleteById(id);
    }

}
