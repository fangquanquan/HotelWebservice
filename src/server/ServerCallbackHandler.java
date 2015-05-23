
/**
 * ServerCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package server;

    /**
     *  ServerCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class ServerCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public ServerCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public ServerCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for getVacancy method
            * override this method for handling normal response from getVacancy operation
            */
           public void receiveResultgetVacancy(
                    server.GetVacancyResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getVacancy operation
           */
            public void receiveErrorgetVacancy(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getCityList method
            * override this method for handling normal response from getCityList operation
            */
           public void receiveResultgetCityList(
                    server.GetCityListResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getCityList operation
           */
            public void receiveErrorgetCityList(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getHotelList method
            * override this method for handling normal response from getHotelList operation
            */
           public void receiveResultgetHotelList(
                    server.GetHotelListResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getHotelList operation
           */
            public void receiveErrorgetHotelList(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getRoomrate method
            * override this method for handling normal response from getRoomrate operation
            */
           public void receiveResultgetRoomrate(
                    server.GetRoomrateResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getRoomrate operation
           */
            public void receiveErrorgetRoomrate(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for bookRoom method
            * override this method for handling normal response from bookRoom operation
            */
           public void receiveResultbookRoom(
                    server.BookRoomResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from bookRoom operation
           */
            public void receiveErrorbookRoom(java.lang.Exception e) {
            }
                


    }
    