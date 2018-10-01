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
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class BookXmlHandler {

    public List<Book> loadFromClasspath() {
        List<Book> books = new ArrayList<>();

        try (InputStream is = this.getClass().getClassLoader().getResourceAsStream("books.xml")) {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(is);

            NodeList bookNodes = document.getElementsByTagName("book");
            for (int i = 0; i < bookNodes.getLength(); i++) {
                String isbn = ((Element) bookNodes.item(i)).getAttribute("isbn");
                String limit = null;
                if (((Element) bookNodes.item(i)).hasAttribute("limit")) {
                    limit = ((Element) bookNodes.item(i)).getAttribute("limit");
                }
                String title = ((Element) bookNodes.item(i)).getElementsByTagName("title").item(0).getTextContent();
                String author = ((Element) bookNodes.item(i)).getElementsByTagName("author").item(0).getTextContent();
                boolean available = ((Element) bookNodes.item(i)).getElementsByTagName("available").getLength() > 0;
                String year = ((Element) bookNodes.item(i)).getElementsByTagName("year").item(0).getTextContent();
                Book b;
                if (limit != null) {
                    b = new Book(isbn, title, author, Integer.parseInt(year), available, Integer.parseInt(limit));
                } else {
                    b = new Book(isbn, title, author, Integer.parseInt(year), available);
                }
                books.add(b);
            }
            return books;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return books;
    }

    public void saveBooksToClasspath(List<Book> books) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
            Document document = db.newDocument();
            //fel kell építeni a document-et a listából
            Node rootNode = document.createElement("all");
            for (Book book : books) {
                Node bookNode = createBookNode(document, book);
                rootNode.appendChild(bookNode);
            }
            document.appendChild(rootNode);


            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);

            StreamResult streamResult = new StreamResult(new File(this.getClass().getClassLoader().getResource("books.xml").getPath()));
            transformer.transform(source, streamResult);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }

    private Node createBookNode(Document document, Book book) {
        Node bookNode = document.createElement("book");
        ((Element) bookNode).setAttribute("isbn", book.getIsbn());
        if (book.getLimit() > 0) {
            ((Element) bookNode).setAttribute("limit", Integer.toString(book.getLimit()));
        }
        //Title
        Node titleNode = document.createElement("title");
        titleNode.setTextContent(book.getTitle());
        bookNode.appendChild(titleNode);
        //Author
        Node authorNode = document.createElement("author");
        authorNode.setTextContent(book.getAuthor());
        bookNode.appendChild(authorNode);
        if (book.isAvailable()) {
            Node availableNode = document.createElement("available");
            bookNode.appendChild(availableNode);
        }
        Node yearNode = document.createElement("year");
        yearNode.setTextContent(Integer.toString(book.getYearOfPublish()));
        bookNode.appendChild(yearNode);
        return bookNode;
    }
}
