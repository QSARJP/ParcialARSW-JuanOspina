package edu.eci.arsw.AirportsFinderBackend;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = AirportsFinderBackend.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class AirportsFinderBackendTest {

    @Autowired
	private MockMvc mvc;

    @Test
    public void getAirportByName() throws Exception{
        
        
        //not found
	    mvc.perform(MockMvcRequestBuilders
        .get("/airports/not-a-city"))
        .andExpect(status().isNotFound());
         
	    //found
	    mvc.perform(MockMvcRequestBuilders
                .get("/airports/berlin"))
                .andExpect(status().isAccepted());

                
    }

   
}
