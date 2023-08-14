package model.elemStates;

import view.myTree.view.TabSlide;

import java.awt.event.MouseEvent;

public interface SlotState {
    void mousePressed(TabSlide tabSlide,MouseEvent e);
    void mouseReleased(TabSlide tabSlide,MouseEvent e);
    void mouseDragged(TabSlide tabSlide,MouseEvent e);

}
