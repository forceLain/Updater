package etr.updater;

import net.erdfelt.android.apk.AndroidApk;

import java.io.File;
import java.io.IOException;

class InfoProcessor extends Processor {
    public void process(String[] args) {
        if (args.length < 2 || args[1] == null) {
            System.out.println("APK file argument is missing");
            printHelpSuggestion();
            return;
        }

        File file = new File(args[1]);

        if (!file.exists()) {
            System.out.println("File " + file + " not found");
            return;
        }

        if (file.isDirectory()) {
            parseDir(file);
        } else {
            parseFile(file);
        }
    }

    private static void parseDir(File dir) {
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.getName().endsWith(".apk")) {
                parseFile(file);
            }
        }
    }

    private static void parseFile(File apkfile) {
        try {
            AndroidApk apk = new AndroidApk(apkfile);
            System.out.println("APK: " + apkfile);
            System.out.println("  .packageName    = " + apk.getPackageName());
            System.out.println("  .appVersion     = " + apk.getAppVersion());
            System.out.println("  .appVersionCode = " + apk.getAppVersionCode());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
