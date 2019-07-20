package com.bs23.travelagencynetwork.service;

import com.bs23.travelagencynetwork.dto.StatusDTO;
import com.bs23.travelagencynetwork.dto.UserPostDTO;
import com.bs23.travelagencynetwork.entity.Location;
import com.bs23.travelagencynetwork.entity.Status;
import com.bs23.travelagencynetwork.entity.User;
import com.bs23.travelagencynetwork.repository.PostRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private static final Logger logger = LogManager.getLogger(PostServiceImpl.class);

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private LocationService locationService;

    @Override
    public void save(UserPostDTO userPostDTO, HttpServletRequest request) {
        User user = userService.findByEmail(request.getUserPrincipal().getName());
        Location location = locationService.getLocationById(userPostDTO.getLocation()).get();

        Status status = new Status();
        status.setPost(userPostDTO.getPost());
        status.setLocation(location);
        status.setUser(user);
        status.setPostPrivacy(userPostDTO.getPostPrivacy());

        postRepository.save(status);
    }

    @Override
    public void updatePost(StatusDTO statusDTO, HttpServletRequest request) {
        Status status = findById(statusDTO.getPostId());
        if(status != null) {
            status.setPost(statusDTO.getPost());
            if (request.getUserPrincipal().getName().equals(status.getUser().getEmail())) {
                postRepository.save(status);
            }
        }
    }

    @Override
    public void updatePrivacy(StatusDTO statusDTO, HttpServletRequest request) {
        Status status = findById(statusDTO.getPostId());
        if(status != null){
            status.setPostPrivacy(statusDTO.getPostPrivacy());
            if(request.getUserPrincipal().getName().equals(status.getUser().getEmail()) ) {
                postRepository.save(status);
            }
        }
    }

    @Override
    public Status findById(Long postId) {
        return postRepository.findById(postId).get();
    }

    @Override
    public List<StatusDTO> findByUserEmail(String email) {
        List<Status> statusList = postRepository.findByUserEmail(email);
        List<StatusDTO> statusDTOList = new ArrayList<StatusDTO>();


        for(Status status : statusList){
            statusDTOList.add(new StatusDTO(status.getId(),status.getPost(),status.getLocation().getLocation(),status.getPostPrivacy(),status.getPostedAt()));
        }

        return statusDTOList;
    }

    @Override
    public List<StatusDTO> getAllPublicPost(HttpServletRequest request) {
        User user = userService.findByEmail(request.getUserPrincipal().getName());
        List<Status> userSpecificStatusList = postRepository.findByUserWithPrivate(user);
        List<Status> publicStatusList = postRepository.getAllPublicPost();

        publicStatusList.addAll(userSpecificStatusList);
        List<StatusDTO> statusDTOList = new ArrayList<StatusDTO>();

        return statusDTOList;
    }

}
