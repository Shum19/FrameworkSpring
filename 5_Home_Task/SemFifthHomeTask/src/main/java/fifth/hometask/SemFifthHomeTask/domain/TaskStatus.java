package fifth.hometask.SemFifthHomeTask.domain;

import lombok.Getter;

@Getter
public enum TaskStatus {
    NOT_STARTED("начать задачу"), IN_PROGRESS("в процессе"), COMPLETED("задача завершена");
    private String status;
    private TaskStatus(String status){
        this.status = status;
    }


}
