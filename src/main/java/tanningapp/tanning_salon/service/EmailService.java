package tanningapp.tanning_salon.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

@Service
public class EmailService {

    @Value("${sendgrid.api-key}") // Injects the SendGrid API key from application properties.
    private String sendgridApiKey;

    // Sends an approval email to the specified recipient.
    public void sendApprovalEmail(String recipientEmail, String clientName) {
        // Constructs the email payload in JSON format.
        String emailPayload = "{\n" +
                "  \"personalizations\": [\n" +
                "    {\n" +
                "      \"to\": [\n" +
                "        {\n" +
                "          \"email\": \"" + recipientEmail + "\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"subject\": \"Registration Approved\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"from\": {\n" +
                "    \"email\": \"tanningsalonie1@gmail.com\"\n" +
                "  },\n" +
                "  \"content\": [\n" +
                "    {\n" +
                "      \"type\": \"text/html\",\n" +
                "      \"value\": \"<p>Hello " + clientName + ",</p><p>Your registration has been successfully approved! Welcome to Tanning Salon!</p>\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        // Configures SendGrid and sends the email.
        SendGrid sg = new SendGrid(sendgridApiKey);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setBaseUri("https://api.sendgrid.com/v3");
            request.setEndpoint("mail/send");
            request.setBody(emailPayload);
            Response response = sg.api(request);

            // Logs the response for debugging purposes.
            System.out.println("Status Code: " + response.getStatusCode());
            System.out.println("Response Body: " + response.getBody());
            System.out.println("Response Headers: " + response.getHeaders());
        } catch (IOException e) {
            // Handles exceptions related to the SendGrid API call.
            e.printStackTrace();
        }
    }
}
