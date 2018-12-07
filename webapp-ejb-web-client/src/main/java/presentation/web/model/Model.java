package presentation.web.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Model implements Serializable {

	/**
     * 
     */
    private static final long serialVersionUID = -141585865274406479L;
    private List<String> messages;

	public Model() {
		messages = new LinkedList<String>();
	}

	public List<String> getMessages () {
		return messages;
	}
	
	public void addMessage(String message) {
		messages.add(message);
	}
	
	public boolean isHasMessages() {
		return messages.size() != 0;
	}

}
