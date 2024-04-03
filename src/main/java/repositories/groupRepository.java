package repositories;

import models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface groupRepository extends JpaRepository<Group,Long> {
}
