package com.bs23.travelagencynetwork.service;

import com.bs23.travelagencynetwork.dto.StatusDTO;
import com.bs23.travelagencynetwork.dto.UserPostDTO;
import com.bs23.travelagencynetwork.entity.Status;
import com.bs23.travelagencynetwork.entity.User;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface PostService {
    List<StatusDTO> findByUserEmail(String email);
    public void save(UserPostDTO userPostDTO, HttpServletRequest request);
    public Status findById(Long postId);
    public void updatePost(StatusDTO statusDTO, HttpServletRequest request);
    public void updatePrivacy(StatusDTO statusDTO, HttpServletRequest request);
    public List<StatusDTO> getAllPublicPost(HttpServletRequest request);
}
