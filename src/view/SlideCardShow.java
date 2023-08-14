package view;

import model.presStates.ReturnState;
import model.nodeModels.Presentation;
import view.myTree.view.TabPresentation;
import view.myTree.view.TabSlide;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SlideCardShow extends JPanel {

    private JButton btPrevious=new JButton("Previous");
    private JButton btClose=new JButton("Close");
    private JButton btNext=new JButton("Next");
    private JLabel lbIme=new JLabel();
    private TabPresentation tp;
    private JPanel cardLayoutPanel=new JPanel();
    private int maxSlide;
    private int currSlide;
    private JPanel centralni=new JPanel(new FlowLayout());
    private JPanel kard=new JPanel();

    public SlideCardShow(Presentation p) {
        this.lbIme.setText(p.getIme());
        this.setLayout(new BorderLayout());
        this.add(lbIme,BorderLayout.NORTH);
        cardLayoutPanel.setLayout(new CardLayout());
        tp=new TabPresentation(p);
        this.maxSlide=p.getNodeChildren().size();
        this.currSlide=0;
        for(Component c : tp.getComponents()){
            if(c instanceof TabSlide){
                cardLayoutPanel.add(c);
                ((TabSlide) c).getSlajd().getParent().removeSubscriber((TabSlide)c);
            }
        }
        kard.add(cardLayoutPanel);
        centralni.add(btPrevious);
        centralni.add(kard);
        centralni.add(btNext);
        centralni.add(btClose);
        this.add(centralni,BorderLayout.CENTER);
        btClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //p.setPs(new ReturnState());
                tp.setReturnState();

            }
        });
        btPrevious.setEnabled(false);
        btPrevious.addActionListener(e -> {
            CardLayout cardLayout= (CardLayout) cardLayoutPanel.getLayout();
            cardLayout.previous(cardLayoutPanel);
            currSlide--;
            cardLayoutPanel.repaint();
            cardLayoutPanel.revalidate();
            if(currSlide==0){
                btPrevious.setEnabled(false);
            }
            if(currSlide==maxSlide-1){
                btNext.setEnabled(true);
            }
        });

        btNext.addActionListener(e -> {
            CardLayout cardLayout= (CardLayout) cardLayoutPanel.getLayout();
            cardLayout.next(cardLayoutPanel);
            currSlide++;
            cardLayoutPanel.revalidate();
            cardLayoutPanel.repaint();
            if(currSlide==maxSlide){
                btNext.setEnabled(false);
            }
            if(currSlide==1){
                btPrevious.setEnabled(true);
            }
        });

        kard.add(cardLayoutPanel);
        centralni.add(btPrevious);
        centralni.add(btNext);
        centralni.add(kard);
        centralni.add(btClose);
        this.add(centralni,BorderLayout.CENTER);
        this.setVisible(true);

    }

    public TabPresentation getTp() {
        return tp;
    }

    public void setTp(TabPresentation tp) {
        this.tp = tp;
    }
}
