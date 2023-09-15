package portafolio.apiControllers;

import org.springframework.web.multipart.MultipartFile;
import portafolio.domain.models.Portafolio;
import portafolio.domain.service.PortafolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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
    public void createPortafolio(@RequestParam String nombre,
                                 @RequestParam String descripcion,
                                 @RequestParam String urlrepo,
                                 @RequestParam String lenguajes,
                                 @RequestParam MultipartFile imagen
    ) throws IOException {
        portafolioService.newPortafolio(nombre, descripcion, urlrepo, lenguajes, imagen);
    }

    @PutMapping("/{id}")
    public void updatePortafolio(@PathVariable Integer id,
                                 @RequestParam String nombre,
                                 @RequestParam String descripcion,
                                 @RequestParam String urlrepo,
                                 @RequestParam String lenguajes,
                                 @RequestParam MultipartFile imagen) {
        portafolioService.update(id, nombre, descripcion, urlrepo, lenguajes, imagen);
    }

    @DeleteMapping("/{id}")
    public void deletePortafolio(@PathVariable Integer id) {
        portafolioService.deletePortafolio(id);
    }
}
