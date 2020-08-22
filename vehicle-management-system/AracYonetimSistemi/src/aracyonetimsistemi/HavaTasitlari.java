
package aracyonetimsistemi;

/**
 * Programlama Laboratuvari II Proje 2
 * @author Mehmet Oguz Aktas & Ebubekir Sit
 */
public interface HavaTasitlari extends Arac {
    
    @Override
    void hizlan(int hiz);
    @Override
    void yavasla(int hiz);
    @Override
    void dur();

}
