// package tanningapp.tanning_salon.service;

// import java.util.HashMap;
// import java.util.Map;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Service;
// import org.springframework.web.client.RestTemplate;

// import com.fasterxml.jackson.databind.JsonNode;
// import com.fasterxml.jackson.databind.ObjectMapper;

// @Service
// public class ChatGPTService {

//     private final RestTemplate restTemplate;

//     @Value("${openai.api.key}")
//     private String apiKey;

//     @Value("${openai.api.url}")
//     private String apiUrl;

//     public ChatGPTService(RestTemplate restTemplate) {
//         this.restTemplate = restTemplate;
//     }

//     public String getChatGPTResponse(String userMessage) {
//         try {
//             // Build the request body
//             Map<String, Object> requestBody = new HashMap<>();
//             requestBody.put("model", "gpt-3.5-turbo");
//             requestBody.put("messages", new Object[]{
//                     Map.of("role", "system", "content", "You are a specialized assistant for artificial tanning."),
//                     Map.of("role", "user", "content", userMessage)
//             });
//             requestBody.put("max_tokens", 300);

//             // Build headers
//             org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
//             headers.set("Authorization", "Bearer " + apiKey);
//             headers.set("Content-Type", "application/json");

//             // Make the API call
//             String response = restTemplate.postForObject(
//                     apiUrl,
//                     new org.springframework.http.HttpEntity<>(requestBody, headers),
//                     String.class
//             );

//             // Parse the response
//             JsonNode responseBody = new ObjectMapper().readTree(response);
//             return responseBody.path("choices").get(0).path("message").path("content").asText();

//         } catch (Exception e) {
//             e.printStackTrace();
//             return "Sorry, I couldn't fetch tips at the moment.";
//         }
//     }
// }
