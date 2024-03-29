package com.haydikodlayalim.ticketservice.service.impl;

import com.haydikodlayalim.messaging.TicketNotification;
import com.haydikodlayalim.ticketservice.model.Ticket;
import com.haydikodlayalim.ticketservice.service.TicketNotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(Source.class)
@RequiredArgsConstructor
public class TicketNotificationServiceImpl implements TicketNotificationService {

    private final Source source; //Kuyruk source u.

    @Override
    public void sendToQueue(Ticket ticket) {

        TicketNotification ticketNotification =new TicketNotification();
        ticketNotification.setAccountId(ticket.getAssignee());
        ticketNotification.setTicketId(ticket.getId());
        ticketNotification.setTicketDescription(ticket.getDescription());
        //Queue ya gidecek mesajın payLoadına koyuyoruz.
        //Header da gönderebiliyoruz.
        //source.output().send(MessageBuilder.withPayload(ticketNotification).setHeader gibi
        //Error channel verebiliriz hata olursa buraya yaz gibi gibi
        source.output().send(MessageBuilder.withPayload(ticketNotification).build());
    }


}
