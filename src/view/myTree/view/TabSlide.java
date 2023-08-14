package view.myTree.view;

import model.Slot;
import model.elemStates.MoveState;
import model.nodeModels.Presentation;
import model.nodeModels.Slide;
import observer.Subscriber;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.Serializable;
import java.util.ArrayList;

public class TabSlide extends JPanel implements Subscriber {

private Slide slajd;
private transient Image  slika;
private ArrayList<TabSlot>tabSlots=new ArrayList<>();
private TabSlot selectedTabSlot=null;


    public TabSlide(Slide slajd) {

        this.slajd=slajd;
        this.setSize(new Dimension(600,400));
        this.setMaximumSize(new Dimension(600,400));
        this.setPreferredSize(new Dimension(600,400));
        Presentation p= (Presentation) slajd.getParent();
        p.addSubscriber(this);
        this.slika=p.getSlika();
        this.add(new JLabel(slajd.getIme()));
        this.setVisible(true);
        for(Slot slot:slajd.getSlots()){
            this.tabSlots.add(new TabSlot(slot));
        }
        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                System.out.println("Pressed");
               /* if(getParent().getParent().getParent().getParent() instanceof TabProject){
                    System.out.println("greska");
                    return;
                }*/
                System.out.println("Ide dalje");
                super.mousePressed(e);
                TabPresentation tabPresentation= (TabPresentation) getParent();
                Presentation presentation=tabPresentation.getP();
                if(presentation.getElementState() instanceof MoveState){
                    for(TabSlot tabSlot:getTabSlots()){
                        if(tabSlot.getSlot().getShape().contains(e.getPoint())){
                            selectedTabSlot=tabSlot;
                            break;
                        }
                    }
                }
                else{
                    System.out.println("Pozivam metodu");
                    presentation.getElementState().mousePressed((TabSlide) e.getComponent(),e);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                selectedTabSlot=null;
                Presentation presentation= (Presentation) slajd.getParent();
                if(presentation.getElementState() instanceof MoveState){
                    presentation.getElementState().mouseReleased((TabSlide) e.getComponent(),e);

                } else{
                    //System.out.println("Pozivam metodu2");
                   // presentation.getElementState().elementAction((TabSlide) e.getComponent(),e);
                }
            }

        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Presentation presentation= (Presentation) slajd.getParent();
                if(presentation.getElementState() instanceof MoveState){
                    presentation.getElementState().mouseDragged((TabSlide) e.getComponent(),e);
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
            }
        });

    }

    public Image getSlika() {
        return slika;
    }

    public void setSlika(Image slika) {
        this.slika = slika;
    }

    public Slide getSlajd() {
        return slajd;
    }

    public void setSlajd(Slide slajd) {
        this.slajd = slajd;
    }

    public ArrayList<TabSlot> getTabSlots() {
        return tabSlots;
    }

    public void setTabSlots(ArrayList<TabSlot> tabSlots) {
        this.tabSlots = tabSlots;
    }

    public TabSlot getSelectedTabSlot() {
        return selectedTabSlot;
    }

    public void setSelectedTabSlot(TabSlot selectedTabSlot) {
        this.selectedTabSlot = selectedTabSlot;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D)g;
        if(this.slika==null)return;
       Image sl = (Image)this.getSlika().getScaledInstance(this.getWidth(), this.getHeight(), 0);
        g2.drawImage(sl,0, 0, this.getWidth(),this.getHeight(), null);
        if(this.getParent().getLayout() instanceof CardLayout){

            g2.scale((double)this.getHeight()/400,(double)this.getWidth()/600);
        }


        else if(!(this.getParent().getParent().getParent().getParent() instanceof TabProject)){
            g2.scale(0.2,0.2);

        }

        for(TabSlot s:this.getTabSlots()){
            s.paint(g2);
        }

    }



    @Override
    public void update(Object notification) {

        Presentation pr=(Presentation) notification;
        if(pr.getSlika()!=this.slika){
            this.setSlika(pr.getSlika());
            repaint();
        }

        System.out.println(pr.getNodeChildren().size());
        Slide ss=this.getSlajd();
        JPanel pan=(JPanel)this.getParent();
        if(!(pr.getNodeChildren()).contains(ss)){
          int pom=0;
            for(int i=0;i<pan.getComponentCount();i++){
              if(pan.getComponent(i).equals(this)){
                  pom=i;
              }
          }
            pan.remove(pom);
            System.out.println("brisem");
           pan.revalidate();
           pan.repaint();
            pr.removeSubscriber(this);


        }


    }
}
