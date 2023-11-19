package service;

import component.SystemComponent;
import mapper.DispositivosUsbMapper;
import model.DispositivosUsbModel;
import oshi.hardware.UsbDevice;

import java.util.List;

public class DispositivosUsbService {
    public static DispositivosUsbModel getDispositivos() {
        return DispositivosUsbMapper.toMapper(getUsbDevices());
    }

    private static List<UsbDevice> getUsbDevices() {
        return SystemComponent.getInstance().getHardware().getUsbDevices(true);
    }
}
