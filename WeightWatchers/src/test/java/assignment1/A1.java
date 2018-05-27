package assignment1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class A1 {

	
	
	public File getDict() {
        return dict;
    }

    public void setDict(File dict) {
        this.dict = dict;
    }

    public List<String> getOutput() {
        return output;
    }

    public void setOutput(List<String> output) {
        this.output = output;
    }

    
    private File dict;
    private List<String> output = new ArrayList<String>();


    public boolean doesFileExist(String filePath) {
        try {
            dict = new File(filePath);
            if (dict.exists() && dict.isFile()) {
                System.out.println("File exist.");
            }
        }
        catch (Exception ex){
            System.out.println("Requested file does not exist.");
            return false;
        }
        return false;
    }

    
    public void readAndParse(File file){
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String read = null;
            while ((read = br.readLine()) != null) {
                String[] wordAndMeanings = read.split("\\s*–\\s*");
                for (String entry : wordAndMeanings) {
                    output.add(entry.replace(", ", "\n"));
                }
            }
         
        } catch (IOException ex) {
            System.out.println("Problem Found: "+ex);
            ex.printStackTrace();
        }
        finally {
            try {
                br.close();
            } catch (Exception ex) {
            }
        }
    }

    
    public void printOutput(List<String> outputList){
        for (String text: outputList){
            System.out.println(text);
        }
    }

    
    public static void main(String args[]){
        A1 a = new A1();
        a.doesFileExist("Dictionary/wordsList.txt");
        a.readAndParse(a.getDict());
        a.printOutput(a.getOutput());
    }


}//end class
