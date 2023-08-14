package model.commands;

import model.RuNode;
import view.MainFrame;

import javax.swing.*;

public class RenameCommand extends AbstractCommand{
    private String newName;
    private String oldName;
    private RuNode node;

    public RenameCommand(String newName, RuNode node) {
        this.newName = newName;
        this.node = node;
        this.oldName= node.getIme();
    }

    @Override
    public void doCommand() {
        node.setIme(newName);
        SwingUtilities.updateComponentTreeUI(MainFrame.getinstance().getMyTree());
    }

    @Override
    public void undoCommand() {
        node.setIme(oldName);
        SwingUtilities.updateComponentTreeUI(MainFrame.getinstance().getMyTree());
    }
}
