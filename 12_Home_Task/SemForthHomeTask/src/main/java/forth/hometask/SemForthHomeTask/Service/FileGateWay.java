package forth.hometask.SemForthHomeTask.Service;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;

@MessagingGateway(defaultRequestChannel = "messageChannelInput")
public interface FileGateWay {
    void writeToFile(@Header(FileHeaders.FILENAME) String fileName, String data);
}
