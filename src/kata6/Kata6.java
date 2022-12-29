
package kata6;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Kata6 {

    public static void main(String[] args) throws IOException {
        List<User> users = JsonDeserializeUsersFromApi();
        for (User u: users) {
            System.out.println(u);
        }
        System.out.println(JsonSerializeUsersFromListUsers(users));
        System.out.println(XmlSerializeUsersFromListUsers(users));
    }
    
    public static String readFromApi(String link) {
        try {
            URL url = new URL(link);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection(); 
            conn.setRequestMethod("GET");
            conn.connect();
            String inline = "";
            try (Scanner sc = new Scanner(url.openStream())) {
                while(sc.hasNext()) {
                    inline += sc.nextLine();
                }
            }
            return inline;
        } catch(IOException e) {
            return null;
        }
    }
    
    public static List<User> JsonDeserializeUsersFromApi() {
        Gson gson = new Gson();
        String json = readFromApi("https://jsonplaceholder.typicode.com/users");
        ArrayList<User> users = gson.fromJson(json, 
                new TypeToken<ArrayList<User>>(){}.getType());
        
        return users;
    }
    
    public static String JsonSerializeUsersFromListUsers(List<User> users) {
        Gson gson = new Gson();
        String json = gson.toJson(users);
        return json;
    }
    
    public static String XmlSerializeUsersFromListUsers(List<User> users) {
        try {
            Users us = new Users();
            us.setUsers(users);
            
            JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            
            StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(us, sw);
            
            return sw.toString();
        } catch(JAXBException e) {
            System.out.println(e);
            return null;
        }
    }
}
