package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InternetModel {
    private String nome, mac, mtu, velocidade, ipv4, ipv6, recebimento, tranferencia;
}
