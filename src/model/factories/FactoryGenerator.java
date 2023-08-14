package model.factories;

import model.RuNode;
import model.nodeModels.Presentation;
import model.nodeModels.Project;
import model.nodeModels.Workspace;

public class FactoryGenerator {

    ProjectFactory projectFactory=new ProjectFactory();
    PresentationFactory presentationFactory=new PresentationFactory();
    SlideFactory slideFactory=new SlideFactory();
    RuNode ruNode;

    public FactoryGenerator(RuNode ruNode) {
        this.ruNode = ruNode;
    }
    public AbstractNodeFactory getAbstractNodeFactory(RuNode ruNode){
        if(ruNode instanceof Workspace){
            return projectFactory;
        }
        if(ruNode instanceof Project){
            return presentationFactory;
        }
        if(ruNode instanceof Presentation){
            return  slideFactory;
        }
        else {
            return null;
        }
    }
}
