package com.example.najia13.tester.util;

/**
 * Created by Chris on 12/4/2016.
 */

public class NotesActivityPresenter {
    NotesActivityView view;

    public NotesActivityPresenter(NotesActivityView view) {
        this.view = view;



    }

    public void editTextUpdated(String text) {
        view.changeText(text);



    }

}
