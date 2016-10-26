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
        {
            comrare(args[1], args[2]);
        }
    }

    //TODO compare versions from metafile and from apks

    public void comrare(String jsonFile, String directoryPath) {

        Gson gson = new Gson();
        List<AndroidApk> androidApkList = null;
        try {
            androidApkList = gson.fromJson(new FileReader(jsonFile), new TypeToken<List<AndroidApk>>() {
            }.getType());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (AndroidApk androidApk : androidApkList) {
            Boolean flag = new Boolean(false);
            File[] apkList = (new File(directoryPath).listFiles());
//            System.out.println(androidApk);
            for (File apkFile : apkList) {
                if (apkFile.getName().contains(androidApk.getPackageName())) {
                    flag = true;
                    AndroidApk apk = null;
                    try {
                        apk = new AndroidApk(apkFile);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (androidApk.getAppVersion().equals(apk.getAppVersion())) {
                        System.out.println("version apk " + apk.getPackageName() + " ident version in metafiles " + jsonFile);
                    } else
                        System.out.println("version apk " + apk.getPackageName() + " not ident version in metafiles " + jsonFile);
                }
            }
            if (flag == false) {
                System.out.println(androidApk.getPackageName() + " is not found!");
            }
        }
    }
}


