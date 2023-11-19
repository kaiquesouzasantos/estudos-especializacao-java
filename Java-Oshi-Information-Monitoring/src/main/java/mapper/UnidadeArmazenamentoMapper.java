package mapper;

import model.UnidadeArmazenamentoModel;
import oshi.hardware.HWPartition;
import oshi.software.os.OSFileStore;
import oshi.util.FormatUtil;

import java.util.ArrayList;
import java.util.List;

public class UnidadeArmazenamentoMapper {
    public static UnidadeArmazenamentoModel toMapper(OSFileStore fileStore) {
        return new UnidadeArmazenamentoModel(
                fileStore.getName(),
                fileStore.getMount(),
                fileStore.getLabel(),
                FormatUtil.formatBytes(fileStore.getFreeSpace()),
                FormatUtil.formatBytes(fileStore.getTotalSpace())
        );
    }

    public static List<UnidadeArmazenamentoModel> toMapper(List<OSFileStore> fileStoreList) {
        List<UnidadeArmazenamentoModel> armazenamentoModelList = new ArrayList<>();

        fileStoreList.forEach(
                fileStore -> armazenamentoModelList.add(toMapper(fileStore))
        );

        return armazenamentoModelList;
    }
}
