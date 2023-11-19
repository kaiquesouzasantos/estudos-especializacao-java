package mapper;

import model.UnidadeMemoriaRamModel;
import oshi.hardware.PhysicalMemory;
import oshi.util.FormatUtil;

import java.util.ArrayList;
import java.util.List;

public class UnidadeMemoriaRamMapper {
    public static UnidadeMemoriaRamModel toMapper(PhysicalMemory physicalMemory) {
        return new UnidadeMemoriaRamModel(
                FormatUtil.formatBytes(physicalMemory.getCapacity()),
                FormatUtil.formatHertz(physicalMemory.getClockSpeed()),
                physicalMemory.getBankLabel(),
                physicalMemory.getManufacturer(),
                physicalMemory.getMemoryType()
        );
    }

    public static List<UnidadeMemoriaRamModel> toMapper(List<PhysicalMemory> physicalMemoryList) {
        List<UnidadeMemoriaRamModel> memoriaRamModelList = new ArrayList<>();

        physicalMemoryList.forEach(
                memory -> memoriaRamModelList.add(toMapper(memory))
        );

        return memoriaRamModelList;
    }
}
