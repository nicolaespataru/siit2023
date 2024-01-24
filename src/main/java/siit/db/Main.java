package siit.db;

import siit.db.dao.AccommodationDao;
import siit.db.dao.AccommodationRoomFairRelationDao;
import siit.db.dao.RoomFairDao;
import siit.db.model.AccommodationModel;
import siit.db.model.AccommodationRoomFairRelation;
import siit.db.model.RoomFairModel;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        //Insert

        AccommodationModel accommodation = new AccommodationModel(1, "Hotel Room", "Double Bed", 2, "Comfortable room with a view");
        RoomFairModel roomFair = new RoomFairModel(1, 150.00, "Summer");

        AccommodationDao accommodationDao = new AccommodationDao();
        RoomFairDao roomFairDao = new RoomFairDao();

        accommodationDao.insertAccommodation(accommodation);
        roomFairDao.insertRoomFair(roomFair);



        //List
        AccommodationRoomFairRelationDao relationDao = new AccommodationRoomFairRelationDao();
        relationDao.insertAccommodationRoomFairRelation(1, 1);

        List<AccommodationRoomFairRelation> relations = relationDao.getAllRelations();

        for (AccommodationRoomFairRelation relation : relations) {
            int accommodationId = relation.getAccommodationId();
            double roomPrice = relation.getRoomPrice();

            System.out.println("Accommodation ID: " + accommodationId + ", Room Price: " + roomPrice);
        }
    }
}
