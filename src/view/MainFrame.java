package view;

import controller.ActionManager;
import controller.myTree.MyDoubleClickListener;
import controller.myTree.MyTripleClickListener;
import model.commands.CommandManager;
import model.nodeModels.Workspace;
import observer.Subscriber;
import view.myTree.modal.MyTreeModel;
import view.myTree.modal.MyTreeNode;
import view.myTree.view.MyTree;
import view.myTree.controller.MyRenderer;

import javax.swing.*;
import javax.swing.tree.TreeCellEditor;
import java.awt.*;

public class MainFrame extends JFrame implements Subscriber {

    private static MainFrame instanca=null;
    private ActionManager actionManager;
    private MenuBar meni;
    private ToolBar tulbar;
    private MyTree myTree;
    private MyTreeModel model;
    private MyDoubleClickListener mdcl;
    private MyRenderer mr;
    JSplitPane sp;
    private CommandManager commandManager;

    private MainFrame() throws HeadlessException {

    }

    private void inicijalizacija(){

        actionManager=new ActionManager();
        inicijalizacijaJTree();
        inicijalizacijaGUI();
        commandManager=new CommandManager();

    }

    private void inicijalizacijaJTree(){

        Workspace w=new Workspace("Workspace",null);
        MyTreeNode n=new MyTreeNode(w);
        model=new MyTreeModel(n);
        myTree=new MyTree();
        myTree.setModel(model);
        new MyDoubleClickListener(myTree);

    }

    private void inicijalizacijaGUI(){

        Toolkit kit=Toolkit.getDefaultToolkit();
        Dimension dim=kit.getScreenSize();
        int visina=dim.height;
        int sirina=dim.width;
        setSize(sirina/2,visina/2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("RuDok");
        meni=new MenuBar();
        tulbar=new ToolBar();
        setJMenuBar(meni);
        add(tulbar,BorderLayout.NORTH);
        JPanel pCenter=new JPanel();
        JScrollPane scLevi=new JScrollPane(myTree);
        scLevi.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        JPanel pDesni=new JPanel();
         sp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scLevi,pDesni);
        sp.setOneTouchExpandable(true);
        sp.setDividerLocation(250);
        Dimension min=new Dimension(220,50);
        scLevi.setMinimumSize(min);
        pDesni.setMinimumSize(min);
        this.add(sp);


    }




    public ActionManager getActionManager(){
        return actionManager;
    }

    public static MainFrame getinstance(){

        if(instanca==null){
            instanca=new MainFrame();
            instanca.inicijalizacija();
            return instanca;
        }
        else{
            return instanca;
        }

    }

    public MyTree getMyTree() {
        return myTree;
    }

    public void setMyTree(MyTree myTree) {
        this.myTree = myTree;
    }

    public MyTreeModel getModel() {
        return model;
    }

    public void setModel(MyTreeModel model) {
        this.model = model;
    }

    public JSplitPane getSp() {
        return sp;
    }

    public void setSp(JSplitPane sp) {
        this.sp = sp;
    }


    public MenuBar getMeni() {
        return meni;
    }

    public void setMeni(MenuBar meni) {
        this.meni = meni;
    }

    public ToolBar getTulbar() {
        return tulbar;
    }

    public void setTulbar(ToolBar tulbar) {
        this.tulbar = tulbar;
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }

    public void setCommandManager(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

    @Override
    public void update(Object notification) {

        MyMessage m=(MyMessage) notification;
        JOptionPane.showMessageDialog(new JDialog(this),m.getText()+"Solucija: "+m.getSolution(),m.getTitle(),m.getType());
    }
}
