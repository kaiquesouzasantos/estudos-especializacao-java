package mapper;

import component.CalculadoraPorcentagemUso;
import model.MemoriaRamModel;
import oshi.hardware.GlobalMemory;
import oshi.util.FormatUtil;

public class MemoriaRamMapper {
    public static MemoriaRamModel toMapper(GlobalMemory globalMemory) {
        return new MemoriaRamModel(
                FormatUtil.formatBytes(globalMemory.getTotal()),
                FormatUtil.formatBytes(globalMemory.getAvailable()),
                CalculadoraPorcentagemUso.getPorcentagemUso(globalMemory.getTotal(), globalMemory.getAvailable()),
                UnidadeMemoriaRamMapper.toMapper(globalMemory.getPhysicalMemory())
        );
    }
}
