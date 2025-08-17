package ie.pensionsauthority.core.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Singleton-like holder for application configuration loaded at startup.
 */
public class ConfigHolder {
	private static final Logger logger = LoggerFactory.getLogger(ConfigHolder.class);
	private static final RunConfig CONFIG;

	static {
		RunConfig config = null;
		try {
			config = ConfigLoader.load();
		} catch (Exception e) {
			logger.error("Failed to load configuration", e);
			throw new RuntimeException("Failed to load config", e);
		}
		CONFIG = config;
	}

	private ConfigHolder() {
		// Prevent instantiation
	}

	public static RunConfig get() {
		return CONFIG;
	}
}