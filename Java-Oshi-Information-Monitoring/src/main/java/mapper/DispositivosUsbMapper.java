package mapper;

import model.DispositivosUsbModel;
import oshi.hardware.UsbDevice;

import java.util.Arrays;
import java.util.List;

public class DispositivosUsbMapper {
    public static DispositivosUsbModel toMapper(List<UsbDevice> deviceList) {
        return new DispositivosUsbModel(
                Arrays.stream(
                        deviceList
                                .toString()
                                .replaceAll("\\s+", " ")
                                .split("\\|--")
                ).map(
                        valor -> valor.replaceAll("\\[", "").replaceAll("\\]", "").trim()
                ).toList()
        );
    }
}
