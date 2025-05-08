package Sockets.exo2;


import java.io.Serializable;

public class Dns implements Serializable {
    private String dnsAde , dnsStr;

    public Dns(String dnsAde, String dnsStr) {
        this.dnsAde = dnsAde;
        this.dnsStr = dnsStr;
    }

    public String getDnsAde() {
        return dnsAde;
    }

    public void setDnsAde(String dnsAde) {
        this.dnsAde = dnsAde;
    }

    public String getDnsStr() {
        return dnsStr;
    }

    public void setDnsStr(String dnsStr) {
        this.dnsStr = dnsStr;
    }

    @Override
    public String toString() {
        return "Dns{" +
                "dnsAde='" + dnsAde + '\'' +
                ", dnsStr='" + dnsStr + '\'' +
                '}';
    }
}
