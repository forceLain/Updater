package etr.updater;

import static etr.updater.Updater.ARG_HELP;

abstract class Processor {
    abstract void process(String[] args);


    void printHelpSuggestion() {
        System.out.println("Use " + ARG_HELP + " to see available arguments");
    }
}
