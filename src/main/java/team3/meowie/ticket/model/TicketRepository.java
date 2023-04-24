package team3.meowie.ticket.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
//查詢剩餘票數量bymovieID
	@Query("SELECT COUNT(t) FROM Ticket t WHERE t.showID = ?1 AND t.payed = false")
	Integer countUnpaidTicketsByMovieID(Integer movieID);

}
