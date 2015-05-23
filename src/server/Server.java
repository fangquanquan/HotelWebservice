

/**
 * Server.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package server;

    /*
     *  Server java interface
     */

    public interface Server {
          

        /**
          * Auto generated method signature
          * 
                    * @param getVacancy0
                
             * @throws server.ServerSQLExceptionException : 
             * @throws server.ServerIOExceptionException : 
         */

         
                     public server.GetVacancyResponse getVacancy(

                        server.GetVacancy getVacancy0)
                        throws java.rmi.RemoteException
             
          ,server.ServerSQLExceptionException
          ,server.ServerIOExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getVacancy0
            
          */
        public void startgetVacancy(

            server.GetVacancy getVacancy0,

            final server.ServerCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getCityList2
                
             * @throws server.ServerSQLExceptionException : 
         */

         
                     public server.GetCityListResponse getCityList(

                        server.GetCityList getCityList2)
                        throws java.rmi.RemoteException
             
          ,server.ServerSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getCityList2
            
          */
        public void startgetCityList(

            server.GetCityList getCityList2,

            final server.ServerCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getHotelList4
                
             * @throws server.ServerSQLExceptionException : 
         */

         
                     public server.GetHotelListResponse getHotelList(

                        server.GetHotelList getHotelList4)
                        throws java.rmi.RemoteException
             
          ,server.ServerSQLExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getHotelList4
            
          */
        public void startgetHotelList(

            server.GetHotelList getHotelList4,

            final server.ServerCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getRoomrate6
                
             * @throws server.ServerSQLExceptionException : 
             * @throws server.ServerRemoteExceptionException : 
         */

         
                     public server.GetRoomrateResponse getRoomrate(

                        server.GetRoomrate getRoomrate6)
                        throws java.rmi.RemoteException
             
          ,server.ServerSQLExceptionException
          ,server.ServerRemoteExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getRoomrate6
            
          */
        public void startgetRoomrate(

            server.GetRoomrate getRoomrate6,

            final server.ServerCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param bookRoom8
                
             * @throws server.ServerSQLExceptionException : 
             * @throws server.ServerIOExceptionException : 
         */

         
                     public server.BookRoomResponse bookRoom(

                        server.BookRoom bookRoom8)
                        throws java.rmi.RemoteException
             
          ,server.ServerSQLExceptionException
          ,server.ServerIOExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param bookRoom8
            
          */
        public void startbookRoom(

            server.BookRoom bookRoom8,

            final server.ServerCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    