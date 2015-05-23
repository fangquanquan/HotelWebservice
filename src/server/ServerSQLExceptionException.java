
/**
 * ServerSQLExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package server;

public class ServerSQLExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1432271353646L;
    
    private server.ServerSQLException faultMessage;

    
        public ServerSQLExceptionException() {
            super("ServerSQLExceptionException");
        }

        public ServerSQLExceptionException(java.lang.String s) {
           super(s);
        }

        public ServerSQLExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public ServerSQLExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(server.ServerSQLException msg){
       faultMessage = msg;
    }
    
    public server.ServerSQLException getFaultMessage(){
       return faultMessage;
    }
}
    