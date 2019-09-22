package nes.welcome2church.repository;

import nes.welcome2church.po.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository("friendRepository")
public interface FriendRepository extends JpaRepository<Friend, String> {

    @Query(value= "SELECT * FROM tbl_friend WHERE DATE(first_visit_date) =DATE(CURDATE())",
            nativeQuery=true)
    public List<Friend> getFriendsByCurrentDate();


}