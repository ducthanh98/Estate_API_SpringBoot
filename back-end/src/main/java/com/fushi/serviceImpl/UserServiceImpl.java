package com.fushi.serviceImpl;

import com.fushi.util.Notifications;
import com.fushi.dto.ResponseCode;
import com.fushi.dto.auth.ro.AuthenticationInformation;
import com.fushi.dto.auth.ro.UserRO;
import com.fushi.model.UserModel;
import com.fushi.repository.UserRepository;
import com.fushi.service.UserService;
import com.fushi.util.JwtProvider;
import com.fushi.util.Response;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public Response<AuthenticationInformation> login(String email, String password) {
        Response response = new Response<String>();

        try{

            UserModel userModel = userRepository.findByEmailAndPassword(email,password);


            if(userModel == null){

                return response.setStatusCode(ResponseCode.ERROR).setMessage(Notifications.EMAIL_PASS_INCORRECT);

            } else if(!userModel.isActive()) {

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
    public Response<String> register(UserModel userModel) {
        try{
            

        }catch (Exception e){

        }
        return null;
    }

}
