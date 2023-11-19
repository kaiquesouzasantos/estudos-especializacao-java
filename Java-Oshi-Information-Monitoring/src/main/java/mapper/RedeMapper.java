package mapper;

import model.RedeModel;
import oshi.software.os.NetworkParams;

import java.util.Arrays;

public class RedeMapper {
    public static RedeModel toMapper(NetworkParams networkParams) {
        return new RedeModel(
                networkParams.getDomainName(),
                networkParams.getHostName(),
                networkParams.getIpv4DefaultGateway(),
                networkParams.getIpv6DefaultGateway(),
                Arrays.toString(networkParams.getDnsServers())
        );
    }

}
