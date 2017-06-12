package id.sch.smktelkom_mlg.privateassignment.xirpl333.shown.model;

/**
 * Created by Sella_NP on 13-Jun-17.
 */

public class MessageEvent {
    private boolean update = false;

    public MessageEvent(boolean update) {
        this.update = update;
    }

    public boolean isUpdate() {
        return update;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }
}
