package local;

import local.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyHandler{

    @Autowired
    MenuRepository menuRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverCanceled_OrderCanceled(@Payload OrderCanceled orderCanceled){

        if(orderCanceled.isMe()){
            System.out.println("##### 주문 취소 요청으로 인한 수량 변화 : " + orderCanceled.toJson());
            //Optional<Menu> temp = menuRepository.findById(Long.parseLong(orderCanceled.getMenuId()));
            Optional<Menu> temp = menuRepository.findById(orderCanceled.getMenuId());
            
            if(temp.isPresent()){
                Menu a = temp.get();
                a.setPCnt(a.getPCnt()+1);
                menuRepository.save(a);
            }
        }
    }

}
