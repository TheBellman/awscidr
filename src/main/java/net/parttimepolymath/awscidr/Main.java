package net.parttimepolymath.awscidr;

import org.apache.commons.cli.*;

/**
 * This main class is the entry point which provides the command line interface via commons-cli.
 *
 * @author Robert Hook
 * @since 2021-03-06
 */
public class Main {

    /**
     * provide a command line interface.
     *
     * @param args the command line arguments, assumed non null but possibly empty.
     */
    public static void main(final String[] args) {
        Options options = options();
        try {
            CommandLine line = new DefaultParser().parse(options, args);

            if (line.hasOption('?') || (line.hasOption('g') && !line.hasOption('f'))) {
                help(options);
            }
            else if (line.hasOption('v')) {
                System.out.println(ApplicationProperties.getDescription());
            }
            else
            {
                Application instance=Application.builder()
                        .servicesMode(line.hasOption('s'))
                        .regionsMode(line.hasOption('r'))
                        .regionFilter(line.getOptionValue('f'))
                        .serviceFilter(line.getOptionValue('g'))
                        .ipv6(line.hasOption('6'))
                        .build();
                instance.run();
            }
        } catch (ParseException ex) {
            help(options);
        }
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
        options.addOption(Option.builder("r").longOpt("regions").desc("list regions").build());
        options.addOption(Option.builder("s").longOpt("services").desc("list services (ignored if 'r' specified)").build());
        options.addOption(Option.builder("6").longOpt("ipv6").desc("use ipv6 ranges instead of ipv4").build());

        options.addOption(Option.builder("f").longOpt("fr").desc("filter by region").hasArg().numberOfArgs(1).argName("region").build());
        options.addOption(Option.builder("g").longOpt("fs").desc("filter by service - required region as well").hasArg().argName("service").numberOfArgs(1).build());

        options.addOption(Option.builder("v").longOpt("version").desc("print version").build());
        options.addOption((Option.builder("?").longOpt("help").desc("print this help message").build()));

        return options;
    }
}
