// package src;

// import java.io.IOException;
// import java.net.URI;
// import java.net.http.HttpClient;
// import java.net.http.HttpRequest;
// import java.net.http.HttpResponse;
// // import org.json.JSONObject;

// public class PaymentService {

//     public static String initiatePayment(String rollno, String amount) {
//         HttpClient client = HttpClient.newHttpClient();
//         HttpRequest request = HttpRequest.newBuilder()
//             .uri(URI.create("https://api.yourbackend.com/initiatePayment"))
//             .header("Content-Type", "application/json")
//             .POST(HttpRequest.BodyPublishers.ofString(new JSONObject()
//                 .put("rollno", rollno)
//                 .put("amount", amount)
//                 .toString()))
//             .build();

//         try {
//             HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//             return response.body(); // Assume the response contains a payment URL
//         } catch (IOException | InterruptedException e) {
//             e.printStackTrace();
//             return null;
//         }
//     }
// }
