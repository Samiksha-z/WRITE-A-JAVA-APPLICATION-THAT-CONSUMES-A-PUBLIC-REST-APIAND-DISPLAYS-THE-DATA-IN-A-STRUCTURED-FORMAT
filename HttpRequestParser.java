import java.io.*;
import java.net.*;
import org.json.JSONObject;

public class HttpRequestParser {
    public static void main(String[] args) throws IOException {
        String urlString = "https://api.github.com/users/octocat"; // Example API (GitHub user data)
        
        // Create URL object
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET"); // HTTP GET request
        
        // Read the response
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        // Parse the JSON response
        JSONObject jsonResponse = new JSONObject(response.toString());
        
        // Extract data from JSON
        String login = jsonResponse.getString("login");
        String name = jsonResponse.getString("name");
        int followers = jsonResponse.getInt("followers");

        // Display data
        System.out.println("GitHub User Info:");
        System.out.println("Login: " + login);
        System.out.println("Name: " + name);
        System.out.println("Followers: " + followers);
    }
}
