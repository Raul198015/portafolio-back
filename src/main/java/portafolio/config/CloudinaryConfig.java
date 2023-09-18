package portafolio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.cloudinary.Cloudinary;


import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {
    @Bean
    public Cloudinary getCloudinary() {
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "dxdenyj7s");
        config.put("api_key", "232623317232594");
        config.put("api_secret", "IrRippKJmVHAULSNwyMGsxZmWdc");
        config.put("secure", "true");

        return new Cloudinary(config);
    }
}

