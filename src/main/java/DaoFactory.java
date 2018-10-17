public class DaoFactory {

    /*
    create a private static property that is an Ad object called adsDao;
    this Data Access Object handles information retrieved from a database table and manipulates it for the model class
     */

    private static Ads adsDao;


    /*
    create a static method that returns the adsDao; if the adsDao does not exist create one from the constructor
    */

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao();
        }
        return adsDao;
    }
}
