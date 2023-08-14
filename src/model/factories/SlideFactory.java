package model.factories;

import model.RuNode;
import model.RuNodeComposite;
import model.nodeModels.Presentation;
import model.nodeModels.Slide;

import javax.swing.tree.DefaultMutableTreeNode;

public class SlideFactory extends AbstractNodeFactory{

    @Override
    public RuNode createNode(RuNode ruNode) {
        return new Slide("Slajd " + (((Presentation)ruNode).getNodeChildren().size()+1), (RuNodeComposite) ruNode);
    }
}
