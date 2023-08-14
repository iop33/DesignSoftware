package controller;

import view.MainFrame;
import view.dialogs.InfoDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class InfoAction extends AbstractRuDokAction{
    MainFrame mf;
    public InfoAction() {


        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("icons\\info32x32.png"));
        putValue(NAME, "Info");
        putValue(SHORT_DESCRIPTION, "Info");


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        InfoDialog infoDialog=new InfoDialog(MainFrame.getinstance());
    }
}
