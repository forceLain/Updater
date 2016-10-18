package etr.updater;

import static etr.updater.Updater.ARG_CHECK;
import static etr.updater.Updater.ARG_INFO;
import static etr.updater.Updater.ARG_HELP;

class HelpProcessor extends Processor {

    public void process(String[] args) {
        System.out.println(ARG_HELP);
        System.out.println("prints this help message");
        System.out.println();
        System.out.println(ARG_INFO + " <file or directory>");
        System.out.println("Prints version name and version code of the apk file provided");
        System.out.println("If directory is specified, then prints information for every apk file in the directory");
        System.out.println();
        System.out.println(ARG_CHECK + " <metafile> <directory>");
        System.out.println("Reads metafile and check if corresponding apks in the directory have same version code and version name");
    }
}
