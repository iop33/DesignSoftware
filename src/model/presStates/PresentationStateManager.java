package model.presStates;

import java.io.Serializable;

public class PresentationStateManager implements Serializable {

    private ReturnState returnState;
    private ShowState showState;
    private PresentationState currState;

    public PresentationStateManager() {
        returnState=new ReturnState();
        showState=new ShowState();
        currState=returnState;

    }
    public PresentationState getCurrState(){
        return currState;
    }
    public void setReturnState(){
        currState=returnState;
    }
    public void setShowState(){
        currState=showState;
    }

}
