package model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DispositivosUsbModel {
    private List<String> dispositivos;
}
