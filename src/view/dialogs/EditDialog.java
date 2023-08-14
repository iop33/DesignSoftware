package view.dialogs;

import model.RuNodeComposite;
import model.nodeModels.Presentation;
import view.MainFrame;
import view.MyErrorHandler;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EditDialog extends JDialog {

    JTextField tfAutor;
    BufferedImage i;
    RuNodeComposite selektovan;
    public EditDialog( RuNodeComposite selektovan) {
        this.setTitle("Edit dialog");
        this.setModal(true);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setResizable(false);
        this.selektovan=selektovan;
        Dimension d=new Dimension(100,30);
        JPanel pomocni=new JPanel();
        JPanel glavni=new JPanel();
        JPanel donji=new JPanel();
        donji.setLayout(new FlowLayout());
        JLabel lbAutor=new JLabel("Autor: ");
        JButton btOk=new JButton("Ok");
        lbAutor.setPreferredSize(d);
        btOk.setPreferredSize(d);
        tfAutor=new JTextField(((Presentation)selektovan).getAutor());
        tfAutor.setPreferredSize(d);
        glavni.setLayout(new BoxLayout(glavni,BoxLayout.Y_AXIS));
        JButton btChoose=new JButton("Browse");
        i= (BufferedImage) ((Presentation) selektovan).getSlika();
        btChoose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc=new JFileChooser();
                int val= fc.showOpenDialog(fc);
                if(val==JFileChooser.APPROVE_OPTION){

                    File file= fc.getSelectedFile();
                    try {
                        i= ImageIO.read(file);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                }
            }
        });
        btOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(i!=null) {
                    String autor = getTfAutor().getText();
                    ((Presentation) selektovan).setAutor(tfAutor.getText());
                    ((Presentation) selektovan).setSlika(i);

                    dispose();
                }
                else{
                    MyErrorHandler.getInstance().errorSetting("GRESKA PRI DODAVANJU SLIKE","NISTE ODABRALI SLIKU","ODABERITE FAJL",1);
                }
            }
        });
        btChoose.setPreferredSize(d);
        glavni.add(pomocni);
        glavni.add(donji);
        glavni.add(Box.createVerticalStrut(50));
        donji.add(btOk);
        donji.add(btChoose);
        pomocni.setLayout(new FlowLayout());
        pomocni.add(lbAutor);
        pomocni.add(tfAutor);
        this.add(glavni);
        this.setSize(450,220);
        this.setLocationRelativeTo(MainFrame.getinstance());
        this.setVisible(true);


    }



    public JTextField getTfAutor() {
        return tfAutor;
    }

    public void setTfAutor(JTextField tfAutor) {
        this.tfAutor = tfAutor;
    }

    public BufferedImage getI() {
        return i;
    }

    public void setI(BufferedImage i) {
        this.i = i;
    }
}
