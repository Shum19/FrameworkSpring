package forth.hometask.SemForthHomeTask.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.GenericTransformer;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.messaging.MessageChannel;

import java.io.File;

public class IntegrationConfigs {
    @Bean
    public MessageChannel messageChannelInput(){
         return new DirectChannel();
    }
    @Bean
    public MessageChannel messageChannelFileWriter(){
         return new DirectChannel();
    }
    @Bean
    @Transformer(inputChannel = "messageChannelInput", outputChannel = "messageChannelFileWriter")
    public GenericTransformer<String, String> myTransformer(){
        return text -> {return text;};
    }
    @Bean
    @ServiceActivator(inputChannel = "messageChannelFileWriter")
    public FileWritingMessageHandler fileWritingMessageHandler(){
        FileWritingMessageHandler handler = new FileWritingMessageHandler(new File
                ("/Users/Mikle/Downloads/GeekBrains/Framework_Spring/Framework_Spring/12_Home_Task/Files_Handler"));
        handler.setExpectReply(false);
        handler.setFileExistsMode(FileExistsMode.APPEND);
        handler.setAppendNewLine(true);
        return handler;
    }

}
