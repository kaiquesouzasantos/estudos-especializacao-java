package mapper;

import model.ArmazenamentoModel;
import oshi.hardware.HWDiskStore;
import oshi.software.os.OSFileStore;

import java.util.List;

public class ArmazenamentoMapper {
    public static ArmazenamentoModel toMapper(HWDiskStore diskStore, List<OSFileStore> fileStoreList) {
        return new ArmazenamentoModel(
                diskStore.getTransferTime() + " ms",
                UnidadeArmazenamentoMapper.toMapper(fileStoreList)
        );
    }

}
