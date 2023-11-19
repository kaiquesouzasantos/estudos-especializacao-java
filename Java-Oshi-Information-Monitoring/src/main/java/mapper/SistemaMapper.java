package mapper;

import model.SistemaModel;

import oshi.software.os.OperatingSystem;

public class SistemaMapper {
    public static SistemaModel toMapper(OperatingSystem operatingSystem) {
        return new SistemaModel(
                operatingSystem.getManufacturer(),
                operatingSystem.getFamily(),
                operatingSystem.getVersionInfo().getVersion(),
                operatingSystem.getSystemBootTime() + "s",
                operatingSystem.getSystemUptime() + "s",
                operatingSystem.getBitness(),
                operatingSystem.getThreadCount(),
                operatingSystem.getProcessCount(),
                operatingSystem.getFileSystem().getOpenFileDescriptors(),
                operatingSystem.getFileSystem().getMaxFileDescriptors()
        );
    }
}
