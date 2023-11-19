package component;

import oshi.SystemInfo;

public class SystemComponent {
    private static SystemInfo instance;

    public static SystemInfo getInstance() {
        if (instance == null)
            instance = new SystemInfo();

        return instance;
    }
}
