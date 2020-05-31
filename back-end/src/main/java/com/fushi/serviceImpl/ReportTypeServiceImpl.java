package com.fushi.serviceImpl;

import com.fushi.config.Notifications;
import com.fushi.dto.ResponseCode;
import com.fushi.model.AmentitiesModel;
import com.fushi.model.ReportTypeModel;
import com.fushi.repository.AmentitiesRepository;
import com.fushi.repository.ReportTypeRepository;
import com.fushi.service.ReportTypeService;
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
public class ReportTypeServiceImpl implements ReportTypeService {

    @Autowired
    private ReportTypeRepository reportTypeRepository;
    private final Logger logger = LoggerFactory.getLogger(ReportTypeServiceImpl.class);


    @Override
    public Response<PaginationResponse<ReportTypeModel>> getAllBy(PaginationRequest pagePaginationRequest) {
        Response<PaginationResponse<ReportTypeModel>> response = new  Response<PaginationResponse<ReportTypeModel>>();

        try{
            Page<ReportTypeModel> pagination = reportTypeRepository.findAll(PageRequest.of(pagePaginationRequest.getPageNumber() - 1, pagePaginationRequest.getPageSize()));

            PaginationResponse<ReportTypeModel> list = new PaginationResponse<ReportTypeModel>();
            list.setList(pagination.getContent());
            list.setTotal(pagination.getTotalPages());


            return response.setStatusCode(ResponseCode.SUCCESS).setMessage(Notifications.SUCCESS).setData(list);

        } catch (Exception e){

            logger.error(e.toString());
            return response.setStatusCode(ResponseCode.ERROR).setMessage(Notifications.ERROR);

        }
    }

    @Override
    public Response insert(ReportTypeModel reportType) {
        Response response = new Response();
        try{

            this.reportTypeRepository.save(reportType);

            return response.setStatusCode(ResponseCode.SUCCESS).setMessage(Notifications.SUCCESS);

        }catch (Exception e){
            logger.error(e.toString());
            return response.setStatusCode(ResponseCode.ERROR).setMessage(Notifications.ERROR);
        }
    }

    @Override
    public Response update(ReportTypeModel model,Integer id) {
        Response response = new Response();
        try{

            var reportType = this.reportTypeRepository.findById(id);

            if(reportType.get() == null){
                return response.setStatusCode(ResponseCode.ERROR).setMessage(Notifications.NOT_FOUND);
            }

            reportType.get().setReportContent(model.getReportContent());

            this.reportTypeRepository.save(reportType.get());

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

            this.reportTypeRepository.deleteById(id);

            return response.setStatusCode(ResponseCode.SUCCESS).setMessage(Notifications.SUCCESS);

        }catch (Exception e){
            logger.error(e.toString());
            return response.setStatusCode(ResponseCode.ERROR).setMessage(Notifications.ERROR);
        }
    }

}
