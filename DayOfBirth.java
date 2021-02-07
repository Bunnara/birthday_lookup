
import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class DayOfBirth {
    public static JSONArray ReadJSONArrayFromFile() {
        JSONParser jsonParser = new JSONParser();
        JSONArray birthdayList = null;
        try(FileReader reader = new FileReader("./birthday.json"))
        {
            Object obj = jsonParser.parse(reader);
            birthdayList = (JSONArray) obj;

        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return birthdayList;
    }
    public static void main(final String[] args) {

        JSONArray jsonArrayData = ReadJSONArrayFromFile();
        HashMap<String, String> personNamesAndBirth = new HashMap<String, String>();
        JSONObject obj = null;
        for(int i = 0; i < jsonArrayData.size(); i++) {
            obj = (JSONObject) jsonArrayData.get(i);
            String name = obj.get("name").toString();
            String birthday = obj.get("birthday").toString();
            personNamesAndBirth.put(name, birthday);
        }
        String name = "";
        System.out.print("What is your name?");
        Scanner input = new Scanner(System.in);
        name = input.nextLine();
        System.out.println("Your day of birth is: ");
        System.out.println(personNamesAndBirth.get(name));
        input.close();
    }
}
