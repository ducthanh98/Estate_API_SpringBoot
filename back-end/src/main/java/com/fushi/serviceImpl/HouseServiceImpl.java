package com.fushi.serviceImpl;

import com.fushi.config.Notifications;
import com.fushi.dto.ResponseCode;
import com.fushi.dto.house.HouseDTO;
import com.fushi.model.*;
import com.fushi.repository.AmentitiesRepository;
import com.fushi.repository.HouseRepository;
import com.fushi.repository.ReportRepository;
import com.fushi.repository.UserRepository;
import com.fushi.service.HouseService;
import com.fushi.util.PaginationRequest;
import com.fushi.util.PaginationResponse;
import com.fushi.util.Response;
import com.fushi.util.Uploads;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AmentitiesRepository amentitiesRepository;

    private final Logger logger = LoggerFactory.getLogger(HouseServiceImpl.class);


    @Override
    public Response<List<HouseModel>> getNewest() {
        Response response = new Response<List<HouseModel>>();

        try{

            Pageable pageable = (Pageable) PageRequest.of(0,6, Sort.by(Sort.Direction.DESC,"created"));

            List<HouseModel> list = this.houseRepository.findAllByStatus(false,pageable).getContent();

            return response.setStatusCode(ResponseCode.SUCCESS).setMessage(Notifications.SUCCESS).setData(list);

        } catch (Exception e){

            logger.error(e.toString());
            return response.setStatusCode(ResponseCode.ERROR).setMessage(Notifications.ERROR);

        }
    }

    @Override
    public Response<HouseModel> getByID(Integer id) {
        Response response = new Response<HouseModel>();

        try{


            HouseModel houseModel = this.houseRepository.findById(id).get();

            if(houseModel == null){
                return response.setStatusCode(ResponseCode.ERROR).setMessage(Notifications.NOT_FOUND);
            }

            return response.setStatusCode(ResponseCode.SUCCESS).setMessage(Notifications.SUCCESS).setData(houseModel);

        } catch (Exception e){

            logger.error(e.toString());
            return response.setStatusCode(ResponseCode.ERROR).setMessage(Notifications.ERROR);

        }
    }

    @Override
    public Response insert(HouseDTO houseDTO) {
        Response response = new Response();

        try {
            if(houseDTO.getFiles().length == 0){
                return response.setStatusCode(ResponseCode.ERROR).setMessage(Notifications.ERROR);
            }

            List<AmentitiesModel> amentities = amentitiesRepository.findByIdIn(houseDTO.getAmentities());

            UserModel userModel = userRepository.findById(houseDTO.getUserId()).get();
            List<GalleryModel> galleryModels = new ArrayList<GalleryModel>();
            HouseModel houseModel = new HouseModel();

            amentities.forEach(x -> x.getHouses().add(houseModel));


            for(int i = 0;i<houseDTO.getFiles().length;i++){

                String filename = Uploads.writeFile(houseDTO.getFiles()[i]);
                if(!filename.equals("")){

                    GalleryModel galleryModel = new GalleryModel();
                    galleryModel.setImgName(filename);
                    galleryModel.setPost(houseModel);

                    galleryModels.add(galleryModel);

                }

            }

            houseModel.setTitle(houseDTO.getTitle());
            houseModel.setArea(houseDTO.getArea());
            houseModel.setBathrooms(houseDTO.getBathrooms());
            houseModel.setBedrooms(houseDTO.getBedrooms());
            houseModel.setDescription(houseDTO.getDescription());
            houseModel.setLat(houseDTO.getLat());
            houseModel.setLng(houseDTO.getLng());
            houseModel.setPrice(houseDTO.getPrice());
            houseModel.setLocation(houseDTO.getLocation());
            houseModel.setAmentities(amentities);
            houseModel.setImages(galleryModels);
            houseModel.setAuthor(userModel);

            houseRepository.save(houseModel);

            return response.setStatusCode(ResponseCode.SUCCESS).setMessage(Notifications.SUCCESS).setData(Notifications.SUCCESS);

        } catch (Exception e){
            logger.error(e.toString());
            return response.setStatusCode(ResponseCode.ERROR).setMessage(Notifications.ERROR);
        }
    }

    @Override
    public Response update(HouseModel report, Integer id) {
        return null;
    }

    @Override
    public Response delete(Integer id) {
        return null;
    }

    @Override
    public Response<PaginationResponse<HouseModel>> getAllBy(PaginationRequest pagePaginationRequest) {
        Response<PaginationResponse<HouseModel>> response = new  Response<PaginationResponse<HouseModel>>();

        try{
            Page<HouseModel> pagination = houseRepository.findAllByStatus(false,PageRequest.of(pagePaginationRequest.getPageNumber() - 1, pagePaginationRequest.getPageSize()));

            PaginationResponse<HouseModel> list = new PaginationResponse<HouseModel>();
            list.setList(pagination.getContent());
            list.setTotal(pagination.getTotalPages());


            return response.setStatusCode(ResponseCode.SUCCESS).setMessage(Notifications.SUCCESS).setData(list);

        } catch (Exception e){

            logger.error(e.toString());
            return response.setStatusCode(ResponseCode.ERROR).setMessage(Notifications.ERROR);

        }
    }

    @Override
    public Response<List<HouseModel>> searchAdvanced(String title,String location,Float area,Float area2, Float price,Float price2,Integer bedrooms,Integer bathrooms) {
        Response<List<HouseModel>> response = new  Response<List<HouseModel>>();

        try{
            List<HouseModel> list = houseRepository.findAllByStatusAndTitleContainsAndLocationContainsAndAreaBetweenAndPriceBetweenAndBedroomsAndBathrooms(false,title,location,area,area2,price,price2,bedrooms,bathrooms);


            return response.setStatusCode(ResponseCode.SUCCESS).setMessage(Notifications.SUCCESS).setData(list);

        } catch (Exception e){

            logger.error(e.toString());
            return response.setStatusCode(ResponseCode.ERROR).setMessage(Notifications.ERROR);

        }
    }
}
