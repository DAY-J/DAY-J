package com.capstone.dayj.appUserFriendGroup;

import com.capstone.dayj.appUser.AppUser;
import com.capstone.dayj.friendGroup.FriendGroup;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class AppUserFriendGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", referencedColumnName = "id")
    @JsonIgnore
    private AppUser appUser;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="friend_group_id", referencedColumnName = "id")
    @JsonIgnore
    private FriendGroup friendGroup;
}
