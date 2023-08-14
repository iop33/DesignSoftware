package controller;

import controller.myTree.EditAction;

public class ActionManager {


    private NewAction newAction;
    private InfoAction infoAction;
    private DeleteNodeAction delAction;
    private EditAction ea;
    private SlideCardShowAction slideShow;
    private AddSlotAction addSlotAction;
    private RemoveSlotAction removeSlotAction;
    private MoveSlotAction moveSlotAction;
    private ChooseColorAction cca;
    private ChooseStrokeAction csa;
    private UndoAction undoAction;
    private RedoAction redoAction;
    private SaveProjectAction saveProjectAction;
    private OpenAction openAction;
    private ShareAction shareAction;
    public ActionManager() {

        initActions();
    }

    private void initActions(){
        shareAction=new ShareAction();
        openAction=new OpenAction();
        saveProjectAction=new SaveProjectAction();
        undoAction =new UndoAction();
        redoAction =new RedoAction();
        moveSlotAction=new MoveSlotAction();
        removeSlotAction=new RemoveSlotAction();
        addSlotAction=new AddSlotAction();
        newAction =new NewAction();
        infoAction =new InfoAction();
        delAction=new DeleteNodeAction();
        ea=new EditAction();
        slideShow=new SlideCardShowAction();
        cca= new ChooseColorAction();
        csa=new ChooseStrokeAction();
    }

    public ShareAction getShareAction() {
        return shareAction;
    }

    public void setShareAction(ShareAction shareAction) {
        this.shareAction = shareAction;
    }

    public OpenAction getOpenAction() {
        return openAction;
    }

    public void setOpenAction(OpenAction openAction) {
        this.openAction = openAction;
    }

    public SaveProjectAction getSaveProjectAction() {
        return saveProjectAction;
    }

    public void setSaveProjectAction(SaveProjectAction saveProjectAction) {
        this.saveProjectAction = saveProjectAction;
    }

    public UndoAction getUndoAction() {
        return undoAction;
    }

    public void setUndoAction(UndoAction undoAction) {
        this.undoAction = undoAction;
    }

    public RedoAction getRedoAction() {
        return redoAction;
    }

    public void setRedoAction(RedoAction redoAction) {
        this.redoAction = redoAction;
    }

    public ChooseStrokeAction getCsa() {
        return csa;
    }

    public void setCsa(ChooseStrokeAction csa) {
        this.csa = csa;
    }

    public ChooseColorAction getCca() {
        return cca;
    }

    public void setCca(ChooseColorAction cca) {
        this.cca = cca;
    }

    public AddSlotAction getAddSlotAction() {
        return addSlotAction;
    }

    public void setAddSlotAction(AddSlotAction addSlotAction) {
        this.addSlotAction = addSlotAction;
    }

    public RemoveSlotAction getRemoveSlotAction() {
        return removeSlotAction;
    }

    public void setRemoveSlotAction(RemoveSlotAction removeSlotAction) {
        this.removeSlotAction = removeSlotAction;
    }

    public MoveSlotAction getMoveSlotAction() {
        return moveSlotAction;
    }

    public void setMoveSlotAction(MoveSlotAction moveSlotAction) {
        this.moveSlotAction = moveSlotAction;
    }

    public SlideCardShowAction getSlideShow() {
        return slideShow;
    }

    public void setSlideShow(SlideCardShowAction slideShow) {
        this.slideShow = slideShow;
    }

    public EditAction getEa() {
        return ea;
    }

    public void setEa(EditAction ea) {
        this.ea = ea;
    }

    public DeleteNodeAction getDelAction() {
        return delAction;
    }

    public void setDelAction(DeleteNodeAction delAction) {
        this.delAction = delAction;
    }

    public NewAction getNewAction() {
        return newAction;
    }

    public void setNewAction(NewAction newAction) {
        this.newAction = newAction;
    }

    public InfoAction getInfoAction() {
        return infoAction;
    }

    public void setInfoAction(InfoAction infoAction) {
        this.infoAction = infoAction;
    }


}
