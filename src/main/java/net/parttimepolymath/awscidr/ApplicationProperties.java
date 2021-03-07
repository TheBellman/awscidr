package net.parttimepolymath.awscidr;

import java.util.Properties;

/**
 * convenience wrapper around the application properties with getter semantics.
 *
 * @author Robert Hook
 * @since 2020-05-16
 */
public final class ApplicationProperties {
    private static final Properties PROPERTIES = ResourceUtils.loadProperties("application.properties");

    /**
     * get the application name from application.name
     *
     * @return a non-null but possibly empty string.
     */
    public static String getAppName() {
        return PROPERTIES.getProperty("application.name", "");
    }

    /**
     * get the application version from application.version
     *
     * @return a non-null but possibly empty string.
     */
    public static String getVersion() {
        return PROPERTIES.getProperty("application.version", "");
    }

    /**
     * get the application build date from application.build.date
     *
     * @return a non-null but possibly empty string.
     */
    public static String getBuildDate() {
        return PROPERTIES.getProperty("application.build.date", "");
    }

    public static String getDescription() {
        return String.format("%s %s (%s)", getAppName(), getVersion(), getBuildDate());
    }
}
