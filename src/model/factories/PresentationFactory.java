package model.factories;

import model.RuNode;
import model.RuNodeComposite;
import model.nodeModels.Presentation;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;



public class PresentationFactory extends AbstractNodeFactory{
    Image image=null;
    @Override
    public RuNode createNode(RuNode ruNode) {

        try {
             image= ImageIO.read(new File("src/controller/icons/info32x32.png"));
        }catch (Exception e){
            e.printStackTrace();
        }

        return new Presentation("Prezentacija",(RuNodeComposite) ruNode,"aa", image);
    }
}
