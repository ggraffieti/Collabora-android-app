package org.gammf.collabora_android.utils;

import org.gammf.collabora_android.app.utils.ExceptionManager;
import org.gammf.collabora_android.short_collaborations.CollaborationsManager;
import org.gammf.collabora_android.short_collaborations.ConcreteCollaborationManager;
import org.gammf.collabora_android.short_collaborations.ShortCollaboration;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Set;

/**
 * @author Manuel Peruzzi
 * Utily class providing methods to convert from collaborations set in a collaborations manager to
 * json message and vice versa.
 */
public class CollaborationsManagerUtils {

    /**
     * Provides a json with all the short collaborations included in the manager.
     * @param manager the collaborations manager.
     * @return a json message with all the short collaborations in the manager.
     */
    public static JSONObject collaborationsManagerToJson(final CollaborationsManager manager) {
        final JSONObject json = new JSONObject();
        try {
            final Set<ShortCollaboration> collaborations = manager.getAllCollaborations();
            if (!collaborations.isEmpty()) {
                final JSONArray jCollaborations = new JSONArray();
                for (final ShortCollaboration c: collaborations) {
                    jCollaborations.put(ShortCollaborationUtils.shortCollaborationToJson(c));
                }
                json.put("collaborations", jCollaborations);
            }
        } catch (final JSONException e) {
            ExceptionManager.getInstance().handle(e);
        }
        return json;
    }

    /**
     * Creates a collaborations manager instance from a json message.
     * @param json the input json message.
     * @return a collaborations manager built from the json message.
     */
    public static CollaborationsManager jsonToCollaborationManager(final JSONObject json) {
        final CollaborationsManager manager = new ConcreteCollaborationManager();
        try {
            if (json.has("collaborations")) {
                final JSONArray jCollaborations = json.getJSONArray("collaborations");
                for (int i = 0; i < jCollaborations.length(); i++) {
                    final ShortCollaboration collaboration = ShortCollaborationUtils.jsonToShortCollaboration(
                            jCollaborations.getJSONObject(i));
                    manager.addCollaboration(collaboration);
                }
            }
        } catch (final JSONException e) {
            ExceptionManager.getInstance().handle(e);
        }
        return manager;
    }

}
