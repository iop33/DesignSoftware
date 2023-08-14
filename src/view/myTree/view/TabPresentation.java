package view.myTree.view;

import model.RuNode;
import model.nodeModels.Presentation;
import model.nodeModels.Slide;
import model.presStates.PresentationStateManager;
import observer.Subscriber;
import javax.swing.*;
import java.awt.*;

public class TabPresentation extends JPanel implements Subscriber {
    Presentation p;
    JLabel lbAutor = new JLabel();
    JScrollPane sp;
    JPanel autor = new JPanel();
    PresentationStateManager presentationStateManager;

    public TabPresentation(Presentation p) {
        this.p = p;
        p.addSubscriber(this);
        this.lbAutor.setText(p.getAutor());
        autor.add(lbAutor);
        autor.setSize(new Dimension(400, 5));
        autor.setMaximumSize(new Dimension(400,5));
        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(boxLayout);
        this.add(autor);
        presentationStateManager=new PresentationStateManager();


        for (RuNode s : p.getNodeChildren()) {
            Slide sn = (Slide) s;
            TabSlide ts = new TabSlide(sn);
            ts.setMinimumSize(new Dimension(400,350));
            ts.setPreferredSize(new Dimension(400,350));
            this.add(ts);
            this.add(Box.createRigidArea(new Dimension(0, 10)));
        }


        this.add(Box.createVerticalGlue());

        this.revalidate();
        this.repaint();

    }

    @Override
    public void update(Object notification) {
        Presentation p = (Presentation)notification;
        this.lbAutor.setText(p.getAutor());
        int br=0;
        for(Component c:this.getComponents()){
            if(c instanceof TabSlide){
                br++;
                TabSlide ts= (TabSlide) c;
                ts.repaint();
            }
        }

        if(p.getNodeChildren().size()>br){
            Slide s=(Slide)p.getNodeChildren().get(p.getNodeChildren().size()-1);
            TabSlide ts=new TabSlide(s);
            ts.setMinimumSize(new Dimension(400,350));
            ts.setPreferredSize(new Dimension(400,350));
            p.addSubscriber(this);
            this.add(ts);
            this.add(Box.createRigidArea(new Dimension(0, 10)));
            if(this.getParent().getParent().getParent() instanceof TabWorkspace){
                ((TabWorkspace) this.getParent().getParent().getParent()).refreshTab(this);
            }
            this.revalidate();
            this.repaint();
        }



        if(this.getParent().getParent().getParent()instanceof TabProject){
            TabProject tap=(TabProject) this.getParent().getParent().getParent();
            for(int i=0;i<tap.getTabCount();i++) {
                if (tap.getTpLista().get(i).getP().equals(p)) {
                    if (tap.getTitleAt(i) != p.getIme()) {
                        tap.setTitleAt(i, p.getIme());
                        this.revalidate();
                        this.repaint();
                    }
                }
            }
        }




    }



    public Presentation getP() {
        return p;
    }

    public void setP(Presentation p) {
        this.p = p;
    }

    public JLabel getLbAutor() {
        return lbAutor;
    }

    public void setLbAutor(JLabel lbAutor) {
        this.lbAutor = lbAutor;
    }

    public JScrollPane getSp() {
        return sp;
    }

    public void setSp(JScrollPane sp) {
        this.sp = sp;
    }

    public PresentationStateManager getPresentationStateManager() {
        return presentationStateManager;
    }

    public void setPresentationStateManager(PresentationStateManager presentationStateManager) {
        this.presentationStateManager = presentationStateManager;
    }
    public void setReturnState(){
        this.presentationStateManager.setReturnState();
        action();
    }
    public void setShowState(){
        this.presentationStateManager.setShowState();
        action();
    }
    public void action(){
        this.presentationStateManager.getCurrState().changeState(getP());
    }
}
