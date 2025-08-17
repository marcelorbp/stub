package ie.pensionsauthority.core.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.LoaderOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Loads the runtime configuration from the file specified by the system property 'runConfig'.
 *
 * @return a populated RunConfig instance
 * @throws IOException if loading or parsing the YAML fails
 */
public class ConfigLoader {

    private static final Logger logger = LoggerFactory.getLogger(ConfigLoader.class);
    private static final String CONFIG_PROPERTY = "runConfig";

    private ConfigLoader() {
        // Prevent instantiation
    }

    public static RunConfig load() throws IOException {
		String path = System.getProperty(CONFIG_PROPERTY);
        logger.debug("Loading configuration from: {}", path);
        
        if (path == null || path.isBlank()) {
            throw new IllegalArgumentException("Missing system property: runConfig. Either build with -DrunConfig=<path to config.yml> or update <properties.runConfig> inside pom.xml");
			
        }



        LoaderOptions loaderOptions = new LoaderOptions();

        try (InputStream input = new FileInputStream(path)) {
            Constructor constructor = new Constructor(RunConfig.class, loaderOptions);
            Yaml yaml = new Yaml(constructor);
            RunConfig config = yaml.load(input);
            if (config == null) {
                throw new IllegalStateException("Parsed config is null. Check the content or format of the YAML file.");
            }
            return config;
        } catch (IOException | YAMLException e) {
            throw new IOException("Failed to load or parse configuration from: " + path, e);
        }
    }
}
