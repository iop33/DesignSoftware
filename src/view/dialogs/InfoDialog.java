package view.dialogs;

import view.MainFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class InfoDialog extends JDialog {
    MainFrame mf;
    public InfoDialog(MainFrame m) {

        this.mf=m;
        this.setTitle("InfoDialog");
        JLabel lbIme= new JLabel("Ime: Mateja");
        JLabel lbPrezime= new JLabel("Prezime: Civkaroski");
        JLabel lbIndeks= new JLabel("Indeks: RN75/20");
        BufferedImage img=null;
        try {
            img= ImageIO.read(new File("src/view/dialogs/dialogIcons/profil.jpg"));


        }catch (IOException e){
            System.err.println("Greska pri ucitavanju ikonice");
        }
        Image imSkala=img.getScaledInstance(50,100,Image.SCALE_DEFAULT);
        JPanel pomoc=new JPanel();
        JLabel lbSlika=new JLabel();
        lbSlika.setIcon(new ImageIcon(imSkala));
        JPanel pNovi=new JPanel();
        pNovi.setLayout(new FlowLayout());
        pNovi.add(lbSlika);
        pNovi.add(pomoc);
        pomoc.setLayout(new BoxLayout(pomoc,BoxLayout.Y_AXIS));
        pomoc.add(lbIme);
        pomoc.add(lbPrezime);
        pomoc.add(lbIndeks);
        this.add(pNovi);
        this.setSize(450,220);
        this.setVisible(true);
        this.setModal(true);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(mf);
        this.setResizable(false);
        BufferedImage ic=null;
        try {
            ic=ImageIO.read(new File("src/view/dialogs/dialogIcons/info32x32.png"));

        }catch (IOException e){
            System.err.println("Greska pri ucitavanju slike");

        }
        this.setIconImage(ic);




    }
}
