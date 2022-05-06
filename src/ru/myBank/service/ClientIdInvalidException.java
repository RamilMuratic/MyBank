package ru.myBank.service;

public class ClientIdInvalidException extends Exception{

        private String clientID;

        public ClientIdInvalidException(String message, String clientID){
            super(message);
            this.clientID = clientID;
        }

        public String getClientID() {
            return clientID;
        }
    }

