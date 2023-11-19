package service;

import component.SystemComponent;
import mapper.ArmazenamentoMapper;
import model.ArmazenamentoModel;
import oshi.hardware.HWDiskStore;
import oshi.software.os.OSFileStore;

import java.util.List;

public class ArmazenamentoService {
    public static ArmazenamentoModel getArmazenamento() {
        return ArmazenamentoMapper.toMapper(getDiskStore(), getOSFileStore());
    }

    private static HWDiskStore getDiskStore() {
        return SystemComponent.getInstance().getHardware().getDiskStores().get(0);
    }

    private static List<OSFileStore> getOSFileStore() {
        return SystemComponent.getInstance().getOperatingSystem().getFileSystem().getFileStores();
    }
}
