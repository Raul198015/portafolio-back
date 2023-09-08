package portafolio.infra.repositories;

import portafolio.domain.models.Portafolio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortafolioRepository extends JpaRepository<Portafolio, Integer> {
}
