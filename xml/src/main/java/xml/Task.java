package xml;

public class Task implements Comparable<Task> {

    private String title;
    private String description;
    private int priority;
    private State state;

    public Task(String title, String description, int priority, State state) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public State getState() {
        return state;
    }

    @Override
    public int compareTo(Task o) {
        return this.priority - o.priority;
    }

    @Override
    public String toString() {
        return "Priority=" + priority + " title='" + title + "'";
    }
}
