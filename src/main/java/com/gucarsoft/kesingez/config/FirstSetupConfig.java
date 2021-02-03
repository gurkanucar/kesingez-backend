package com.gucarsoft.kesingez.config;


import com.gucarsoft.kesingez.model.user.Role;
import com.gucarsoft.kesingez.model.user.User;
import com.gucarsoft.kesingez.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class FirstSetupConfig implements ApplicationListener<ContextRefreshedEvent> {

    private boolean alreadySetup = false;

    @Autowired
    private UserRepository userRepo;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (!alreadySetup) {
            User adminUser = userRepo.findByUsername("admin");
            if (adminUser == null) {

                // CREATE ADMIN USER
                User newUser = new User();
                newUser.setUsername("admin");
                newUser.setPassword("admin123");
                newUser.setName("admin");
                newUser.setSurname("admin");
                newUser.setEmail("admin");
                newUser.setRole(Role.ADMIN);
                userRepo.save(newUser);
            }
            alreadySetup = true;
        }
    }


}
