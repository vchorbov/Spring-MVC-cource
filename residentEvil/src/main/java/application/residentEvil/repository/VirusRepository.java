package application.residentEvil.repository;

import application.residentEvil.domain.entities.Virus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VirusRepository extends JpaRepository<Virus, String> {

}
