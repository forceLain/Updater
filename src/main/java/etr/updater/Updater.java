package etr.updater;

import java.util.HashMap;
import java.util.Map;

public class Updater {

    static final String ARG_HELP = "-h";
    static final String ARG_INFO = "-i";
    static final String ARG_CHECK = "-check";

    private static final Map<String, Processor> PROCESSORS = new HashMap<String, Processor>();

    static {
        PROCESSORS.put(ARG_HELP, new HelpProcessor());
        PROCESSORS.put(ARG_INFO, new InfoProcessor());
        PROCESSORS.put(ARG_CHECK, new CheckProcessor());
    }

    public static void main(String[] args) {

        if (args == null || args.length == 0) {
            System.out.println("You have not provided arguments");
            new SimpleProcessor().printHelpSuggestion();
            return;
        }

        String mainArg = args[0];

        Processor processor = PROCESSORS.get(mainArg);
        if (processor != null) {
            processor.process(args);
        } else {
            System.out.println("Unknown arguments");
        }
    }
}
