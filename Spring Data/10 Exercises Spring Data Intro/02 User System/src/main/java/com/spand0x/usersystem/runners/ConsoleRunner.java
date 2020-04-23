package com.spand0x.usersystem.runners;

import com.spand0x.usersystem.entities.User;
import com.spand0x.usersystem.services.AlbumService;
import com.spand0x.usersystem.services.PictureService;
import com.spand0x.usersystem.services.TownService;
import com.spand0x.usersystem.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private UserService userService;
    private PictureService pictureService;
    private AlbumService albumService;
    private TownService townService;

    public ConsoleRunner(UserService userService, PictureService pictureService, AlbumService albumService, TownService townService) {
        this.userService = userService;
        this.pictureService = pictureService;
        this.albumService = albumService;
        this.townService = townService;
    }

    @Override
    public void run(String... args) throws Exception {
//            addUsers(10);

//        this.userService.getUsersByEmailProvider("@gmail.com")
//                .forEach(u->{
//                    System.out.printf("%s %s%n",u.getUsername(),u.getEmail());
//                });

        System.out.println(this.userService.markForDeleteUsers(LocalDateTime.now().minusYears(1)));
        this.userService.deleteUsers();

    }
    private void addUsers(final int count) {
        for (int i = 1; i <= count; i++) {
            User user = new User();
            user.setUsername("Mariq" + i);
            user.setPassword("pasSWORD%" + i);
            user.setEmail("mail" + i + "x@gmail.com");
            user.setAge(i % 120 + 1);
            user.setFirstName("FirstM" + i);
            user.setLastName("LastM" + i);
            user.setRegisteredOn(LocalDateTime.now().minusYears(2));
            user.setLastTimeLoggedIn(LocalDateTime.now().minusYears(2));
            user.setDeleted(false);
            this.userService.save(user);
        }
    }
}
