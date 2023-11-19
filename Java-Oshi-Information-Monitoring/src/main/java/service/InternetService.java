package service;

import component.SystemComponent;
import mapper.InternetMapper;
import model.InternetModel;
import oshi.hardware.NetworkIF;

public class InternetService {
    public static InternetModel getInternet() {
        return InternetMapper.toMapper(getNetworkIF());
    }

    private static NetworkIF getNetworkIF() {
        return SystemComponent.getInstance().getHardware().getNetworkIFs().get(0);
    }
}
