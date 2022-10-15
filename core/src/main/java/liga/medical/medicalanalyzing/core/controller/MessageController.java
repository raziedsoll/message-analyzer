package liga.medical.medicalanalyzing.core.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import liga.medical.medicalanalyzing.core.api.MessageSenderService;
import liga.medical.medicalanalyzing.core.configuration.RabbitConfiguration;
import liga.medical.model.RabbitMessageDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbit")
public class MessageController {
    private final MessageSenderService messageSenderService;

    public MessageController(MessageSenderService messageSenderService) {
        this.messageSenderService = messageSenderService;
    }

    @PostMapping("/send")
    public void sendMessage(@RequestBody RabbitMessageDto message) throws JsonProcessingException {
        messageSenderService.sendMessage(message, RabbitConfiguration.ROUTER_QUEUE_NAME);
    }
}
