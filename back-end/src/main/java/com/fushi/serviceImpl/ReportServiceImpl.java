package com.fushi.serviceImpl;

import com.fushi.config.Notifications;
import com.fushi.dto.ResponseCode;
import com.fushi.model.AmentitiesModel;
import com.fushi.model.ReportModel;
import com.fushi.repository.AmentitiesRepository;
import com.fushi.repository.ReportRepository;
import com.fushi.service.ReportService;
import com.fushi.util.PaginationRequest;
import com.fushi.util.PaginationResponse;
import com.fushi.util.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportRepository reportRepository;
    private final Logger logger = LoggerFactory.getLogger(ReportServiceImpl.class);


    @Override
    public Response insertOrUpdate(ReportModel report) {
        Response response = new Response();
        try{

            this.reportRepository.save(report);

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

            this.reportRepository.deleteById(id);

            return response.setStatusCode(ResponseCode.SUCCESS).setMessage(Notifications.SUCCESS);

        }catch (Exception e){
            logger.error(e.toString());
            return response.setStatusCode(ResponseCode.ERROR).setMessage(Notifications.ERROR);
        }
    }

    @Override
    public Response<PaginationResponse<ReportModel>> getAllBy(PaginationRequest pagePaginationRequest) {
        Response<PaginationResponse<ReportModel>> response = new  Response<PaginationResponse<ReportModel>>();

        try{
            Page<ReportModel> pagination = reportRepository.findAll(PageRequest.of(pagePaginationRequest.getPageNumber(), pagePaginationRequest.getPageSize()));

            PaginationResponse<ReportModel> list = new PaginationResponse<ReportModel>();
            list.setList(pagination.getContent());
            list.setTotal(pagination.getTotalPages());


            return response.setStatusCode(ResponseCode.SUCCESS).setMessage(Notifications.SUCCESS).setData(list);

        } catch (Exception e){

            logger.error(e.toString());
            return response.setStatusCode(ResponseCode.ERROR).setMessage(Notifications.ERROR);

        }
    }
}
