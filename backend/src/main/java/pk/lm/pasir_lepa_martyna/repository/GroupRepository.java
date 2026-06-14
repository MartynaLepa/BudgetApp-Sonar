package pk.lm.pasir_lepa_martyna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pk.lm.pasir_lepa_martyna.model.Group;
import pk.lm.pasir_lepa_martyna.model.User;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    List<Group> findByMemberships_User(User user);
}