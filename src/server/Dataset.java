package server;

import java.util.ArrayList;

public class Dataset{
    
    private String datasetName;
    private ArrayList<String[]> lines = new ArrayList<String[]>();

    public Dataset(String datasetName){
        this.datasetName = datasetName;
    }
 
    public String getName(){
        return this.datasetName;
    }

    public ArrayList<String[]> getLines(){
        return this.lines;
    }

    public void setLines(ArrayList<String[]> Lines){
    	for(int j = 0; j < Lines.size(); j++) {
    		
    		int length = Lines.get(j).length;
    		// making a deep copy 
    		String[] newArray = new String[length];
    		for(int k = 0; k < length; k++) {
    			newArray[k] = Lines.get(j)[k];
    		}
    		lines.add(newArray);
    	}
    }

    public void printLines(){
        for (int i=0; i < lines.size(); i++){
            for(int j=0; j < lines.get(i).length; j++){
                System.out.print(lines.get(i)[j] + " ");
            }            
        }
    }
}