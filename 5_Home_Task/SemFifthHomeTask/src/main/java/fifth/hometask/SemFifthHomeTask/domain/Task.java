package fifth.hometask.SemFifthHomeTask.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**Структура задачи(класс Task):
 - ID (автоинкрементное)(тип Long)
 - Описание (не может быть пустым)(тип String)
 - Статус (одно из значений: "не начата", "в процессе", "завершена")(Тип TaskStatus )
 - Дата создания (автоматически устанавливается при создании задачи)(Тип LocalDateTime)
 Подсказка понадобится энумератор:
 enum TaskStatus
 NOT_STARTED, IN_PROGRESS, COMPLETED;
 *
 **/
@Data
@Entity
@Table(name = "tasksTABLE")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nameTask;
    @Column(nullable = false)
    private String  status = TaskStatus.NOT_STARTED.getStatus();
    @Column
    private LocalDate localDate = LocalDate.now();
    @Column
    private String localTime = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

}

