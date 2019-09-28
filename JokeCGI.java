import java.io.FileInputStream;
import java.io.IOException;

public class JokeCGI {
    private static final String FILENAME = "joke-record.txt";
    public static void main(String... args) {
        System.out.println("Content-type: text/html");
        System.out.println();
        System.out.println("<!DOCTYPE html>");
        System.out.println("<html>");
        System.out.println("<head>");
        System.out.println("<title> Joke response submitted</title>");
        System.out.println("</head>");
        System.out.println("<body>");

        int totalVotes = 0; yesVotes = 0;

        try (FileInputStream fileIN = new FileInputStream(FILENAME);
            Scanner in = new Scanner(fileIn)){
             totalVotes = in.nextInt();
             yesVotes = in.nextInt();
            }catch (IOException ex) {
                ex.printStackTrace();
                return;
            }

            Scanner formIn = new Scanner(System.in);
            String line = formIn.nextLine();
            boolean votedYes = line.indexOf("yes") !=-1;

            ++totalVotes;
            if (votedYes)
                ++yesVotes;
            try (PrintWriter out = new PrintWriter(FILENAME)){
                out.println(totalVotes + " " + yesVotes);
            }catch (IOException ex) {
                ex.printStackTrace();
                return;
                
            }
            
            System.out.println(yesVotes + "out of" + totalVotes + " people think this joke is a good one");
            System.out.println("</body></html>");
            
    }
}