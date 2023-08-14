package model.factories;

import model.RuNode;
import view.myTree.modal.MyTreeNode;



public abstract class AbstractNodeFactory {

        public RuNode getNodeFromTree(MyTreeNode myTreeNode){
              RuNode ruNode=myTreeNode.getNode();
              RuNode dete=createNode(ruNode);
              dete.setParent(ruNode);
              return dete;
        }
        public abstract RuNode createNode(RuNode ruNode);

}
