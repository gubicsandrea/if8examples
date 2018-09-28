package xml;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class TaskXmlRepositoryTest {

    @Rule
    public final TemporaryFolder temporaryFolder = new TemporaryFolder();
    private File inputFile;
    private File outputFile;

    @Before
    public void setUp() throws IOException {
        outputFile = temporaryFolder.newFile();
        inputFile = new File(this.getClass().getClassLoader().getResource("tasks.xml").getFile());

    }


    @Test
    public void testLoad() {
        TaskXmlRepository taskXmlRepository = new TaskXmlRepository();
        Queue<Task> tasks = taskXmlRepository.loadTasks(inputFile);

        assertThat(tasks.poll().getTitle(), equalTo("Plan base classes"));
    }

    @Test
    public void testSave() {
        TaskXmlRepository taskXmlRepository = new TaskXmlRepository();
        Queue<Task> tasks = new PriorityQueue<>();
        tasks.add(new Task("első", "első leírása", 2, State.FINISHED));
        tasks.add(new Task("második", "második leírása", 1, State.PENDING));
        tasks.add(new Task("harmadik", "harmadik leírása", 3, State.DELETED));


        taskXmlRepository.saveTasks(outputFile, tasks);
        byte[] content;
        try (InputStream is = new FileInputStream(outputFile)) {
            content = is.readAllBytes();
            assertThat(content.length, equalTo(408));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
