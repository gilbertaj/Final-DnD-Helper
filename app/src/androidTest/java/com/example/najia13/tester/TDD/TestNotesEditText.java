package com.example.najia13.tester.TDD;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import com.example.najia13.tester.util.*;

/**
 * Created by Najia13 on 11/28/2016.
 */
public class TestNotesEditText {
    NotesActivityPresenter present_for_text_edit;
    NotesActivityView view;

    class MockedView implements NotesActivityView{
        String notes_text_check;

        @Override
        public void changeText(String text) {
            notes_text_check = text;
        }
    }

    @Before
    public void setUp() throws Exception {
        view = new MockedView();
        present_for_text_edit = new NotesActivityPresenter(view);
    }

    @Test
    public void editTextUpdated() throws Exception {
        //Arrange
        String notes_string = "test";
        //Act
        present_for_text_edit.editTextUpdated(notes_string);
        //Assert
        assertEquals(notes_string, ((MockedView)view).notes_text_check);

    }

}