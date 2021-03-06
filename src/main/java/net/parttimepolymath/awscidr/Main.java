package net.parttimepolymath.awscidr;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.cli.*;

/**
 * This main class is the entry point which provides the command line interface via commons-cli.
 * Note the use of the project lombok logging annotation.
 *
 * @author Robert Hook
 * @since 2021-03-06
 */
@Slf4j
public class Main {

    /**
     * provide a command line interface.
     *
     * @param args the command line arguments, assumed non null but possibly empty.
     */
    public static void main(final String[] args) {
        log.info("started");

        Options options = options();
        try {
            CommandLine line = new DefaultParser().parse(options, args);

            if (line.hasOption('?')) {
                help(options);
            } else {
                Application instance=Application.builder().build();
                instance.run();
            }
        } catch (ParseException ex) {
            help(options);
        }
        log.info("ended");
    }

    /**
     * print the command line help associated with the supplied options.
     *
     * @param options a non-null set of CLI options.
     */
    private static void help(final Options options) {
        HelpFormatter help = new HelpFormatter();
        help.printHelp(ApplicationProperties.getAppName(), options);
    }

    /**
     * construct the set of options for the command line.
     *
     * @return a non-null set of options.
     */
    private static Options options() {
        Options options = new Options();
//        options.addOption(Option.builder("m").longOpt("mode").desc("mode - either regions or services").hasArg().numberOfArgs(1).argName("mode").build());
        options.addOption((Option.builder("?").longOpt("help").desc("print this help message").build()));

        return options;
    }
}
