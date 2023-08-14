package model.factories;

import model.RuNode;
import model.RuNodeComposite;
import model.nodeModels.Project;

public class ProjectFactory extends AbstractNodeFactory{
    @Override
    public RuNode createNode(RuNode ruNode) {
        return new Project("Projekat "+ (((RuNodeComposite)ruNode).getNodeChildren().size()+1), (RuNodeComposite) ruNode);
    }
}
