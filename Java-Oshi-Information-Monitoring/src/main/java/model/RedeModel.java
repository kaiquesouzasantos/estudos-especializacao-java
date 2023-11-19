package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RedeModel {
    private String dominio, hospedagem, ipv4, ipv6, servidoresDns;
}
