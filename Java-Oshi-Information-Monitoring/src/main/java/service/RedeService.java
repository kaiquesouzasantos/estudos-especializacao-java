package service;

import component.SystemComponent;
import mapper.RedeMapper;
import model.RedeModel;
import oshi.software.os.NetworkParams;

public class RedeService {
    public static RedeModel getRede() {
        return RedeMapper.toMapper(getNetworkParams());
    }

    private static NetworkParams getNetworkParams() {
        return SystemComponent.getInstance().getOperatingSystem().getNetworkParams();
    }
}
