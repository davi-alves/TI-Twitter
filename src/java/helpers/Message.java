package helpers;

/**
 *
 * @author davi
 */
public class Message {

    private String text;
    private String type;

    public Message() {
    }

    public Message(String text, String type) {
        this.text = text;
        this.type = type;
    }

    /**
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return
     */
    public String getText() {
        return text;
    }

    /**
     * @return
     */
    public String getType() {
        return type;
    }
}
