package etr.updater;

class CheckProcessor extends Processor {
    void process(String[] args) {
        if (args.length < 3 || args[1] == null || args[2] == null) {
            System.out.println("Missing arguments");
            printHelpSuggestion();
            return;
        }

        //TODO compare versions from metafile and from apks
    }
}
