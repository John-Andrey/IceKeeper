package com.tweb.icekeeper;

import com.tweb.icekeeper.Service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class IceKeeperApplicationTests {




    @Autowired
    private UserService userService;  // Inietta il servizio reale

    @Test
    void contextLoads() {
        // Verifica che il bean UserService sia caricato correttamente
        assertNotNull(userService);
    }

}

