package portafolio.apiControllers;

import portafolio.domain.models.Portafolio;
import portafolio.domain.service.PortafolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping(path = "api/portafolio")
public class PortafolioController {
    private final PortafolioService portafolioService;

    @Autowired
    public PortafolioController(PortafolioService portafolioService) {
        this.portafolioService = portafolioService;
    }

    @GetMapping
    public List<Portafolio> getPortafolioController() {
        return portafolioService.getPortafolio();
    }

    @PostMapping
    public void createPortafolio(@RequestBody Portafolio portafolio) {
        portafolioService.newPortafolio(portafolio);
    }

    @PutMapping("/{id}")
    public void updatePortafolio(@PathVariable Integer id, @RequestBody Portafolio portafolio) {
        portafolioService.update(id, portafolio);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        portafolioService.deletePortafolio(id);
    }
}
