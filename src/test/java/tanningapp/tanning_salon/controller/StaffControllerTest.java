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
// public class StaffControllerTest {

//     @Autowired
//     private MockMvc mockMvc;

//     @Test
//     public void testApproveClient() throws Exception {
//         // Simule a aprovação de um cliente com ID 1
//         mockMvc.perform(MockMvcRequestBuilders.post("/staff/approve")
//         .contentType(MediaType.APPLICATION_JSON)
//         .param("id", "11")) 
//         .andExpect(status().isOk()) 
//         .andExpect(jsonPath("$.approved").value(true)) 
//         .andExpect(jsonPath("$.id").value("11")); 
//     }
// }
