import java.net.*;
import java.util.*;

import static java.lang.System.out;

public class Network {
    public static void main(String args[]) throws SocketException {
        Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
        for (NetworkInterface netint : Collections.list(nets))
            displayInterfaceInformation(netint);
    }

    static void displayInterfaceInformation(NetworkInterface netint) throws SocketException {
        out.println("Display name: " + netint.getDisplayName());
        out.println("Name: " + netint.getName());

        byte[] hardwareAddress = netint.getHardwareAddress();
        if (hardwareAddress != null) {
            String[] hexadecimalFormat = new String[hardwareAddress.length];
            for (int i = 0; i < hardwareAddress.length; i++) {
                hexadecimalFormat[i] = String.format("%02X", hardwareAddress[i]);
            }
            out.println("Mac: " + String.join("-", hexadecimalFormat));
        }
        Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();
        for (InetAddress inetAddress : Collections.list(inetAddresses)) {
            out.println("InetAddress: " + inetAddress);
        }
        out.println("\n");
    }
}
