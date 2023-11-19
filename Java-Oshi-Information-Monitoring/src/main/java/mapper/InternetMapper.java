package mapper;

import model.InternetModel;
import oshi.hardware.NetworkIF;
import oshi.util.FormatUtil;

public class InternetMapper {
    public static InternetModel toMapper(NetworkIF networkIF) {
        return new InternetModel(
                networkIF.getName() + " | " + networkIF.getDisplayName(),
                networkIF.getMacaddr(),
                String.valueOf(networkIF.getMTU()),
                FormatUtil.formatValue(networkIF.getSpeed(), "bps"),
                networkIF.getIPv4addr()[0],
                networkIF.getIPv6addr()[0],
                getRecebimento(networkIF),
                getTranferencia(networkIF)
        );
    }

    private static String getRecebimento(NetworkIF networkIF) {
        boolean tranferindo = estaTransferindo(networkIF);

        return String.format(
                "%s/%s%s",
                tranferindo ? networkIF.getPacketsRecv() + " pacotes" : "?",
                tranferindo ? FormatUtil.formatBytes(networkIF.getBytesRecv()) : "?",
                tranferindo ? " (" + networkIF.getInErrors() + " erros)" : ""
        );
    }

    private static String getTranferencia(NetworkIF networkIF) {
        boolean tranferindo = estaTransferindo(networkIF);

        return String.format(
                "%s/%s%s",
                tranferindo ? networkIF.getPacketsSent() + " pacotes" : "?",
                tranferindo ? FormatUtil.formatBytes(networkIF.getBytesSent()) : "?",
                tranferindo ? " (" + networkIF.getOutErrors() + " erros)" : ""
        );
    }

    private static boolean estaTransferindo(NetworkIF networkIF) {
        return  networkIF.getBytesRecv() > 0 || networkIF.getBytesSent() > 0 ||
                networkIF.getPacketsRecv() > 0 || networkIF.getPacketsSent() > 0;
    }
}
