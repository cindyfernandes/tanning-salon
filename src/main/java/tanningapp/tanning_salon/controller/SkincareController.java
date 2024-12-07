// package tanningapp.tanning_salon.controller;

// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.ResponseBody;


// @Controller
// public class SkincareController {

//     // @Autowired
//     // private ChatGPTService chatGPTService;

//     @GetMapping("/skincareTips")
//     public String showSkincareTipsPage() {
//         return "skincare_tips"; 
//     }

//     @PostMapping("/skincareTips/advice")
//     @ResponseBody
//     public String getSkincareTips(@RequestParam String skinTone) {
//         String userMessage = String.format("What are the skincare tips for %s skin before and after artificial tanning in Ireland?", skinTone);
//         return "www";
//         //return chatGPTService.getChatGPTResponse(userMessage);
//     }
// }
