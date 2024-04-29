package com.capstone.dayj.friendGroup;

import com.capstone.dayj.exception.CustomException;
import com.capstone.dayj.exception.ErrorCode;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FriendGroupService {
    private final FriendGroupRepository friendGroupRepository;

    public void createFriendGroup(FriendGroup group) {
        friendGroupRepository.save(group);
    }
    
    public List<FriendGroup> readAllFriendGroup() {
        List<FriendGroup> friendGroups = friendGroupRepository.findAll();
        
        if (friendGroups.isEmpty())
            throw new CustomException(ErrorCode.FRIEND_GROUP_NOT_FOUND);
        
        return friendGroupRepository.findAll();
    }

    @Transactional
    public FriendGroupDto.Response readFriendGroupById(int id) {
        FriendGroup friendGroup = friendGroupRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.FRIEND_GROUP_NOT_FOUND));

        return new FriendGroupDto.Response(friendGroup);
    }

    @Transactional
    public void updateFriendGroup(int id, FriendGroupDto.Request dto) {
        FriendGroup existingFriendGroup = friendGroupRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.FRIEND_GROUP_NOT_FOUND));

        existingFriendGroup.update(dto.getGroupName());
    }
    
    public void deleteFriendGroupById(int id) {
        friendGroupRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.FRIEND_GROUP_NOT_FOUND));
        
        friendGroupRepository.deleteById(id);
    }
}
