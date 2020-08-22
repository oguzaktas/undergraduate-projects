import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped // girilen bilgilerin ne kadar sure tutulmasi gerektigini belirti
public class ManagedBeanSinif {
    String isim;
    String adres;
    String il;
    String parola;
    List<String> cinsiyet = new ArrayList<String>();
    String ehliyetvarmi;
    boolean kabuledildimi;
    String mesaj;
    
    public String getIsim() {
        return isim;
    }

    public String getAdres() {
        return adres;
    }

    public String getIl() {
        return il;
    }

    public String getParola() {
        return parola;
    }

    public List<String> getCinsiyet() {
        return cinsiyet;
    }

    public String getEhliyetvarmi() {
        return ehliyetvarmi;
    }

    public boolean isKabuledildimi() {
        return kabuledildimi;
    }

    public String getMesaj() {
        if(!kabuledildimi) {
            mesaj = "Sartlari kabul etmediniz.";
        } else {
            mesaj = "Sartlari kabul ettiniz.";
        }
        return mesaj;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public void setIl(String il) {
        this.il = il;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public void setCinsiyet(List<String> cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public void setEhliyetvarmi(String ehliyetvarmi) {
        this.ehliyetvarmi = ehliyetvarmi;
    }

    public void setKabuledildimi(boolean kabuledildimi) {
        this.kabuledildimi = kabuledildimi;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }
    
}
