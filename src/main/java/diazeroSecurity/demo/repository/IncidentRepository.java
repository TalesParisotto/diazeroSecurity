package diazeroSecurity.demo.repository;

import diazeroSecurity.demo.entity.Incident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidentRepository extends JpaRepository<Incident,Integer> {
}
