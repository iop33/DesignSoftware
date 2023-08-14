package model.commands;

import view.MainFrame;

import java.util.ArrayList;

public class CommandManager {
    private ArrayList<AbstractCommand> commands = new ArrayList<AbstractCommand>();
    private int currentCommand = 0;


    public void addCommand(AbstractCommand command){
        while(currentCommand < commands.size())
            commands.remove(currentCommand);
        commands.add(command);
        doCommand();
    }


    public void doCommand(){
        if(currentCommand < commands.size()){
            commands.get(currentCommand++).doCommand();
            MainFrame.getinstance().getActionManager().getUndoAction().setEnabled(true);
        }
        if(currentCommand==commands.size()){
            MainFrame.getinstance().getActionManager().getRedoAction().setEnabled(false);
        }
    }


    public void undoCommand(){
        if(currentCommand > 0){
            MainFrame.getinstance().getActionManager().getRedoAction().setEnabled(true);
            commands.get(--currentCommand).undoCommand();
        }
        if(currentCommand==0){
            MainFrame.getinstance().getActionManager().getUndoAction().setEnabled(false);
        }
    }
}
