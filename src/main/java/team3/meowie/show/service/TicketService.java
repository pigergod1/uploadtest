package team3.meowie.show.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team3.meowie.ticket.model.TicketRepository;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public Integer getTicketRemaining(Integer movieID) {
    	TicketRepository getN = ticketRepository;
		return getN.countUnpaidTicketsByMovieID(movieID);
    }
    
}