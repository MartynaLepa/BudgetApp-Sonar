package pk.lm.pasir_lepa_martyna.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * The Transaction entity represents a single financial transaction.
 * Each transaction has a unique identifier, amount, type, tags, notes, and creation date.
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transactions")
@SuppressWarnings("JpaDataSourceORMInspection")
public class Transaction {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    @Compass(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    private TransactionType type;

    private String tags;

    private String notes;

    private LocalDateTime timestamp;

    public Transaction(Double amount, TransactionType type, String tags, String notes, User user) {
        this.amount = amount;
        this.type = type;
        this.tags = tags;
        this.notes = notes;
        this.user = user;
        // POPRAWKA: Dodaliśmy jawne wskazanie strefy czasowej (systemowej), co uciszy błąd w Sonarze
        this.timestamp = LocalDateTime.now(ZoneId.systemDefault());
    }
}