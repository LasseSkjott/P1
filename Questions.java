import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

public class Questions
{

    static Random random;
    static Question temp;

    Questions(List<Question> questions, List<Question> rQuestions) throws IOException, SAXException, ParserConfigurationException
    {
        //r = new SecureRandom();
        random = new Random();
        readQuestionsFromFile(questions, rQuestions);


    }


    public static void readQuestionsFromFile(List<Question> questions, List<Question> rQuestions) throws ParserConfigurationException, IOException, SAXException {

                File file = new File("Questions.xml");
                DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
                Document document = documentBuilder.parse(file);
                NodeList list = document.getElementsByTagName("Question");

        for (int i = 0; i < list.getLength(); i++)
        {
            temp = new Question();

                temp.setId(Integer.parseInt(document.getElementsByTagName("id").item(i).getTextContent()));

                temp.setTextOfQuestion(document.getElementsByTagName("textOfQuestion").item(i).getTextContent());
                temp.setSoundFile(document.getElementsByTagName("soundfile").item(i).getTextContent());
                temp.setCorrectAnswer(document.getElementsByTagName("correctAnswer").item(i).getTextContent());
                temp.setDummyAnswers1(document.getElementsByTagName("dummyAnswer1").item(i).getTextContent());
                temp.setDummyAnswers2(document.getElementsByTagName("dummyAnswer2").item(i).getTextContent());
                temp.setDummyAnswers3(document.getElementsByTagName("dummyAnswer3").item(i).getTextContent());


           // System.out.println(temp.getCorrectAnswer());

                questions.add(temp);
        }
        //System.out.println(getRandomQuestions(questions, rQuestions).get(0).getCorrectAnswer());
        //System.out.println(getRandomQuestions(questions, rQuestions).get(1).getCorrectAnswer());
        //System.out.println(getRandomQuestions(questions, rQuestions).get(2).getCorrectAnswer());

        //System.out.println(getRandomQuestions(questions, rQuestions).get(0).getCorrectAnswer());
    }


    public static void getRandomQuestions(List<Question> questions, List<Question> rQuestions) throws ParserConfigurationException, SAXException, IOException {

        Question q;

        while (questions.size() != rQuestions.size())
        {
            SecureRandom r = new SecureRandom();


            //readQuestionsFromFile(questions);
            q = questions.get(r.nextInt(questions.size()));

            if (!rQuestions.contains(q))
            {  // should implement the Comparable interface.
                rQuestions.add(q);
                System.out.println("rQuestions " +rQuestions);
            }
        }
    }

    void saveQuestionsOnFile() {
        // write the file...
    }

}