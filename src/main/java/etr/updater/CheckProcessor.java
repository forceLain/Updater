package etr.updater;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import net.erdfelt.android.apk.AndroidApk;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

class CheckProcessor extends Processor {
    void process(String[] args) {
        if (args.length < 3 || args[1] == null || args[2] == null) {
            System.out.println("Missing arguments");
            printHelpSuggestion();
            return;
        }

        compare(args[1], args[2]);
    }

    //TODO compare versions from metafile and from apks

    private void compare(String jsonFile, String directoryPath) {

        Gson gson = new Gson();
        List<AndroidApkFile> androidApkFileList = null;
        try {
            androidApkFileList = gson.fromJson(new FileReader(jsonFile), new TypeToken<List<AndroidApkFile>>() {
            }.getType());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (AndroidApkFile androidApkFile : androidApkFileList) {
            boolean isApkFileFound = false;
            File[] apkList = (new File(directoryPath).listFiles());
            for (File apkFile : apkList) {
                if (apkFile.getName().contains(androidApkFile.getId())) {
                    isApkFileFound = true;
                    AndroidApk apk = null;
                    try {
                        apk = new AndroidApk(apkFile);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (androidApkFile.getVersion() == (Integer.parseInt(apk.getAppVersionCode()))) {
                        System.out.println("version apk " + apk.getPackageName() + " ident version in metafiles " + jsonFile);
                    } else
                        System.out.println("version apk " + apk.getPackageName() + " not ident version in metafiles " + jsonFile);
                }
            }
            if (!isApkFileFound) {
                System.out.println(androidApkFile.getId() + " is not found!");
            }
        }

    }
}


