package sixth.hometask.SemSixthHomeTask.domains;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**  Структура заметки:
 * - ID (автоинкрементное)(тип - Long)
 * - Заголовок (не может быть пустым)(тип - String)
 * - Содержимое (не может быть пустым)(тип - String)
 * - Дата создания (автоматически устанавливается при создании заметки)(тип - LocalDateTime)
 */
@Entity
@Data
@Table(name = "notes_Table")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title",nullable = false)
    private String title;
    @Column(name = "note", nullable = false)
    private String note;
    @Column(name = "date_time")
    private String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));


}
