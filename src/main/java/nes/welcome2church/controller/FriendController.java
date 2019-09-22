package nes.welcome2church.controller;

import nes.welcome2church.po.Friend;
import nes.welcome2church.repository.FriendRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/friends")
@CrossOrigin(origins = "*")
public class FriendController {

    @Resource(name = "friendRepository")
    FriendRepository repository;

    @GetMapping("/{id}")
    @ResponseBody
    public Friend getFriend(@PathVariable("id") String friendId) {
        Optional<Friend> friend = repository.findById(friendId);
        return friend.get();
    }

    @GetMapping("/today")
    @ResponseBody
    public List<Friend> getFriendByCurrentDate() {
        List<Friend> friends = repository.getFriendsByCurrentDate();
        return friends;
    }

    @PostMapping
    public Friend insertFriend(@RequestBody Friend friend) {
        return repository.save(friend);
    }
}

