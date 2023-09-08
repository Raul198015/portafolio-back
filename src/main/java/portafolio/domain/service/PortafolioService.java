package portafolio.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portafolio.domain.models.Portafolio;
import portafolio.infra.repositories.PortafolioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PortafolioService {
    private final PortafolioRepository portafolioRepository;

    @Autowired
    public PortafolioService(PortafolioRepository portafolioRepository) {
        this.portafolioRepository = portafolioRepository;
    }

    public List<Portafolio> getPortafolio() {
        return portafolioRepository.findAll();
    }

    public void newPortafolio(Portafolio portafolio) {
        portafolioRepository.save(portafolio);
    }

    public void update(Integer id, Portafolio portafolio) {
        Optional<Portafolio> portafoliobyID = portafolioRepository.findById(id);
        if (portafoliobyID.isPresent()) {
            Portafolio portafolioExisting = portafoliobyID.get();

            portafolioExisting.setNombre(portafolio.getNombre());
            portafolioExisting.setDescripcion(portafolio.getDescripcion());
            portafolioExisting.setUrlrepo(portafolio.getUrlrepo());
            portafolioExisting.setLenguaje(portafolio.getLenguaje());
            portafolioRepository.save(portafolioExisting);
        }
    }

    public void deletePortafolio(Integer id) {
        boolean existe = portafolioRepository.existsById(id);
        if (existe) {
            portafolioRepository.deleteById(id);
        }
    }
}
