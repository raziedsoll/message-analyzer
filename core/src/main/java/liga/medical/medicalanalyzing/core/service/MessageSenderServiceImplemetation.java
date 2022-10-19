package liga.medical.medicalanalyzing.core.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import liga.medical.medicalanalyzing.core.api.MessageSenderService;
import liga.medical.model.RabbitMessageDto;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageSenderServiceImplemetation implements MessageSenderService {

    private final AmqpTemplate amqpTemplate;
    private final ObjectMapper objectMapper;

    public MessageSenderServiceImplemetation(AmqpTemplate amqpTemplate, ObjectMapper objectMapper) {
        this.amqpTemplate = amqpTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public void sendMessage(RabbitMessageDto messageDto, String queue) throws JsonProcessingException {
        String messageStr = objectMapper.writeValueAsString(messageDto);
        amqpTemplate.convertAndSend(queue, messageStr);
        System.out.println(String.format("Сообщение " + messageStr + " в очередь " + queue + " отправлено!"));
    }
}
