// package tanningapp.tanning_salon.controller;

// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.http.MediaType;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

// @SpringBootTest
// @AutoConfigureMockMvc
// public class RegisterControllerTest {

//     @Autowired
//     private MockMvc mockMvc;

//     @Test
//     public void testRegisterClient() throws Exception {
//         mockMvc.perform(MockMvcRequestBuilders.post("/registerpage")
//         .contentType(MediaType.APPLICATION_FORM_URLENCODED)
//         .param("firstname", "Test")
//         .param("lastname", "User")
//         .param("dateOfBirth", "1995-01-01") 
//         .param("email", "testuser@gmail.com")
//         .param("password", "testpassword"))
//         .andExpect(status().isOk())
//         .andExpect(view().name("register_success"))
//         .andExpect(model().attributeExists("client"));
//     }
// }
