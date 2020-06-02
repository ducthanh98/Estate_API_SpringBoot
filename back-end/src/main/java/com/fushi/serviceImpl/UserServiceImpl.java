package com.fushi.serviceImpl;

import com.fushi.config.Notifications;
import com.fushi.dto.ResponseCode;
import com.fushi.dto.auth.dto.ChangePassDTO;
import com.fushi.dto.auth.dto.UserDTO;
import com.fushi.dto.auth.dto.UserInfoDTO;
import com.fushi.dto.auth.ro.AuthenticationInformation;
import com.fushi.dto.auth.ro.UserRO;
import com.fushi.dto.observe.ObserveDTO;
import com.fushi.model.ReportTypeModel;
import com.fushi.model.UserModel;
import com.fushi.repository.UserRepository;
import com.fushi.service.UserService;
import com.fushi.util.*;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MailProvider mailProvider;

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public Response<AuthenticationInformation> login(String email, String password) {
        Response response = new Response<String>();

        try{

            UserModel userModel = userRepository.findByEmailAndPassword(email,password);


            if(userModel == null){

                return response.setStatusCode(ResponseCode.ERROR).setMessage(Notifications.EMAIL_PASS_INCORRECT);

            } else if(!userModel.getActive()) {

                return response.setStatusCode(ResponseCode.ERROR).setMessage(Notifications.USER_NOT_ACTIVE);

            } else {

                UserRO userRO = modelMapper.map(userModel, UserRO.class);
                String token = JwtProvider.generateToken(userRO);

                AuthenticationInformation authenticationInformation = new AuthenticationInformation();
                authenticationInformation.setAccess_token(token).setUser_info(userRO);


                return response.setStatusCode(ResponseCode.SUCCESS).setMessage(Notifications.SUCCESS).setData(authenticationInformation);
            }

        } catch (Exception e){

            logger.error(e.toString());
            return response.setStatusCode(ResponseCode.ERROR).setMessage(Notifications.ERROR);

        }

    }

    @Override
    public Response register(UserDTO dto) {
        Response response = new Response();
        try{

            var isExist = this.userRepository.existsByEmail(dto.getEmail());
            if(isExist){
                return response.setStatusCode(ResponseCode.ERROR).setMessage(Notifications.EMAIL_EXIST);
            }

            UserModel data = modelMapper.map(dto, UserModel.class);


            UUID uuid = UUID.randomUUID();
            data.setCode(uuid.toString());
            userRepository.save(data);


            mailProvider.sendActiveMail(data.getEmail(),data.getCode());
            return response.setStatusCode(ResponseCode.SUCCESS).setMessage(Notifications.SUCCESS);

        }catch (Exception e){
            logger.error(e.toString());
            return response.setStatusCode(ResponseCode.ERROR).setMessage(Notifications.ERROR);
        }
    }


    @Override
    public Response active(Integer id,String code) {
        Response response = new Response();
        try{

            Optional<UserModel> account = this.userRepository.findById(id);
            if(account == null){
                return response.setStatusCode(ResponseCode.ERROR).setMessage(Notifications.ACCOUNT_NOT_EXIST);
            }

           if(account.get().getCode().equals(code)){
                account.get().setCode("");
                account.get().setActive(true);
           }


            return response.setStatusCode(ResponseCode.SUCCESS).setMessage(Notifications.SUCCESS);

        }catch (Exception e){
            logger.error(e.toString());
            return response.setStatusCode(ResponseCode.ERROR).setMessage(Notifications.ERROR);
        }
    }

    @Override
    public Response<PaginationResponse<UserModel>> getAllBy(PaginationRequest pagePaginationRequest) {
        Response<PaginationResponse<UserModel>> response = new  Response<PaginationResponse<UserModel>>();

        try{
            Page<UserModel> pagination = userRepository.findAllByRoleNot(0,PageRequest.of(pagePaginationRequest.getPageNumber() - 1, pagePaginationRequest.getPageSize()));

            PaginationResponse<UserModel> list = new PaginationResponse<UserModel>();
            list.setList(pagination.getContent());
            list.setTotal(pagination.getTotalPages());


            return response.setStatusCode(ResponseCode.SUCCESS).setMessage(Notifications.SUCCESS).setData(list);

        } catch (Exception e){

            logger.error(e.toString());
            return response.setStatusCode(ResponseCode.ERROR).setMessage(Notifications.ERROR);

        }
    }

    @Override
    public Response updateUserInfo(Integer id, UserInfoDTO user) {
        Response response = new Response();
        try{

            var account = this.userRepository.findById(id).get();
            if(account == null){
                return response.setStatusCode(ResponseCode.ERROR).setMessage(Notifications.ACCOUNT_NOT_EXIST);
            }

            account.setName(user.getName());
            account.setPhone(user.getPhone());
            account.setFacebook(user.getFacebook());
            account.setSkype(user.getSkype());

            userRepository.save(account);

            return response.setStatusCode(ResponseCode.SUCCESS).setMessage(Notifications.SUCCESS);

        }catch (Exception e){
            logger.error(e.toString());
            return response.setStatusCode(ResponseCode.ERROR).setMessage(Notifications.ERROR);
        }
    }

    @Override
    public Response update(Integer id, UserDTO user) {
        Response response = new Response();
        try{

            var account = this.userRepository.findById(id).get();
            if(account == null){
                return response.setStatusCode(ResponseCode.ERROR).setMessage(Notifications.ACCOUNT_NOT_EXIST);
            }

            account.setName(user.getName());
            account.setPhone(user.getPhone());
            account.setEmail(user.getEmail());
            account.setPassword(user.getPassword());
            account.setActive(user.getActive());
            account.setRole(user.getRole());



            userRepository.save(account);

            return response.setStatusCode(ResponseCode.SUCCESS).setMessage(Notifications.SUCCESS);

        }catch (Exception e){
            logger.error(e.toString());
            return response.setStatusCode(ResponseCode.ERROR).setMessage(Notifications.ERROR);
        }
    }

    @Override
    public Response changePassword(Integer id, ChangePassDTO info) {
        Response response = new Response();
        try{

            var account = this.userRepository.findById(id).get();
            if(account == null){
                return response.setStatusCode(ResponseCode.ERROR).setMessage(Notifications.ACCOUNT_NOT_EXIST);
            }

            if(!account.getPassword().equals(info.getOldPass())){
                return response.setStatusCode(ResponseCode.ERROR).setMessage(Notifications.EMAIL_PASS_INCORRECT);
            }

            account.setPassword(info.getPassword());

            userRepository.save(account);

            return response.setStatusCode(ResponseCode.SUCCESS).setMessage(Notifications.SUCCESS);

        }catch (Exception e){
            logger.error(e.toString());
            return response.setStatusCode(ResponseCode.ERROR).setMessage(Notifications.ERROR);
        }
    }

    @Override
    public Response observe(ObserveDTO dto) {
        Response response = new Response();
        try{
            UserModel account = this.userRepository.findByEmail(dto.getEmail());
            if(account == null){
                return response.setStatusCode(ResponseCode.ERROR).setMessage(Notifications.ACCOUNT_NOT_EXIST);
            }


            account.setSubcribe(true);

            userRepository.save(account);

            return response.setStatusCode(ResponseCode.SUCCESS).setMessage(Notifications.SUCCESS);

        }catch (Exception e){
            logger.error(e.toString());
            return response.setStatusCode(ResponseCode.ERROR).setMessage(Notifications.ERROR);
        }
    }

}
