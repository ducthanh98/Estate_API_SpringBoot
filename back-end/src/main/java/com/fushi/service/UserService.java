package com.fushi.service;

import com.fushi.dto.auth.dto.ChangePassDTO;
import com.fushi.dto.auth.dto.UserDTO;
import com.fushi.dto.auth.dto.UserInfoDTO;
import com.fushi.dto.auth.ro.AuthenticationInformation;
import com.fushi.dto.observe.ObserveDTO;
import com.fushi.model.ReportModel;
import com.fushi.model.UserModel;
import com.fushi.util.PaginationRequest;
import com.fushi.util.PaginationResponse;
import com.fushi.util.Response;

public interface UserService {
    Response<AuthenticationInformation> login(String email,String password);
    Response register(UserDTO userModel);
    Response active(Integer id,String code);
    Response<PaginationResponse<UserModel>> getAllBy(PaginationRequest pagePaginationRequest);
    Response updateUserInfo(Integer id, UserInfoDTO user);
    Response update(Integer id, UserDTO user);
    Response changePassword(Integer id, ChangePassDTO info);
    Response observe(ObserveDTO email);

}
