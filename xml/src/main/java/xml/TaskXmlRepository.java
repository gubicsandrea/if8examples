package xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskXmlRepository {

    public Queue<Task> loadTasks(File file) {
        Queue<Task> tasks = new PriorityQueue<>();
        try (InputStream is = new FileInputStream(file)) {

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(is);

            NodeList taskNodes = document.getElementsByTagName("task");
            for (int i = 0; i < taskNodes.getLength(); i++) {
                String title = ((Element) taskNodes.item(i)).getElementsByTagName("title").item(0).getTextContent();
                String description = ((Element) taskNodes.item(i)).getElementsByTagName("description").item(0).getTextContent();
                String stateString = ((Element) taskNodes.item(i)).getElementsByTagName("state").item(0).getTextContent();
                State state = State.valueOf(stateString);
                int priority = Integer.parseInt(((Element) taskNodes.item(i)).getAttribute("priority"));
                tasks.add(new Task(title, description, priority, state));
            }
        } catch (IOException e) {
            System.out.println("Unable to read source file");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public void saveTasks(File file, Queue<Task> tasks) {
        try (OutputStream os = new FileOutputStream(file)) {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.newDocument();

            Node rootNode = document.createElement("all");
            document.appendChild(rootNode);
            for (Task task : tasks) {
                rootNode.appendChild(createNodeFromTask(document, task));
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            StreamResult result = new StreamResult(baos);
            transformer.transform(source, result);
            os.write(baos.toByteArray());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    private Node createNodeFromTask(Document doc, Task task) {
        Node taskNode = doc.createElement("task");
        ((Element) taskNode).setAttribute("priority", Integer.toString(task.getPriority()));
        Node taskTitleNode = doc.createElement("title");
        taskTitleNode.setTextContent(task.getTitle());
        Node taskDescriptionNode = doc.createElement("description");
        taskDescriptionNode.setTextContent(task.getDescription());
        Node taskStateNode = doc.createElement("state");
        taskStateNode.setTextContent(task.getState().name());
        taskNode.appendChild(taskTitleNode);
        taskNode.appendChild(taskDescriptionNode);
        taskNode.appendChild(taskStateNode);
        return taskNode;
    }
}
