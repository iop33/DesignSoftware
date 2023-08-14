package view.dialogs;

import controller.SerializableStrokeAdapter;
import view.myTree.view.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseStrokeDialog extends JDialog {


    private JLabel lbVrstaLinije=new JLabel("Vrsta linije");
    private JCheckBox cbIsprekidana= new JCheckBox("Isprekidana");
    private JCheckBox cbNeisprekidana= new JCheckBox("Neisprekidana");
    private  ButtonGroup bgCentar = new ButtonGroup();
    private JSpinner jsDebljina;
    private JPanel pnlCentar =new JPanel();
    private JButton btnOk= new JButton("OK");
    private JButton btnCancel= new JButton("Cancel");
    private JPanel pnlButtons= new JPanel();
    private float debljina;


    public ChooseStrokeDialog(TabWorkspace tabWorkspace) {

        this.setTitle("Choose");
        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(400,150));
        this.setModal(true);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setLocationRelativeTo(tabWorkspace);
        this.setResizable(false);

        bgCentar.add(cbIsprekidana);
        bgCentar.add(cbNeisprekidana);
        SpinnerModel value= new SpinnerNumberModel(2,1,25,1);
        jsDebljina = new JSpinner(value);
        pnlCentar.setLayout(new GridLayout());
        pnlCentar.add(cbNeisprekidana);
        pnlCentar.add(cbIsprekidana);
        pnlButtons.add(btnOk);
        pnlButtons.add(btnCancel);
        this.add(pnlCentar,BorderLayout.NORTH);
        this.add(jsDebljina,BorderLayout.CENTER);
        this.add(pnlButtons,BorderLayout.SOUTH);
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                debljina= (int)jsDebljina.getValue();
                TabProject tp=tabWorkspace.getTp();
                JScrollPane jsp= (JScrollPane) tp.getSelectedComponent();
                TabPresentation tap= (TabPresentation) jsp.getViewport().getView();
                if(cbNeisprekidana.isSelected()){
                    for(Component c:tap.getComponents()){
                        if(c instanceof TabSlide){
                            for(TabSlot cd:((TabSlide) c).getTabSlots()){
                                cd.getSlot().setStroke(new SerializableStrokeAdapter(new BasicStroke(debljina)));

                            }
                            c.repaint();
                        }

                    }
                }
                else{
                    for(Component c:tap.getComponents()){
                        if(c instanceof TabSlide){
                            for(TabSlot cd:((TabSlide) c).getTabSlots()){
                                cd.getSlot().setStroke(new SerializableStrokeAdapter(new BasicStroke(debljina,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,3.0f,new float[]{4.0f,2.0f},0.0f)));

                            }
                            c.repaint();
                        }

                    }
                }
                for(Component c:((TabPresentation)(tabWorkspace.getJsp().getViewport().getView())).getComponents()){
                    if(c instanceof TabSlide){


                        TabSlide ts= (TabSlide) c;
                        if(ts.getSlajd().getIme().equals(ts.getSlajd().getIme())){
                            ts.repaint();
                        }

                    }

                }
                dispose();
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });


        this.setVisible(true);
    }
}
