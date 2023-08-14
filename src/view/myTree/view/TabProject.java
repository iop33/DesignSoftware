package view.myTree.view;

import model.RuNode;
import model.nodeModels.Presentation;
import model.nodeModels.Project;
import model.nodeModels.Workspace;
import observer.Subscriber;
import view.MainFrame;

import javax.swing.*;
import java.util.ArrayList;

public class TabProject extends JTabbedPane implements Subscriber {

    JLabel ime = new JLabel();
    Project pr;
    ArrayList<TabPresentation>tpLista;
    Workspace pom;
    JScrollPane scp;
    public TabProject(Project pr) {


        this.pr=pr;
        this.pom= (Workspace) pr.getParent();
        pom.addSubscriber(this);
        this.tpLista=new ArrayList<>();
        this.ime.setText(pr.getIme());

        pr.addSubscriber(this);
        for(RuNode p:pr.getNodeChildren()){
            scp = new JScrollPane();
            TabPresentation tp = new TabPresentation((Presentation) p);
            tpLista.add(tp);
            scp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            scp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            scp.setLayout(new ScrollPaneLayout());
            scp.setViewportView(tp);
            addTab(p.getIme(),scp);
        }

    }

    public JScrollPane getScp() {
        return scp;
    }

    public void setScp(JScrollPane scp) {
        this.scp = scp;
    }

    public Project getPr() {
        return pr;
    }

    public void setPr(Project pr) {
        this.pr = pr;
    }

    public ArrayList<TabPresentation> getTpLista() {
        return tpLista;
    }

    public void setTpLista(ArrayList<TabPresentation> tpLista) {
        this.tpLista = tpLista;
    }

    @Override
    public void update(Object notification) {


        if(notification instanceof Workspace){
            MainFrame.getinstance().getSp().setRightComponent(new JPanel());
            this.getPr().removeSubscriber(this);
            this.revalidate();
            this.repaint();
            SwingUtilities.updateComponentTreeUI(MainFrame.getinstance().getMyTree());
            return;
        }

        if(notification instanceof Project) {
            Project p = (Project) notification;
            TabWorkspace novi= (TabWorkspace) this.getParent();
            if(novi.getLbIme().getText()!=p.getIme()){
                novi.getLbIme().setText(p.getIme());
                novi.revalidate();
                novi.repaint();
                SwingUtilities.updateComponentTreeUI(MainFrame.getinstance().getMyTree());
                return;
            }

            for (int i = 0; i < this.getTabCount(); i++) {
                if (!(p.getNodeChildren().contains(tpLista.get(i).getP()))) {
                    this.removeTabAt(i);
                    MainFrame.getinstance().getSp().revalidate();
                    MainFrame.getinstance().getSp().repaint();
                    this.revalidate();
                    this.repaint();
                    tpLista.get(i).getP().removeSubscriber(this);
                    tpLista.remove(i);
                    return;
                }
            }

            Presentation zadnji = (Presentation)p.getNodeChildren().get(p.getNodeChildren().size()-1);
            int flag = 0;
            for (int i = 0; i < this.getTabCount(); i++) {
                if (this.getTpLista().get(i).getP().equals(zadnji)) {
                    flag = 1;
                }
            }
            if (flag == 0) {
                JScrollPane scp = new JScrollPane();
                TabPresentation tp = new TabPresentation((Presentation) zadnji);
                tpLista.add(tp);
                scp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                scp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                scp.setLayout(new ScrollPaneLayout());
                scp.setViewportView(tp);
                addTab(zadnji.getIme(), scp);
                zadnji.addSubscriber(this);
                this.revalidate();
                this.repaint();
            } else {
                flag = 0;
            }






        }




    }
}
