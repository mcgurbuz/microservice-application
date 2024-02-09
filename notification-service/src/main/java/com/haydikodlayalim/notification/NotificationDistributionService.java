package com.haydikodlayalim.notification;

import com.haydikodlayalim.messaging.TicketNotification;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

//NotificationDistributionService-->Kuyruğu dinleyen class.

@EnableBinding(Sink.class)  //Kuyruk tüketen dinleyen classa verilir.
public class NotificationDistributionService {
    //ticketNotification bir şema gibi düşünebiliriz. JSON içerisinde mi ayrı bir class.
    //Kuyruğa mesaj yazıldığında burası tetiklenecek.

    @StreamListener(Sink.INPUT)
    public void onNotification(TicketNotification ticketNotification){
        System.out.println("———————————————————————————————————————————");
        System.out.println("Notification Alindi Kullanicilara gönderiliyor.");
        System.out.println("Notification -> " + ticketNotification.toString());
    }
}
