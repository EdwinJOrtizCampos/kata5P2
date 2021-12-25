package kata5parte2.main;

import java.util.List;
import kata5parte2.model.Mail;
import kata5parte2.model.Histogram;
import kata5parte2.view.HistogramDisplay;
import kata5parte2.view.MailHistogramBuilder;
import kata5parte2.view.MailListReader;



/**
 *
 * @author Edwin Ortiz Campos
 */
public class Main {
    private String path;
    
    public Main(String path){
        this.path = path;
    }
        
    public void execute(){
        List<Mail> readMails = input(path);
        HistogramDisplay histoDisplay = process(readMails);
        output(histoDisplay);
        
    }
    
    public List<Mail> input(String path){
      List<Mail> mailList = MailListReader.read(path);
      return mailList;
    }
    
    public HistogramDisplay process(List<Mail> readMails){
        Histogram<String> histogram = MailHistogramBuilder.build(readMails);
        HistogramDisplay histoDisplay = new HistogramDisplay(histogram); 
        return histoDisplay;
    }
    
    public void output(HistogramDisplay histoDisplay){
        histoDisplay.execute();
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main kata = new Main("C:\\Users\\edwin\\OneDrive\\Documentos\\NetBeansProjects\\Kata4\\email.txt");
        kata.execute();
    }
    

    
    
}
