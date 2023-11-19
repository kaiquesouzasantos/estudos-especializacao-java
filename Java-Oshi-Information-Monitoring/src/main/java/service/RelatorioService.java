package service;

import mapper.RelatorioMapper;
import model.RelatorioModel;

public class RelatorioService {
    public static RelatorioModel getRelatorio() {
        return RelatorioMapper.toMapper();
    }
}
