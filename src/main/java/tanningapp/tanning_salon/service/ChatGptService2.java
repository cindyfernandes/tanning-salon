package tanningapp.tanning_salon.service;

import java.io.IOException;
import java.util.List;

import io.github.sashirestela.openai.SimpleOpenAI;
import io.github.sashirestela.openai.domain.chat.ChatMessage;
import io.github.sashirestela.openai.domain.chat.ChatRequest;

public class ChatGptService2 {
    private static ChatRequest createChatRequest(List<ChatMessage> chatMessages) {
        var maxTokens = 0;
        var temperature = 0.0;
        return ChatRequest.builder().model("gpt-3.5-turbo-0125").maxCompletionTokens(maxTokens).temperature(temperature)
                .messages(chatMessages).build();
    }

    public static void main(String[] args) throws IOException {
        SimpleOpenAI openAI = SimpleOpenAI.builder()
        .apiKey("")
        .build();

        String systemMessage = "You are an AI expert in skincare and tanning session.";
        String userMessage = String.format("What are the skincare tips for %s skin before and after artificial tanning?", "skincare");

        ChatMessage system = ChatMessage.SystemMessage.of(systemMessage);
        ChatMessage user = ChatMessage.UserMessage.of(userMessage);
        List<ChatMessage> chatMessages = List.of(system, user);


        ChatRequest chatRequest = createChatRequest(chatMessages);

        var futureChat = openAI.chatCompletions().create(chatRequest);
        var chatResponse = futureChat.join();
        System.out.println(chatResponse.firstContent());


        
        //List<ChatMessage> chatMessages2 = List.of(system, user);
    }

}
