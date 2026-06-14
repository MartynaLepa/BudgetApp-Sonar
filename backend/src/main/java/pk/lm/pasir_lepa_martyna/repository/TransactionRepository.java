package pk.lm.pasir_lepa_martyna.repository;

import pk.lm.pasir_lepa_martyna.model.Transaction;
import pk.lm.pasir_lepa_martyna.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findAllByUser(User user);

    List<Transaction> findByUser(User user);

    List<Transaction> findAllByUserAndTimestampGreaterThanEqual(User user, LocalDateTime timestamp);
}