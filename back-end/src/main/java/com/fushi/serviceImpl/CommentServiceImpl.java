package com.fushi.serviceImpl;

import com.fushi.config.Notifications;
import com.fushi.dto.ResponseCode;
import com.fushi.dto.comment.CommentDTO;
import com.fushi.model.CommentModel;
import com.fushi.model.HouseModel;
import com.fushi.model.UserModel;
import com.fushi.repository.AmentitiesRepository;
import com.fushi.repository.CommentRepository;
import com.fushi.repository.HouseRepository;
import com.fushi.repository.UserRepository;
import com.fushi.service.CommentService;
import com.fushi.util.MailProvider;
import com.fushi.util.PaginationRequest;
import com.fushi.util.PaginationResponse;
import com.fushi.util.Response;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private UserRepository userRepository;

    private final Logger logger = LoggerFactory.getLogger(CommentServiceImpl.class);

    @Override
    public Response insert(CommentDTO dto) {

        Response response = new Response();
        try{

            UserModel userModel = this.userRepository.findById(dto.getUserID()).get();
            HouseModel houseModel = this.houseRepository.findById(dto.getPostID()).get();

            if(userModel == null || houseModel == null){
                return response.setStatusCode(ResponseCode.ERROR).setMessage(Notifications.NOT_FOUND);
            }

            CommentModel commentModel = new CommentModel();
            commentModel.setComment(dto.getComment());
            commentModel.setPost(houseModel);
            commentModel.setUser(userModel);

            commentRepository.save(commentModel);

            return response.setStatusCode(ResponseCode.SUCCESS).setMessage(Notifications.SUCCESS);

        }catch (Exception e){
            logger.error(e.toString());
            return response.setStatusCode(ResponseCode.ERROR).setMessage(Notifications.ERROR);
        }

    }

    @Override
    public Response update(CommentModel comment, Integer id) {
        return null;
    }

    @Override
    public Response delete(Integer id) {
        return null;
    }

    @Override
    public Response<PaginationResponse<CommentModel>> getAllBy(PaginationRequest pagePaginationRequest,Integer id) {
        Response<PaginationResponse<CommentModel>> response = new  Response<PaginationResponse<CommentModel>>();

        try{
            HouseModel houseModel = houseRepository.findById(id).get();

            if(houseModel == null){
                return response.setStatusCode(ResponseCode.ERROR).setMessage(Notifications.NOT_FOUND);
            }

            Page<CommentModel> pagination = commentRepository.findAllByPost(houseModel,PageRequest.of(pagePaginationRequest.getPageNumber() - 1, pagePaginationRequest.getPageSize()));

            PaginationResponse<CommentModel> list = new PaginationResponse<CommentModel>();
            list.setList(pagination.getContent());
            list.setTotal(pagination.getTotalPages());


            return response.setStatusCode(ResponseCode.SUCCESS).setMessage(Notifications.SUCCESS).setData(list);

        } catch (Exception e){

            logger.error(e.toString());
            return response.setStatusCode(ResponseCode.ERROR).setMessage(Notifications.ERROR);

        }
    }
}
