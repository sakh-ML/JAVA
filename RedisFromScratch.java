import java.io.IOException;
import java.util.*;

public class RedisFromScratch{

    public static void main(String[] args) throws IOException{

        Redis redis = new Redis();

        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("----------------------");
            System.out.println("Usage: ");
            System.out.println("SET X Y (Key X wird auf Value Y gebildet)");
            System.out.println("GET X (Der Value des Key X wird zuruckgeben");
            System.out.println("DEL X (Key X wird gelöscht)");
            System.out.println("Type 1 to show the Database");
            System.out.println("Type exit to end the programm");
            System.out.println(">");
            //take the command from the user
            String argumens = scanner.nextLine();
            if(argumens.equals("1")){
                redis.dispalyDataBase();
            }
            else if(argumens.toLowerCase().equals("exit")){
                break;
            }
            else{
                List<String> parsedCommand = parseCommand(argumens);
                //we make sure that the comamnd is valid
                //and then excute it
                if(!checkValidCommand(parsedCommand)){
                    System.out.println("What u wrote is inavild command");
                }
                else{
                    excuteCommand(redis,parsedCommand);
                }
            }
        }
    }

    public static void excuteCommand( Redis redis,List<String> command){
        String toDo = command.get(0);

        switch (toDo){
            case "SET":
                redis.addKeyValue(command.get(1), command.get(2));
                break;
            case "GET":
                System.out.println(redis.getValue(command.get(1)));
                break;

            case "DEL":
                redis.deleteKey(command.get(1));
                break;
            default:
                System.out.println("Unkown command");
        }
    }

    public static boolean checkValidCommand(List<String> command){

        if(command.get(0).toUpperCase().equals("SET") && command.size() == 3){
            return true;
        }
        else if(command.get(0).toUpperCase().equals("GET") && command.size() == 2){
            return true;
        }
        else if(command.get(0).toUpperCase().equals("DEL") && command.size() == 2){
            return true;
        }
        return false;
    }

    public static List<String> parseCommand(String arguments){
        List<String> result = new ArrayList<String>();

        String toAdd = "";
        for(int i = 0; i < arguments.length(); ++i){
            if(arguments.charAt(i) == ' '){
                result.add(toAdd);
                toAdd = "";
            }
            else{
                toAdd += arguments.charAt(i);
            }
        }
        if(!toAdd.isEmpty()){
            result.add(toAdd);
        }
        return result;
    }

}

class Redis{
    private Map<String, String> dataBase = new HashMap<String, String>();
    //private Map<String, Integer> ttlKeys = new HashMap<String,Integer>();

    public void addKeyValue(String key, String value) {

        dataBase.put(key, value);

    }

    public void deleteKey(String key){

        if(dataBase.containsKey(key)){
            dataBase.remove(key);
        }
        else{
            System.out.println("Key is not found in the database");
        }
    }
    public String getValue(String key){
        if(dataBase.containsKey(key)){
            return dataBase.get(key);
        }
        return "";
    }

    public void dispalyDataBase(){
        for(Map.Entry<String, String> entry : dataBase.entrySet()){
            System.out.println("Key: " + entry.getKey() + " , Value: " + entry.getValue());
        }
    }
}