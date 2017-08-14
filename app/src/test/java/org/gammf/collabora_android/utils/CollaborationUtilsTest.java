package org.gammf.collabora_android.utils;

import org.gammf.collabora_android.collaborations.Collaboration;
import org.gammf.collabora_android.collaborations.ConcreteProject;
import org.gammf.collabora_android.collaborations.Project;
import org.gammf.collabora_android.modules.ConcreteModule;
import org.gammf.collabora_android.modules.Module;
import org.gammf.collabora_android.notes.Note;
import org.gammf.collabora_android.notes.SimpleModuleNote;
import org.gammf.collabora_android.notes.SimpleNoteBuilder;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author ManuelPeruzzi
 * Simple tests for the collaboration/json conversion.
 */
public class CollaborationUtilsTest {

    private Project project;
    private Note singleNote;
    private Module firstModule;
    private Module secondModule;
    private Note firstNote;
    private Note secondNote;
    private Note thirdNote;

    @Before
    public void setUp() throws Exception {
        project = new ConcreteProject("myProjectId", "MyProject");

        singleNote = new SimpleNoteBuilder("SingleNote")
                .setNoteID("singleNoteId")
                .buildNote();
        project.addNote(singleNote);

        firstModule = new ConcreteModule("firstModuleId", "FirstModule", "toDo");
        firstNote = new SimpleNoteBuilder("FirstNote")
                .setNoteID("firstNoteId")
                .buildNote();
        firstModule.addNote(firstNote);
        project.addModule(firstModule);

        secondModule = new ConcreteModule("secondModuleId", "SecondModule", "toDo");
        secondNote = new SimpleNoteBuilder("SecondNote")
                .setNoteID("secondNoteId")
                .buildNote();
        secondModule.addNote(secondNote);
        project.addModule(secondModule);

        thirdNote = new SimpleNoteBuilder("ThirdNote")
                .setNoteID("thirdNoteId")
                .buildNote();
        project.addNote(new SimpleModuleNote(thirdNote, firstModule.getId()));
    }

    @Test
    public void collaborationToJson() throws Exception {
        final JSONObject json = CollaborationUtils.collaborationToJson(project);
        System.out.println("[CollaborationUtilsTest]: " + json);
        final Collaboration collaboration = CollaborationUtils.jsonToCollaboration(json);
        //assertEquals(project, collaboration);
    }

}