package liga.medical.medicalanalyzing.core.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import liga.medical.model.RabbitMessageDto;

public interface MessageSenderService {
    void sendMessage(RabbitMessageDto messageDto, String queue) throws JsonProcessingException;
}
