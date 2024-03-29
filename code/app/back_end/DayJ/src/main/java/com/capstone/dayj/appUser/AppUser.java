package com.capstone.dayj.appUser;

import com.capstone.dayj.appUserFriendGroup.AppUserFriendGroup;
import com.capstone.dayj.plan.Plan;
import com.capstone.dayj.post.Post;
import com.capstone.dayj.setting.Setting;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false)
    private String password;
    
    @OneToMany(mappedBy = "appUser")
    @JsonIgnore
    private List<AppUserFriendGroup> appUserFriendGroups;
    
    @OneToMany(mappedBy = "appUser")
    @JsonIgnore
    private List<Plan> plans;
    
    @OneToMany(mappedBy = "appUser")
    @JsonIgnore
    private List<Post> posts;
    
    @OneToOne(mappedBy = "appUser")
    @JsonIgnore
    private Setting setting;
}

    

