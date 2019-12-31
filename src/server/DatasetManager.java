package server;
import utils.SimpleCSVReader;
import java.util.*;

public class DatasetManager implements IDatasetManager{

    private ArrayList<Dataset> allDatasets;// = new ArrayList<Dataset>();
    public DatasetManager() {
    	allDatasets = new ArrayList<Dataset>();
    }

    public int registerDataset(String datasetName, String canonicalPath){
        if (datasetName == null){
           return -1;     
        }
        for (int i = 0; i < allDatasets.size(); i++){
            if (datasetName.equals(allDatasets.get(i).getName())){
                return -10;
            } 
        }
        SimpleCSVReader read = new SimpleCSVReader();
        Dataset data = new Dataset(datasetName);
        ArrayList<String[]> file = new ArrayList<String[]>();
        file = read.load(canonicalPath);
//        	for(int g = 0;g<file.get(0).length;g++) {
//        		System.out.print(file.get(0)[g]+" ");
//        	}
        data.setLines(file);
        allDatasets.add(data);

        return 0;
    }

	public String[] retrieveDataset(String datasetName, ArrayList<String[]> data){
		String[] newArray;

        for (int i = 0; i < allDatasets.size(); i++){
        	System.out.println(allDatasets.get(i).getName());

            if (datasetName.equals(allDatasets.get(i).getName())){
            	ArrayList<String[]> temp = new ArrayList<String[]>();
            	temp =  allDatasets.get(i).getLines();
            	for(int j = 0; j < temp.size(); j++) {
            		
            		int length = temp.get(j).length;
            		// making a deep copy 
            		newArray = new String[length];
            		for(int k = 0; k < length; k++) {
            			newArray[k] = temp.get(j)[k];
            		}
            		data.add(newArray);
            	}
//            	for(int v = 0;v < data.get(0).length;v++) {
//            		
//            		System.out.println(data.get(0)[v]);
//            	}
            	return data.get(0);
            }
        }
        return null;
    }

    public int filterDataset(String originalDatasetName, String newDatasetName, String filterColumnName, String filterValue){
    	int tempor = -1;//the position of the dataset with the name we want from allDatasets
        for (int i = 0; i < allDatasets.size(); i++) {
            if (originalDatasetName.equals(allDatasets.get(i).getName())){
            	System.out.println(allDatasets.get(i).getName());
            	tempor = i;
                break;
            }
        }
        if(tempor == -1) {
        	return -1;
        }

        Dataset newdata = new Dataset(newDatasetName);
        String[] temp = new String[allDatasets.get(tempor).getLines().get(0).length];
        for(int v=0;v<temp.length;v++) {
        	temp[v] = allDatasets.get(tempor).getLines().get(0)[v];
        	//System.out.println(temp[v]);
        }
       // temp = allDatasets.get(tempor).getLines().get(0);//the array with the field names
        //for(int v = 0;v<temp.length;v++) {
        //		System.out.println(temp[v]);
        //	}
        int position = -1;
        for (int j=0;j<temp.length; j++) {
                if(temp[j].equals(filterColumnName)){
                	position = j;
                	break;
                }
        }
        if(position == -1) {
        	return -1;
        }
      //  String[] arrayWFV=new String[allDatasets.get(tempor).getLines().get(0).length];
        ArrayList<String[]> filtered = new ArrayList<String[]>();
        filtered.add(allDatasets.get(tempor).getLines().get(0));
        for(int k = 1;k<allDatasets.get(tempor).getLines().size();k++){
                if(allDatasets.get(tempor).getLines().get(k)[position].equals(filterValue)){
                	//for(int v = 0;v<allDatasets.get(tempor).getLines().get(k).length;v++) {
                	//	arrayWFV[v] = allDatasets.get(tempor).getLines().get(k)[v];
                	//}
                	filtered.add(allDatasets.get(tempor).getLines().get(k));
//              	for(int v = 0;v<filtered.size();v++) {
//                		for(int b = 0;b < filtered.get(v).length;b++) {
//                			
//                		System.out.println(allDatasets.get(tempor).getLines().get(v)[b]);
//                		}
//                	}
                }
        }
        newdata.setLines(filtered);
        if(newdata.getLines().equals(null)) {
        	return -1;
        }
        allDatasets.add(newdata);
    	return 0;
    }

    public ArrayList<String[]> getDatasetProjection(String datasetName, ArrayList<String> attributeNames){
    	
    	ArrayList<String[]> info = new ArrayList<String[]>();
    	String att1 = attributeNames.get(0);   // System.out.println("att1 " +att1);

    	String att2 = attributeNames.get(1); //  System.out.println("att2 " + att2);

    	//String[] values = new String[2];
    	
        for (int i = 0; i < allDatasets.size(); i++){
            if (datasetName.equals(allDatasets.get(i).getName())){
            	
            	String[] header = allDatasets.get(i).getLines().get(0);
            	int pos1 = -1; int pos2 = -1;
            	
            	for(int j = 0; j < header.length; j++) { 
            		if (header[j].equals(att1)) {
            			pos1 = j;
            			//System.out.println("pos1 " + pos1);

            			break;
            		}
            	}
            	for(int j = 0; j < header.length; j++) { 
            		if (header[j].equals(att2)) {
            			pos2 = j;
            			//System.out.println("pos2 " + pos2);
               			break;
            		}
            	}
            	for (int k = 1; k < allDatasets.get(i).getLines().size(); k++) {
            		String[] temp = allDatasets.get(i).getLines().get(k);
            		String a = temp[pos1]; String b = temp[pos2];
                	String[] values = new String[2];

            		values[0] = a; values[1] = b;
        			//System.out.println("a " + a);
        			//System.out.println("b" + b);

            		info.add(values);
            	}
            }
       }
       return info;
       //return null;
    }


}//end class