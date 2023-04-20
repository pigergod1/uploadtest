package team3.meowie.ticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import team3.meowie.show.service.TicketService;

@RestController
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/tickets/remaining/{showID}")
    public Integer getTicketRemaining(@PathVariable("showID") Integer showID) {
        return ticketService.getTicketRemaining(showID);
    }
    
    
}