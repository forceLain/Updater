package etr.updater;


public class AndroidApkFile {
    private String id;
    private String name;
    private int version;
    private String versionName;
    private String cheksum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getCheksum() {
        return cheksum;
    }

    public void setCheksum(String cheksum) {
        this.cheksum = cheksum;
    }
}
