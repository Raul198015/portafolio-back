package portafolio.domain.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import portafolio.domain.models.Portafolio;
import portafolio.infra.repositories.PortafolioRepository;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PortafolioService {
    private final PortafolioRepository portafolioRepository;
    private final Cloudinary cloudinary;

    @Autowired
    public PortafolioService(PortafolioRepository portafolioRepository, Cloudinary cloudinary) {
        this.portafolioRepository = portafolioRepository;
        this.cloudinary = cloudinary;
    }

    public List<Portafolio> getPortafolio() {
        return portafolioRepository.findAll();
    }

    public Portafolio portafolioById(Integer id) {
        Optional<Portafolio> portafolioById = portafolioRepository.findById(id);
        return portafolioById.orElse(null);
    }

    public void newPortafolio(String nombre, String descripcion, String urlrepo, String lenguajes, MultipartFile imagen) throws IOException {
        Map uploadResult = cloudinary.uploader().upload(imagen.getBytes(), ObjectUtils.emptyMap());
        String imageUrl = (String) uploadResult.get("url");

        Portafolio portafolio = new Portafolio(nombre, descripcion, urlrepo, lenguajes, imageUrl);

        portafolioRepository.save(portafolio);
    }

    public void update(Integer id, String nombre, String descripcion, String urlrepo, String lenguajes, MultipartFile imagen) {
        Portafolio portafolioEncontrado = portafolioById(id);

        if (portafolioEncontrado != null) {
            try {
                Map uploadResult = cloudinary.uploader().upload(imagen.getBytes(), ObjectUtils.emptyMap());
                String imagenUrl = (String) uploadResult.get("url");

                portafolioEncontrado.setNombre(nombre);
                portafolioEncontrado.setDescripcion(descripcion);
                portafolioEncontrado.setUrlrepo(urlrepo);
                portafolioEncontrado.setLenguajes(lenguajes);
                portafolioEncontrado.setImagen(imagenUrl);

                portafolioRepository.save(portafolioEncontrado);
            } catch (IOException e) {


                throw new RuntimeException("Error al cargar la imagen", e);
            }

        }
    }

    public void deletePortafolio(Integer id) {
        boolean existe = portafolioRepository.existsById(id);
        if (existe) {
            portafolioRepository.deleteById(id);
        }
    }
}


