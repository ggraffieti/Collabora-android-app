package org.gammf.collabora_android.users;

import org.gammf.collabora_android.utils.AccessRight;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Manuel Peruzzi
 * Simple tests for collaboration member class.
 */
public class CollaborationMemberTest {

    private CollaborationMember member;

    @Before
    public void setUp() throws Exception {
        member = new SimpleCollaborationMember("peru", AccessRight.ADMIN);
    }

    @Test
    public void getUsername() throws Exception {
        assertEquals(member.getUsername(), member.getUsername());
    }

    @Test
    public void getAccessRight() throws Exception {
        assertEquals(member.getAccessRight(), AccessRight.ADMIN);
    }

}