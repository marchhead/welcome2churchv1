package nes.welcome2church.repository;

import nes.welcome2church.po.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository("friendRepository")
public interface FriendRepository extends JpaRepository<Friend, String> {
}