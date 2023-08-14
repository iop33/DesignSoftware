package model.presStates;

import model.nodeModels.Presentation;

import java.io.Serializable;

public interface PresentationState {

    void changeState(Presentation presentation);
}
