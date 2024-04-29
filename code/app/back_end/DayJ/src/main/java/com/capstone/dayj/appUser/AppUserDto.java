package com.capstone.dayj.appUser;

import com.capstone.dayj.appUserFriendGroup.AppUserFriendGroup;
import com.capstone.dayj.comment.CommentDto;
import com.capstone.dayj.plan.Plan;
import com.capstone.dayj.post.PostDto;
import com.capstone.dayj.setting.Setting;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

public class AppUserDto {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request {

        private int id; //기본키
        private String name; //유저 이름
        private String nickname; // 유저 닉네임, 중복 불가, 친구 그룹 추가에 사용
        private String password; //유저 비밀번호
        private String email; //유저 구글 이메일
        private String role; //유저 권한
        private String provider; //공급자
        private String providerId; //공급 아이디

        public AppUser toEntity(){
            return AppUser.builder()
                    .id(id)
                    .name(name)
                    .nickname(nickname)
                    .password(password)
                    .email(email)
                    .role(role)
                    .provider(provider)
                    .providerId(providerId)
                    .build();
        }
    }

    @Getter
    public static class Response {
        private final int id; //기본키
        private final String name; //유저 이름
        private final String nickname; // 유저 닉네임, 중복 불가, 친구 그룹 추가에 사용
        private final String password; //유저 비밀번호
        private final String email; //유저 구글 이메일
        private final String role; //유저 권한
        private final String provider; //공급자
        private final String providerId; //공급 아이디
        private final List<AppUserFriendGroup> appUserFriendGroup;
        private final List<Plan> plans;
        private final List<PostDto.Response> posts;
        private final List<CommentDto.Response> comments;
        private final Setting setting;


        public Response(AppUser appUser){
            this.id = appUser.getId();
            this.name = appUser.getName();
            this.nickname = appUser.getNickname();
            this.password = appUser.getPassword();
            this.email = appUser.getEmail();
            this.role = appUser.getRole();
            this.provider = appUser.getProvider();
            this.providerId = appUser.getProviderId();
            this.appUserFriendGroup = appUser.getAppUserFriendGroup();
            this.plans = appUser.getPlans();
            this.posts = appUser.getPosts().stream().map(PostDto.Response::new).collect(Collectors.toList());
            this.comments = appUser.getComments().stream().map(CommentDto.Response::new).collect(Collectors.toList());
            this.setting = appUser.getSetting();
        }

    }
}