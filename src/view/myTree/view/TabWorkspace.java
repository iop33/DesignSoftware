package view.myTree.view;

import model.nodeModels.Presentation;
import model.nodeModels.Slide;
import observer.Subscriber;
import view.MainFrame;
import view.SecondToolBar;
import view.SlideCardShow;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class TabWorkspace extends JPanel {


    private TabProject tp;
    private JLabel lbIme;
    private JScrollPane jsp;
    private SecondToolBar secondToolBar;

    public TabWorkspace( TabProject tp) {
        this.tp = tp;

        tp.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {

                System.out.println("uso je");

                    if(!(tp.getSelectedComponent() instanceof SlideCardShow)){
                        MainFrame.getinstance().setJMenuBar(MainFrame.getinstance().getMeni());
                        MainFrame.getinstance().add(MainFrame.getinstance().getTulbar(),BorderLayout.NORTH);
                        add(getSecondToolBar(),BorderLayout.EAST);
                        MainFrame.getinstance().revalidate();
                        MainFrame.getinstance().repaint();
                        if(!tp.getPr().getNodeChildren().isEmpty()){
                            changeTab( ((TabPresentation) ((JScrollPane) tp.getSelectedComponent()).getViewport().getView()));
                        }
                        else{
                            brisanje();
                        }
                    }
                    else{

                        remove(jsp);
                        MainFrame.getinstance().setJMenuBar(null);
                        MainFrame.getinstance().remove(MainFrame.getinstance().getTulbar());
                        remove(getSecondToolBar());
                        MainFrame.getinstance().revalidate();
                        MainFrame.getinstance().repaint();
                    }

            }
        });
        this.setLayout(new BorderLayout());
        if(tp!=null) {
            Presentation otvorena = ((TabPresentation) ((JScrollPane) tp.getSelectedComponent()).getViewport().getView()).getP();
            TabPresentation nova=new TabPresentation(otvorena);

            for(Component c:nova.getComponents()){
                c.setPreferredSize(new Dimension(120,80));
                c.setMinimumSize(new Dimension(120,80));
                c.setMaximumSize(new Dimension(120,80));
                nova.revalidate();
                nova.repaint();
            }
             jsp =new JScrollPane();
            jsp.setViewportView(nova);
            jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            this.add(jsp,BorderLayout.WEST);
        }
        lbIme=new JLabel();
        lbIme.setText(this.tp.getPr().getIme());
        this.add(lbIme,BorderLayout.NORTH);
        this.add(tp,BorderLayout.CENTER);
        revalidate();
        repaint();
        this.secondToolBar=new SecondToolBar();
        this.add(secondToolBar,BorderLayout.EAST);

    }

    public void refreshTab(TabPresentation tap){

        if(tap==null){
            return;
        }

        for(Component c:tap.getComponents()){
            c.setPreferredSize(new Dimension(120,80));
            c.setMinimumSize(new Dimension(120,80));
            c.setMaximumSize(new Dimension(120,80));
            tap.revalidate();
            tap.repaint();
        }
    }


    public void changeTab(TabPresentation tap){
        this.remove(jsp);
        if(tap==null){
            return;
        }
        TabPresentation novi=new TabPresentation(tap.getP());
        for(Component c:novi.getComponents()){
            c.setPreferredSize(new Dimension(120,80));
            c.setMinimumSize(new Dimension(120,80));
            c.setMaximumSize(new Dimension(120,80));
            novi.revalidate();
            novi.repaint();
        }
        jsp =new JScrollPane();
        jsp.setViewportView(novi);
        jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(jsp,BorderLayout.WEST);
        this.revalidate();
        this.repaint();

    }

public void brisanje(){
        this.remove(jsp);
        this.revalidate();
        this.repaint();
}


    public JLabel getLbIme() {
        return lbIme;
    }

    public void setLbIme(JLabel lbIme) {
        this.lbIme = lbIme;
    }


    public TabProject getTp() {
        return tp;
    }

    public void setTp(TabProject tp) {
        this.tp = tp;
    }

    public JScrollPane getJsp() {
        return jsp;
    }

    public void setJsp(JScrollPane jsp) {
        this.jsp = jsp;
    }

    public SecondToolBar getSecondToolBar() {
        return secondToolBar;
    }

    public void setSecondToolBar(SecondToolBar paletteBar) {
        this.secondToolBar = paletteBar;
    }
}
