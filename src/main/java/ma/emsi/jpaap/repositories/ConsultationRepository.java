package ma.emsi.jpaap.repositories;

import ma.emsi.jpaap.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
