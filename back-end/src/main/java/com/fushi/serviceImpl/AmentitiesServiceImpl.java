package com.fushi.serviceImpl;

import com.fushi.config.Notifications;
import com.fushi.dto.ResponseCode;
import com.fushi.dto.amentities.AmentitiesDTO;
import com.fushi.model.AmentitiesModel;
import com.fushi.repository.AmentitiesRepository;
import com.fushi.service.AmentitiesService;
import com.fushi.util.PaginationRequest;
import com.fushi.util.PaginationResponse;
import com.fushi.util.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmentitiesServiceImpl implements AmentitiesService {
    @Autowired
    private AmentitiesRepository amentitiesRepository;
    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public Response<List<AmentitiesModel>> getAll() {
        Response response = new Response<List<AmentitiesModel>>();

        try{

            List<AmentitiesModel> list = amentitiesRepository.findAll();

            return response.setStatusCode(ResponseCode.SUCCESS).setMessage(Notifications.SUCCESS).setData(list);

        } catch (Exception e){

            logger.error(e.toString());
            return response.setStatusCode(ResponseCode.ERROR).setMessage(Notifications.ERROR);

        }
    }

    @Override
    public Response<PaginationResponse<AmentitiesModel>> getAllBy(PaginationRequest pagePaginationRequest) {
        Response<PaginationResponse<AmentitiesModel>> response = new  Response<PaginationResponse<AmentitiesModel>>();

        try{
            Page<AmentitiesModel> pagination = amentitiesRepository.findAll(PageRequest.of(pagePaginationRequest.getPageNumber() - 1, pagePaginationRequest.getPageSize()));

            PaginationResponse<AmentitiesModel> list = new PaginationResponse<AmentitiesModel>();
            list.setList(pagination.getContent());
            list.setTotal(pagination.getTotalPages());


            return response.setStatusCode(ResponseCode.SUCCESS).setMessage(Notifications.SUCCESS).setData(list);

        } catch (Exception e){

            logger.error(e.toString());
            return response.setStatusCode(ResponseCode.ERROR).setMessage(Notifications.ERROR);

        }
    }

    @Override
    public Response insert(AmentitiesDTO amentities) {
        Response response = new Response();
        try{
            AmentitiesModel amentitiesModel = new AmentitiesModel();
            amentitiesModel.setName(amentities.getName());
            amentitiesModel.setIcon(amentities.getIcon());

            this.amentitiesRepository.save(amentitiesModel);

            return response.setStatusCode(ResponseCode.SUCCESS).setMessage(Notifications.SUCCESS);

        }catch (Exception e){
            logger.error(e.toString());
            return response.setStatusCode(ResponseCode.ERROR).setMessage(Notifications.ERROR);
        }
    }

    @Override
    public Response update(Integer id,AmentitiesDTO amentities) {
        Response response = new Response();
        try{
            AmentitiesModel amentitiesModel = amentitiesRepository.findById(id).get();

            if(amentitiesModel == null){
                return response.setStatusCode(ResponseCode.ERROR).setMessage(Notifications.NOT_FOUND);

            }

            amentitiesModel.setName(amentities.getName());
            amentitiesModel.setIcon(amentities.getIcon());

            this.amentitiesRepository.save(amentitiesModel);

            return response.setStatusCode(ResponseCode.SUCCESS).setMessage(Notifications.SUCCESS);

        }catch (Exception e){
            logger.error(e.toString());
            return response.setStatusCode(ResponseCode.ERROR).setMessage(Notifications.ERROR);
        }
    }

    @Override
    public Response delete(Integer id) {
        Response response = new Response();
        try{

            this.amentitiesRepository.deleteById(id);

            return response.setStatusCode(ResponseCode.SUCCESS).setMessage(Notifications.SUCCESS);

        }catch (Exception e){
            logger.error(e.toString());
            return response.setStatusCode(ResponseCode.ERROR).setMessage(Notifications.ERROR);
        }
    }
}
