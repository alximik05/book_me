package info.grishaev.dao;

import info.grishaev.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by stas on 16/02/17.
 */
@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}
